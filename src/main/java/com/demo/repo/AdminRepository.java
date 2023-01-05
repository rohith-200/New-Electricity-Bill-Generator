package com.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.demo.pojo.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
	@Query(value = "select * from admin where admin_id=?", nativeQuery = true)
	Admin validateAdmin(int id);
	
	

}
