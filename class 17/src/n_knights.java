
public class n_knights {

	public static void main(String[] args) {
		boolean[][] board = new boolean[4][4];
		knightss(board, 1, 1, "");

	}

	static int counter = 0;

	private static void knightss(boolean[][] board, int cq, int cellno, String asf) {
		if (cq > board.length) {
			System.out.println(++counter + "" + asf);
			return;
		}
		if (cellno > board.length * board.length) {
			return;
		}
		knightss(board, cq, cellno + 1, asf); // box said no
		int rno = (cellno - 1) / board.length;
		int cno = (cellno - 1) % board.length;
		if (board[rno][cno] == false && isqueensafe(board, rno, cno)) {
			board[rno][cno] = true;
			knightss(board, cq + 1, cellno + 1, asf + " " + cellno); // box said yes
			board[rno][cno] = false;
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
		int[][] dir = { { 1, 2 },
				{ -1, 2 }, 
				{ -1, -2 },
				{ 1, -2 },
				{ 2, 1 }, 
				{ 2, -1 }, 
				{ -2, -1 },
				{ -2, 1 }, 
		};
		for (int dirs[] : dir) {
			int renemy = row + dirs[0];
			int cenemy = col + dirs[1];
			if (renemy >= 0 && renemy < board.length && cenemy >= 0 && cenemy < board.length
					&& board[renemy][cenemy] == true) {
				return false;
			}
		}

		return true;
	}
}
