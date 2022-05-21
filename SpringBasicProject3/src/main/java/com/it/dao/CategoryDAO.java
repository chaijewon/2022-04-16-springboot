package com.it.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository // 메모리 할당 
public class CategoryDAO {
  // 구현된 인터페이스 읽기 
  @Autowired
  private CategoryMapper mapper;
  
  public List<CategoryVO> categoryListData()
  {
	  return mapper.categoryListData();
  }
  
  public CategoryVO categoryCnoData(int cno)
  {
	  return mapper.categoryCnoData(cno);
  }
}
