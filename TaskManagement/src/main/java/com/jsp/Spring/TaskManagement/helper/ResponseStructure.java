package com.jsp.Spring.TaskManagement.helper;

public class ResponseStructure<T>{
	
	private int statueCode;
	private String mesg;
	private T data;
	public int getStatueCode() {
		return statueCode;
	}
	public void setStatueCode(int statueCode) {
		this.statueCode = statueCode;
	}
	public String getMesg() {
		return mesg;
	}
	public void setMesg(String mesg) {
		this.mesg = mesg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	

}
