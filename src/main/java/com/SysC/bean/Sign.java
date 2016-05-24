package com.SysC.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import org.apache.wicket.authroles.authorization.strategies.role.Roles;

/**
 * 	既にSignInした後のユーザー情報を格納するBean
 */

@Data
@AllArgsConstructor
public class Sign implements Serializable{

	private static final long serialVersionUID = 4209174269846034743L;

	@NonNull
	private Integer accountId;
	@NonNull
	private String accountName;
	@NonNull
	private Roles role;

	public Sign(){
		accountId = -1;
		accountName = "";
		new Roles();
	}
}
