package softwaresecurity;

public class VignereEncrypt {

	 public	static String cipherText(String str, String key)
		{
			StringBuffer cipher_text= new StringBuffer();

			for (int i = 0; i < str.length(); i++)
			{
				// converting in range 0-25
				int x = (str.charAt(i) + key.charAt(i)) %26;

				// convert into alphabets(ASCII)
				x += 'A';
				
				cipher_text.append((char)(x));
				//cipher_text.add(char)(x);
			}
			return cipher_text.toString();
		}
}
