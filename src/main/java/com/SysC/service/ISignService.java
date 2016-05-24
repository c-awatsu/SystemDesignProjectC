package com.SysC.service;

import java.util.List;
import java.util.Optional;

import com.SysC.bean.Sign;
import com.SysC.bean.SignIn;
import com.SysC.bean.SignUp;
import com.SysC.dao.ISignRepository;

public interface ISignService {

	/**
	 *アカウントを認証する
	 *
	 * @param authentication
	 * 			認証用の{@link SignIn} オブジェクト
	 * @return 認証成功時はaccountIdの{@link Optional}, それ以外は空の{@link Optional}
	 */
	public Optional<Sign> authenticate(SignIn authentication);

	/**
	 * アカウントが存在するか
	 * @return アカウントが存在した場合はaccountIdの{@link List},それ以外は空の{@link List}
	 */
	public List<Integer> existUser();

	/**
	 *
	 * @param signUp アカウント登録フォームに入力された情報
	 * @return {@link ISignRepository}のinsertメソッドから返ってきた値が1かどうか
	 */
	public boolean joinAccount(SignUp signUp);
}
