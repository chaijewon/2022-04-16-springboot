package com.it.model;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.it.dao.*;
public class FoodModel {
   public void foodCategoryData(HttpServletRequest request)//JSP에서 보낸값 
   {
	   // Call by Reference => 주소를 넘겨주고  해당 주소에 값을 채워준다 
	   FoodDAO dao=new FoodDAO();
	   List<FoodCategoryVO> list=dao.foodCategoryData();
	   request.setAttribute("list", list);//JSP가지고 있는 request에 값을 추가 
   }
}
