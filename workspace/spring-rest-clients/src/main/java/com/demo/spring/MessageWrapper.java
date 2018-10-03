package com.demo.spring;

import java.util.ArrayList;
import java.util.List;

public class MessageWrapper<T> {
	private T wrapped;
	private String message;

	public MessageWrapper(T wrapped, String message) {
		this.wrapped = wrapped;
		this.message = message;
	}

	public T getWrapped() {
		return wrapped;
	}

	public void setWrapped(T wrapped) {
		this.wrapped = wrapped;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static void main(String[] args) {
		MessageWrapper<List<String>> list = new MessageWrapper<List<String>>(new ArrayList<>(), "Dummy");
	}
}
