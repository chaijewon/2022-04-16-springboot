package com.it.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.it.mapper.FoodMapper;
import java.util.*;
import com.it.vo.*;
@Repository
public class FoodDAO {
  @Autowired
  private FoodMapper mapper;
  
  public List<CategoryVO> categoryAllData()
  {
	  return mapper.categoryAllData();
  }
  public List<FoodVO> foodCategoryList(int cno)
  {
	  return mapper.foodCategoryList(cno);
  }
  public CategoryVO categoryInfoData(int cno)
  {
	  return mapper.categoryInfoData(cno);
  }
  
  public FoodVO foodDetailData(int no)
  {
	  return mapper.foodDetailData(no);
  }
  /*
   *  @Select("SELECT no,poster,name "
		 +"FROM foodLocation "
		 +"WHERE address LIKE CONCAT('%',#{ss},'%') "
		 +"limit #{start},12")
  public List<FoodVO> foodFindData(Map map);
  
  @Select("SELECT CEIL(COUNT(*)/12.0) FROM foodLocation "
		 +"WHERE address LIKE CONCAT('%',#{ss},'%')")
  public int foodFindTotalPage(String ss);
   */
  public List<FoodVO> foodFindData(Map map)
  {
	  return mapper.foodFindData(map);
  }
  public int foodFindTotalPage(String ss)
  {
	  return mapper.foodFindTotalPage(ss);
  }
}
