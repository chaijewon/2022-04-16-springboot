package com.it.manager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SeoulManager {
   public static void main(String[] args) {
	  SeoulManager sm=new SeoulManager(); // 클래스 메모리 할당 
	  sm.seoulLocationData();
   }
   public void seoulLocationData()
   {
	   try
	   {
		   // 1. 사이트에 접근 
		   // 2. 사이트안에서 필요한 HTML의 값을 가지고 온다 
		  for(int j=1;j<=35;j++)
		  {
			   Document doc=Jsoup.connect("https://korean.visitseoul.net/attractions?curPage="+j).get();
		       //System.out.println(doc);
			   /*
			    *  <ul class="article-list">
					<li class="item">
					<a href="/attractions/양화진외국인선교사묘원_/1153" target="_self"  title="페이지 이동">
			    */
			   // 구분자 => class , id
			   Elements link=doc.select(".article-list .item a");
			   /*
			    *   private String title;
					private String poster;
					private String address;
					private String msg;
					
					<div class="detail-map-infor"> eq(0)
					  전화번호
					  
					</div>
					<div class="detail-map-infor"> eq(1)
					  주소 
					</div>
					
					<div class="wide-slide owl-carousel"><!-- 20200615 owl-carousel -->
								<!-- 2020 웹접근성 -->
									<div class="item" tabindex="0" style="
			    */
			   for(int i=0;i<link.size();i++)
			   {
				   try
				   {
					   System.out.println((i+1)+"."+link.get(i).attr("href"));
					   Document doc2=Jsoup.connect("https://korean.visitseoul.net"
					                 +link.get(i).attr("href")).get();
					   Element title=doc2.selectFirst("section.infor-element .h3");
					   Element poster=doc2.selectFirst("div.wide-slide div.item");
					   Element address=doc2.select("div.detail-map-infor:eq(1) dl dd").get(0);
					   Element msg=doc2.selectFirst("div.text-area span");
					   /*
					    *   <a href="adada">
					    *   <div>dadada</div>
					    */
					   System.out.println("명소:"+title.text());
					   System.out.println("주소:"+address.text());
					   System.out.println("설명:"+msg.text());
					   System.out.println("이미지:"+poster.attr("style"));
					   System.out.println("================================");
				   }catch(Exception ex) {}
			   }
		  }
		   
	   }catch(Exception ex)
	   {
		   ex.printStackTrace(); // 에러 확인 
	   }
   }
}
