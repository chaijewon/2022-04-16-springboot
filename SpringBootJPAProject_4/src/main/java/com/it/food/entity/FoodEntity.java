package com.it.food.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity(name="foodlocation")
public class FoodEntity {
	@Id
    private int no;
    private String poster,name,address,tel,type,price,time,parking,menu;
    private double score;
}
