package com.atn.controller;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			st.setDate(dtf.format(now));
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

	@GetMapping("/{resellerId}")
	public ResponseEntity<Response> getResellerTransction(@PathVariable String resellerId,
			@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int size) {
		try {
			Response res = new Response();
			res.setCurrentPage(pageNumber);
			List<SalesTransaction> result = salesService.findSalesTransactionBySeller(resellerId, size);
			res.setTotalItems(result.size());
			res.setData(result);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} catch (Exception ex) {
			throw ex;
		}
	}

	@GetMapping("/filter")
	public ResponseEntity<Response> filterTransaction(@RequestParam("currentPage") int currentPage,
			@RequestParam("pageSize") int size, @RequestParam("transactionDate") String transactionDate,
			@RequestParam("status") String status) {
		try {
			Response res = new Response();
			res.setCurrentPage(currentPage);
			List<SalesTransaction> result = salesService.filterTransaction(transactionDate, status, size);
			res.setData(result);
			res.setTotalItems(result.size());
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
