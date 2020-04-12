package com.flair.world.exception.support;

public class CodeNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CodeNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public CodeNotFoundException(String message) {
		super(message);
	}

	public CodeNotFoundException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public CodeNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public CodeNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}
}
