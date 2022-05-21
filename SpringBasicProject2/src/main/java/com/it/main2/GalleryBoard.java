package com.it.main2;

import org.springframework.stereotype.Repository;

@Repository("gb")
public class GalleryBoard implements Board{

	@Override
	public void list() {
		// TODO Auto-generated method stub
		System.out.println("GalleryBoard:list() Call..");
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		System.out.println("GalleryBoard:insert() Call..");
	}

}
