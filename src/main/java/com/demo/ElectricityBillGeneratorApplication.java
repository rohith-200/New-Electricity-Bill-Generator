package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.pojo.Admin;
import com.demo.pojo.Bill;
import com.demo.pojo.Consumer;
import com.demo.repo.AdminRepository;
import com.demo.repo.BillRepository;
import com.demo.repo.ConsumerRepository;
import com.demo.service.ConsumerService;

@SpringBootApplication
public class ElectricityBillGeneratorApplication implements CommandLineRunner {
	
	@Autowired
	BillRepository billRepository;
	
	@Autowired
	ConsumerRepository consumerRepository;
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	ConsumerService consumerService;

	public static void main(String[] args) {
		SpringApplication.run(ElectricityBillGeneratorApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Consumer c1 = new Consumer("aaa","Glen Quagmire", "Anna nagar", "Chennai","domestic");
		consumerRepository.save(c1);
		Consumer c2 = new Consumer("aaa","Mahatma Gandhi", "Miyapur", "Hyderabad","domestic");
		consumerRepository.save(c2);
		Consumer c3 = new Consumer("aaa","John Cena", "RK colony", "Hyderabad","commercial");
		consumerRepository.save(c3);
		Consumer c4 = new Consumer("aaa","Katrina Kaif", "Naaripuri", "Mumbai","domestic");
		consumerRepository.save(c4);
		Consumer c5 = new Consumer("aaa","bahubali", "Maahishmathi", "Bangalore","commercial");
		consumerRepository.save(c5);
		billRepository.save(new Bill(c1,123,2022,"January",246));
		billRepository.save(new Bill(c2,355,2022,"March",710));
		billRepository.save(new Bill(c3,734,2022,"June",2936));
		billRepository.save(new Bill(c4,454,2021,"Febraury",908));
		billRepository.save(new Bill(c5,555,2021,"May",2220));

		adminRepository.save(new Admin("admin","admin"));
//		for(Bill emp:billRepository.getBillsByMonth("jan", 2023, c1.getConsumerId()) ) {
//			System.out.println(emp);
//		}
		
		//consumerRepository.updateByConsumerId("rohith", "rkk", "chennai", "domestic", 5);
//		consumerService.deleteByConsumerId(2);
		
	}

}