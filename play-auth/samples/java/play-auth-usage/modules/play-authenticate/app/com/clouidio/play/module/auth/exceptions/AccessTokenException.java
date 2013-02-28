package com.clouidio.play.module.auth.exceptions;

public class AccessTokenException extends AuthException {
	private static final long serialVersionUID = 1L;

	public AccessTokenException(final String message) {
		super(message);
	}

	public AccessTokenException() {
		super();
	}

}
