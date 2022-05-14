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
}
