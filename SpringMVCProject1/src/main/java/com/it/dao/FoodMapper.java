package com.it.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
public interface FoodMapper {
  // 카테고리 출력 
  @Select("SELECT cno,poster,title,subject "
		 +"FROM food_category")
  public List<CategoryVO> categoryListData();
  // 카테고리별 맛집 
  @Select("SELECT no,cno,poster,name,tel,type "
		 +"FROM food_house "
		 +"WHERE cno=#{cno}")
  public List<FoodVO> categoryFoodListData(int cno);
  // 상세보기 
  @Select("SELECT * FROM food_house "
		 +"WHERE no=#{no}")
  public FoodVO foodDetailData(int no);
  
  // 맛집(지역별) => LIKE => CONCAT
}
