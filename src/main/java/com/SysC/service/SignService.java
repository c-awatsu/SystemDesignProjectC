package com.SysC.service;

import static java.util.Optional.*;

import java.util.List;
import java.util.Optional;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;

import com.SysC.bean.Sign;
import com.SysC.bean.SignIn;
import com.SysC.bean.SignUp;
import com.SysC.bean.TeacherSignUp;
import com.SysC.dao.ISignRepository;
import com.google.inject.Inject;

public class SignService implements ISignService{

	@Inject
	private ISignRepository signRepository;

	@Override
	public Optional<Sign> authenticate(SignIn authentication) {
		Sign sign = null;
		int accountId = signRepository.fetchAccountId(authentication.getAccountName(),
													  DigestUtils.sha256Hex(authentication.getPassphrase()));
		String role = signRepository.fetchARSRole(accountId);
		sign = new Sign(accountId,authentication.getAccountName(),new Roles(role));

		return ofNullable(sign);
	}

	@Override
	public List<Integer> existUser() {
 		return signRepository.fetchAccountId();
	}

	@Override
	public boolean joinAccount(SignUp signUp) {
		return	signRepository.insert
						(signUp.getAccountName(),
						 DigestUtils.sha256Hex(signUp.getPassphrase())
						,signUp.getRole()
						)==1;
	}
	
	@Override
	public boolean joinAccount(TeacherSignUp teacherSignUp){
		return signRepository.insert
						(teacherSignUp.getAccountName(),
								DigestUtils.sha256Hex(teacherSignUp.getPassphrase())
								,teacherSignUp.getRole()
								)==1;
	}


}
