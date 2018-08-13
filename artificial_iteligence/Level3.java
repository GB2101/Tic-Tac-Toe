package artificial_iteligence;

import java.util.Random;

public class Level3 {

	public static int[] brain(int[][] board, int choice) {
		int[] move = new int[2];

		try {
			move = Level2.analyse(board, choice);
		} catch (Exception error) {
			move = analyse(board, choice);
		}

		return move;
	}

	public static int[] analyse(int[][] board, int choice) {
		int mine = choice * (-1);
		int x = -1;
		int y = -1;
		int ind = 0;
		int[][] moves = new int[9][2];
		int[][] corner = { { 0, 0 }, { 0, 2 }, { 2, 0 }, { 2, 2 } };
		int[][] middle = { { 0, 1 }, { 1, 0 }, { 1, 2 }, { 2, 1 } };

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] != 0) {
					moves[ind][0] = i;
					moves[ind][1] = j;
					ind++;
				}
			}
		}

		// Main part
		if (ind % 2 == 0) {
			int[] aux = even(board, corner, middle, moves, ind);
			x = aux[0];
			y = aux[1];
		} else if (ind % 2 == 1) {
			int[] aux = odd(board, corner, middle, moves, ind);
			x = aux[0];
			y = aux[1];
		}

		int[] move = { x, y };

		return move;
	}

	public static int[] even(int[][] board, int[][] corner, int[][] middle, int[][] moves, int ind) {
		Random rmd = new Random();
		int x = -1;
		int y = -1;

		if (ind == 0) {
			int aux = rmd.nextInt(4);
			x = corner[aux][0];
			y = corner[aux][1];
		} else if (ind == 2) {
			corner = aux1(corner, moves, ind);
			int aux = aux2(corner);
			if (aux == 2 || board[1][1] != 0) {
				aux = rmd.nextInt(aux);
				x = corner[aux][0];
				y = corner[aux][1];
			} else {
				x = 1;
				y = 1;
			}
		} else if (ind == 4) {
			corner = aux1(corner, moves, ind);
			middle = aux1(middle, moves, ind);
			int ax1 = aux2(corner);
			int ax2 = aux2(middle);
			if (ax1 == 1) {
				x = corner[0][0];
				y = corner[0][1];
			} else if (ax2 == 3) {
				int x1 = 0, x2 = 0;
				int y1 = 0, y2 = 0;
				for (int i = 0; i < ax2; i++) {
					int aux1 = middle[i][0] + middle[i][1];
					if (aux1 == 1) {
						x1++;
					} else if (aux1 == 3) {
						x2++;
					}
					if (i < ax1) {
						int aux2 = corner[i][0] + corner[i][1];
						if (aux2 == 2) {
							y2++;
						} else {
							y1++;
						}
					}
				}
				if (y1 > 0) {
					if (x1 == 2) {
						x = 0;
						y = 0;
					} else if (x2 == 2) {
						x = 2;
						y = 2;
					}
				} else if (y2 > 0) {
					if (x1 == 1) {
						int[][] auxArray = { { 0, 1 }, { 1, 0 } };
						auxArray = aux1(auxArray, moves, ind);
						x = auxArray[0][0];
						y = auxArray[0][1];
					}else if (x2 == 1) {
						int[][] auxArray = { { 1, 2 }, { 2, 1 } };
						auxArray = aux1(auxArray, moves, ind);
						x = auxArray[0][0];
						y = auxArray[0][1];
					}
				}
			}
		}else {
			int[] aux = Level1.brain(board);
			x = aux[0];
			y = aux[1];
		}

		int[] move = { x, y };
		return move;
	}

	public static int[] odd(int[][] board, int[][] corner, int[][] middle, int[][] moves, int ind) {
		Random rmd = new Random();
		int x = -1;
		int y = -1;
		if (ind == 1) {
			if (board[1][1] == 0) {
				x = 1;
				y = 1;
			} else {
				int aux = rmd.nextInt(4);
				x = corner[aux][0];
				y = corner[aux][1];
			}
		} else if (ind == 3) {
			middle = aux1(middle, moves, ind);
			int aux = aux2(middle);
			if (aux == 2) {
				int ax1 = middle[0][0] + middle[0][1];
				int ax2 = middle[1][0] + middle[1][1];
				if (ax1 == 1 && ax2 == 1) {
					x = 2;
					y = 2;
				} else if (ax1 == 3 && ax2 == 3) {
					x = 0;
					y = 0;
				} else {
					int[][] auxArray = { { 0, 0 }, { 2, 2 } };
					aux = rmd.nextInt(2);
					x = auxArray[aux][0];
					y = auxArray[aux][1];
				}
			} else {
				aux = rmd.nextInt(aux);
				x = middle[aux][0];
				y = middle[aux][1];
			}
		} else if (ind == 5) {
			corner = aux1(corner, moves, ind);
			int aux = aux2(corner);
			aux = rmd.nextInt(aux);
			x = corner[aux][0];
			y = corner[aux][1];
		} else {
			int[] aux = Level1.brain(board);
			x = aux[0];
			y = aux[1];
		}

		int[] move = { x, y };
		return move;
	}

	public static int[][] aux1(int[][] board, int[][] moves, int ind) {
		int aux = board.length;
		aux--;
		for (int i = 0; i < ind; i++) {
			for (int j = 0; j <= aux; j++) {
				if (moves[i][0] == board[j][0] && moves[i][1] == board[j][1]) {
					board[j] = board[aux];
					board[aux] = null;
					aux--;
					j = aux;
				}
			}
		}
		return board;
	}

	public static int aux2(int[][] moves) {
		int aux = 0;
		for (int i = 0; i < moves.length; i++) {
			if (moves[i] != null) {
				aux++;
			} else {
				i = moves.length;
			}
		}
		return aux;
	}

}
