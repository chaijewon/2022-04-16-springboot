package com.it.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
 *    @Component  ==> 자동 id생성 => class명 (첫자만 소문자)
 *                    BoardDAO => boardDAO
 *    class Sawon
 *    
 *    @Component("mem") => id를 지정 
 *    class Member
 *    
 *    스프링 : 
 *      1. 등록된 모든 클래스 메모리 할당 
 *      2. DI (Setter,Contructor)
 *      --------------------------- Map에 저장 
 *      3. 프로그래머가 활용 
 *      ---------------------------
 *      4. 메모리해제 
 *      --------------------------- ApplicationContext(컨테이너)
 *        컨테이터 
 *          => 객체생성 ~ 객체 소멸 => 핵심 코딩만 
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app.xml");
        Member m=(Member)app.getBean("member");
        System.out.println("m="+m);
        m.setName("홍길동");
        m.setAddress("서울");
        m.setTel("1111-1111");
        System.out.println("이름:"+m.getName());
        System.out.println("주소:"+m.getAddress());
        System.out.println("전화:"+m.getTel());
        Sawon s=(Sawon)app.getBean("sa");
        System.out.println("s="+s);
	}

}
