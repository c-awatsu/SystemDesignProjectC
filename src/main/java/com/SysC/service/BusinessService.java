package com.SysC.service;

import java.util.List;

import com.SysC.bean.BusinessItem;
import com.SysC.bean.LectureItem;
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
	
	@Override
	public List<BusinessItem> selectBusinessItems(){
		return businessRepository.selectBusinessItems();		
	}
		
}
