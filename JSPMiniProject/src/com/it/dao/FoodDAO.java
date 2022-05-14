package com.it.dao;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
public class FoodDAO {
   private static SqlSessionFactory ssf;
   static {
	   try
	   {
		   Reader reader=Resources.getResourceAsReader("Config.xml");
		   ssf=new SqlSessionFactoryBuilder().build(reader);
		   // 파싱
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
   }
   public static List<FoodCategoryVO> foodCategoryData()
   {
	   return ssf.openSession().selectList("foodCategoryData");
   }
   /*
    *  <select id="foodListData" resultType="com.it.dao.FoodHouseVO" parameterType="int">
    SELECT * FROM food_house
    WHERE cno=#{cno}
  </select>
  <select id="foodCategoryInfo" resultType="FoodCategoryVO" parameterType="int">
    SELECT * FROM food_category
    WHERE cno=#{cno}
  </select>
    */
   public static FoodCategoryVO foodCategoryInfo(int cno)
   {
	   return ssf.openSession().selectOne("foodCategoryInfo",cno);
   }
   public static List<FoodHouseVO> foodListData(int cno)
   {
	   return ssf.openSession().selectList("foodListData",cno);
   }
}
