package fun.games.bubbleblast.main;

import java.util.Random;

public class BubbleBlastGame {
	private static final int MAX_ROW = 6;
	private static final int MAX_COL = 5;
	private int[][]grid;
	
	
	public BubbleBlastGame(){
		Random rand = new Random();
		grid = new int[MAX_ROW][MAX_COL];
		for(int i=0;i<6;i++){
			for(int j=0;j<5;j++){
				grid[i][j] = rand.nextInt(4);
			}
		}
	}
	
	public void displayGrid(){
		for(int i=0;i<6;i++){
			for(int j=0;j<5;j++){
				System.out.println(grid[i][j]+ " ");
			}
			System.out.println("");
		}
	}
	
	public int[][] play(int row, int col){
		
		if(grid[row][col] !=0){
			if(grid[row][col] == 1){
				grid[row][col]-=1;
				if((row-1) != -1){
					play(row-1,col);
				}
				if((col -1) != -1){
					play(row,col-1);
				}
				if((row+1) <= MAX_ROW-1 ){
					play (row+1,col);
				}
				if((col+1) <=MAX_COL-1){
					play(row,col+1);
				}
			}else{
				grid[row][col]-=1;
			}
		}
		return grid;
	}
	
	public boolean checkGameOver(int[][] tempGrid){
		boolean isGameOver = true;
		for(int i=0;i<6;i++ ){
			for(int j=0;j<5;j++){
				if(tempGrid[i][j] !=0){
					isGameOver = false;
					break;
				}
			}
			if(!isGameOver){
				break;
			}
		}
		return isGameOver;
	}
}
