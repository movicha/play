package com.clouidio.play.module.auth.user;

public interface ExtendedIdentity extends BasicIdentity, FirstLastNameIdentity {
	public String getGender();
}
