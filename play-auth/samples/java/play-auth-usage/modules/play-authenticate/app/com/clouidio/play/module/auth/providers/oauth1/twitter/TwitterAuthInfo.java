package com.clouidio.play.module.auth.providers.oauth1.twitter;

import com.clouidio.play.module.auth.providers.oauth1.OAuth1AuthInfo;

public class TwitterAuthInfo extends OAuth1AuthInfo {
	private static final long serialVersionUID = 1L;

	public TwitterAuthInfo(final String token, final String tokenSecret) {
		super(token, tokenSecret);
	}
}
