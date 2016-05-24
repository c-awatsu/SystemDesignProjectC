package com.SysC.service;

import java.util.List;
import java.util.Optional;

import com.SysC.bean.Sign;
import com.SysC.bean.SignIn;

public interface ISignService {
	/**
	 *アカウントを認証する
	 *
	 * @param authentication
	 * 			認証用の{@link SignIn} オブジェクト
	 * @return 認証成功時はaccountIdの{@link Optional}, それ以外は空の{@link Optional}
	 */
	public Optional<Sign> authenticate(SignIn authentication);
	public List<Integer> existUser();
}
