package com.it.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// 공통 모듈 
@Aspect
@Component // 메모리 할당 
public class MyAspect {
  @Around("execution(* com.it.dao.CategoryDAO.*(..))")
  //       PointCut => 어떤 메소드 
  //                 * (리턴형) => 리턴형은 모두 리턴형 
  //                                           *(..) => 모든 메소드 (..) => 모든 매개변수 
  //                              .categoryListData()
  //                              .categoryCnoData(int) (..매개변수 0개이상)
  //   CategoryDAO가 가지고 있는 모든 메소드에 적용
  /*
   *    ProXY패턴 => 대리자 
   *    class A
   *    {
   *       public void display()
   *       {
   *          System.out.println("홍길동");
   *       }
   *    }
   *    
   *    class ProXY 
   *    {
   *        A a;
   *        public ProXY(A a)
   *        {
   *           this.a=a;
   *        }
   *        public void display()
   *        {
   *           System.out.println("Hello");
   *           a.display();
   *           System.out.println("Hi");
   *        }
   *    }
   *    
   *    A a=new A();
   *    a.diaplay();
   *    
   *    ProXY p=new ProXY(a);
   *    p.display();
   */
  public Object around(ProceedingJoinPoint jp)
  {
	  // log파일  => around
	  Object obj=null;
	  try
	  {
		  System.out.println("요청한 메소드:"+jp.getSignature().getName());
		  long start=System.currentTimeMillis();
		  obj=jp.proceed();
		  long end=System.currentTimeMillis();
		  System.out.println("처리 완료:"+(end-start));
	  }catch(Throwable ex){}
	  return obj;
  }
}
