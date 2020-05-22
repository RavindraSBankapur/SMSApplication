package com.sakha.sms.am.utils;

import java.util.Random;
import java.util.UUID;

public class RandomNumberGenerator {

	public static final void main(String... aArgs) {
		// generate random UUIDs
		UUID idOne = UUID.randomUUID();
		UUID idTwo = UUID.randomUUID();
		log("UUID One: " + idOne);
		log("UUID Two: " + idTwo);
		generateRandom(8);
	}

	private static void log(Object aObject) {
		System.out.println(String.valueOf(aObject));
	}

	public static long generateRandom(int length) {
		Random random = new Random();
		char[] digits = new char[length];
		digits[0] = (char) (random.nextInt(9) + '1');
		for (int i = 1; i < length; i++) {
			digits[i] = (char) (random.nextInt(10) + '0');
		}
		System.out.println(digits);
		return Long.parseLong(new String(digits));
	}

}
