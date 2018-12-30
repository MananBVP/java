import java.util.ArrayList;
import java.util.HashMap;

public class HMClient {

	public static void main(String[] args) {
		highestFrequencyCharacter("aababahaha");
		
	}
	
	public static void highestFrequencyCharacter(String word) {
		HashMap<Character, Integer> frequency = new HashMap<>();
		
		
		for(int i=0; i < word.length(); i++) {
			int key = word.charAt(i);
			boolean ans = frequency.containsKey(key);
			if(ans) {
				Integer value = frequency.get(word.charAt(i));
				frequency.put(word.charAt(i), value + 1);
			}else {
				frequency.put(word.charAt(i), 1);
			}
		}
		
		char mfk = word.charAt(0);
		for(Character ch : word.toCharArray()) {
			if(frequency.get(ch) > frequency.get(mfk)) {
				mfk = ch;
			}
		}
		
		System.out.println(mfk);
	}
}
