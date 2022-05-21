package com.it.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.it.spring4.Member;

@Configuration
public class MemberConfig {
  @Bean("mm")//<bean id="mm">
  @Scope("prototype")//<bean id="mm" scope="prototype">
  public Member member() // <bean id="mm" scope="" class="Member">
  {
	  Member m=new Member();
	  m.setMno(1);
	  m.setName("강감찬");
	  m.setAddress("서울");
	  return m;
  }
}
