package com.demo.repo;

import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.pojo.Consumer;
@Repository
public interface ConsumerRepository extends CrudRepository<Consumer, Integer> {
	
	@Transactional
	@Modifying
	@Query(value="UPDATE Consumer SET consumer_name=:name, area=:area,city=:city,connection_type=:connectionType WHERE consumer_id=:id", nativeQuery=true)
	void updateByConsumerId(@Param("name") String name,@Param("area") String area,@Param("city") String city,@Param("connectionType") String connectionType,@Param("id") int id);
	
	@Query(value = "select * from Consumer where consumer_id=?", nativeQuery = true)
	Consumer validateConsumer(int id);
}
