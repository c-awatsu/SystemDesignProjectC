package com.SysC.bean;

import java.io.Serializable;
import java.util.Arrays;

import com.SysC.define.BusinessDefine.BUSINESS_TYPE;
import com.SysC.define.ColDifine.COL_TYPE;
import com.SysC.define.RowDifine.ROW_TYPE;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BusinessItem implements Serializable{
	private static final long serialVersionUID = 4937631007571128796L;
	
	private long businessId;
	private BUSINESS_TYPE business;
	private String other;
	private COL_TYPE col;
	private ROW_TYPE row;
	//private Time time;
	
	public BusinessItem(){
		this(-1,BUSINESS_TYPE.UNKNOWN,"",COL_TYPE.UNKNOWN,ROW_TYPE.UNKNOWN);
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
	
	/**
	 * DBなどからcolを取得した際にStringをcolに変換してsetする
	 * @param col
	 */
	public void setCol(String col){
		this.col = 
				Arrays.stream(COL_TYPE.values())
				.filter(g -> g.getLabel().equals(col))
				.findFirst()
				.orElse(COL_TYPE.UNKNOWN);
	}
	
	/**
	 * DBなどからrowを取得した際にStringをrowに変換してsetする
	 * @param row
	 */
	public void setRow(String row){
		this.row = 
				Arrays.stream(ROW_TYPE.values())
				.filter(g -> g.getLabel().equals(row))
				.findFirst()
				.orElse(ROW_TYPE.UNKNOWN);
	}

}
