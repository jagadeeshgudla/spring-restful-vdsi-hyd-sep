package com.demo.spring;

public class MessageWrapper<T> {

	private T myObject;
	private String message;
	
	public MessageWrapper(T myObject, String message) {
		this.myObject = myObject;
		this.message = message;
	}
	public MessageWrapper() {
		
	}
	public T getMyObject() {
		return myObject;
	}
	public void setMyObject(T myObject) {
		this.myObject = myObject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
