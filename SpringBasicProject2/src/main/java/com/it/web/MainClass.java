package com.it.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("mc1") //id부여
public class MainClass {
	@Autowired // 스프링에 의한 자동 주입 => 웹에서는 getBean()을 사용할 수 없다 => 자동 주입으로 사용 
	// 사용 변수는 사용 할 수 없다 => 클래스 객체 주소값만 받을  수 있다 (같은 유형의 클래스인 경우에는 사용이 불가능)
    private BoardDAO dao;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app1.xml");
        //BoardDAO dao=(BoardDAO)app.getBean("boardDAO");
        MainClass mc=(MainClass)app.getBean("mc1");
        mc.dao.list();
        System.out.println("==========");
        mc.dao.write();
        System.out.println("==========");
        mc.dao.update();
        System.out.println("==========");
        mc.dao.delete();
        System.out.println("==========");
	}

}
