package com.clouidio.play.module.auth.providers.openid.exceptions;

import com.clouidio.play.module.auth.exceptions.AuthException;

public class NoOpenIdAuthException extends AuthException {

	public NoOpenIdAuthException(final String string) {
		super(string);
	}

	private static final long serialVersionUID = 1L;
}
