
public class stock_span {

	public static void main(String[] args) {
		int[] prices = { 30, 40, 50, 45, 48, 60, 20, 25, 38, 32, 37, 50 };
		int[] spans = Stack_spn(prices);
		for (int val : spans) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

	private static int[] Stack_spn(int[] prices) {
		stack st = new stack(prices.length);
		int[] spans = new int[prices.length];
		spans[0] = 1;
		st.push(0);
		for (int i = 1; i < prices.length; i++) {
			while (st.size() > 0 && prices[i] > prices[st.top()]) {
				st.pop();
			}
			spans[i] = st.size() == 0 ? i + 1 : i - st.top();
			st.push(i);
		}
		return spans;
	}
}