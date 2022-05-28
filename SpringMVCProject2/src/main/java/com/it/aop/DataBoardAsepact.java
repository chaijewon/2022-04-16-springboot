package com.it.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect // 공통모듈
@Component // 메모리 할당 
// 로그처리 
public class DataBoardAsepact {
   @Around("execution(* com.it.web.DataBoardController.*(..))")
   public Object around(ProceedingJoinPoint jp)
   {
	   Object obj=null;
	   try
	   {
		   System.out.println("---------------------------------");
		   System.out.println(jp.getSignature()+" 수행전...");
		   //jp.getSignature() (사용자가 요청한 메소드명)
		   long start=System.currentTimeMillis(); // 시작시간 
		   obj=jp.proceed(); // 메소드가 수행 
		   long end=System.currentTimeMillis(); // 종료 시간 
		   System.out.println(jp.getSignature()+" 수행 완료...");
		   System.out.println("수행시간 :"+(end-start));
		   System.out.println("---------------------------------");
	   }catch(Throwable ex) {}
	   return obj;
   }
   @AfterReturning(value="execution(* com.it.web.DataBoardController.*(..))", 
		   returning = "obj")
   public void afterReturning(Object obj)
   {
	   System.out.println("사용자가 요청한 파일명:"+obj);
   }
}
