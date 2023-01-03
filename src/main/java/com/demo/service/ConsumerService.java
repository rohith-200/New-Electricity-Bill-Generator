package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.repo.ConsumerRepository;

@Service
public class ConsumerService {
	@Autowired
	ConsumerRepository consumerRepository;
	
	public void updateByConsumerId(String name, String area,String city, String connectionType,int id) {
		if(consumerRepository.existsById(id)) {
			consumerRepository.updateByConsumerId(name, area, city, connectionType, id);
		}
	}
	
	public void deleteByConsumerId(int id) {
		consumerRepository.deleteById(id);
	}
}
