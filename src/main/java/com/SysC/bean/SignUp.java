package com.SysC.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class SignUp implements Serializable {
	private static final long serialVersionUID = 3234100499312075256L;

	@NonNull
	private String accountId;

	@NonNull
	private String passphrase;
	
	@NonNull
	private String cpassphrase;

	@NonNull
	private String role;

	@NonNull
	private String accountName;

	public SignUp(){
		this("","","","","");
	}
}
