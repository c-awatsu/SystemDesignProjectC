package com.SysC.service;

import com.SysC.bean.BusinessItem;
import com.SysC.dao.IBusinessRepository;
import com.google.inject.Inject;

public class BusinessService implements IBusinessService{
	
	@Inject
	private IBusinessRepository businessRepository;
	
	@Override
	public boolean insertBusiness(BusinessItem businessItem){
		return businessRepository.insertBusiness(
				businessItem.getBusiness().getLabel(),
				businessItem.getOther(),
				businessItem.getCol().getLabel(),
				businessItem.getRow().getLabel()
		)==1;				
	}

}
