package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.pojo.Admin;
import com.demo.repo.AdminRepository;

@Service
public class AdminService {
	@Autowired 
	AdminRepository adminRepository;
	
	public Admin validateAdmin(int adminId) {
		return adminRepository.validateAdmin(adminId);
	}
	
	public boolean existsByAdminId(int id) {
		return adminRepository.existsById(id);
	}

}
