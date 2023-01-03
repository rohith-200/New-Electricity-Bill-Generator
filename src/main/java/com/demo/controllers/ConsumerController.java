package com.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.ConsumerService;

@RestController
public class ConsumerController {
	
	@Autowired
	ConsumerService consumerService;
	
	

}
