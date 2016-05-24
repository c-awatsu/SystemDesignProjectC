package com.SysC.costant;
//インスタンス生成禁止
public class ARSRoles {

	public static final String TEACHER = "TEACHER";
	public static final String STUDENT = "STUDENT";
	public static final String TA = "TA";

	private ARSRoles() {
		throw new AssertionError("No " + getClass().getName() + " instances for you!");
	}

}
