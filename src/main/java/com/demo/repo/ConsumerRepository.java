package com.demo.repo;

import javax.transaction.Transactional;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.demo.pojo.Consumer;
@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, Integer> {
	
	@Query(value="Select * from Consumer where consumer_id= :id and password = :password", nativeQuery=true)
	Consumer validateConsumer(int id, String password);
	
	
	@org.springframework.data.jpa.repository.Modifying
	@org.springframework.transaction.annotation.Transactional
	@Query(value="UPDATE Consumer SET consumer_name=:name, area=:area,city=:city,connection_type=:connectionType WHERE consumer_id=:id")
	void updateByConsumerId(@Param("name") String name,@Param("area") String area,@Param("city") String city,@Param("connectionType") String connectionType,@Param("id") int id);

}
