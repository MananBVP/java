import java.util.ArrayList;

public class board_path {

	public static void main(String[] args) {

//		System.out.println(getBoardPath(0, 10));	
//		System.out.println(getMP(0, 0, 2, 2));
//		System.out.println(getdMP(0, 0, 3, 3));
//		printSS("abc", "");
//		printSSwithascii("abc", "");
//		printkpc("367", "");
//		printbp(0, 10, "");
		printMP(0, 0, 2, 2, "");

	}

//	public static ArrayList<String> getBoardPath(int src, int dest) {
//		if (src == dest) {
//			ArrayList<String> bs = new ArrayList<>();
//			bs.add("\n");
//			return bs;
//		}
//		ArrayList<String> mresult = new ArrayList<>();
//
//		for (int i = 1; i <= 6; i++) {
//			if (i > dest) {
//				continue;
//			}
//			ArrayList<String> rs = getBoardPath(src, dest - i);
//			for (String recs : rs) {
//				mresult.add(i + recs);
//			}
//		}
//		return mresult;
//	}
	private static ArrayList<String> getBoardPath(int src, int dest) {
		if (src == dest) {
			ArrayList<String> bs = new ArrayList<>();
			bs.add("\n");
			return bs;
		}
//		if(src>dest) {
//			ArrayList<String> bs = new ArrayList<>();
//			return bs;
//		}
		ArrayList<String> manypathsfromstod = new ArrayList<>();

		for (int dice = 1; dice <= 6 && src + dice <= dest; dice++) {
			int i = src + dice;
			ArrayList<String> manypathsfromitod = getBoardPath(i, dest);

			for (String pathfromitod : manypathsfromitod) {
				String pathfromstod = dice + pathfromitod;
				manypathsfromstod.add(pathfromstod);
			}
		}

		return manypathsfromstod;
	}

	public static ArrayList<String> getMP(int sr, int sc, int dr, int dc) {
		if (sc == dc && sr == dc) {
			ArrayList<String> bs = new ArrayList<>();
			bs.add("");
			return bs;
		}
		if (sr > dr || sc > dc) {
			ArrayList<String> bs = new ArrayList<>();
			return bs;
		}
		ArrayList<String> mresult = new ArrayList<>();
		ArrayList<String> hor = getMP(sr, sc + 1, dr, dc);
		for (String res : hor) {
			mresult.add("H" + res);
		}
		ArrayList<String> ver = getMP(sr + 1, sc, dr, dc);
		for (String res : ver) {
			mresult.add("V" + res);
		}
		return mresult;
	}

	public static ArrayList<String> getdMP(int sr, int sc, int dr, int dc) {
		if (sc == dc && sr == dc) {
			ArrayList<String> bs = new ArrayList<>();
			bs.add("");
			return bs;
		}
		if (sr > dr || sc > dc || sr > sc) {
			ArrayList<String> bs = new ArrayList<>();
			return bs;
		}
		ArrayList<String> mresult = new ArrayList<>();
		ArrayList<String> hor = getdMP(sr, sc + 1, dr, dc);
		for (String res : hor) {
			mresult.add("H" + res);
		}
		ArrayList<String> ver = getdMP(sr + 1, sc, dr, dc);
		for (String res : ver) {
			mresult.add("V" + res);
		}
		return mresult;
	}

	private static void printSS(String ques, String asf) {
		if (ques.length() == 0) {
			System.out.println(asf);
			return;
		}
		char ch = ques.charAt(0);
		String ros = ques.substring(1);
		printSS(ros, asf + ch);
		printSS(ros, asf + "-");

	}

	private static void printSSwithascii(String ques, String asf) {
		if (ques.length() == 0) {
			System.out.println(asf);
			return;
		}
		char ch = ques.charAt(0);
		String ros = ques.substring(1);
		printSSwithascii(ros, asf + ch);
		printSSwithascii(ros, asf + "-");
		printSSwithascii(ros, asf + (int) ch);
	}

	static String[] codes = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

	private static void printkpc(String ques, String asf) {
		if (ques.length() == 0) {
			System.out.println(asf);
			return;
		}
		char ch = ques.charAt(0);
		String ros = ques.substring(1);
		String code=codes[ch-'0'];
		for (int i = 0; i < code.length(); i++) {
			printkpc(ros, asf + code.charAt(i));
		}
	}
   static int counter=0;
	private static void printbp(int src,int dest,String asf) {
		
		if(src==dest) {
			System.out.println(++counter+" "+asf);
			return;
		}
		for(int dice=1;dice<=6 && src+dice<=dest;dice++) {
	        int i=src+dice;
		   printbp(i, dest, asf+dice);
	}
	}
		private static void printMP(int sr,int sc,int dr,int dc,String asf) {
			if (sc == dc && sr == dc) {
				System.out.println(asf);
				return;
			}
			if (sr > dr || sc > dc) {
				return;
		}
			printMP(sr, sc+1, dr, dc, asf+"h");
			printMP(sr+1, sc, dr, dc, asf+"v");
}
}