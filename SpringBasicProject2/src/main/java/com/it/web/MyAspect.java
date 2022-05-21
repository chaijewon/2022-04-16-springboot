package com.it.web;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
   @Before("execution(* com.it.web.BoardDAO.*(..))")
   public void before()
   {
	   System.out.println("MY SQL 연결...");
   }
   @After("execution(* com.it.web.BoardDAO.*(..))")
   public void after()
   {
	   System.out.println("MY SQL 해제...");
   }
}
