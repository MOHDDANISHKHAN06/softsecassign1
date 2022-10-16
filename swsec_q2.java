
import java.util.*;

public class swsec_q2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter text for encryption");
		String text = sc.nextLine();
		sc.close();
		System.out.println("Most probable output for text 1 with key: " + attackCeasar(text));
	}

	public static HashMap<Integer, String> attackCeasar(String inputText) {
		String text = inputText.toLowerCase();

		double n = text.length();
		HashMap<Character, Double> frequency = new HashMap<>();
		int count[] = new int[26];
		HashMap<Integer, Double> oneGram = new HashMap<>();
		double[] crln = new double[26];
		HashMap<Integer, String> opMap = new HashMap<>();

		oneGram.put('a' - 'a', 0.080);
		oneGram.put('b' - 'a', 0.015);
		oneGram.put('c' - 'a', 0.030);
		oneGram.put('d' - 'a', 0.040);
		oneGram.put('e' - 'a', 0.130);
		oneGram.put('f' - 'a', 0.020);
		oneGram.put('g' - 'a', 0.015);
		oneGram.put('h' - 'a', 0.060);
		oneGram.put('i' - 'a', 0.065);
		oneGram.put('j' - 'a', 0.005);
		oneGram.put('k' - 'a', 0.005);
		oneGram.put('l' - 'a', 0.035);
		oneGram.put('m' - 'a', 0.030);
		oneGram.put('n' - 'a', 0.070);
		oneGram.put('o' - 'a', 0.080);
		oneGram.put('p' - 'a', 0.020);
		oneGram.put('q' - 'a', 0.002);
		oneGram.put('r' - 'a', 0.065);
		oneGram.put('s' - 'a', 0.060);
		oneGram.put('t' - 'a', 0.090);
		oneGram.put('u' - 'a', 0.030);
		oneGram.put('v' - 'a', 0.010);
		oneGram.put('w' - 'a', 0.015);
		oneGram.put('x' - 'a', 0.005);
		oneGram.put('y' - 'a', 0.020);
		oneGram.put('z' - 'a', 0.002);
		for (int i = 0; i < n; i++) {
			char c = text.charAt(i);
			if (c == ' ')
				continue;
			count[c - 'a']++;
		}

		for (int i = 0; i < n; i++) {
			char c = text.charAt(i);
			if (c == ' ')
				continue;
			double freq = count[c - 'a'] / n;
			frequency.put(c, freq);
		}

		for (int i = 0; i < 26; i++) {
			double cr = 0;
			for (Character c : frequency.keySet()) {
				if ((c - 'a') - i < 0)
					continue;
				cr += frequency.get(c) * oneGram.get((c - 'a') - i);
			}
			crln[i] = cr;

		}
		HashMap<Double, Integer> value2idx = new HashMap<>();

		for (int i = 0; i < 26; i++) {
			value2idx.put(crln[i], i);
		}
		Arrays.sort(crln);
		for (int i = 25; i >= 20; i--) {
			String output = decrypt(text, value2idx.get(crln[i]));
			opMap.put(value2idx.get(crln[i]), output);
		}
		return opMap;
	}

	public static String decrypt(String text, int s) {
		StringBuffer result = new StringBuffer();
		text.toLowerCase();
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == ' ') {
				result.append(' ');
				continue;
			}
			if (Character.isUpperCase(text.charAt(i))) {
				int val = (int) text.charAt(i) - s - 65;
				if (val < 0)
					val = val + 26;
				char ch = (char) (val % 26 + 65);
				result.append(ch);
			} else {
				int val = (int) text.charAt(i) - s - 97;
				if (val < 0)
					val = val + 26;
				char ch = (char) ((val) % 26 + 97);
				result.append(ch);
			}
		}
		return result.toString();
	}
}
