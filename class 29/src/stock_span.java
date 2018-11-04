
public class stock_span {

	public static void main(String[] args) {
//		int[] prices = { 30, 40, 50, 45, 48, 60, 20, 25, 38, 32, 37, 50 };
//		int[] spans = Stock_spn(prices);
//		for (int val : spans) {
//			System.out.print(val + " ");
//		}
//		System.out.println();
		int[] arr = { 6, 2, 5, 4, 5, 1, 6 };
		System.out.println(Largest_Histogram_Area(arr));
	}

	private static int[] Stock_spn(int[] prices) {
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

	private static int Largest_Histogram_Area(int[] arr) {
		stack st = new stack(arr.length);
		int maxa = Integer.MIN_VALUE;
		st.push(0);
		int carea = 0;
		for (int i = 1; i < arr.length; i++) {
			while (st.size() > 0 && arr[i] < arr[st.top()]) {
				int breadth = 0;
				int val = arr[st.pop()];
				if (st.size() == 0) {
					breadth = i;
				} else {
					breadth = i - st.top() - 1;
				}
				carea = val * breadth;
				maxa = Math.max(carea, maxa);
			}
			st.push(i);
		}
		while (st.size() > 0) {
			int breadth = 0;

			int val = arr[st.pop()];
			if (st.size() == 0) {
				breadth = arr.length;
			} else {
				breadth = arr.length - st.top() - 1;
			}
			carea = val * breadth;
			maxa = Math.max(carea, maxa);
		}
		return maxa;
	}
}