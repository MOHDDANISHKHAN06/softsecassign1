package softwaresecurity;

import java.util.Scanner;

public class softsec {
	

	// Driver code
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
	    System.out.println("Enter text for encryption");
	    String text = sc.nextLine();
	    System.out.println("Enter shift for Cipher");
		int shift = sc.nextInt();
		sc.close();
		System.out.println("Text : " + text);
		System.out.println("Shift : " + shift);
		System.out.println("Cipher: " + CaesarCipher.encrypt(text, shift));
	}

}
