package com.SysC.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
/**
 * SignIn時のユーザー情報を格納するBean
 */
@Data
@AllArgsConstructor
public class SignIn implements Serializable{

	private static final long serialVersionUID = 6394930973402207634L;

	private String accountName;
	private String passphrase;

	public SignIn(){
		accountName = "";
		passphrase = "";
	}
}
