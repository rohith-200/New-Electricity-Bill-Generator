package com.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.exceptions.BillNotFoundException;
import com.demo.pojo.Bill;
import com.demo.repo.BillRepository;

@Service
public class BillService {
	@Autowired
	BillRepository billRepository;
	
	public ResponseEntity<List<Bill>> findAllBills() throws BillNotFoundException {
		List<Bill> billList = billRepository.findAllBill();
		if(billList.isEmpty()) {
//			return new ResponseEntity(new Exception("Error").getMessage(),HttpStatus.BAD_REQUEST);
			throw new BillNotFoundException("No bills found");
		}
		return new ResponseEntity<List<Bill>>(billList, HttpStatus.OK);
	}
	
	public List<Bill> findAllByYear(int year) {
		return billRepository.findAllByYear(year);
	}
	
	public List<Bill> findAllByMonth(String month, int year) {
		return billRepository.findAllByMonth(month, year);
	}
	
	public List<Bill> findBillsByArea(String area) {
		return billRepository.findBillsByArea(area);
	}
	
	public List<Bill> findBillsByCity(String city) {
		return billRepository.findBillsByCity(city);
	}
	
	public List<Bill> getBillsByMonth(String month, int year, int id) {
		return billRepository.getBillsByMonth(month, year, id);
	}
	
	public List<Bill> getBillsByYear(int year, int id) {
		return billRepository.getBillsByYear(year, id);
	}
	
	public List<Bill> getAllBills(int id) {
		return billRepository.getAllBills(id);
	}
}
