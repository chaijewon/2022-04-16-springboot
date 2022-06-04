package com.it.board.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.Getter;
import lombok.Setter;
@Entity(name="board") //테이블 연결 
@Getter
@Setter
public class BoardEntity {
  @Id    //primary key
  private int no;
  private String name,subject,content,pwd;
  private LocalDateTime regdate;
  private int hit;
  
  @PrePersist
  public void regdate()
  {
	  this.regdate=LocalDateTime.now();
  }
}
