package com.it.food.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.it.food.entity.FoodEntity;
/*
 *  no int PK 
poster varchar(2000) 
name varchar(300) 
score double 
address varchar(2000) 
tel varchar(20) 
type varchar(100) 
price varchar(30) 
time varchar(50) 
parking varchar(100) 
menu varchar(4000)
 */
@Repository
public interface FoodDAO extends JpaRepository<FoodEntity, Integer>{
    // findByAddressContaining(String address)  => '%데이터%
	// findByAddressStartsWith => '데이터%'
	// findByAddressEndsWith => '%데이터'
   @Query(value="SELECT no,poster,name,score,address,tel,type,price,"
		  +"time,parking,menu "
		  +"FROM foodlocation "
		  +"WHERE address LIKE CONCAT('%',:address,'%') "
		  +"limit :start,20",nativeQuery = true)
   public List<FoodEntity> foodFindData(@Param("address") String address,
		      @Param("start") Integer start);
   
   public FoodEntity findByNo(@Param("no") Integer no);
}
