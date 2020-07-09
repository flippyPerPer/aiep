package com.tensorflow.util;

import java.util.Random;

public class GenerateClassCode {

	public static String createShareCode() {
		int maxNum = 36;
		int i;
		int count = 0;
		char[] str = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
				'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		StringBuffer code = new StringBuffer("");
		Random r = new Random();
		while (count < 6) {
			i = Math.abs(r.nextInt(maxNum));
			if (i >= 0 && i < str.length) {
				code.append(str[i]);
				count++;
			}
		}
		return code.toString();
	}
}
