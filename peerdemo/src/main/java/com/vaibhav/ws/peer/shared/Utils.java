package com.vaibhav.ws.peer.shared;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Utils {
	
	private final Random RANDOM = new SecureRandom();
	private final String ALPHABET = "0987654321ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz";
	private final String NUMBER = "0987654321";
	//private final int ITERATIONS = 100000;
	//private final int KEY_LENGTH = 256;
	
	public String generateTransactionId(int length) {
		return generateRandomTxn(length);
	}
	
	private String generateRandomTxn(int length) {
		StringBuilder returnValue = new StringBuilder(length);
		for(int i = 0; i < length; i++) {
			returnValue.append(NUMBER.charAt(RANDOM.nextInt(NUMBER.length())));
		}
		return new String (returnValue);
	}

	public String generateUserId(int length) {
		return generateRandomString(length);
	}

	private String generateRandomString(int length) {
		
		StringBuilder returnValue = new StringBuilder(length);
		for(int i = 0; i < length; i++) {
			returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}
		return new String (returnValue);
	}

}
