package com.SysC.dao;

import java.util.List;

import com.SysC.bean.LectureItem;
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
	 * @param accountName アカウント登録フォームに入力されたアカウント名
	 * @param passphrase  アカウント登録フォームに入力されたパスワードをSHA256方式で暗号化したもの
	 * @return accountテーブルの更新された行があればtrue,なければfalse
	 */
	public int insert(String accountName,String passphrase,String role);

	/**
	 * @param accountName アカウント登録フォームに入力されたアカウント名
	 * @param passphrase  アカウント登録フォームに入力されたパスワード
	 * @retun 検索されたアカウントID
	 */
	public int fetchAccountId(String accountName,String passphrase);

	/**
	 * @param accountId アカウントID
	 * @return 検索されたシステム上の権限
	 */
	public String fetchARSRole(int accountId);
	
	//
	public int insert(LectureItem lectureItem);

}
