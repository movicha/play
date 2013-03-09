package com.clouidio.play.module.auth.providers.openid;

import java.util.Map;

import play.libs.OpenID.UserInfo;

import com.clouidio.play.module.auth.providers.openid.OpenIdAuthProvider.SettingKeys;
import com.clouidio.play.module.auth.user.AuthUser;

public class OpenIdAuthUser extends AuthUser {
	private static final long serialVersionUID = 1L;

	private final String id;
	private final Map<String, String> attributes;

	public OpenIdAuthUser(final String id, final UserInfo u) {
		this.id = id;
		attributes = u.attributes;
	}

	@Override
	public String getId() {
		return id;
	}

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public String getAttribute(final String attribute) {
		if (attributes != null) {
			return attributes.get(attribute);
		} else {
			return null;
		}
	}

	@Override
	public String getProvider() {
		return SettingKeys.PROVIDER_KEY;
	}
}
