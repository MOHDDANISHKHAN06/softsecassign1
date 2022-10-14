package softwaresecurity;

import java.util.Scanner;

public class VigenereCipher {
	
	public static String generateKey(String str, String key)
	{
		int x = str.length();

		for (int i = 0; ; i++)
		{
			if (x == i)
				i = 0;
			if (key.length() == str.length())
				break;
			key+=(key.charAt(i));
		}
		return key;
	}

	public static void main(String[] args){
		String str = "ARIZONASTATEUNIVERSITY";
		String keyword = "EUCDRHEVNEWYYQCZHLWLNC";
	
		//Scanner sc = new Scanner(System.in);
	    //System.out.println("Enter text for encryption");
	    //String str = sc.nextLine();
	    //System.out.println("Enter KEY of length 1-3 consisting alphabets A-Z");
	    //String keyword = sc.nextLine();
	    //sc.close();
		//String key = generateKey(str, keyword);
		//System.out.println(key);
		String cipher_text = VignereEncrypt.cipherText(str, keyword);

		//System.out.println("Ciphertext :	+ cipher_text + "\n");

		System.out.println("Original Text : "+ VignereKeyFinder.findKey(keyword, str));
		//System.out.println("Original Text : "+ VignereDecrypt.originalText(keyword, str).length());

	}
}
