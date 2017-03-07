package com.eurogo.exception;

public class VertexNotFoundException extends Exception{
	private static final long serialVersionUID = 42L;

	public VertexNotFoundException(String message){
		super(message);
	}
}
