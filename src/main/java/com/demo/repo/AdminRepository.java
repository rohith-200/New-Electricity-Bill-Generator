package com.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.demo.pojo.Admin;
@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer>{

}
