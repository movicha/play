package com.clouidio.play.module.auth.providers.oauth1;

import com.clouidio.play.module.auth.user.AuthUser;

public abstract class OAuth1AuthUser extends AuthUser {
	private static final long serialVersionUID = 1L;

	private OAuth1AuthInfo info;
	private String id;

	private final String state;

	public OAuth1AuthUser(final String id, final OAuth1AuthInfo info,
			final String state) {
		this.info = info;
		this.id = id;
		this.state = state;
	}

	public OAuth1AuthInfo getOAuth1AuthInfo() {
		return info;
	}

	@Override
	public String getId() {
		return id;
	}


	public String getState() {
		return state;
	}
}
