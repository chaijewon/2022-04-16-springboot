package com.it.main;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component("sa")
public class Sawon {
   private String name;
   private String dept;
   private String loc;
}
