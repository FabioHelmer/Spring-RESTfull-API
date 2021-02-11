package com.demo.services.util;

import org.apache.commons.codec.digest.DigestUtils;

public class PasswordUtil {

	public static String getSecureHash(String txt) {
		return DigestUtils.sha256Hex(txt);
	}

	public static void main(String[] args) {
		System.out.println(getSecureHash("fabio helmer"));
	}



}
