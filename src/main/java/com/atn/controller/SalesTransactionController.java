package com.atn.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atn.models.SalesTransaction;
import com.atn.services.IsalesTransactionService;
import com.atn.utils.MnoRealAccountRecorderResponse;
import com.atn.utils.Response;
import com.atn.utils.SalesTransactionResponse;

@RestController
@RequestMapping("/api/sales")
public class SalesTransactionController {
	@Autowired
	private IsalesTransactionService salesService;

	@PostMapping("/resell")
	public ResponseEntity<SalesTransactionResponse> createSalesTransaction(@RequestBody @Valid SalesTransaction st,
			final BindingResult result) {
		System.out.println("got here");
		// check if we have validation error
		if (result.hasErrors()) {
			SalesTransactionResponse response = new SalesTransactionResponse();
			response.setError(true);
			response.setMessage("validation error");
			List<String> arrlist = new ArrayList<String>();
			for (ObjectError i : result.getAllErrors()) {
				arrlist.add(i.getDefaultMessage());
			}
			;
			response.setValidationError(arrlist);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		// If no error we proceed
		try {
			st.setDate(LocalDate.now());
			SalesTransaction savedSt = salesService.create(st);
			SalesTransactionResponse response = new SalesTransactionResponse();
			response.setData(savedSt);
			response.setError(false);
			response.setMessage("Transaction created");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception ex) {
			throw ex;
		}
	}

	@GetMapping("/transactions/{accountId}")
	public ResponseEntity<Response> getResellerTransction(@PathVariable String accountId,
			@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int size,
			@RequestParam("searchBy") String searchBy) {
		try {
			Response res = new Response();
			res.setCurrentPage(pageNumber);
			res.setTotalItems(size);
			res.setData(salesService.findSalesTransactionBySeller(accountId));
			return new ResponseEntity<>(res, HttpStatus.OK);

		} catch (Exception ex) {
			throw ex;
		}
	}

	@GetMapping("/amountByMnoRealAccountRecorder/{mnoRealAccountRecorder}")
	public ResponseEntity<MnoRealAccountRecorderResponse> getAmountBymnoRealAccountRecorder(
			@PathVariable int mnoRealAccountRecorder) {
		try {
			return new ResponseEntity<>(new MnoRealAccountRecorderResponse(mnoRealAccountRecorder,
					salesService.AmountBymnoRealAccountRecorder(mnoRealAccountRecorder)), HttpStatus.OK);
		} catch (Exception ex) {
			throw ex;
		}
	}
}
