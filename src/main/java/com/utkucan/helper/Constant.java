package com.utkucan.helper;

public class Constant {
	private static final int ADMIN_AUTORIZATION_ID = 1;
	private static final int USER_AUTORIZATION_ID = 0;

	public static int getAdminAutorizationId() {
		return ADMIN_AUTORIZATION_ID;
	}

	public static int getUserAutorizationId() {
		return USER_AUTORIZATION_ID;
	}

}
