package com.it.spring4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.it.config.MemberConfig;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        AnnotationConfigApplicationContext app=
        		new AnnotationConfigApplicationContext(MemberConfig.class);
        Member m=(Member)app.getBean("mm");
        System.out.println(m.getMno());
        System.out.println(m.getName());
        System.out.println(m.getAddress());
	}

}
