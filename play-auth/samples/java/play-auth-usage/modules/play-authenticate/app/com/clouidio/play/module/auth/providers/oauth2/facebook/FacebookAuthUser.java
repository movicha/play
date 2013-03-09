package com.clouidio.play.module.auth.providers.oauth2.facebook;

import java.util.Locale;

import org.codehaus.jackson.JsonNode;

import com.clouidio.play.module.auth.providers.oauth2.BasicOAuth2AuthUser;
import com.clouidio.play.module.auth.user.AuthUser;
import com.clouidio.play.module.auth.user.ExtendedIdentity;
import com.clouidio.play.module.auth.user.LocaleIdentity;
import com.clouidio.play.module.auth.user.PicturedIdentity;
import com.clouidio.play.module.auth.user.ProfiledIdentity;

public class FacebookAuthUser extends BasicOAuth2AuthUser implements
		ExtendedIdentity, PicturedIdentity, ProfiledIdentity, LocaleIdentity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static abstract class Constants {
		public static final String ID = "id"; // "616473731"
		public static final String NAME = "name"; // "Alex Barreto"
		public static final String FIRST_NAME = "first_name";// "Alex"
		public static final String LAST_NAME = "last_name"; // "Barreto"
		public static final String LINK = "link"; // "http://www.facebook.com/shakayumi"
		public static final String USERNAME = "username";// "shakayumi"
		public static final String GENDER = "gender";// "male"
		public static final String EMAIL = "email";// "alex@clouidio.com"
		public static final String TIME_ZONE = "timezone";// 2
		public static final String LOCALE = "locale";// "en_GB"
		public static final String VERIFIED = "verified";// true
		public static final String UPDATE_TIME = "updated_time"; // "2012-04-26T20:22:52+0000"}
	}

	private String name;
	private String firstName;
	private String lastName;
	private String link;
	private String username;
	private String gender;
	private String email;
	private boolean verified = false;
	private int timezone;
	private String locale;
	private String updateTime;

	public FacebookAuthUser(final JsonNode node, final FacebookAuthInfo info,
			final String state) {
		super(node.get(Constants.ID).asText(), info, state);

		if (node.has(Constants.NAME)) {
			this.name = node.get(Constants.NAME).asText();
		}
		if (node.has(Constants.FIRST_NAME)) {
			this.firstName = node.get(Constants.FIRST_NAME).asText();
		}
		if (node.has(Constants.LAST_NAME)) {
			this.lastName = node.get(Constants.LAST_NAME).asText();
		}
		if (node.has(Constants.LINK)) {
			this.link = node.get(Constants.LINK).asText();
		}
		if (node.has(Constants.USERNAME)) {
			this.username = node.get(Constants.USERNAME).asText();
		}
		if (node.has(Constants.GENDER)) {
			this.gender = node.get(Constants.GENDER).asText();
		}
		if (node.has(Constants.EMAIL)) {
			this.email = node.get(Constants.EMAIL).asText();
		}
		if (node.has(Constants.VERIFIED)) {
			this.verified = node.get(Constants.VERIFIED).asBoolean(false);
		}
		if (node.has(Constants.TIME_ZONE)) {
			this.timezone = node.get(Constants.TIME_ZONE).asInt();
		}
		if (node.has(Constants.LOCALE)) {
			this.locale = node.get(Constants.LOCALE).asText();
		}
		if (node.has(Constants.UPDATE_TIME)) {
			this.updateTime = node.get(Constants.UPDATE_TIME).asText();
		}
	}

	@Override
	public String getProvider() {
		return FacebookAuthProvider.PROVIDER_KEY;
	}

	public String getName() {
		return name;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getProfileLink() {
		return link;
	}

	public String getUsername() {
		return username;
	}

	public String getGender() {
		return gender;
	}

	public String getEmail() {
		return email;
	}

	public boolean isVerified() {
		return verified;
	}

	public int getTimezone() {
		return timezone;
	}

	public String getPicture() {
		// According to
		// https://developers.facebook.com/docs/reference/api/#pictures
		return String.format("https://graph.facebook.com/%s/picture", getUsername());
	}

	public Locale getLocale() {
		return AuthUser.getLocaleFromString(locale);
	}

	public String getUpdateTime() {
		return updateTime;
	}
}
