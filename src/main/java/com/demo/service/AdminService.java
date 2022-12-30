package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.repo.AdminRepository;

@Service
public class AdminService {
	@Autowired 
	AdminRepository adminRepository;
	
	

}
