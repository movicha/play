package com.clouidio.play.module.auth.providers.oauth1;

import com.clouidio.play.module.auth.user.AuthUser;
import com.clouidio.play.module.auth.user.AuthUserIdentity;
import com.clouidio.play.module.auth.user.NameIdentity;

public abstract class BasicOAuth1AuthUser extends OAuth1AuthUser implements NameIdentity, AuthUserIdentity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BasicOAuth1AuthUser(final String id, final OAuth1AuthInfo info,
			final String state) {
		super(id, info, state);
	}

	@Override
	public String toString() {
		return AuthUser.toString(this);
	}

}