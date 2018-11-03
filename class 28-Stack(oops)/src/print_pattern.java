
public class print_pattern {

	public static void main(String[] args) {
		String str = "ddiddidd";
		printPattern(str);
	}

	private static void printPattern(String str) {
		int n = 1;
		stack st = new stack(str.length() + 1);
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == 'd') {
				st.push(n);
				n++;
			} else if (ch == 'i') {
				st.push(n);
				n++;
				while (st.isEmpty() == false) {
					System.out.print(st.pop() + " ");
					
				}
			}
		}
		st.push(n);
		while (st.isEmpty() == false) {
			System.out.print(st.pop() + " ");
		}
	}
}
