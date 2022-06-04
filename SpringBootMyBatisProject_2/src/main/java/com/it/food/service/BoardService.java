package com.it.food.service;

import java.util.List;
import java.util.Map;

import com.it.food.vo.BoardVO;

public interface BoardService {
	public List<BoardVO> boardListData(Map map);
	public int boardTotalPage();
}
