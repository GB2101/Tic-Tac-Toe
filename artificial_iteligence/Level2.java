package artificial_iteligence;

import auxiliar.ErrorException;

public class Level2 {

	public static int[] brain(int[][] board, int choice) {
		int[] move = new int[2];
		
		try {
			move = analyse(board, choice);
		}catch (Exception error) {
			move = Level1.brain(board);
		}
		
		return move;
	}

	public static int[] analyse(int[][] board, int choice) throws Exception{
		int mine = choice * (-1);
		int x = -1;
		int y = -1;
		int dig = 0;
		int win = 0;
		int[] move = new int[2];

		// columns and lines
		for (int i = 0; i < 3; i++) {
			int x1 = 0, y1 = 0;
			int x2 = 0, y2 = 0;
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == mine) {
					x1++;
				} else if (board[i][j] == choice) {
					x2++;
				}
				if (board[j][i] == mine) {
					y1++;
				} else if (board[j][i] == choice) {
					y2++;
				}
			}
			if (x1 == 2 && x2 == 0) {
				x = i;
				y = -1;
				i = 3;
				win = 1;
			} else if (y1 == 2 && y2 == 0) {
				y = i;
				x = -1;
				i = 3;
				win = 1;
			}
			if (win == 0) {
				if (x2 == 2 && x1 == 0) {
					x = i;
					win = -1;
				} else if (y2 == 2 && y1 == 0) {
					y = i;
					win = -1;
				}
			}
		}
		// diagonals
		if (win <= 0) {
			int dx1 = 0, dy1 = 0;
			int dx2 = 0, dy2 = 0;
			for (int i = 0, j = 2; i < 3 && j >= 0; i++, j--) {
				if (board[i][i] == 1) {
					dx1++;
				} else if (board[i][i] == -1) {
					dx2++;
				}
				if (board[i][j] == 1) {
					dy1++;
				} else if (board[i][j] == -1) {
					dy2++;
				}
			}
			if (dx1 == 2 && dx2 == 0) {
				dig = 1;
				win = 1;
			} else if (dy1 == 2 && dy2 == 0) {
				dig = -1;
				win = 1;
			}
			if (win == 0) {
				if (dx2 == 2 && dx1 == 0) {
					dig = 1;
					win = -1;
				} else if (dy2 == 2 && dy1 == 0) {
					dig = -1;
					win = -1;
				}
			}
		}

		if (win != 0) {
			if (dig == 0) {
				if (x >= 0) {
					for (int i = 0; i < 3; i++) {
						if (board[x][i] == 0) {
							y = i;
							i = 3;
						}
					}
				} else if (y >= 0) {
					for (int i = 0; i < 3; i++) {
						if (board[i][y] == 0) {
							x = i;
							i = 3;
						}
					}
				}
			} else if (dig == 1) {
				for (int i = 0; i < 3; i++) {
					if (board[i][i] == 0) {
						x = i;
						y = i;
					}
				}
			} else if (dig == -1) {
				for (int i = 0, j = 2; i < 3 && j >= 0; i++, j--) {
					if (board[i][j] == 0) {
						x = i;
						y = j;
					}
				}
			}
			move[0] = x;
			move[1] = y;
		}else {
			throw new ErrorException("NullPointException");
		}

		return move;
	}

}
