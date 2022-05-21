package com.it.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository // 메모리 할당 
public class FoodDAO {
   @Autowired //자동 주입 
   private FoodMapper mapper;
   
  // 카테고리 출력 
  /*@Select("SELECT cno,poster,title,subject "
		 +"FROM food_category")*/
  public List<CategoryVO> categoryListData()
  {
	  return mapper.categoryListData();
  }
  // 카테고리별 맛집 
  /*@Select("SELECT no,cno,poster,name,tel,type "
		 +"FROM food_house "
		 +"WHERE cno=#{cno}")*/
  public List<FoodVO> categoryFoodListData(int cno)
  {
	  return mapper.categoryFoodListData(cno);
  }
  // 상세보기 
  /*@Select("SELECT * FROM food_house "
		 +"WHERE no=#{no}")*/
  public FoodVO foodDetailData(int no)
  {
	  return mapper.foodDetailData(no);
  }
}
