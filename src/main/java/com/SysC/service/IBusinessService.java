package com.SysC.service;

import java.util.List;

import com.SysC.bean.BusinessItem;
import com.google.inject.ImplementedBy;

@ImplementedBy(BusinessService.class)
public interface IBusinessService {
	
	public boolean insertBusiness(BusinessItem businessItem);
	public List <BusinessItem> selectBusinessItems();
}
