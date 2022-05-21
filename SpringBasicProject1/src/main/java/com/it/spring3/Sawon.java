package com.it.spring3;
/*
 *   1. DI
 *       = 객체 생성 
 *       = 주입 (변수의 초기화)
 *             -----------
 *             1) setter 
 *             2) constructor
 *             3) 생성시 호출 , 소멸시 호출 
 *       = 객체 소멸 
 *       = 객체와 객체의 관계 
 *       ------------------- 클래스를 모아서 관리 (DL:클래스)
 *   2. AOP (Transaction,log) : 반복을 제거 (공통 모듈) ==> 자동 호출이 가능 (OOP를 보완)
 *       = 호출 시점 (JoinPoint)
 *         public void display()
 *         {
 *             @Around  conn.setAutoCommit(false)
 *             => 처리 
 *                insert() : 정상 수행 (입고)
 *                insert() : 오류 (재고)
 *             @Around  conn.commit()
 *         }
 *         public void display()
 *         {
 *            @Before(드라이버 등록) ==> CallBack
 *            try
 *            {
 *            }catch(Exception e)
 *            {
 *               @AfterThrowing(오류 발생)
 *            }
 *            finally
 *            {
 *               @After(에러발생 , 미발생)
 *            }
 *            return; @AfterReturning (정상)
 *         }
 *       = 메소드 대상 (PointCut)
 *       ---------------------- + Advice
 *                               -------
 *                                 Aspect : 공통모듈  
 *   --------
 *   3. MVC (웹 => Front-end / Back-end) : 자바/html (Spring에서는 MVC만 있다)
 *   --------
 */
// 1. 클래스 생성후 관리 
/*
 *     스프링에서 클래스 생성 / 소멸 담당하는 클래스 => ApplicationContext
 *     ----------------------------------- 컨테이너 (사용자 만든 클래스 : 컴포넌트)
 *           스프링에서 제공하는 컨테이너 
 *           ----------------------
 *             BeanFactory : core (DI, 객체생성 .소멸)
 *               |
 *            ApplicationContext : core+AOP => AnnotationConfigApplicationContext
 *               |
 *          WebApplicationContext : core+AOP+MVC
 *     => Spring4 => Spring5(보안) => Boot(Annotation)
 *        -------    ------- => Java파일을 이용해서 처리 (호환성이 있다)
 *        설정 파일 => 4(XML,properties) 
 */
public class Sawon {
    private int sabun;
    private String name;
    private String dept;
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public String getName() {
		return name;
	}
	// setter DI
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Sawon()
	{
		
	}
	// constructor DI
	public Sawon(int sabun, String name, String dept) {
		this.sabun = sabun;
		this.name = name;
		this.dept = dept;
	}
	// 객체 생성시 
	public void init()
	{
		System.out.println("===== 사원 정보 =====");
	}
	// 객체 소멸시 
	public void destory()
	{
		System.out.println("Sawon 객체 메모리 해제...");
	}
   
}
