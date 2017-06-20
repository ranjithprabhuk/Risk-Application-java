/**
 * 
 */
package com.challido.RiskApplication.dto;

import org.hibernate.exception.DataException;

/**
 * @author URK7KOR
 *
 */
public class ResponseDto<T> {
	
	private static final String SUCCESS = "SUCCESS";
	private static final String FAILURE = "FAILURE";
	
	private String status;
	private String message;
	private String code;
	private T data;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	public void isSuccess(boolean isSuccess){
		this.setStatus(isSuccess ? ResponseDto.SUCCESS : ResponseDto.FAILURE);
	}
	
	public void setException(DataException e){
		this.isSuccess(false);
		this.setMessage(e.getMessage());
	}

}
