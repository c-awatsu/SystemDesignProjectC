package com.SysC.dao;

import java.util.List;

import com.SysC.bean.Sign;
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
	 * @return aa
	 */
	public List<Integer> fetchAccountId();

}
