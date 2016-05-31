package com.SysC;

import static com.SysC.costant.ARSRoles.*;
import static java.util.Optional.*;

import java.util.Optional;

import lombok.Getter;
import lombok.ToString;

import org.apache.wicket.Session;
import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

import com.SysC.bean.Sign;

@ToString
public class MySession extends AbstractAuthenticatedWebSession{
	private static final long serialVersionUID = -8641210825955256991L;

	@Getter
	private Optional<Sign> loginInfo;

	public static MySession get(){
		return (MySession) Session.get();
	}

	public MySession(Request request) {
		super(request);
		loginInfo = empty();
	}

	@Override
	public void invalidate() {
		replaceSession();
		loginInfo = empty();
		super.invalidate();
	}

	@Override
	public Roles getRoles() {
		return loginInfo.map(l->l.getRole()).orElse(new Roles());
	}

	@Override
	public boolean isSignedIn() {
		return loginInfo.isPresent();
	}

	public final void signIn(Optional<Sign> loginInfo){
		this.loginInfo = loginInfo;
		this.loginInfo.ifPresent(l ->{
			replaceSession();
			dirty();
		});
	}

	public final int getAccountId(){
		return loginInfo.map(l -> l.getAccountId()).orElseThrow(() -> new WicketRuntimeException("session is empty!"));

	}

	public final String getAccountName(){
		return loginInfo.map(l -> l.getAccountName()).orElseThrow(() -> new WicketRuntimeException("session is empty!"));
	}

	public final boolean isTeacher(){
		return getRoles().hasRole(TEACHER);
	}

	public final boolean isTA(){
		return getRoles().hasRole(TA);
	}

	public final boolean isStudent(){
		return getRoles().hasRole(STUDENT);
	}

}
