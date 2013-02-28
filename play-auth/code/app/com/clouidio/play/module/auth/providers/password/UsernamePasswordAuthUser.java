package com.clouidio.play.module.auth.providers.password;

import org.mindrot.jbcrypt.BCrypt;

import com.clouidio.play.module.auth.user.AuthUser;
import com.clouidio.play.module.auth.user.EmailIdentity;

public abstract class UsernamePasswordAuthUser extends AuthUser implements EmailIdentity {
	private static final long serialVersionUID = 1L;
	
	private final transient String password;
	private final String email;

	public UsernamePasswordAuthUser(final String clearPassword, final String email) {
		this.password = clearPassword;
		this.email = email;
	}
	
	@Override
	public String getId() {
		return getHashedPassword();
	}

	@Override
	public String getProvider() {
		return UsernamePasswordAuthProvider.PROVIDER_KEY;
	}

	@Override
	public String getEmail() {
		return email;
	}

	public String getHashedPassword() {
		return createPassword(this.password);
	}
	
	/**
	 * You *SHOULD* provide your own implementation of this which implements your own security.
	 */
	protected String createPassword(final String clearString) {
		return BCrypt.hashpw(clearString, BCrypt.gensalt());
	}
	
	/**
	 * You *SHOULD* provide your own implementation of this which implements your own security.
	 */
	public boolean checkPassword(final String hashed, final String candidate) {
		if(hashed == null || candidate == null) {
			return false;
		}
		return BCrypt.checkpw(candidate, hashed);
	}
	
	public String getPassword() {
		return this.password;
	}
}
