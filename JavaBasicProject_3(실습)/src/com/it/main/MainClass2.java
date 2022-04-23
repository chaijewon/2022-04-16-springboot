package com.it.main;
import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class Sawon{
	private int sabun;
	private String name;
	private String loc;
}
/*
 *   => String 클래스 
 *   => List클래스 
 *   => 데이터베이스 관련 
 */
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ArrayList<Integer> list2=new ArrayList<Integer>();
		//Integer i=null;//auto boxing
		//int j=null; // un boxing 
		// 제네릭스는 반드시 클래스형으로 설정 한다 
        ArrayList<Sawon> list=new ArrayList<Sawon>();
        list.add(new Sawon(1,"홍길동","서울"));
        list.add(new Sawon(2,"심청이","광주"));
        list.add(new Sawon(3,"박문수","제주"));
        list.add(new Sawon(4,"이순신","부산"));
        list.add(new Sawon(5,"강감찬","강원"));
        // 출력 
        System.out.println("===== 사원 목록 =====");
        for(Sawon s:list) // foreach => 출력전용 
        {
        	System.out.println("사번:"+s.getSabun());
        	System.out.println("이름:"+s.getName());
        	System.out.println("근무지:"+s.getLoc());
        	System.out.println("=================");
        }
        System.out.println("======== 삭제 =========");
        list.remove(3);
        for(Sawon s:list) // foreach => 출력전용 
        {
        	System.out.println("사번:"+s.getSabun());
        	System.out.println("이름:"+s.getName());
        	System.out.println("근무지:"+s.getLoc());
        	System.out.println("=================");
        }
        
        System.out.println("======= 전체 삭제 ========");
        list.clear();
        for(Sawon s:list) // foreach => 출력전용 
        {
        	System.out.println("사번:"+s.getSabun());
        	System.out.println("이름:"+s.getName());
        	System.out.println("근무지:"+s.getLoc());
        	System.out.println("=================");
        }
        
	}

}
