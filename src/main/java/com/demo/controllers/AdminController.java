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

import com.demo.exceptions.AdminNotFoundException;
import com.demo.exceptions.BillNotFoundException;
import com.demo.exceptions.ConsumerNotFoundException;
import com.demo.pojo.Admin;
import com.demo.pojo.Bill;
import com.demo.service.AdminService;
import com.demo.service.BillService;
import com.demo.service.ConsumerService;

@RestController
public class AdminController {
	
	@Autowired
	BillService billService;
	
	@Autowired
	ConsumerService consumerService;
	
	@Autowired
	AdminService adminService;
	
	@GetMapping(value = "/admin/getAllBills")
	public ResponseEntity<List<Bill>> getAllBills() throws BillNotFoundException {
		return billService.findAllBills();
	}
	
	@GetMapping(value = "/admin/getAllBillsByYear/{year}")
	public ResponseEntity<List<Bill>> getAllBillsByYear(@PathVariable int year) throws BillNotFoundException {
		List<Bill> billList = billService.findAllByYear(year);
		if(billList.isEmpty()) {
			throw new BillNotFoundException("Error!! Bill Not Found");
		}
		return new ResponseEntity<List<Bill>>(billList, HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/admin/getAllBillsByMonth/{month}/{year}")
	public ResponseEntity<List<Bill>> getAllBillsByMonth(@PathVariable String month, @PathVariable int year) throws BillNotFoundException {
		List<Bill> billList = billService.findAllByMonth(month,year);
		if(billList.isEmpty()) {
			throw new BillNotFoundException("Error!! Bill Not Found");
		}
		return new ResponseEntity<List<Bill>>(billList, HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/admin/getAllBillsByArea/{area}")
	public ResponseEntity<List<Bill>> getAllBillsByArea(@PathVariable String area) throws BillNotFoundException {
		List<Bill> billList = billService.findBillsByArea(area);
		if(billList.isEmpty()) {
			throw new BillNotFoundException("Error!! Bill Not Found");
		}
		return new ResponseEntity<List<Bill>>(billList, HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/admin/getAllBillsByCity/{city}")
	public ResponseEntity<List<Bill>> getAllBillsByCity(@PathVariable String city) throws BillNotFoundException {
		List<Bill> billList = billService.findBillsByCity(city);
		if(billList.isEmpty()) {
			throw new BillNotFoundException("Error!! Bill Not Found");
		}
		return new ResponseEntity<List<Bill>>(billList, HttpStatus.ACCEPTED);
	}
	
	@PutMapping(value = "/admin/updateByConsumerId/{name}/{area}/{city}/{connectionType}/{id}")
	public ResponseEntity<String> updateByConsumerId(@PathVariable String name,@PathVariable String area,@PathVariable String city,@PathVariable String connectionType,@PathVariable int id) throws ConsumerNotFoundException{
		
		boolean indicator = consumerService.updateByConsumerId(name, area, city, connectionType, id);
		if(indicator == false) {
			throw new ConsumerNotFoundException("Error!!Consumer Not Found");
		}
		return new ResponseEntity<String>("Consumer Details are Updated Successfully!!",HttpStatus.ACCEPTED);	
	}
	
	@DeleteMapping(value = "/admin/deleteByConsumerId/{id}")
	public ResponseEntity<String> deleteByConsumerId(@PathVariable int id) throws ConsumerNotFoundException {
		boolean indicator = consumerService.deleteByConsumerId(id);
		if(indicator == false) {
			throw new ConsumerNotFoundException("Error!!Consumer Not Found");
		}
		return new ResponseEntity<String>("Consumer Details are Deleted Successfully!!",HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/admin/validateAdmin/{userName}/{password}/{id}")
	public ResponseEntity<Boolean> validateAdmin(@PathVariable String userName,@PathVariable String password,@PathVariable int id) throws AdminNotFoundException {
		if(adminService.existsByAdminId(id)) {
			Admin admin = adminService.validateAdmin(id);
			if(admin.getUserName().equals(userName) && admin.getPassword().equals(password)) {
				return new ResponseEntity<Boolean>(true,HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
			}
		} else {
			throw new AdminNotFoundException("Error!! Admin Not Found");
		}
		
	}
	

}
