package main;

import artificial_iteligence.Level1;
import artificial_iteligence.Level3;
import auxiliar.ErrorException;
import userInterface.*;

public class Test {

	public static void main(String[] args) throws Exception {
		int[][] board = { { 0, 0, -1 }, { 0, 0, 1 }, { 0, 0, 0 } };
		int[] move = Level3.brain(board, 1);
		System.out.println(move[0] + " " + move[1]);
	}

}
