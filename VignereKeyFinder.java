package softwaresecurity;

public class VignereKeyFinder {
	
	public static String findKey(String ciphertext, String plaintext) {
		return VignereDecrypt.originalText(ciphertext, plaintext);
		}
}
