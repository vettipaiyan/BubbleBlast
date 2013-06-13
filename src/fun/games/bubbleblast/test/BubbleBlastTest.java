package fun.games.bubbleblast.test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import fun.games.bubbleblast.main.BubbleBlastGame;

public class BubbleBlastTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input;
		String[] tokens = new String[2];
		int row = 0;
		int col = 0;
		final int MAX_ROW = 6;
		final int MAX_COL = 5;
		boolean gameOver = false;
		
		BubbleBlastGame bg = new BubbleBlastGame();
		
		while(!gameOver){
			System.out.println("***********************");
			bg.displayGrid();
			System.out.println("***********************");
			System.out.println("Enter to play (row,col)");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				input = br.readLine();
				System.out.println("Input string is: "+ input);
				tokens = input.toString().split(",");
				if(null != tokens[0] && !"".equalsIgnoreCase(tokens[0])){
					row = Integer.parseInt(tokens[0]);
				}else{
					System.out.println("Invalid row value");
				}
				if(null != tokens[1] && !"".equalsIgnoreCase(tokens[1])){
					col = Integer.parseInt(tokens[1]);
				}
				if(row >0 && row <=MAX_ROW && col > 0 && col <= MAX_COL){
					gameOver = bg.checkGameOver(bg.play(row-1, col-1));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
