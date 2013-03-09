package com.clouidio.play.module.auth.exceptions;

public class AccessDeniedException extends AuthException {
	private static final long serialVersionUID = 1L;
	private String providerKey;

	public AccessDeniedException(final String providerKey) {
		super();
		this.providerKey = providerKey;
	}

	public AccessDeniedException() {
		super();
	}

	public String getProviderKey() {
		return providerKey;
	}

}
