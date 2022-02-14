package com.cuoikhoa.demo.model;

public class ResponseDTO {
	private String status;
	private String message;
	private Object data;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	public ResponseDTO(String status, String message, Object data) {
		this.message = message;
		this.status = status;
		this.data = data;
	}
	
	public ResponseDTO() {
	}
	
}
