package com.it.dao;
// 마이바티스 SQL문장 
/*
 *   @Select()  ================> <select>
 *         <select id="" resultType="" parameterType="">
 *                ----   ------------- ----------------
 *                구분자       결과값                ?값을 채워준다 
 *          =>    리턴형     메소드명(매개변수) => MyBatis에서 자동 구현 (메소드 선언) 
 *                -----  ------ --------
 *                          id   parameterType
 *                resultType 
 *   @Insert() => @SelectKey() => <insert>
 *   @Update() => <update>
 *   @Delete() => <delete>
 */
import java.util.*;

import org.apache.ibatis.annotations.Select;
public interface CategoryMapper {
    // 카테고리 목록 읽기 
	@Select("SELECT cno,title,subject FROM food_category")
	public List<CategoryVO> categoryListData();
	
	@Select("SELECT cno,title,subject FROM food_category WHERE cno=#{cno}")
	public CategoryVO categoryCnoData(int cno);
}










