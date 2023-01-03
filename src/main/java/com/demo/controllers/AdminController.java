package com.demo.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.pojo.Bill;
import com.demo.service.BillService;

@RestController
public class AdminController {
	
	@Autowired
	BillService billService;
	
	@GetMapping(value = "/admin/getAllBills")
	public ResponseEntity<List<Bill>> getAllBills() {
		return billService.findAllBills();
	}
	
	@GetMapping(value = "/admin/getAllBillsByYear/{year}")
	public ResponseEntity<List<Bill>> getAllBillsByYear(@RequestParam int year) {
		List<Bill> billList = billService.findAllByYear(year);
		if(billList.isEmpty()) {
			return new ResponseEntity(new Exception("Bills are not found for this year !!!").getMessage(),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Bill>>(billList, HttpStatus.ACCEPTED);
	}
	

}
