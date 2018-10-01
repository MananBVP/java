import java.util.Scanner;

public class Crossword {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		char[][] cross=new char[10][10];
		for(int i=0;i<cross.length;i++) {
			cross[i]=scn.nextLine().toCharArray();
		}
      String[] word=scn.nextLine().split(";");
	}
	public static void crossword(char[][]cross,String[] words,int widx) {
		if(widx==cross.length) {
		for(int r=0;r<cross.length;r++) {
			for(int c=0;c<cross[r].length;c++) {
				System.out.println(cross[r][c]);
			}
			System.out.println();
		}
		return;
		}
		for(int r=0;r<cross.length;r++) {
			for(int c=0;c<cross[r].length;c++) {
				if(cross[r][c]=='-' || cross[r][c]==words[widx].charAt(0)) {
					if(canplaceh(cross, words, r, c);) {
						boolean[] reset=placeh(cross, words[widx], r, c);
						
					}
				}
					
				}
			}
		if(canplaceh) {
			boolean reset=placeh(cross, words[widx], r, c);
			
		}
	}
    private static void canplaceh(char[][]cross,String words,int r,int c) {

	}
    private static boolean[] placeh(char[][]cross,String words,int r,int c) {
    	
	}
    private static void canplacev(char[][]cross,String words) {

	}
    private static void upplceh(char[][]cross,String words,boolean[] reset,int r,int c) {
		

	}
    private static void placev(char[][]cross,String[] words) {
    	

	}
}
