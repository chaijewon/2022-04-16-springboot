package com.it.dao;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface DataBoardMapper {
   // 목록 출력 
    @Select("SELECT no,subject,name,DATE_FORMAT(regdate,'%Y-%m-%d') as dbday,hit "
    	   +"FROM databoard "
    	   +"ORDER BY no DESC "
    	   +"limit #{start},#{rowSize}")
    public List<DataBoardVO> databoardListData(Map map);
    //  ===> 매개변수는 반드시 1개만 설정이 가능 (데이터가 많은 경우 => ~VO,Map)
    // 총페이지 
    @Select("SELECT CEIL(COUNT(*)/10.0) FROM databoard")
    public int databoardTotalPage();
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
   /*@SelectKey(keyProperty = "no",resultType = int.class,before = true,
		   statement = "SELECT ifnull(MAX(no)+1,1) FROM databoard")*/
   @Insert("INSERT INTO dataBoard(name,subject,content,pwd,filename,filesize,filecount) "
		  +"VALUES(#{name},#{subject},#{content},"
		  +"#{pwd},#{filename},#{filesize},#{filecount})")
   public void databoardInsert(DataBoardVO vo);
   // 수정 
   // 삭제 
   @Select("SELECT pwd FROM databoard "
		  +"WHERE no=#{no}")
   public String databoardGetPassword(int no);
   
   @Delete("DELETE FROM databoard "
		  +"WHERE no=#{no}")
   public void databoardDelete(int no);
}






