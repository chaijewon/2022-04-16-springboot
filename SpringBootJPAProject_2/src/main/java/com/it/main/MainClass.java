package com.it.main;
/*
 *   String data=(i)+"|"
        		            +title.get(i).text()+"|"
        		            +singer.get(i).text()+"|"
        		            +poster.get(i).attr("src")+"|"
        		            +youtubeGetKey(title.get(i).text())+"|"
        		            +album.get(i).text()+"\n";
 */
import java.io.*;
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	FileReader fr=new FileReader("D:\\0416WeekDev\\melon.txt");
        	int i=0;
        	String data="";
        	while((i=fr.read())!=-1) //-1 EOF
        	{
        		data+=String.valueOf((char)i);
        	}
        	fr.close();
        	
        	//System.out.println(data);
        	String[] datas=data.split("\n");
        	MelonDAO dao=new MelonDAO();
        	int k=1;
        	for(String s:datas)
        	{
        		System.out.println(s);
        		StringTokenizer st=new StringTokenizer(s,"|");
        		MelonVO vo=new MelonVO();
        		st.nextToken();
        		vo.setNo(k);
        		vo.setTitle(st.nextToken());
        		vo.setSinger(st.nextToken());
        		vo.setPoster(st.nextToken());
        		vo.setMkey(st.nextToken());
        		vo.setAlbum(st.nextToken());
        		dao.melonInsert(vo);
        		k++;
        	}
        	System.out.println("저장 완료");
        }catch(Exception ex){ex.printStackTrace();}
	}

}







