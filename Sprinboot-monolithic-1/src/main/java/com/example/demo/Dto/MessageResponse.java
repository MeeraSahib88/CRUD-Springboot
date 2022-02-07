package com.example.demo.Dto;

import lombok.Data;

@Data
public class MessageResponse {

	private int status;
	
	private String message;
	
	private Object response;
	
	public MessageResponse(int status, String message, Object response) {
		super();
		this.status = status;
		this.message = message;
		this.response = response;
	}

	public MessageResponse(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	
	
}
