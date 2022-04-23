package com.it.main;
// List => ArrayList 
/*
 *   Web => 자바 클래스 
 *   1. String 
 *   2. List 
 *   3. Integer
 */
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ArrayList<String> list=new ArrayList<String>();
        list.add("홍길동");//0
        list.add("심청이");//1
        //list.add(2,"이순신");//2
        list.add("박문수");//3
        list.add("강감찬");//4
        list.add("을지문덕");//5
        
        // 출력 
        for(int i=0;i<list.size();i++)
        {
        	String name=list.get(i);
        	System.out.println(i+"."+name);
        }
        System.out.println("======== 원하는 위치에 데이터 첨부 =======");
        list.add(2,"이순신");
        for(int i=0;i<list.size();i++)
        {
        	String name=list.get(i);
        	System.out.println(i+"."+name);
        }
        System.out.println("========= 데이터 수정 =========");
        list.set(1, "춘향이");
        for(int i=0;i<list.size();i++)
        {
        	String name=list.get(i);
        	System.out.println(i+"."+name);
        }
        System.out.println("========= 데이터 삭제 =========");
        list.remove(3);
        for(int i=0;i<list.size();i++)
        {
        	String name=list.get(i);
        	System.out.println(i+"."+name);
        }
        System.out.println("========= 전체 삭제 ===========");
        list.clear();
        System.out.println("총인원:"+list.size());
        for(int i=0;i<list.size();i++)
        {
        	String name=list.get(i);
        	System.out.println(i+"."+name);
        }
	}

}
