package com.example.demo.Dto;

import java.math.BigDecimal;

import org.joda.time.DateTime;

import lombok.Data;

@Data
public class gadgetDto {
	
private String Id;
	
	private String name;
	
	private BigDecimal price;
	
	private String description;
	
	private String brand;
	
}
