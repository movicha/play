package com.clouidio.play.module.auth.providers.openid.exceptions;

import com.clouidio.play.module.auth.exceptions.AuthException;

public class OpenIdConnectException extends AuthException {

	public OpenIdConnectException(String message) {
		super(message);
	}

	private static final long serialVersionUID = 1L;

}
