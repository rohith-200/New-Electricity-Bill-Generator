package com.demo.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.pojo.Bill;
import com.demo.service.BillService;
import com.demo.service.ConsumerService;

@RestController
public class AdminController {
	
	@Autowired
	BillService billService;
	
	@Autowired
	ConsumerService consumerService;
	
	@GetMapping(value = "/admin/getAllBills")
	public ResponseEntity<List<Bill>> getAllBills() {
		return billService.findAllBills();
	}
	
	@GetMapping(value = "/admin/getAllBillsByYear/{year}")
	public ResponseEntity<List<Bill>> getAllBillsByYear(@PathVariable int year) {
		List<Bill> billList = billService.findAllByYear(year);
		if(billList.isEmpty()) {
			return new ResponseEntity(new Exception("Bills are not found for this year !!!").getMessage(),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Bill>>(billList, HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/admin/getAllBillsByMonth/{month}/{year}")
	public ResponseEntity<List<Bill>> getAllBillsByMonth(@PathVariable String month, @PathVariable int year) {
		List<Bill> billList = billService.findAllByMonth(month,year);
		if(billList.isEmpty()) {
			return new ResponseEntity(new Exception("Bills are not found for this month!!!").getMessage(),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Bill>>(billList, HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/admin/getAllBillsByArea/{area}")
	public ResponseEntity<List<Bill>> getAllBillsByArea(@PathVariable String area) {
		List<Bill> billList = billService.findBillsByArea(area);
		if(billList.isEmpty()) {
			return new ResponseEntity(new Exception("Bills are not found for this area!!!").getMessage(),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Bill>>(billList, HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/admin/getAllBillsByCity/{city}")
	public ResponseEntity<List<Bill>> getAllBillsByCity(@PathVariable String city) {
		List<Bill> billList = billService.findBillsByCity(city);
		if(billList.isEmpty()) {
			return new ResponseEntity(new Exception("Bills are not found for this city!!!").getMessage(),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Bill>>(billList, HttpStatus.ACCEPTED);
	}
	
	@PutMapping(value = "/admin/updateByConsumerId/{name}/{area}/{city}/{connectionType}/{id}")
	public ResponseEntity<String> updateByConsumerId(@PathVariable String name,@PathVariable String area,@PathVariable String city,@PathVariable String connectionType,@PathVariable int id){
		
		boolean indicator = consumerService.updateByConsumerId(name, area, city, connectionType, id);
		if(indicator) {
			return new ResponseEntity<String>("Consumer Details are Updated Successfully!!",HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<String>("Error in updating!!", HttpStatus.BAD_REQUEST);	
	}
	
	@DeleteMapping(value = "/admin/deleteByConsumerId/{id}")
	public ResponseEntity<String> deleteByConsumerId(@PathVariable int id) {
		boolean indicator = consumerService.deleteByConsumerId(id);
		if(indicator) {
			return new ResponseEntity<String>("Consumer Details are Deleted Successfully!!",HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<String>("Error in deleting!!", HttpStatus.BAD_REQUEST);	
	}
	

}
