
public class n_queens {

	public static void main(String[] args) {
		boolean[][] board = new boolean[4][4];
//		print_nqueens(board, 1, 0, "");
//		print_nqueensPA(board, 1, 0, " ");
		queenss(board, 1, 1, " ");

	}

	static int counter = 0;

	private static void queenss(boolean[][] board, int cq, int cellno, String asf) {
		if (cq > board.length) {
			System.out.println(++counter + "" + asf);
			return;
		}
		if (cellno > board.length * board.length) {
			return;
		}
		queenss(board, cq, cellno + 1, asf); // box said no
		int rno = (cellno - 1) / board.length;
		int cno = (cellno - 1) % board.length;
		if (board[rno][cno] == false && isqueensafe(board, rno, cno)) {
			board[rno][cno] = true;
			queenss(board, cq + 1, cellno + 1, asf + " "+cellno + " "); // box said yes
			board[rno][cno] = false;
		}

	}

	public static void print_nqueensPA(boolean[][] board, int cq, int lqb, String asf) {
		if (cq > board.length) {
			System.out.println(++counter + "." + asf);
			return;
		}

		for (int i = lqb + 1; i <= board.length * board.length; i++) {
			int rno = (i - 1) / board.length;
			int cno = (i - 1) % board.length;
			if (board[rno][cno] == false && isqueensafe(board, rno, cno) == true) {
				board[rno][cno] = true;
				print_nqueensPA(board, cq + 1, i, asf + i + " ");
				board[rno][cno] = false;
			}
		}
	}

	public static void print_nqueens(boolean[][] board, int cq, int lqb, String asf) {
		if (cq > board.length) {
			if (isboardvalid(board) == true)
				System.out.println(++counter + "." + asf);
			return;
		}

		for (int i = lqb + 1; i <= board.length * board.length; i++) {
			int rno = (i - 1) / board.length;
			int cno = (i - 1) % board.length;
			if (board[rno][cno] == false) {
				board[rno][cno] = true;
				print_nqueens(board, cq + 1, i, asf + i + " ");
				board[rno][cno] = false;
			}
		}
	}

	private static boolean isboardvalid(boolean[][] board) {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board.length; col++) {
				if (board[row][col] == true) {
					if (isqueensafe(board, row, col) == false) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private static boolean isqueensafe(boolean[][] board, int row, int col) {
		int[][] dir = { { -1, 0 }, // north
				{ -1, 1 }, // ne
				{ 0, 1 }, // east
				{ 1, 1 }, // se
				{ 1, 0 }, // south
				{ 1, 1 }, // sw
				{ 0, -1 }, // west
				{ -1, -1 }, // nw
		};
		for (int dirs[] : dir) {
			for (int rad = 1; rad < board.length; rad++) {
				int renemy = row + dirs[0] * rad;
				int cenemy = col + dirs[1] * rad;
				if (renemy >= 0 && renemy < board.length && cenemy >= 0 && cenemy < board.length
						&& board[renemy][cenemy] == true) {
					return false;
				}
			}
		}
		return true;
	}
}
