package softwaresecurity;

import java.util.*;


public class OneGram {
	
	
	public static void main(String[] args)
	{
		String text2 = "KCECMKS";
		String text = text2.toLowerCase();
		//System.out.println(text);
		double n = text.length();
		HashMap<Character, Double> frequency = new HashMap<>();
		int count[] = new int[26];
		HashMap<Integer, Double> oneGram = new HashMap<>();
		double[] crln = new double[26];
		List<Integer> prob_shift = new ArrayList<>();
		oneGram.put('a'-'a',0.080);
		oneGram.put('b'-'a',0.015);
		oneGram.put('c'-'a',0.030);
		oneGram.put('d'-'a',0.040);
		oneGram.put('e'-'a',0.130);
		oneGram.put('f'-'a',0.020);
		oneGram.put('g'-'a',0.015);
		oneGram.put('h'-'a',0.060);
		oneGram.put('i'-'a',0.065);
		oneGram.put('j'-'a',0.005);
		oneGram.put('k'-'a',0.005);
		oneGram.put('l'-'a',0.035);
		oneGram.put('m'-'a',0.030);
		oneGram.put('n'-'a',0.070);
		oneGram.put('o'-'a',0.080);
		oneGram.put('p'-'a',0.020);
		oneGram.put('q'-'a',0.002);
		oneGram.put('r'-'a',0.065);
		oneGram.put('s'-'a',0.060);
		oneGram.put('t'-'a',0.090);
		oneGram.put('u'-'a',0.030);
		oneGram.put('v'-'a',0.010);
		oneGram.put('w'-'a',0.015);
		oneGram.put('x'-'a',0.005);
		oneGram.put('y'-'a',0.020);
		oneGram.put('z'-'a',0.002);
		
		for(int i =0; i<n;i++)
		{
			char c = text.charAt(i);
			if(c == ' ') continue;
			count[c -'a']++;
		}
		
		for( int i =0; i <n ; i++)
		{
			char c = text.charAt(i);
			if(c == ' ') continue;
			double freq = count[ c-'a']/n;
			frequency.put(c,freq);
		}
		
		for(int i=0;i<26;i++)
		{
			 double cr =0;
			 for(Character c : frequency.keySet())
			 {
				 if((c-'a')-i <0)continue;
				 cr += frequency.get(c)*oneGram.get((c-'a')-i);
			 }
			 if(cr>0.05) prob_shift.add(i);
			 crln[i] = cr;
		}
		
		//System.out.println(prob_shift.size());
		
		HashMap<Double, Integer> value2dx = new HashMap<>();
		
		for(int i =0 ; i<26;i++)
		{
			value2dx.put(crln[i],i);
		}
		Arrays.sort(crln);
		
		for(int i =25; i>=20;i--)
		{
			//System.out.println(value2dx.get(crln[i]));
			String output = caesar_decrypt.decrypt(text,value2dx.get(crln[i]));
			//System.out.println("bef");
			System.out.println(output);
			//System.out.println("af");

		}

	}

	
	
	

}
