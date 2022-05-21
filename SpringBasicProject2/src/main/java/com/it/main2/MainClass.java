package com.it.main2;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("mc")
public class MainClass {
	// 자동 주입 
	//@Autowired
	//@Qualifier("gb") // 특정 객체 지정 
	// @Autowired+@Qualifier("gb") =>@Resource(name="gb")
	@Resource(name="gb")
    private Board board;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app2.xml");
        MainClass mc=(MainClass)app.getBean("mc");
        mc.board.list();
        mc.board.insert();
        
	}

}
