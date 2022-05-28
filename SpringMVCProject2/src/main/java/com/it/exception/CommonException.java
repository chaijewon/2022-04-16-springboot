package com.it.exception;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonException {
  @ExceptionHandler(SQLException.class)
  public void sqlException(SQLException ex)
  {
	  System.out.println("===== SQLException 발생 =====");
	  System.out.println(ex.getMessage());
	  System.out.println("============================");
  }
  @ExceptionHandler(RuntimeException.class)
  public void runtimeException(RuntimeException ex)
  {
	  System.out.println("===== RuntimeException 발생 =====");
	  System.out.println(ex.getMessage());
	  System.out.println("============================");
  }
  @ExceptionHandler(Exception.class)
  public void exception(Exception ex)
  {
	  System.out.println("===== Exception 발생 =====");
	  System.out.println(ex.getMessage());
	  System.out.println("============================");
  }
}
