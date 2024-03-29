package com.clouidio.play.module.auth.providers.oauth1;

import com.clouidio.play.module.auth.providers.AuthInfo;

public  class OAuth1AuthInfo extends AuthInfo {
	private static final long serialVersionUID = 1L;
	
	private String accessToken;
	private String accessTokenSecret;

	public OAuth1AuthInfo(final String token, final String tokenSecret) {
		accessToken = token;
		accessTokenSecret = tokenSecret;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public String getAccessTokenSecret() {
		return accessTokenSecret;
	}
}
