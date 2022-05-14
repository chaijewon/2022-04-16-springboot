package com.it.controller;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.it.model.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
@WebServlet("*.do") // /*
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<String> clsList=new ArrayList<String>();
	public void init(ServletConfig config) throws ServletException {
		try
		{
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			// XML파서기 생성 
			DocumentBuilder db=dbf.newDocumentBuilder();
			// XML파서기 
			// 메모리 저장 
			Document doc=db.parse(new File("D:\\0416WeekDev\\javaStudy\\JSPMiniProject\\WebContent\\WEB-INF\\application.xml"));
			// Root태그 
			Element root=doc.getDocumentElement();
			System.out.println(root.getTagName());
			NodeList list=root.getElementsByTagName("bean");
			for(int i=0;i<list.getLength();i++)
			{
				Element bean=(Element)list.item(i);
				String cls=bean.getAttribute("class");
				System.out.println(cls);
				clsList.add(cls);
			}
		}catch(Exception ex){}
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자 보낸 URI주소 읽기
		String cmd=request.getRequestURI();
		cmd=cmd.substring(request.getContextPath().length()+1);
		// list.do
		try
		{
			for(String pack:clsList)
			{
				Class clsName=Class.forName(pack);
				Object obj=clsName.getDeclaredConstructor().newInstance();
				// 클래스 이름으로 메모리 할당 => 리플렉션 (스프링 , 마이바티스)
				// 클래스에 선언된 메소드 읽기 
				Method[] methods=clsName.getDeclaredMethods();
				for(Method m:methods)
				{
					//System.out.println(m.getName());
					RequestMapping rm=m.getAnnotation(RequestMapping.class);
					if(rm.value().equals(cmd))
					{
						// 어노테이션으로 메소드 찾기 
						String jsp=(String)m.invoke(obj, request);
						RequestDispatcher rd=request.getRequestDispatcher(jsp);
						rd.forward(request, response);
						return;
					}
				}
			}
		}catch(Exception ex){}
	}

}








