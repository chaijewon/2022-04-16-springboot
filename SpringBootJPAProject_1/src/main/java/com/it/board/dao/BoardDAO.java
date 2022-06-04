package com.it.board.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.it.board.entity.BoardEntity;
import java.util.*;
@Repository
public interface BoardDAO extends JpaRepository<BoardEntity, Integer>{
     //목록 
	 @Query(value="SELECT no,name,subject,content,pwd,regdate,hit "
		         +"FROM board ORDER BY no DESC "
			     +"limit :start,10",nativeQuery = true )
	 public List<BoardEntity> boardListData(@Param("start") int start);
	 //총페이지
	 @Query(value="SELECT CEIL(COUNT(*)/10.0) FROM board",nativeQuery = true)
	 public int boardTotalPage();
	 
	 //상세보기
	 public BoardEntity findByNo(@Param("no") Integer no);
	 // SELECT * FROM board WHERE no=?
	 //수정 / 삭제 / 추가 => 지원하는 메소드 이용 
}
