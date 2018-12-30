import java.util.ArrayList;
import java.util.HashMap;

public class HMClient {

	public static void main(String[] args) {
		highestFrequencyCharacter("aababahaha");
		int[] one = { 5, 1, 3, 1, 2, 2, 1 };
		int[] two = { 2, 2, 4, 1, 1, 5, 2 };
		getCommonEelment1(one, two);
		getCommonEelment2(one, two);

		int[] arr = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 };
		longestConsecutiveSequence(arr);
	}

	public static void highestFrequencyCharacter(String word) {
		HashMap<Character, Integer> frequency = new HashMap<>();

		for (int i = 0; i < word.length(); i++) {
			int key = word.charAt(i);
			boolean ans = frequency.containsKey(key);
			if (ans) {
				Integer value = frequency.get(word.charAt(i));
				frequency.put(word.charAt(i), value + 1);
			} else {
				frequency.put(word.charAt(i), 1);
			}
		}

		char mfk = word.charAt(0);
		for (Character ch : word.toCharArray()) {
			if (frequency.get(ch) > frequency.get(mfk)) {
				mfk = ch;
			}
		}

		System.out.println(mfk);
	}

	public static void getCommonEelment1(int[] one, int[] two) {
		HashMap<Integer, Integer> gce1 = new HashMap<>();

		for (int i : one) {
			gce1.put(i, gce1.containsKey(i) ? gce1.get(i) + 1 : 1);
		}

		for (int i : two) {
//			gce1.put(i, gce1.containsKey(i) ? gce1.get(i) + 1 : 1);
			if (gce1.containsKey(i)) {
				System.out.print(i + " ");
				gce1.remove(i);
			}
		}
		System.out.println();

//		for (int i : one) {
//			if (gce1.get(i) > 1) {
//				System.out.print(i + " ");
//				gce1.put(i, 1);
//			}
//		}
	}

	public static void getCommonEelment2(int[] one, int[] two) {
		HashMap<Integer, Integer> gce2 = new HashMap<>();

		for (int i : one) {
			gce2.put(i, gce2.containsKey(i) ? gce2.get(i) + 1 : 1);
		}

		for (int i : two) {
			if (gce2.containsKey(i) && gce2.get(i) > 0) {
				System.out.print(i + " ");
				gce2.put(i, gce2.get(i) - 1);
			}
		}
		System.out.println();
	}

	public static void longestConsecutiveSequence(int[] arr) {
		HashMap<Integer, Boolean> map = new HashMap<>();
		
		for(int val : arr) {
			map.put(val, true);
		}
		
		for(int val : arr) {
			map.put(val, !map.containsKey(val -1));
		}
		
		Integer msp = null;
		Integer mlen = 0;
		
		for(int val : arr) {
			if(map.get(val) == true) {
				int tsp = val;
				int tlen = 1;
				
				while(map.containsKey(tsp + tlen)) {
					tlen++;
				}
				
				if(tlen > mlen) {
					mlen = tlen;
					msp = tsp;
				}
			}
		}
		
		System.out.println(msp + " @ "+ mlen);
	}
}
