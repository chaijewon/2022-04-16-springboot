package com.it.dao;
/*
 *      no int AI PK 
		name varchar(34) 
		subject varchar(1000) 
		content text 
		pwd varchar(10) 
		regdate datetime 
		hit int 
		filename varchar(1000) 
		filesize varchar(300) 
		filecount int
 */
import java.util.*;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class DataBoardVO {
   private int no,hit,filecount;
   private String name,subject,content,pwd,filename,filesize,dbday;
   private Date regdate;
   private List<MultipartFile> files;
}
