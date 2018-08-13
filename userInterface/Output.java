package userInterface;

import auxiliar.*;

public class Output {

	public static void main(String[] args) {
		System.out.println("Olá, vamos jogar o Jogo da Velha ?\n(Aperte Enter)");
		Oxx.enter();
		int aux = instruction();
		if (aux == 0) {
			rules();
		}
	}

	public static void rules() {
		System.out.println("Como jogar");
		System.out.println();
		System.out.println("Para responder as perguntas, use a letra da alternativa indicada."
				+ "\n A) Neste exemplo você usaria 'A'.\n\nAperte 'Enter' para mostar mais.");
		Oxx.enter();
		System.out.println("Quando o jogo começar, você deve dizer qual movimento você quer fazer.");
		Oxx.enter();
		System.out.println("Seu movimento deve seguir o quadro a abaixo:");
		System.out.println("   A    B    C ");
		System.out.println("1 A1 | B1 | C1 ");
		System.out.println(" ----+----+----");
		System.out.println("2 A2 | B2 | C2 ");
		System.out.println(" ----+----+----");
		System.out.println("3 A3 | B3 | C3 ");
		Oxx.enter();
		System.out.println("Se você jogar 'A3', o quadro fica como mostrado:");
		int[][] board = new int[3][3];
		board[0][2] = 1;
		board(board);
		Oxx.enter();
	}

	public static void board(int[][] board) {
		String[][] print = new String[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == 0) {
					print[i][j] = "  ";
				} else if (board[i][j] == 1) {
					print[i][j] = "X ";
				} else if (board[i][j] == -1) {
					print[i][j] = "O ";
				}
			}
		}

		System.out.printf("\n  A   B   C ");
		System.out.printf("\n1 %s| %s| %s", print[0][0], print[1][0], print[2][0]);
		System.out.printf("\n ---+---+---");
		System.out.printf("\n2 %s| %s| %s", print[0][1], print[1][1], print[2][1]);
		System.out.printf("\n ---+---+---");
		System.out.printf("\n3 %s| %s| %s", print[0][2], print[1][2], print[2][2]);
		System.out.println();
	}

	public static int twoPlayer() {
		System.out.println("Contra quem você quer jogar ?");
		System.out.println("A) O computador");
		System.out.println("B) Outro jogador");
		int answer = Input.answer(1);
		if (answer == 0) {
			System.out.println("A) O computador");
		} else if (answer == 1) {
			System.out.println("B) Outro jogador");
		}
		Oxx.enter();
		return answer;
	}

	public static int first1() {
		System.out.println("Quem irá começar ?");
		System.out.println("A) O jogador");
		System.out.println("B) O computador");
		int answer = Input.answer(1);
		if (answer == 0) {
			answer = 1;
			System.out.println("A) O jogador");
		} else if (answer == 1) {
			answer = -1;
			System.out.println("B) O computador");
		}
		Oxx.enter();
		return answer;
	}

	public static int first2() {
		System.out.println("Quem irá começar ?");
		System.out.println("A) O jogador X");
		System.out.println("B) O jogador O");
		int answer = Input.answer(1);
		if (answer == 0) {
			answer = 1;
			System.out.println("A) O jogador X");
		} else if (answer == 1) {
			answer = -1;
			System.out.println("B) O jogador O");
		}
		Oxx.enter();
		return answer;
	}

	public static int choice() {
		System.out.println("Qual símbolo você quer usar ?");
		System.out.println("A) Símbolo 'X'.");
		System.out.println("B) Símbolo 'O'.");
		int answer = Input.answer(1);
		if (answer == 0) {
			answer = 1;
			System.out.println("A) Símbolo 'X'.");
			Oxx.enter();
			System.out.println("O computador será o jogador O.");
		} else if (answer == 1) {
			answer = -1;
			System.out.println("B) Símbolo 'O'.");
			Oxx.enter();
			System.out.println("O computador será o jogador X.");
		}
		Oxx.enter();
		return answer;
	}

	public static int level() {
		System.out.println("Contra qual nível você deseja jogar ?");
		System.out.println("A) Level 1");
		System.out.println("B) Level 2");
		System.out.println("C) Level 3");
		int answer = Input.answer(2);
		if (answer == 0) {
			System.out.println("A) Level 1");
		} else if (answer == 1) {
			System.out.println("B) Level 2");
		} else if (answer == 2) {
			System.out.println("C) Level 3");
		}
		Oxx.enter();
		return answer;
	}

	public static int again() {
		System.out.println("Quer jogar novamente ?");
		System.out.println("A) Sim");
		System.out.println("B) Não");
		int answer = Input.answer(1);
		if (answer == 0) {
			System.out.println("A) Sim");
		} else if (answer == 1) {
			System.out.println("B) Não");
		}
		Oxx.enter();
		return answer;
	}

	public static int reset() {
		System.out.println("Quer reiniciar os pontos ?");
		System.out.println("A) Sim");
		System.out.println("B) Não");
		int answer = Input.answer(1);
		if (answer == 0) {
			System.out.println("A) Sim");
		} else if (answer == 1) {
			System.out.println("B) Não");
		}
		Oxx.enter();
		return answer;
	}

	public static int config() {
		System.out.println("Quer altera algo ?");
		System.out.println("A) Alterar configurações de jogo");
		System.out.println("B) Reiniciar os pontos");
		System.out.println("C) Não");
		int answer = Input.answer(2);
		if (answer == 0) {
			System.out.println("A) Alterar configurações de jogo");
		} else if (answer == 1) {
			System.out.println("B) Reiniciar os pontos");
		} else if (answer == 2) {
			System.out.println("C) Não");
		}
		Oxx.enter();
		return answer;
	}

	public static int instruction() {
		System.out.println("Quer ver as instruções de jogo ?\n(indique a letra escolhida)");
		System.out.println("A) Sim");
		System.out.println("B) Não");
		int answer = Input.answer(1);
		if (answer == 0) {
			System.out.println("A) Sim");
		} else if (answer == 1) {
			System.out.println("B) Não");
		}
		Oxx.enter();
		return answer;
	}

	public static void score(int[] score) {
		System.out.println("Pontuação :");
		System.out.printf("\nJogador X : %02d", score[0]);
		System.out.printf("\nJogador O : %02d", score[1]);
		System.out.printf("\nVelha : %02d", score[2]);
		System.out.println();
	}

}
