package com.it.food.service;

import java.util.List;
import java.util.Map;

import com.it.food.vo.BoardVO;

public interface BoardService {
	public List<BoardVO> boardListData(Map map);
	public int boardTotalPage();
	public void boardInsert(BoardVO vo);
	//public void hitIncrement(int no);
	public BoardVO boardDetailData(int no);
	public BoardVO boardUpdateData(int no);
	public void boardUpdate(BoardVO vo);
	public void boardDelete(int no);
}
