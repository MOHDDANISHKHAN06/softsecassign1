import java.util.Scanner;

public class swsec_q1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter choice to encrypt or decrypt? e/d");
		String choice = sc.nextLine();
		System.out.println("Enter text for encryption/decryption");
		String text = sc.nextLine();
		System.out.println("Enter shift for Cipher");
		int shift = sc.nextInt();
		sc.close();
		System.out.println("Text : " + text);
		System.out.println("Shift : " + shift);
		System.out.println(performCaesar(text, shift, choice));
	}

	public static String performCaesar(String input, int shift, String choice) {
		String result = new String();
		input = input.toUpperCase();

		if (choice.equals("e")) { // encryption
			for (int i = 0; i < input.length(); i++) {
				char ch = (char) (((int) input.charAt(i) + shift - 65) % 26 + 65);
				result += ch;
			}
		} else if (choice.equals("d")) { // decryption
			for (int i = 0; i < input.length(); i++) {
				char ch = (char) (((int) input.charAt(i) - shift + 65) % 26 + 65);
				result += ch;
			}
		} else {
			return "Please enter valid choice for encryption or decryption e/d";
		}
		return "Output: " + result;
	}
}
