package com.it.controller;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(METHOD)
/*
 *   찾기 (인덱스) => if문 한개 추가 
 *   --------------------------
 *   사용 위치 
 *   @ => TYPE
 *   public class ClassName{
 *       @ => FIELD
 *       B b;
 *       
 *       @ => CONSTRUCTOR
 *       public ClassName()
 *       {
 *       }
 *       
 *       @ => METHOD
 *       public void display()
 *       {
 *       }
 *       
 *       public void disp(@ PARAMETER B b)
 *       {
 *       }
 *   }
 */
// @RequestMapping("list.do")
public @interface RequestMapping {
   public String value();
}






