package com.it.web;

import com.it.spring3.Sawon;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String path="D:\\0416WeekDev\\javaStudy\\SpringBasicProject1\\src\\main\\java\\com\\it\\web\\app.xml";
        ApplicationContext app=
        		new ApplicationContext(path);
        Sawon sa=(Sawon)app.getBean("sa");
        System.out.println("sa="+sa);
        Sawon sa1=(Sawon)app.getBean("sa");
        System.out.println("sa1="+sa1);
	}

}
