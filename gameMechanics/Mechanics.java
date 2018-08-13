package gameMechanics;

import userInterface.Input;
import auxiliar.*;

public class Mechanics {

	public static int[][] movement(int[][] board, int[] move, int who) throws Exception {
		int x = move[0];
		int y = move[1];
		if (board[x][y] == 0) {
			if (who == 1) {
				board[x][y] = 1;
			} else if (who == -1) {
				board[x][y] = -1;
			}
		} else {
			throw new ErrorException("Movimento inválido. Esse movimento já foi jogado.");
		}
		return board;
	}

	public static int[] move(int who) {
		int[] move = { -1, -1 };
		try {
			move = Input.playerMove(who);
		} catch (Exception error) {
			System.out.println(error);
			System.out.println("Tente novamente.");
			move = move(who);
		}
		return move;
	}

	public static int[][] computer(int[][] board, int[] move, int choice) {
		int x = move[0];
		int y = move[1];

		if (choice == 1) {
			board[x][y] = -1;
		} else if (choice == -1) {
			board[x][y] = 1;
		}

		return board;
	}

	public static String print(int[] move, int choice) {
		String print = "";

		if (choice == 1) {
			print = "O: ";
		} else if (choice == -1) {
			print = "X: ";
		}

		if (move[0] == 0) {
			print += "A";
		} else if (move[0] == 1) {
			print += "B";
		} else if (move[0] == 2) {
			print += "C";
		}

		if (move[1] == 0) {
			print += "1";
		} else if (move[1] == 1) {
			print += "2";
		} else if (move[1] == 2) {
			print += "3";
		}

		return print;
	}

	public static int victory(int[][] board) {
		int result = 0;
		boolean pl1 = false, pl2 = false;
		// columns and lines
		for (int i = 0; i < 3; i++) {
			int x1 = 0, y1 = 0;
			int x2 = 0, y2 = 0;
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == 1) {
					x1++;
				} else if (board[i][j] == -1) {
					x2++;
				}
				if (board[j][i] == 1) {
					y1++;
				} else if (board[j][i] == -1) {
					y2++;
				}
			}
			if (x1 == 3 || y1 == 3) {
				i = 3;
				pl1 = true;
			} else if (x2 == 3 || y2 == 3) {
				i = 3;
				pl2 = true;
			}
		}
		// diagonals
		if (!pl1 && !pl2) {
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
			if (dx1 == 3 || dy1 == 3) {
				pl1 = true;
			} else if (dx2 == 3 || dy2 == 3) {
				pl2 = true;
			}
		}

		if (pl1) {
			result = 1;
		} else if (pl2) {
			result = -1;
		}

		return result;
	}

}
