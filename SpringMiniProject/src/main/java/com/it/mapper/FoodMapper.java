package com.it.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.it.vo.CategoryVO;
import com.it.vo.FoodVO;
public interface FoodMapper {
  // 카테고리 출력 
  @Select("SELECT cno,title,subject,poster "
		 +"FROM food_category")
  public List<CategoryVO> categoryAllData();
  
  // 카테고리별 맛집목록 
  @Select("SELECT no,cno,name,tel,address,type,poster,score "
		 +"FROM food_house "
		 +"WHERE cno=#{cno}")
  public List<FoodVO> foodCategoryList(int cno);
  
  // 카테고리 정보 
  @Select("SELECT title,subject FROM food_category "
		 +"WHERE cno=#{cno}")
  public CategoryVO categoryInfoData(int cno);
  // JPA => findByCno(int cno)
	
  @Select("SELECT * FROM food_house "
		 +"WHERE no=#{no}")
  public FoodVO foodDetailData(int no);
}
