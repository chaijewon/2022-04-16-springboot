package com.it.food.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.food.dao.BoardMapper;
import com.it.food.vo.BoardVO;

// BI 
@Service
public class BoardServiceImpl implements BoardService{
    @Autowired
    private BoardMapper mapper;

	@Override
	public List<BoardVO> boardListData(Map map) {
		// TODO Auto-generated method stub
		return mapper.boardListData(map);
	}

	@Override
	public int boardTotalPage() {
		// TODO Auto-generated method stub
		return mapper.boardTotalPage();
	}

	@Override
	public void boardInsert(BoardVO vo) {
		// TODO Auto-generated method stub
		mapper.boardInsert(vo);
	}

	@Override
	public BoardVO boardDetailData(int no) {
		// TODO Auto-generated method stub
		mapper.hitIncrement(no);
		return mapper.boardDetailData(no);
	}
}
