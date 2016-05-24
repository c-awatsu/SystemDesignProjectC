package com.SysC.dao;

import java.util.List;

import com.google.inject.ImplementedBy;
/**
 *
 * @author 永田
 * アカウント関連のDAO
 */
@ImplementedBy(SignRepository.class)
public interface ISignRepository {

	/**
	 *
	 * @return アカウントが1つでも存在する場合は,accountIdの{@link List},存在しない場合は空の{@link List}を返す
	 */
	public List<Integer> fetchAccountId();

	/**
	 *
	 * @param signUp アカウント登録フォームに入力された情報
	 * @return accountテーブルの更新された行があればtrue,なければfalse
	 */
	public int insert(String accountName,String passphrase);

}
