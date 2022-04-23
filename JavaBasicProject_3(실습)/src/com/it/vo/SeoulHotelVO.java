package com.it.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// Hotel 한개의 모든 정보 => 관리하기가 쉽다 
// 여러개가 나오면 (데이터 ,클래스 ) => 한개의 이름으로 전체를 제어 
/*
 *   데이터가 여러개 
 *   1)
 *       90,80,79,67,89 .... => int[] arr={90,80,79,67,89}
 *       
 */
public class SeoulHotelVO extends SeoulVO{
	private String images;
}
