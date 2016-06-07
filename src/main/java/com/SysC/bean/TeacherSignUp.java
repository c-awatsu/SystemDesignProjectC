package com.SysC.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class TeacherSignUp implements Serializable {
	private static final long serialVersionUID = -3649806456521275659L;

	
	private String accountName;

	
	private String passphrase;

	@NonNull
	private String role;


	public TeacherSignUp(){
		this("","","");
	}
}