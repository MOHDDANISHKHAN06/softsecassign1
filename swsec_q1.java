import java.util.Scanner;

public class swsec_q1 {

	// Driver code
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter text for encryption");
		String text = sc.nextLine();
		System.out.println("Enter shift for Cipher");
		int shift = sc.nextInt();
		sc.close();
		System.out.println("Text : " + text);
		System.out.println("Shift : " + shift);
		System.out.println("Cipher: " + encrypt(text, shift));
	}

	public static String encrypt(String input, int shift) {
		String result = new String();

		for (int i = 0; i < input.length(); i++) {

			if (Character.isUpperCase(input.charAt(i))) {
				char ch = (char) (((int) input.charAt(i) + shift - 65) % 26 + 65);
				result += ch;
			} else {
				char ch = (char) (((int) input.charAt(i) + shift - 97) % 26 + 97);
				result += ch;
			}
		}
		return result;
	}
}
