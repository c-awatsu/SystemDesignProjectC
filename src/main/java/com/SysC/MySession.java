package com.SysC;

import java.util.Optional;

import lombok.Getter;
import lombok.ToString;

import org.apache.wicket.Session;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

@ToString
public class MySession extends AbstractAuthenticatedWebSession{

	@Getter
	private Optional<Sign> loginInfo;

	public MySession(Request request) {
		super(request);
	}

	public static MySession get(){
		return (MySession) Session.get();
	}



	private static final long serialVersionUID = -8641210825955256991L;

	@Override
	public Roles getRoles() {
		return null;
	}

	@Override
	public boolean isSignedIn() {
		return false;
	}

}
