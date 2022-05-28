package com.it.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
/*
 *    1. @Controller => 요청처리 => 파일 지정 
 *    2. @RestController => 요청처리 =>  처리 결과값을 전송 => JavaScript/Kotlin(JSON)
 *    3. @Repository => DAO(저장소)
 *    4. @Service => BI (DAO를 여러개를 묶어서)
 *    5. @ControllerAdvice => 공통으로 예외처리
 *    6. @Component => 일반 클래스 
 */
@Repository
public class DataBoardDAO {
   /*
    *  @Select("SELECT no,subject,name,DATE_FORMAT(regdate,'%Y-%m-%d') as dbday,hit "
    	   +"FROM databoard "
    	   +"ORDER BY no DESC "
    	   +"limit #{start},#{rowSize}")
    public List<DataBoardVO> databoardListData(Map map);
    //  ===> 매개변수는 반드시 1개만 설정이 가능 (데이터가 많은 경우 => ~VO,Map)
   // 상세 보기(다운로드)
    @Update("UPDATE databoard SET "
    	   +"hit=hit+1 "
    	   +"WHERE no=#{no}")
    public void hitIncrement(int no);
    @Select("SELECT no,name,subject,content,DATE_FORMAT(regdate,'%Y-%m-%d') as dbday,hit,filename,filesize,filecount "
    	   +"FROM databoard "
    	   +"WHERE no=#{no}")
    public DataBoardVO databoardDetailData(int no);
   // 추가 (업로드) => 시퀀스
   @SelectKey(keyProperty = "no",resultType = int.class,before = true,
		   statement = "SELECT ifnull(MAX(no)+1,1) FROM databoard")
   @Insert("INSERT INTO dataBoard(name,subject,content,pwd,filename,filesize,filecount) "
		  +"VALUES(#{name},#{subject},#{content},"
		  +"#{pwd},#{filename},#{filesize},#{filecount})")
   public void databoardInsert(DataBoardVO vo);
    */
	// 구현된 클래스 읽기 
	@Autowired // 자동 주입 
	private DataBoardMapper mapper;
	public List<DataBoardVO> databoardListData(Map map)
	{
		return mapper.databoardListData(map);
	}
	public int databoardTotalPage()
	{
		return mapper.databoardTotalPage();
	}
	public DataBoardVO databoardDetailData(int no)
	{
		mapper.hitIncrement(no);
		return mapper.databoardDetailData(no);
	}
	public void databoardInsert(DataBoardVO vo)
	{
		mapper.databoardInsert(vo);
	}
	
	/*
	 *  @Select("SELECT pwd FROM databoard "
		  +"WHERE no=#{no}")
   public String databoardGetPassword(int no);
   
   @Delete("DELETE FROM databoard "
		  +"WHERE no=#{no}")
   public void databoardDelete(int no);
	 */
	public boolean databoardDelete(int no,String pwd)
	{
		//DAO는 매개변수 ,리턴형을 마음대로 코딩이 가능 
		boolean bCheck=false;
		String db_pwd=mapper.databoardGetPassword(no);//데이터베이스에 저장된 비밀번호 읽기
		if(pwd.equals(db_pwd))
		{
			// 삭제 
			bCheck=true;
			mapper.databoardDelete(no);
		}
		else
		{
			// 삭제안됨
			bCheck=false;
		}
		return bCheck;
	}
}
