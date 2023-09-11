package utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomData {

	public static String randomString(int length) {
		String str = RandomStringUtils.randomAlphabetic(length);
		return str;
	}
	
	public static String randomNumber(int length) {
		String num = RandomStringUtils.randomNumeric(length);
		return num;
	}
	
	public static String randomAlphaNumeric(int length) {
		String str = RandomStringUtils.randomAlphabetic(length);
		String num = RandomStringUtils.randomNumeric(length);
		return str+num;
	}
}
