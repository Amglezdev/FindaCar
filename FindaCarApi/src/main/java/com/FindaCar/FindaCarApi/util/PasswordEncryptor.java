package com.FindaCar.FindaCarApi.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

// TODO: Auto-generated Javadoc
/**
 * The Class PasswordEncryptor.
 */
@Component
public class PasswordEncryptor {

	/**
	 * Encrypt password.
	 *
	 * @param password the password
	 * @return the string
	 */
	public String encryptPassword(String password) {
		try {

			MessageDigest digest = MessageDigest.getInstance("SHA-256");

			byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));

			StringBuilder hexString = new StringBuilder();
			for (byte b : encodedHash) {
				String hex = Integer.toHexString(0xff & b);
				if (hex.length() == 1) {
					hexString.append('0');
				}
				hexString.append(hex);
			}

			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return null;
	}
}