package com.clouidio.play.module.auth.exceptions;

public class AuthException extends Exception {
	private static final long serialVersionUID = 1L;

	public AuthException(final String message) {
		super(message);
	}
	
	public AuthException() {
		super();
	}
}
