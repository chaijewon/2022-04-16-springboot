package com.it.main;

import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class MainClass2 {
	public static String youtubeGetKey(String title)
	{
		String key="";
		try
		{
			Document doc=Jsoup.connect("https://www.youtube.com/results?search_query="+title).get();
			Pattern p=Pattern.compile("/watch\\?v=[^가-힣]+");
			// /watch?v=(숫자,알파벳,특수문자) +(여러개문자를 읽어 올때)
			Matcher m=p.matcher(doc.toString());
			// /watch?v=47JjBTbI6P0"
			while(m.find())// 시작하는 문자열을 찾은 경우 
			{
				String s=m.group();//찾은 문장을 읽어 온다 
				key=s.substring(s.indexOf("=")+1,s.indexOf("\""));
				break;
			}
		}catch(Exception ex){}
		return key;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
        {
          
        	Document doc=Jsoup.connect("https://www.melon.com/chart/index.htm").get();
        	Elements poster=doc.select("div.service_list_song tr.lst50 a.image_typeAll img");
        	Elements title=doc.select("div.service_list_song tr.lst50 div.rank01 a");
        	Elements singer=doc.select("div.service_list_song tr.lst50 div.rank02 a");
        	Elements album=doc.select("div.service_list_song tr.lst50 div.rank03 a");
        	for(int i=0;i<title.size();i++)
        	{
        		System.out.println("순위:"+(i+1));
        		System.out.println("곡명:"+title.get(i).text());
        		System.out.println("가수명:"+singer.get(i).text());
        		System.out.println("앨범:"+album.get(i).text());
        		System.out.println("이미지:"+poster.get(i).attr("src"));
        		System.out.println("===============================");
        		FileWriter fw=new FileWriter("D:\\0416WeekDev\\melon.txt",true);
        		String data=(i)+"|"
        		            +title.get(i).text()+"|"
        		            +singer.get(i).text()+"|"
        		            +poster.get(i).attr("src")+"|"
        		            +youtubeGetKey(title.get(i).text())+"|"
        		            +album.get(i).text()+"\n";
        		fw.write(data);
        		fw.close();
        	}
        	poster=doc.select("div.service_list_song tr.lst100 a.image_typeAll img");
        	title=doc.select("div.service_list_song tr.lst100 div.rank01 a");
        	singer=doc.select("div.service_list_song tr.lst100 div.rank02 a");
        	album=doc.select("div.service_list_song tr.lst100 div.rank03 a");
        	for(int i=0;i<title.size();i++)
        	{
        		try
        		{
        		System.out.println("순위:"+(i+51));
        		System.out.println("곡명:"+title.get(i).text());
        		System.out.println("가수명:"+singer.get(i).text());
        		System.out.println("앨범:"+album.get(i).text());
        		System.out.println("이미지:"+poster.get(i).attr("src"));
        		System.out.println("===============================");
        		FileWriter fw=new FileWriter("c:\\javaDev\\melon.txt",true);
        		String data=(i+51)+"|"
        		            +title.get(i).text()+"|"
        		            +singer.get(i).text()+"|"
        		            +poster.get(i).attr("src")+"|"
        		            +youtubeGetKey(title.get(i).text())+"|"
        		            +album.get(i).text()+"\n";
        		fw.write(data);
        		fw.close();
        		}catch(Exception e) {}	  
        	}
        }catch(Exception ex) {}
	}

}
