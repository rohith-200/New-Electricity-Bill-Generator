package com.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.stereotype.Service;
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
	
	public boolean deleteByConsumerId(int id) {
		if(consumerRepository.existsById(id)) {
			consumerRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
