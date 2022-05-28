package com.it.vo;

import lombok.Getter;
import lombok.Setter;

/*
 *  cno int AI PK 
title varchar(2000) 
subject varchar(2000) 
poster varchar(260) 
link varchar(260)
 */
@Getter
@Setter
public class CategoryVO {
     private int cno;
     private String title,subject,poster;
}
