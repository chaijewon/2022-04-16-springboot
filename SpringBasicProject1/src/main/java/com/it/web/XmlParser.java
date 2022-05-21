package com.it.web;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.*;
public class XmlParser extends DefaultHandler{
     Map map=new HashMap();

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		try
		{
			if(qName.equals("bean"))//bean 태그를 읽었을때 
			{
				String id=attributes.getValue("id");
				String cls=attributes.getValue("class");
				Class className=Class.forName(cls);
				Object obj=className.getDeclaredConstructor().newInstance();
				map.put(id, obj);
			}
		}catch(Exception ex) {}
	}
     
}
