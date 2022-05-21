package com.it.main2;

import org.springframework.stereotype.Repository;

@Repository("rb")
public class ReplyBoard implements Board{

	@Override
	public void list() {
		// TODO Auto-generated method stub
		System.out.println("ReplyBoard:list() Call..");
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		System.out.println("ReplyBoard:insert() Call..");
	}

}
