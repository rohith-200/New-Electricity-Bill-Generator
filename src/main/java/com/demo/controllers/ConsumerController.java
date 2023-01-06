package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.exceptions.BillNotFoundException;
import com.demo.exceptions.ConsumerNotFoundException;
import com.demo.pojo.Bill;
import com.demo.pojo.Consumer;
import com.demo.service.BillService;
import com.demo.service.ConsumerService;

@RestController
public class ConsumerController {
	
	@Autowired
	ConsumerService consumerService;
	
	@Autowired
	BillService billService;
	
	@GetMapping(value = "/consumer/getBillsByMonth/{month}/{year}/{id}")
	public ResponseEntity<List<Bill>> getBillsByMonth(@PathVariable String month,@PathVariable int year,@PathVariable int id) throws BillNotFoundException {
		List<Bill> billList = billService.getBillsByMonth(month, year, id);
		if(billList.isEmpty()) {
			throw new BillNotFoundException("Error!! Bill Not Found ");
		}
		return new ResponseEntity<List<Bill>>(billList,HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/consumer/getBillsByYear/{year}/{id}")
	public ResponseEntity<List<Bill>> getBillsByYear(@PathVariable int year,@PathVariable int id) throws BillNotFoundException {
		List<Bill> billList = billService.getBillsByYear(year, id);
		if(billList.isEmpty()) {
			throw new BillNotFoundException("Error!! Bill Not Found ");
		}
		return new ResponseEntity<List<Bill>>(billList,HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/consumer/getAllBills/{id}")
	public ResponseEntity<List<Bill>> getAllBills(@PathVariable int id) throws BillNotFoundException {
		List<Bill> billList = billService.getAllBills(id);
		if(billList.isEmpty()) {
			throw new BillNotFoundException("Error!! Bill Not Found ");
		}
		return new ResponseEntity<List<Bill>>(billList,HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/consumer/validateConsumer/{id}/{password}")
	public ResponseEntity<Boolean> validateConsumer(@PathVariable int id,@PathVariable String password) throws ConsumerNotFoundException {
		if(consumerService.exitsByConsumerId(id)) {
			Consumer consumer = consumerService.validateConsumer(id);
			if(consumer.getPassword().equals(password)) {
				return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
			}
		} else {
			throw new ConsumerNotFoundException("Error!! Consumer Not Found");
		}
	}
	
	@PostMapping("/consumer/register")
	public ResponseEntity<Consumer> addConsumer(@RequestBody Consumer c)  {
			Consumer consumer = consumerService.save(c);
			return new ResponseEntity<Consumer>(consumer,HttpStatus.ACCEPTED);
	}
	
	

}
