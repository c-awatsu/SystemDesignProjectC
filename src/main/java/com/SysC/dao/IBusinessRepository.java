package com.SysC.dao;

import java.util.List;

import com.SysC.bean.BusinessItem;
import com.google.inject.ImplementedBy;

@ImplementedBy(BusinessRepository.class)

public interface IBusinessRepository {
	
	public int insertBusiness(String business,String other,String col,String row);
	public List<BusinessItem> selectBusinessItems();
	
}
