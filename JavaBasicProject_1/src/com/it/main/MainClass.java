package com.it.main;
/*
 *   자바 기본 
 *   -------
 *   J2SE => 공통 사용 (Application,WebApplication,MobileApplication)
 *                    J2SE         J2EE           J2ME(=> Kotlin)
 *     1. 변수 
 *        => 데이터베이스 (한개의 값을 저장하는 공간) : 메모리 , 파일 , RDBMS (MySQL,MariaDB,Oracle..)
 *                                                   ------------- 영구적인 저장 장소 
 *                                            ----- RAM(휘발성) 
 *        => 같은 데이터형 여러개 저장 : 배열 (웹에서 가끔 사용) => 고정 
 *        => 다른 데이터형 여러개 저장 : 클래스 
 *        => 데이터 저장 방법 
 *           ------------
 *           정수 : byte(1byte) , short(2byte) , int(4byte) , long(8byte)
 *                               ---- default   
 *                 byte : 파일 전송 , 네트워크 통신 => 인코딩 / 디코딩
 *                 short: C언어와 호환 
 *                 int : 일반 정수 
 *                 long : 빅데이터 , AI , JPA
 *           실수 : float , double (8byte)
 *           문자 : char(2byte) => Unicode => 한글
 *           문자열 : String (******)
 *           논리형 : boolean : true/false 
 *        -------------------------------------------------
 *          ==> 변수 설정하는 방법 (식별자)
 *              1. 알파벳,한글 시작 (알파벳 => 대소문자 구분)
 *              2. 숫자 사용 (앞에 사용 금지) 
 *              3. 키워드는 사용 금지 
 *              4. 특수문자 사용 가능 (_, $) 
 *     2. 연산자 
 *         단항연산자 
 *           = 증감연산자 (++ , --) : 한개 증가 감소 
 *              = 전치 연산자
 *                int a=10;
 *                int b = ++a; => 증가후 대입 
 *                        --
 *                         1
 *                      --
 *                      2 
 *              = 후치 연산자
 *                int a=10;
 *                int b = a++ => 대입후 나중에 증가 
 *                    -------
 *                       1  2
 *           = 부정 연산자 (!) => 사용할 수 있는 데이터형 (boolean) 
 *             boolean b=true;
 *             !b => false ==> 예약가능한 날 
 *           = 형변환 연산자 (type) => (int)10.5 => 10
 *             byte < short < int < long < float < double 
 *                    char
 *             ------------------------- 연산처리 
 *               = 자동 형변환 (Upcasting)
 *                 10.5+10 = 20.5
 *                      ---
 *                      10.0
 *                  10.5+10.0 => 20.5
 *                  
 *                  10+'A'
 *                     ---
 *                     65  => 10+65=75
 *               = 강제 형변환 (DownCasting)
 *                 (int)10.5+(int)10.5 => 20
 *                 --------- ----------
 *                   10     + 10  => 20
 *               ------------------------------- 클래스 형변환 (상속) 
 *         이항연산자
 *           = 산술연산자 (+,-,*,/,%)
 *             = 형변환 
 *               byte b1=10;
 *               byte b2=20;
 *               byte b3=b1+b2;  => 30(X) => 에러 
 *               int이하 (byte,char,short)가 연산되면 결과값은 int 
 *                  char+char = int 
 *                  byte+byte = int
 *                  char + int = int
 *             = / 
 *               = 정수/정수=정수   10/3 => 3  5/2 = 2
 *               = 0으로 나눌 수 없다 
 *             = %
 *               = 결과값은 왼쪽편 부호와 동일 
 *                 5%2 => 1
 *                 -5%2 => -1
 *                 5%-2 => 1
 *                 -5%-2 => -1
 *           = 비교연산자 
 *              => 결과값 => boolean 
 *                 == , !=  , <  , >  , <= , >=
 *                 같다  같지 않다 , 작다 , 크다 , 작거나 같다 , 크거나 같다 
 *           = 논리연산자
 *               => && , ||(범위 포한이 안된 상태) 
 *                  --- 범위, 기간안에 포함 
 *                  --- 효율적인 연산처리 
 *                  
 *                  예) 
 *                     int a=10;
 *                     int b=9;
 *                     
 *                     a<b && ++b==a
 *                     ---    -------
 *                     false ==> 뒤에 있는 연산처리는 하지 않는다 
 *                  
 *           = 대입연산자 : = , += , -= 
 *             int a=10;
 *             a+=10;  ===> a=a+10 ==> 20 (복합대입연산자) => 문자열 결합 
 *             
 *             ==> 연산자는 왼쪽에서 오른쪽 
 *                  -->
 *                  a+b+c 
 *                  ---
 *                    ---
 *                  대입연산자 : 오른쪽 => 왼쪽 
 *                  int a=10;
 *         삼항연산자  
 *             => 조건 ? 값1:값2 
 *                true => 값1 
 *                false => 값2   ===> if ~ else 
 *                
 *              <%
 *                 if()
 *                 {
 *              %>
 *                      HTML
 *              <%
 *                 }
 *                 else
 *                 {
 *              %>
 *                      HTML
 *              <%
 *                 }
 *              %>
 *              
 *              <%
 *                  조건 ? 값1:값2
 *              %>
 *              HTML 
 *               
 *     3. 제어문 
 *        -----
 *         조건문
 *          단일조건  if(조건문)
 *          선택조건  if~else
 *          다중조건문  if~else if ~else if ~ else
 *         반복문 
 *          for : 2차 for 
 *          while ============> 데이터베이스 
 *         반복제어문 
 *           break : 반복 종료 
 *         
 *     ---------- + 메소드 (연산자+제어문)
 *                --------
 *                + 클래스 
 *                --------
 *                + 패키지 
 *     ------------------------
 *     1. 데이터 보호  ( 캡슐화)
 *     2. 재사용 (상속)
 *     3. 확장 / 재정의 / 추가 (다형성)
 *        ----------- -----
 *         오버라이딩       오버로딩  
 *     ------------------------- 객체지향의 3대 특성 
 *     1. 클래스 종류 
 *        ============== 웹 
 *        = 추상 클래스
 *        = 인터페이스 
 *        ==============
 *        = 내부 클래스  (멤버클래스 , 익명의 클래스 , 지역클래스) 
 *                               ========== 상속 오버라이딩이 가능 (빅데이터,윈도우)
 *     2. 클래스 구성 요소 
 *        = 멤버변수 (인스턴스 , 정적)
 *        = 생성자 (변수 초기화) =======> 초기화 블록 
 *        = 메소드 
 *     3. 라이브러리 
 *        Object , String , StringBuffer , Wrapper 
 *        StringTokenizer , Date 
 *        List , Map , Set ==> 제네릭스 
 *        File , URL 
 *     ----------------------------
 *     
 *     J2EE : Web개발 
 *     Servlet / JSP => JSTL/EL 
 *     Spring 라이브러리 
 *     SpringBoot => Thymeleaf
 *     ----------------------------- Database (JDBC => DBCP => ORM(MyBatis,JPA)
 *     
 *     Spring => MyBatis => JSP
 *     SpringBoot => JPA => html(Thymeleaf)
 */
public class MainClass {
   public static void main(String[] args) {
	  byte b1=127; // 127
	  byte b2=32;
	  //byte b3=(byte)(b1+b2);
	  int b3=b1+b2;
	  System.out.println(b3);
	  /*
	   *    0 1 1 1 1 1 1 1 
	   *    0 0 0 1 0 0 0 0
	   *    ----------------
	   *    127+32 => 159(-128) => 31 => 15
	   *    128 64 32 16 8 4 2 1
	   *     1   0  0  1 1 1 1 1
	   *     --------------------
	   */
	  double d=123456.78;
	  int a=(int)((d-123456)*100);
	  System.out.println(a);
   }
}








