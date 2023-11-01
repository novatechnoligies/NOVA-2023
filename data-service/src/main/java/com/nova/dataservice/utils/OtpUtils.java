package com.nova.dataservice.utils;

import java.util.Random;

public class OtpUtils {

	public static int generateOtp() {
		Random random = new Random();
		int randomNumber = random.nextInt(900000) + 100000;
		return randomNumber;

	}
}
