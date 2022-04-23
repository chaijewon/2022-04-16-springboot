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
					   //System.out.println("이미지:"+poster.attr("style"));
					   String image=poster.attr("style");
					   image="https://korean.visitseoul.net"+image.substring(image.indexOf("'")+1,image.lastIndexOf("'"));
					   System.out.println(image);
					   // background-image:url('/csomm/getImage?srvcId=MEDIA&parentSn=50320&fileTy=MEDIA&fileNo=2&thumbTy=L');
					   /*
					    *   = String / List
					    *   1. String : 문자열을 관리 클래스 
					    *      String s="문자열"; ==> 일반 데이터형 (******)
					    *      String s=new String("문자열"); ==> 클래스형
					    *      => char[]을 클래스로 제작  
					    *      => final 클래스 => 변경해서 사용할 수 없다 (산속을 받을 수 없다)
					    *      => 문자열 : "" , 문자 : ''
					    *   2. 주요 메소드 
					    *      1) equals : 문자를 비교할 때 사용 (아이디비교 , 비밀번호 비교) => 대소문자 구분  
					    *      2) equalsIgnoreCase : 문자열을 비교할때 사용 => 대소문자 구분없이 비교 
					    *      3) length() : 문자의 갯수 **문자번호 0번부터
					    *      4) substring() : 문자를 자를 경우에 사용 
					    *         substring(int start)
					    *         substring(int start,int end)
					    *         String s="Hello Java!!";
					    *                   01234567891011  => length() => 12
					    *         s=s.substring(3) => lo Java!!
					    *         s=s.substring(6) => Java!!
					    *         s=s.substring(6,10) => Jav => end-1
					    *      5) indexOf()
					    *      6) lastIndexOf() 찾기 
					    *      
					    *      String s="Hello Java";
					    *      int s.indexOf("a") =>
					    *      s.lastIndexOf("a")  <=
					    *      7) trim() => 좌우의 공백을 제거 
					    *      8) contains() => 포함 단어 (like)  '%A%'
					    *         A% => startsWith
					    *         %A => endsWith 
					    *         ------------------ 서제스트 (자동완성기)
					    *      9) valueOf() => 모든 데이터형을 문자열 
					    *         valueOf(1) => "1"
					    *         valueOf(true) => "true"
					    *      10) split => 단어별로 잘라서 저장 => String[]
					    *          ------ 정규식 (자음) ㄱ
					    *          문자형태를 만들어서 찾기 , 저장 
					    *          
					    *          1. 알파벳 : [A-Z] , [a-z] ==> [A-Za-z]
					    *          2. 숫자 : [0-9]
					    *          3. 한글 : [가-힣]
					    *          
					    *          ip  3,3,3,3 , 1,1,1,3 ,3,2,1,1
					    *          [0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}
					    *          
					    *     List => 자료구조 (CURD) 
					    *             Create , Update , Read , Delete 
					    *             ------(Insert)(UPdate) (select) (delete) 
					    *             1. 추가  : add()
					    *             2. 수정 : set()
					    *             3. 검색 : get()
					    *             4. 삭제 : remove()
					    *             5. 저장된 갯수 : size()
					    *             메모리에 데이터 입출력 
					    */
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
