package com.wipro.userms.util;

import java.security.SecureRandom;
import java.util.Base64;

public class GenJwtSecrettKey {

	public static void main(String[] args) {
		SecureRandom random = new SecureRandom();
        byte[] key = new byte[64];
        random.nextBytes(key);
        String encodedKey = Base64.getEncoder().encodeToString(key);
        System.out.println("Generated HS512 key (base64 encoded): " + encodedKey);


	}

}