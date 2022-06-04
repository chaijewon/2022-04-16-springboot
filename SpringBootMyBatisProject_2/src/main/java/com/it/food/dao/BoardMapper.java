package com.it.food.dao;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.it.food.vo.BoardVO;

@Repository
@Mapper
public interface BoardMapper {
  public List<BoardVO> boardListData(Map map);
  public int boardTotalPage();
  public void boardInsert(BoardVO vo);
  public void hitIncrement(int no);
  public BoardVO boardDetailData(int no); // findByNo(int no)
  public void boardUpdate(BoardVO vo);
  public void boardDelete(int no);
}
