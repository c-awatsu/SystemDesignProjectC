package com.SysC.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.codec.digest.DigestUtils;

import com.SysC.bean.Sign;
import com.SysC.bean.SignIn;
import com.SysC.bean.SignUp;
import com.SysC.dao.ISignRepository;
import com.google.inject.Inject;

public class SignService implements ISignService{

	@Inject
	private ISignRepository signRepository;

	@Override
	public Optional<Sign> authenticate(SignIn authentication) {
		return null;
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
									 )==1;
	}


}
