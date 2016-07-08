package com.SysC.bean;

import java.io.Serializable;
import java.util.Arrays;

import com.SysC.define.BusinessDefine.BUSINESS_TYPE;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BusinessItem implements Serializable{
	private static final long serialVersionUID = 4937631007571128796L;
	
	private long businessId;
	private BUSINESS_TYPE business;
	private String other;
	
	public BusinessItem(){
		this(-1,BUSINESS_TYPE.UNKNOWN,"");
	}
	
	/**
	 * DBなどからbusinessを取得した際にStringをBUSINESSに変換してsetする
	 * @param business 課題ができた、課題がわからないのような形式
	 */
	public void setBusiness(String business){
		this.business = 
				Arrays.stream(BUSINESS_TYPE.values())
				.filter(g -> g.getLabel().equals(business))
				.findFirst()
				.orElse(BUSINESS_TYPE.UNKNOWN);
	}

}
