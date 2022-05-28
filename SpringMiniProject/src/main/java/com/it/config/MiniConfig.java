package com.it.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
/*
 *    <context:component-scan base-package="com.it.*"/>
 */
@ComponentScan(basePackages = {"com.it.*"})
/*
 *  <aop:aspectj-autoproxy/>
 */
@EnableAspectJAutoProxy
@EnableWebMvc
@MapperScan(basePackages = {"com.it.mapper"})
// mapper등록 
// Transaction
public class MiniConfig {
	/*
	 *  <bean id="viewResolver"
         class="org.springframework.web.servlet.view.InternalResourceViewResolver"
         p:prefix="/"
         p:suffix=".jsp"
     />
	 */
   @Bean("viewResolver")
   public ViewResolver viewResolver()
   {
	   InternalResourceViewResolver vr=new InternalResourceViewResolver();
	   vr.setPrefix("/");
	   vr.setSuffix(".jsp");
	   return vr;
   }
   /*
    *  <bean id="ds"
        class="org.apache.commons.dbcp.BasicDataSource"
        p:driverClassName="#{db['driver']}"
        p:url="#{db['url']}"
        p:username="#{db['username']}"
        p:password="#{db['password']}"
    />
    <bean id="ssf"
       class="org.mybatis.spring.SqlSessionFactoryBean"
       p:dataSource-ref="ds"
    />
    */
   @Bean("ds")
   public DataSource dataSource()
   {
	   BasicDataSource ds=new BasicDataSource();
	   ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
	   ds.setUrl("jdbc:mysql://localhost:3306/db0416?serverTimezone=UTC");
	   ds.setUsername("root");
	   ds.setPassword("1111");
	   return ds;
   }
   @Bean("ssf")
   public SqlSessionFactory sqlSessionFactory() throws Exception
   {
	   SqlSessionFactoryBean ssf=
			   new SqlSessionFactoryBean();
	   ssf.setDataSource(dataSource());
	   return ssf.getObject();
   }
   
}
