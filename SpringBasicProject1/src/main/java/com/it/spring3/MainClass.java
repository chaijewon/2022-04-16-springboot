package com.it.spring3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 1. XML을 컨테이너에 전송 => 클래스 메모리 할당 => 주입
		//ApplicationContext app=
				//new ClassPathXmlApplicationContext("app.xml");//XML파싱 종료 
		GenericXmlApplicationContext app=
				new GenericXmlApplicationContext("app2.xml");
		// classpath => src/main/java
		// 클래스 찾기 
		Sawon s1=(Sawon)app.getBean("sa");
		System.out.println("name:"+s1.getName());// DI
		System.out.println("sabun:"+s1.getSabun());
		System.out.println("dept:"+s1.getDept());
		
		Sawon s2=(Sawon)app.getBean("sa1");// DL 
		System.out.println("name:"+s2.getName());
		System.out.println("sabun:"+s2.getSabun());
		System.out.println("dept:"+s2.getDept());
		//       app.getBean("sa",Sawon.class) => 제네릭스 타입 
		/*System.out.println("s1="+s1);
		s1.setName("홍길동");
		Sawon s2=(Sawon)app.getBean("sa");
		System.out.println("s2="+s2);
		s2.setName("심청이");
		
		System.out.println("s1.name="+s1.getName());
		System.out.println("s2.name="+s2.getName());
		
		app.close();// 객체 소멸 */
		app.close();// MethodDI
	}

}
