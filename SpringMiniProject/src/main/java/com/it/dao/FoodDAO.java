package com.it.dao;

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
}
