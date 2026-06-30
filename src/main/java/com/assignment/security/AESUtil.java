package com.assignment.security;
import com.assignment.util.ConfigLoader;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;


public class AESUtil {
	
	 private static final String ALGORITHM = "AES";

	    private static SecretKeySpec getKey() {
	        String key = ConfigLoader.getKey();
	        return new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), ALGORITHM);
	    }

	    public static String encrypt(String text) throws Exception {

	        Cipher cipher = Cipher.getInstance(ALGORITHM);

	        cipher.init(Cipher.ENCRYPT_MODE, getKey());

	        byte[] encrypted = cipher.doFinal(text.getBytes(StandardCharsets.UTF_8));

	        return Base64.getEncoder().encodeToString(encrypted);
	    }

	    public static String decrypt(String encryptedText) throws Exception {

	        Cipher cipher = Cipher.getInstance(ALGORITHM);

	        cipher.init(Cipher.DECRYPT_MODE, getKey());

	        byte[] decoded = Base64.getDecoder().decode(encryptedText);

	        return new String(cipher.doFinal(decoded), StandardCharsets.UTF_8);
	    }
}
