package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.pojo.Consumer;
import com.demo.repo.ConsumerRepository;

@Service
public class ConsumerService {
	@Autowired
	ConsumerRepository consumerRepository;
	
	public boolean updateByConsumerId(String name, String area,String city, String connectionType,int id) {
		if(consumerRepository.existsById(id)) {
			consumerRepository.updateByConsumerId(name, area, city, connectionType, id);
			return true;
		}
		return false;	
	}
	
	@Transactional
	public boolean deleteByConsumerId(int id) {
		if(consumerRepository.existsById(id)) {
			consumerRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public Consumer validateConsumer(int id) {
		return consumerRepository.validateConsumer(id);
	}
	
	public boolean exitsByConsumerId(int id) {
		return consumerRepository.existsById(id);
	}

	public Consumer save(Consumer c) {
		// TODO Auto-generated method stub
		return consumerRepository.save(c);
	}
}
