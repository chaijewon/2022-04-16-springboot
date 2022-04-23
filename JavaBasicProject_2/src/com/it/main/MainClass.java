package com.it.main;
/*
 *   자바 
 *   ===> CRUD
 *   => JSP / MVC => MySql (JDBC) => 망고플레이트 
 *   => Spring MVC => MySql (Mybatis => Annotaion,XML) => JSP
 *      => Ajax (VueJS) => 서울여행 
 *   => Spring-Boot => MySql (JPA) => HTML (Thymeleaf) => 레시피 
 *   
 *   ==========================================================
 *   자바 : 변수 / 연산자 / 제어문 
 *         배열 : 일차원 배열 
 *         클래스 
 *           1. 사용자 정의 데이터형 (변수만 제어하는 방식) => ~VO , ~DTO , ~Entity(JPA)
 *           2. 기능을 수행하는 클래스 (메소드 중심) => ~DAO , ~Manager , ~Service(BI)
 *           =================================================================
 *         클래스의 구성요소 
 *                         메모리 공간 (JVM)
 *                       =======================================
 *                        method 영역 
 *                           method , static 
 *                           공유변수 (한개만 생성되는 공간) => 싱글턴 
 *                       =====================================
 *                        stack (스택) 
 *                            지역변수 (메소드 영역 , {}) , 매개변수 
 *                       =====================================
 *                        heap 
 *                          클래스에 선언된 변수 (멤버변수) => new 메모리 할당시에 저장 
 *                          인스턴스 변수 
 *                       =====================================
 *                       프로그램 : 상태 관리 프로그램 
 *                                === 데이터 
 *                                
 *                       프로그램 시작 
 *                       ----------
 *                        데이터 저장   ==================== 데이터 연산처리 ============= 결과값 출력 
 *                        =========                     =============요청한 내용 가공      = Application(윈도우,도스) : J2SE   
 *                        1. 한개 저장 (변수)               연산자 , 제어문                             = WebApplication(사이트) : J2EE
 *                        2. 같은 데이터형을 여러개(배열)                                 =  MobileApplication : J2ME
 *                        3. 다른 데이터형을 여러개(클래스)                                ====================== Kotlin
 *                        =========================== 메모리(휘발성)
 *                        4. 파일 
 *                        5. RDBMS (MySQL)
 *         class className => 관련된 내용을 모아서 재사용을 할 목적 
 *         {
 *           ======================
 *            1. 변수(데이터 저장 공간)
 *               = 공유변수 (static) ==> 메모리 공간이 1개만 생성 
 *               = 인스턴스 변수 
 *           ======================
 *            2. 초기화 블록 => 변수에 대한 초기화 
 *               = 인스턴스 블록 
 *                 {
 *                 }
 *               = static 블록 
 *                 static
 *                 {
 *                    //mybatis
 *                 }
 *           ======================
 *            3. 생성자 : 시작과 동시에 실행하는 문장이 있는 경우(데이터베이스 연결) 
 *                      멤버변수의 초기화 (자동 로그인)
 *           ======================
 *            4. 메소드 (기능 처리)
 *           ======================
 *         }
 *         
 *         클래스 => 객체지향 3대 요소 
 *         1. 데이터 보호 : 캡슐화 (사용자 정의 클래스 => ~VO,~DTO) => getter/setter
 *         2. 재사용 : 상속 (is-a) / 포함 (has-a)
 *                    상속 : 메소드을 수정해서 사용, 메소드,데이터 추가 
 *                          오버라이딩                   오버로딩 
 *                    포함 : 변경하지 않고 있는 그대로 사용 (라이브러리)
 *                          데이터베이스 접근시 (Connection,ResultSet,Statement) 
 *         3. 수정 , 추가가 가능하게 만든다 : 다형성 (오버로딩,오버라이딩)
 *        ==================================================================
 *        클래스의 종류 
 *        ==========
 *        1. 추상클래스 : 공통으로 사용되는 기능을 모아서 필요시마다 구현해서 사용 
 *           게시판 => 댓글형 => 묻고답하기 , 겔러리 게시판 
 *           => 여러개의 클래스를 모아서 한개의 이름으로 제어 
 *        2. 인터페이스 (스프링 , 마이바티스 , JPA)
 *        3. 내부 클래스 (멤버클래스 , 익명의 클래스)
 *        4. 종단 클래스 (상속을 내릴 수 없는 클래스) ==> String,System,Math...
 *        ============================================================
 *        
 *        프로그램 관련 : 비정상 종료 방지 , 사전 에러를 방지 => 예외처리 
 *        
 *        => 라이브러리 (java.lang,java.util,java.io,java.net)
 *        ==================================================
 *        
 *        1. 객체지향 프로그램 
 *           1) 접근 지정어 (scope) : 다른 클래스에서 접근하는 범위 
 *              =======================================================================================
 *                      자신의 클래스에서 접근 | 같은 패키지에서만 접근 | 같은 패키지에서,
 *                                                             상속받은 클래스에서 접근| 모든 클래스에서 접근이 가능
 *              =======================================================================================
 *              private       O (은닉화)
 *              =======================================================================================
 *              default       O                  O
 *              =======================================================================================
 *              protected     O                  O                    O
 *              =======================================================================================
 *              public        O                  O                    O                  O
 *              =======================================================================================
 *
 *              멤버변수 (클래스영역에 설정되는 변수) => 프로그램 종료시까지 유지하는 메모라 공간 
 *                => 데이터를 보호 => private
 *              메소드 : 다른 클래스에서 사용이 가능하게 만든다 
 *                     객체는 객체와 객체의 상호 보완(연결)
 *                     public 
 *              생성자 : public 
 *              클래스 : public 
 *              
 *              사용방법 
 *              변수 ====> 접근지정어 데이터형 변수명;
 *                        private int age; ==> 다른 클래스에서 사용이 어렵다
 *                        ==> setAge() , getAge()
 *              메소드 ===> 기능 수행 (요청에 대한 처리)
 *                        접근지정어 리턴형 메소드명(요청데이터..매개변수)
 *                        public boolean isLogin(String id,String pwd)
 *                              ---------        ----------------------
 *                               결과값                        사용자가 요청값 
 *                        결과값 2개 =======> boolean
 *                        결과값 여러개 예상 ===> String , int
 *              생성자 ==> 초기화 담당
 *                       특징) 클래스명과 동일 
 *                            리턴형이 없다 
 *                            오버로딩이 가능 
 *                            클래스를 메모리에 저장할때 반드시 필요하다 
 *                              => 메모리에 저장 => new 생성자()
 *                                              ----- 새로운 메모리 생성 
 *                                              malloc() => 사용빈도가 많다 =>승격 (연산자) => new 
 *                                              free()  => delete (자바에서는 사용하지 않는다) => GC(자동 메모리 제거)
 *                                              GC의 단점 : 바로 해제하지 않는다 => System.gc()
 *                            형식) 
 *                                  public 클래스명() 
 *                                  public void 클래스명() => 일반 메소드
 *              프로그램 : 가독성 , 최적화 
 *                       ----- 메소드 (구조적인 프로그램)
 *                       
 *              클래스의 종류 
 *                컴파일러가 자동으로 생성 
 *                public class A
 *                {
 *                }
 *                컴파일 
 *                ==> public class A extends Object(최상위)
 *                
 *                public class A
 *                {
 *                   private int aa;
 *                }
 *                컴파일 
 *                ==> public class A extends Objet
 *                    {
 *                        private int aa;
 *                        public A() = 생성자 추가 (디폴트 생성자)
 *                        {
 *                        }
 *                    }
 *                 ==> public class A
 *                     {
 *                        public void display()
 *                        {
 *                            처리 ===
 *                        }
 *                        
 *                     }
 *                 ==> 컴파일                           
 *                     import java.lang.*; ==> 자동 추가  
 *                            String , Math ,System, SringBuffer,Wrapper
 *                     public class A (extends Object)
 *                     {
 *                        ============= 생성자 추가 2
 *                        public A()
 *                        {
 *                        }
 *                        =============
 *                        public void display()
 *                        {
 *                           처리 ===
 *                           3. return 
 *                        }
 *                     }
 *              ----------
 *                1. 일반 클래스
 *                   접근지정어 class className{
 *                      변수 : 선언만 가능 => 구현(X)
 *                      int a;
 *                      a=10;(X)
 *                      ==> 명시적 초기화 
 *                          int a=10;
 *                          
 *                      int a;
 *                      
 *                      {
 *                         a=10; // 초기화 블록 => 자동 호출 
 *                      }
 *                      
 *                      public 생성자() // 반드시 호출 
 *                      {
 *                         a=10;
 *                      }
 *                      
 *                      ==> 명시적 초기값 => 초기화 블록 => 생성자 
 *                          (초기화 블록과 생성자는 같이 사용하지 않는다)
 *                   }
 *                2. 추상 클래스 : 미완성된 클래스 (메모리에 저장이 불가능)
 *                              => 완성해서 사용 (상속을 받아소 완성후에 사용)
 *                   public abstract class className{
 *                      구현이 안된 메소드 선언 
 *                      public abstract void display();
 *                   }
 *                3. 인터페이스 : 추상 클래스의 일종 => 서로 다른 클래스 연결 (Spring)
 *                   public interface interName{
 *                      변수 선언 => 상수형 변수 (반드시 값을 입력) 
 *                      (public static final) int a; (error)
 *                      () int a=10;
 *                      메소드 => 구현이 안된 메소드만 선언 (요구사항) 
 *                      (public abstract) void display();
 *                   }
 *                   
 *                   public interface A
 *                   {
 *                      (public abstract) void display();
 *                   }
 *                   오버라이딩 : 접근 지정어를 축소할 수 없고 확대는 가능 
 *                             private < default < protected < public 
 *                   public class B implements A
 *                   {
 *                       void display() => 오류 
 *                       {
 *                       }
 *                       public void display() => 정상  
 *                       {
 *                       }
 *                   } 
 *                   
 *                   ==> 
 *                   interface ======> interface 상속  ==> 다중 상속 
 *                              extends (확장)
 *                   interface A
 *                   interface B extends A
 *                   interface C extends B
 *                   ==========  interface C extends A,B
 *                   interface ======> class 상속   ===> 다중 상속 
 *                              implements (구현후 사용)
 *                   class     ======> class  상속  ===> 단일 상속만 가능 
 *                              extends (확장) 
 *                   class     ======> interface (X)
 *                4. 내부 클래스
 *                   public class A => 멤버 클래스 (쓰레드,윈도우)
 *                   {
 *                      public class B
 *                      {
 *                      }
 *                   }
 *                   ==> Spring : POJO방식 (독립적으로 사용) 
 *                       다른 클래스에 영향이 없는 클래스 (상속,인테페이스 구현 (X))
 *                   public class A
 *                   {
 *                       B b=new B(){
 *                         public void display() => 상속이 없이 클래스 오버라이딩 (익명의 클래스)
 *                         {
 *                            => 람다식  ->
 *                         }
 *                       }
 *                   }
 *                   public class B
 *                   {
 *                       public void display()
 *                       {
 *                       }
 *                   }
 *                5. 상속 : 재사용 (추가,변경해서 사용) => 반복을 제거 , 속도가 늦다
 *                   => 상속의 예외 조건 
 *                      static , 생성자 , 초기블록 
 *                   => 상속은 한다 (사용을 못한다)
 *                      private => protected 
 *                public class A
 *                {
 *                   private int a,b,c; // 시큐어 코딩
 *                   getter/setter => lombok  
 *                }
 *                public class B extends A
 *                {
 *                =====================
 *                   private int a,b,c;
 *                =====================
 *                    int d;
 *                }
 *                6. 포함 : 재사용 (있는 그대로 사용) ==> 사용빈도가 많다 
 *                public class A
 *                public class B
 *                {
 *                    A a=new A(); // DataBase
 *                }
 *                *** 라이브러리 => 코딩을 볼 수 없다 
 *                
 *         ==> 에러방지 프로그램 
 *             예외처리 (가벼운 에러 => 소스상에서 수정이 가능한 에러) => if => 대체 (Annotation)
 *             시스템관련 에러,네트워크 관련 에러 => 에러 
 *               = 에러 발생 
 *                  = 사용자 입력 =======> 유효성 검사 
 *                  = 프로그램의 실수 ====> 배열 , 연산 
 *                    int[] arr=new int[2];
 *                    arr[1]=10;
 *                    arr[2]=20;  
 *               => 예외복구 (직접처리)
 *                  예외처리 : 자바 실행 과정 (javac , java)
 *                                      컴파일      인터프리터 
 *                                      컴파일 에러  실행시 에러 (예상이 안됨)
 *                                      ========= ==========
 *                                      CheckException UncheckException(예외처리 생략이 가능)
 *                                      -------------------------------
 *                                      컴파일시에 예외처리 여부 확인 
 *                                      => IOException (파일관련)
 *                                      => MalformedURLException (네트워크)
 *                                      => InterruptException (쓰레드)
 *                                      => SQLException(데이터베이스)
 *                                      => ClassNotFoundException (클래스 등록) => web
 *                  try
 *                  {
 *                     정상 수행 문장 
 *                     int a=10; ---- 정상 수행 
 *                     int b=0;  ---- 정상 수행 
 *                     int c=a/b; --------------> catch로 이동 
 *                           ---- 오류발생 
 *                     System.out.println(c);
 *                  }catch(예외처리 종류)
 *                  {
 *                     예외발생시 복구 => 0으로 나눌수 없다 
 *                  }
 *                  
 *                  ==============================try~catch================
 *                  
 *               => 예외회피 (간접처리)
 *                  형식)
 *                       시스템에 이런 예외가 발생할 수 있다고 알려만 준다 
 *                       => 메소드를 사용시에는 반드시 예외처리릏 하고 사용한다 
 *                       method() throws 예상되는 예외를 등록 
 *                       public void method() throws Exception ==> try~catch 
 *                                            ----------------- 라이브러리가 많다 
 *                       {
 *                           
 *                       }
 *             라이브러리 (자바) 
 *             --------------
 *              1. 자바에서 지원하는 라이브러리 
 *                 java.lang
 *                   Object 
 *                   ***String 
 *                   ***StringBuffer
 *                   ***Math 
 *                   System
 *                   Wrapper (데이터형을 클래스화) => 사용이 쉽게 만든어준 클래스 
 *                     => ***int Integer
 *                        ***double Double 
 *                        ***boolean Boolean 
 *                        byte    Byte 
 *                        long    Long  
 *                 java.util
 *                   Scanner
 *                   ***Date 
 *                   ***StringTokenizer 
 *                   ***Calendar 
 *                   StringFormat 
 *                   MessageFormat 
 *                   ------------- Collection (데이터 수집) ********** 자료구조 
 *                      => 가변형 (배열:고정) => 네트워크 사용자 정보 저장 , 데이터베이스 데이터 읽기 
 *                   3가지 종류 
 *                    List : 순서(인덱스)가 존재하고 데이터 중복을 허용 => 데이터베이스 프로그램 
 *                           => request  
 *                    Set : 순서가 존재하지 않는다, 데이터중복을 허용하지 않는다  
 *                           => cookie 
 *                    Map : 키와 값을 동시에 저장 => 클래스를 저장하고 관리 (스프링:클래스관리자)
 *                          키는 중복을 허용하지 않는다 
 *                          값은 중복이 허용 
 *                    ============================= 인터페이스 
 *                                 Collection 
 *                                    |
 *                         ---------------------------------------------
 *                         |          |                                |
 *                       List       Set(HashSet,TreeSet)               Map
 *                         |                                           | HashMap ,Hashtable
 *                   ---------------------
 *                   |          |         |
 *                 ArrayList  Vector    LinkedList
 *                  => 비동기   => 동기화 (네트워크 유저저장)
 *                 ---------
 *                     => 데이터베이스 
 *                     
 *                 => 데이터형 => Object (모든 데이터를 저장할 수 있다) 
 *                    Object o=1
 *                    Object o=true
 *                    Object o=10.5
 *                    Object o="Hello"
 *                    ==> 데이터형을 통일 => 사용이 쉽게 만들어 준다 (제네릭스)
 *                        형변환없이 사용이 가능 
 *                    List list=new ArrayList() => 모든 메소드의 리턴형 Object (for사용이 어렵다)
 *                    List<String> list=new ArrayList<String>
 *                      => Object => String 변환 
 *                   T => Type(class형)
 *                   K => Key
 *                   V => Value 
 *                   Map<K,V>
 *                   class Box<T> => Type (Class)  <int> , <double> (X) 
 *                                                 <Integer> , <Double>
 *                   {
 *                       T t;
 *                       public void setT(T t)
 *                       {
 *                          this.t=t;
 *                       }
 *                       public T getT()
 *                       {
 *                          return t;
 *                       }
 *                   }
 *                   
 *                   class Box<T>
 *                   {
 *                       T t;
 *                       public void setT(T t)
 *                       {
 *                          this.t=t;
 *                       }
 *                       public T getT()
 *                       {
 *                          return t;
 *                       }
 *                   }
 *                   
 *                   Box<String> box=new Box<String>();
 *                   class Box<String>
 *                   {
 *                       String t;
 *                       public void setT(String t)
 *                       {
 *                          this.t=t;
 *                       }
 *                       public String getT()
 *                       {
 *                          return t;
 *                       }
 *                   }
 *                 java.net : URL, URLEncoder => 
 *                            java => 브라우저 => java
 *                            (char2) (char1)  (char2)
 *                               Encoding    Decoding
 *                               %EC%9E%90%EB%B0%94 자바
 *                 https://www.google.com/search?q=%EC%9E%90%EB%B0%94&oq=%EC%9E%90%EB%B0%94&aqs=chrome..69i57j69i59l2j0i433i512l4j0i512j0i433i512j0i512.897j0j15&sourceid=chrome&ie=UTF-8
 *                 java.io 
 *                   File 
 *                   FileReader
 *                   FileWriter
 *                   FileInputStream 
 *                   FileOutputStream 
 *                   BufferedReader 
 *              2. 외부 업체에서 만든 라이브러리 (mvnrepository.com) => Jsoup , Json...
 *                                                              ------
 *                   JSON / Jsoup 
 *                 
 *              
 */
// sleep() throws InterruptedException
public class MainClass {
     public static void main(String[] args) throws Exception {
		 
	 }
}




