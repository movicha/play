package com.clouidio.play.module.auth.providers.oauth1.linkedin;

import com.clouidio.play.module.auth.providers.oauth1.OAuth1AuthInfo;

public class LinkedinAuthInfo extends OAuth1AuthInfo {
	private static final long serialVersionUID = 1L;

	public LinkedinAuthInfo(final String token, final String tokenSecret) {
		super(token, tokenSecret);
	}
}
