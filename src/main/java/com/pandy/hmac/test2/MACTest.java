package com.pandy.hmac.test2;

public class MACTest {
	public static void main(String[] args) throws Exception {
		String testString = "test";

		byte[] keyHmacMD5=MACCoder.initHmacMD5Key();
		System.out.println(MACCoder.encodeHmacMD5(testString.getBytes(),keyHmacMD5));

		byte[] keyHmacSHA1=MACCoder.initHmacSHAKey();
		System.out.println(MACCoder.encodeHmacSHA(testString.getBytes(),keyHmacSHA1));

		byte[] keyHmacSHA256=MACCoder.initHmacSHA256Key();
		System.out.println(MACCoder.encodeHmacSHA256(testString.getBytes(),keyHmacSHA256));

		byte[] keyHmacSHA384=MACCoder.initHmacSHA384Key();
		System.out.println(MACCoder.encodeHmacSHA384(testString.getBytes(),keyHmacSHA384));

		byte[] keyHmacSHA512=MACCoder.initHmacSHA512Key();
		System.out.println(MACCoder.encodeHmacSHA512(testString.getBytes(),keyHmacSHA512));
	}
}
