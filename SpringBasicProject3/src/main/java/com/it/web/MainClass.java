package com.it.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import java.util.*;
import com.it.dao.*;
@Component // 메모리 할당 
public class MainClass {
	@Autowired
    private CategoryDAO dao;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String[] xml={"application-context.xml","application-datasource.xml"};
        ApplicationContext app=
        		new ClassPathXmlApplicationContext(xml);
        MainClass mc=(MainClass)app.getBean("mainClass");
        List<CategoryVO> list=mc.dao.categoryListData();
        //확인
        for(CategoryVO vo:list)
        {
        	System.out.println((vo.getCno())+"."+vo.getTitle());
        }
        System.out.println("================================");
        CategoryVO vo=mc.dao.categoryCnoData(1);
        System.out.println(vo.getCno());
        System.out.println(vo.getTitle());
        System.out.println(vo.getSubject());
        
	}

}
