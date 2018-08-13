package artificial_iteligence;

public class AI {

	public static int[] brain(int[][] board, int level, int choice) {
		int[] move = new int[2];

		if (level == 0) {
			move = Level1.brain(board);
		} else if (level == 1) {
			move = Level2.brain(board, choice);
		} else if (level == 2) {
			move = Level3.brain(board, choice);
		}

		return move;
	}

}
