package softwaresecurity;

public class caesar_decrypt {
	
		// decrypts text using a shift on s
		public static String decrypt(String text, int s)
		{
			StringBuffer result= new StringBuffer();
			text.toLowerCase();
			for (int i=0; i<text.length(); i++)
			{
				if(text.charAt(i) == ' '){
					result.append(' ');
					continue;
				}
				if (Character.isUpperCase(text.charAt(i)))
				{
					int val = (int)text.charAt(i) -s - 65;
					if (val<0) val = val+26;
					char ch = (char)(val % 26 + 65);
					result.append(ch);
				}
				else
				{
					int val = (int)text.charAt(i) -s - 97;
					System.out.println(val);
					if (val<0) val = val+26;
					char ch = (char)((val) % 26 + 97);
					result.append(ch);
				}
			}
			return result.toString();
		}


}
