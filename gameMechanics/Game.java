package gameMechanics;

import artificial_iteligence.*;
import auxiliar.Oxx;
import userInterface.*;

public class Game {

	public static int game(int twoPlayer, int first, int level, int choice) {
		int result = 0;
		if (twoPlayer == 0) {
			result = pcGame(first, level, choice);
		} else {
			result = tpGame(first);
		}
		return result;
	}

	public static int pcGame(int first, int level, int choice) {
		int result = 0;
		int movement = 1;
		int[][] board = new int[3][3];

		int pl1 = choice;

		boolean won1 = false, won2 = false;

		while (!won1 && !won2 && movement < 10) {
			if (first == 1) {
				if (movement == 1) {
					Output.board(board);
				}
				board = aux1(board, pl1);
				result = Mechanics.victory(board);
				movement++;

				if (result == 0 && movement < 10) {
					board = aux2(board, level, choice);
					result = Mechanics.victory(board);
					movement++;
				}
				Output.board(board);
			} else if (first == -1) {
				board = aux2(board, level, choice);
				Output.board(board);
				result = Mechanics.victory(board);
				movement++;

				if (result == 0 && movement < 10) {
					board = aux1(board, pl1);
					result = Mechanics.victory(board);
					if (result != 0) {
						Output.board(board);
					}
					movement++;
				}
			}
			if (result == 1) {
				won1 = true;
			} else if (result == -1) {
				won2 = true;
			}
		}
		return result;
	}

	public static int tpGame(int first) {
		int result = 0;
		int movement = 1;
		int[][] board = new int[3][3];

		int pl1 = first;
		int pl2 = first * (-1);

		boolean won1 = false, won2 = false;

		Output.board(board);
		
		while (!won1 && !won2 && movement < 10) {
			board = aux1(board, pl1);
			result = Mechanics.victory(board);
			Output.board(board);
			movement++;

			if (result == 0 && movement < 10) {
				board = aux1(board, pl2);
				result = Mechanics.victory(board);
				Output.board(board);
				movement++;
			}
			if (result == 1) {
				won1 = true;
			} else if (result == -1) {
				won2 = true;
			}
		}
		
		return result;
	}

	public static int[][] aux1(int[][] board, int pl) {
		int[] move = Mechanics.move(pl);
		try {
			board = Mechanics.movement(board, move, pl);
		} catch (Exception error) {
			System.out.println(error);
			System.out.println("Jogue novamente.");
			board = aux1(board, pl);
		}
		return board;
	}

	public static int[][] aux2(int[][] board, int level, int choice) {
		int[] move = AI.brain(board, level, choice);
		String print = Mechanics.print(move, choice);
		System.out.printf("Movimento do Jogador %s", print);
		board = Mechanics.computer(board, move, choice);
		return board;
	}

}
