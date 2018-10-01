
public class pnc_recursion {

	public static void main(String[] args) {
//		boolean[] boxes=new boolean[4];
//		permutations(boxes, 2, 0, " ");
//		combinations(boxes, 2,0, -1, " ");
//		int[] coins= {2,3,5,6};
//		coinsp(coins, 10, " ");
//		coinsc(coins, 10, " ", 0);
//		perm(0,4 ,2,0, " ");
		combbox(4, 0, 2, 0, " ");

	}

	public static void permutations(boolean[] boxes, int titem, int citem, String asf) {
		if (citem == titem) {
			System.out.println(asf);
		}
		for (int i = 0; i < boxes.length; i++) {
			if (boxes[i] == false) {
				boxes[i] = true;
				permutations(boxes, titem, citem + 1, asf + "b" + i + "i" + citem + " ");
				boxes[i] = false;
			}
		}
	}

	public static void combinations(boolean[] boxes, int titem, int citem, int llbu, String asf) {
		if (citem == titem) {
			System.out.println(asf);
		}
		for (int i = llbu + 1; i < boxes.length; i++) {
			if (boxes[i] == false) {
				boxes[i] = true;
				combinations(boxes, titem, citem + 1, i, asf + "b" + i + "i" + citem + " ");
				boxes[i] = false;
			}
		}
	}

	private static void coinsp(int[] coins, int ramount, String psf) {
		if (ramount == 0) {
			System.out.println(psf);
			return;
		}
		for (int i = 0; i < coins.length; i++) {
			if (ramount >= coins[i]) {
				coinsp(coins, ramount - coins[i], psf + coins[i]);
			}
		}
	}

	private static void coinsc(int[] coins, int ramount, String psf, int lpci) {
		if (ramount == 0) {
			System.out.println(psf);
			return;
		}
		for (int i = lpci; i < coins.length; i++) {
			if (ramount >= coins[i]) {
				coinsc(coins, ramount - coins[i], psf + coins[i], i);
			}
		}
	}

	public static void perm(int choicebm, int tboxes, int titem, int citem, String asf) {
		if (citem == titem) {
			System.out.println(asf);
		}
		for (int i = 0; i < tboxes; i++) {
			if ((choicebm & (1 << i)) == 0) {
				choicebm = choicebm | (1 << i);
				perm(choicebm, tboxes, titem, citem + 1, asf + "b" + i + "i" + citem + " ");
				choicebm = choicebm & (~(1 << i));
			}

		}
	}

	private static void combbox(int tbox, int cbox, int titem, int citem, String asf) {
		if (citem == titem) {
			System.out.println(asf);
			return;
		}
		if (cbox == tbox) {
			return;
		}
		combbox(tbox, cbox + 1, titem, citem + 1, asf + "b" + cbox + "i" + tbox + " ");
		combbox(tbox, cbox + 1, titem, citem, asf);

	}
}
