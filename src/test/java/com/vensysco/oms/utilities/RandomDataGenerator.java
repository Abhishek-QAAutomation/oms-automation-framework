package com.vensysco.oms.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomDataGenerator {
	
	public static String randomAadharNumber() {
		String generatedAadharNumber = RandomStringUtils.secure().nextNumeric(12);
		return generatedAadharNumber;
	}
	
	public static String randomPanNumber() {
		String panPrefixLetters = RandomStringUtils.secure().nextAlphabetic(5).toUpperCase();
		String panNumericPart = RandomStringUtils.secure().nextNumeric(4);
		String panSuffixLetter = RandomStringUtils.secure().nextAlphabetic(1).toUpperCase();
		String panNumber = panPrefixLetters + panNumericPart + panSuffixLetter; 
		return panNumber;
	}
	
	public static String randomIFSCCode() {
		String bankIdentifier = RandomStringUtils.secure().nextAlphabetic(4).toUpperCase();
		String branchIdentifier = RandomStringUtils.secure().nextNumeric(6);
		String ifscCode = bankIdentifier + "0" + branchIdentifier;
		return ifscCode;
	}
	
	public static String randomAccountNumber() {
		String accountNumber = RandomStringUtils.secure().nextNumeric(18);
		return accountNumber;
	}

}
