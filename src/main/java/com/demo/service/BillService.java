package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.pojo.Bill;
import com.demo.repo.BillRepository;

@Service
public class BillService {
	@Autowired
	BillRepository billRepository;
	
	public List<Bill> findAllBills() {
		return billRepository.findAllBill();
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
