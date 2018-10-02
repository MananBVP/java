import java.util.ArrayList;

public class arraylist {

	public static void main(String[] args) {
//     System.out.println(gss("abc"));
//		System.out.println(gsswithascii("ab"));
		System.out.println(getkpc("367"));
	}

//	public static ArrayList<String> gss1(String str) {
//		if(str.length()==0) {
//			ArrayList<String> br=new ArrayList<String>();
//			br.add(" ");
//			return br;
//		}
//		int c = str.charAt(0)-'0';
//		String ros = str.substring(1);
//		ArrayList<String> rr = gss(ros);
//        ArrayList<String> mr=new ArrayList<String>();
//        for(String rstr:rr) {
//        	mr.add(rstr);
//        	mr.add(ch+rstr);
//        }
//        return mr;
	public static ArrayList<String> gss(String str) {
		if (str.length() == 1) {
			ArrayList<String> br = new ArrayList<String>();
			br.add(str);
			br.add("_");
			return br;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> rr = gss(ros);
		ArrayList<String> mr = new ArrayList<String>();
		for (String rstr : rr) {
			mr.add(rstr);
			mr.add(ch + rstr);
		}
		return mr;
	}

	public static ArrayList<String> gsswithascii(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> rr = gsswithascii(ros);
		ArrayList<String> mr = new ArrayList<String>();
		for (String rstr : rr) {
			mr.add(rstr);
			mr.add(ch+rstr);
			mr.add((int) ch + rstr);
		}
		return mr;
	}
//	static String[] codes= {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
//	public static ArrayList<String> getkpc(String str){
//		if (str.length() == 0) {
//			ArrayList<String> bresult = new ArrayList<>();
//			bresult.add("");
//			return bresult;
//		}
//		int c = str.charAt(0) - '0';
//		String ros = str.substring(1);
//		ArrayList<String> rresult = getkpc(ros);
//		ArrayList<String> mresult = new ArrayList<>();
//		String ch = codes[c];
//		for (String r : rresult) {
//
//			for (int i = 0; i < ch.length(); i++) {
//				mresult.add(ch.charAt(i) + r);
//			}
//		}
//		return mresult;
//	}
	static String[] codes= {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
	public static ArrayList<String> getkpc(String str){
		if (str.length() == 0) {
			ArrayList<String> bresult = new ArrayList<>();
			bresult.add("");
			return bresult;
		}
		char ch=str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> rresult = getkpc(ros);
		ArrayList<String> mresult = new ArrayList<>();
		String code=codes[ch-'0'];
		for (String r : rresult) {

			for (int i = 0; i < code.length(); i++) {
				mresult.add(code.charAt(i) + r);
			}
		}
		return mresult;
	}
	public static ArrayList<String> get_path(String str){
		
	}
	}

