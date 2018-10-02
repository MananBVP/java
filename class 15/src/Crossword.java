import java.util.Scanner;

public class Crossword {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		char[][] crossword = new char[10][10];
		for(int i = 0; i < 10; i++){
			crossword[i] = scn.nextLine().toCharArray();
		}
		String[] words = scn.nextLine().split(";");
		crossword(crossword, words, 0);
	}

	public static void crossword(char[][] crossword, String[] words, 
								int widx) {
		if (widx == words.length) {
			for (int r = 0; r < crossword.length; r++) {
				for (int c = 0; c < crossword[r].length; c++) {
					System.out.print(crossword[r][c]);
				}
				System.out.println();
			}

			return;
		}

		for (int r = 0; r < crossword.length; r++) {
			for (int c = 0; c < crossword[r].length; c++) {
				if (crossword[r][c] == '-' || crossword[r][c] == words[widx].charAt(0)) {
					if (cpwHoriz(words[widx], crossword, r, c)) {
						boolean[] reset = pwHoriz(words[widx], crossword, r, c);
						crossword(crossword, words, widx + 1);
						upwHoriz(words[widx], crossword, r, c, reset);
					}

					if (cpwVert(words[widx], crossword, r, c)) {
						boolean[] reset = pwVert(words[widx], crossword, r, c);
						crossword(crossword, words, widx + 1);
						upwVert(words[widx], crossword, r, c, reset);
					}
				}
			}
		}
	}

	private static boolean cpwHoriz(String word, char[][] crossword, int r, int c) {
		if (c + word.length() > crossword[0].length) {
			return false;
		}

		for (int i = 0; i < word.length(); i++) {
			if (crossword[r][c + i] != '-' && 
				crossword[r][c + i] != word.charAt(i)) {
				return false;
			}
		}

		// exact fit

		return true;
	}

	private static boolean[] pwHoriz(String word, char[][] crossword, int r, int c) {
		boolean[] reset = new boolean[word.length()];
		for (int i = 0; i < word.length(); i++) {
			reset[i] = crossword[r][c + i] == '-';
			crossword[r][c + i] = word.charAt(i);
		}
		return reset;
	}

	private static void upwHoriz(String word, char[][] crossword, int r, int c, boolean[] reset) {
		for (int i = 0; i < word.length(); i++) {
			if (reset[i]) {
				crossword[r][c + i] = '-';
			}
		}
	}

	private static boolean cpwVert(String word, char[][] crossword, int r, int c) {
		if (r + word.length() > crossword.length) {
			return false;
		}

		for (int i = 0; i < word.length(); i++) {
			if (crossword[r + i][c] != '-' && 
				crossword[r + i][c] != word.charAt(i)) {
				return false;
			}
		}

		// exact fit

		return true;
	}

	private static boolean[] pwVert(String word, char[][] crossword, int r, int c) {
		boolean[] reset = new boolean[word.length()];
		for (int i = 0; i < word.length(); i++) {
			reset[i] = crossword[r + i][c] == '-';
			crossword[r + i][c] = word.charAt(i);
		}
		return reset;
	}

	private static void upwVert(String word, char[][] crossword, 
								int r, int c, boolean[] reset) {
		for (int i = 0; i < word.length(); i++) {
			if (reset[i]) {
				crossword[r + i][c] = '-';
			}
		}
	}

}
/*+-++++++++
+-------++
+-++-+++++
+-------++
+-++-+++++
+-++-+++++
+-++------
++++++++++
+++++----+
++++++++++
ANDAMAN;MANIPUR;ICELAND;ALLEPY;YANGON;PUNE*/
