package com.it.dao;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
// 사용자 정의 데이터형 => 스프링 담당이 아니라 필요시마다 사용 
public class CategoryVO {
    private int cno;
    private String title;
    private String subject;
    private String poster;
}
