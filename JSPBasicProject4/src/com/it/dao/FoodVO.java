package com.it.dao;
/*
 *  no int,
	   poster VARCHAR(2000) NOT NULL,
	   name VARCHAR(300) NOT NULL ,
	   score double NOT NULL,
	   address VARCHAR(2000) NOT NULL,
	   tel VARCHAR(20) NOT NULL,
	   type VARCHAR(100) NOT NULL,
	   price VARCHAR(30) NOT NULL,
	   time VARCHAR(50),
	   parking VARCHAR(100),
	   menu VARCHAR(4000),
 */
public class FoodVO {
    private int no;
    private double score;
    private String poster,name,address,tel,type,price,time,parking,menu;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getParking() {
		return parking;
	}
	public void setParking(String parking) {
		this.parking = parking;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
    
}
