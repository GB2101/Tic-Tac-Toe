package artificial_iteligence;

import java.util.Random;

public class Level1 {

	public static int[] brain(int[][] board) {
		Random rmd = new Random();
		int[][] moves = new int[9][2];
		int ind = 0;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == 0) {
					moves[ind][0] = i;
					moves[ind][1] = j;
					ind++;
				}
			}
		}
		
		ind = rmd.nextInt(ind);

		int x = moves[ind][0];
		int y = moves[ind][1];

		int[] move = { x, y };
		
		return move;
	}

}
