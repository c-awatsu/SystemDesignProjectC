package com.SysC.dao;

import com.google.inject.ImplementedBy;

@ImplementedBy(BusinessRepository.class)

public interface IBusinessRepository {
	
	public int insertBusiness(String business,String other);
	
}
