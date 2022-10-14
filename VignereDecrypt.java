package softwaresecurity;

public class VignereDecrypt {
	
	// This function decrypts the encrypted text
	// and returns the original text
	static String originalText(String cipher_text, String key)
	{
		StringBuffer orig_text= new StringBuffer();

		for (int i = 0 ; i < cipher_text.length() &&
								i < key.length(); i++)
		{
			// converting in range 0-25
			int x = (cipher_text.charAt(i) -
						key.charAt(i) + 26) %26;

			// convert into alphabets(ASCII)
			x += 'A';
			orig_text.append((char)(x));		}
		return orig_text.toString();
	}

}
