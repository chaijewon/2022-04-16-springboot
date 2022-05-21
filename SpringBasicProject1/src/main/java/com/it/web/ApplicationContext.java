package com.it.web;
import java.util.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.*;
public class ApplicationContext {
   Map map=new HashMap();
   public ApplicationContext(String path)
   {
	   try
	   {
		   SAXParserFactory spf=SAXParserFactory.newInstance();
		   SAXParser sp=spf.newSAXParser();
		   XmlParser xm=new XmlParser();
		   sp.parse(new File(path), xm);
		   map=xm.map;
	   }catch(Exception ex) {}
   }
   public Object getBean(String id)
   {
	   return map.get(id);
   }
}
