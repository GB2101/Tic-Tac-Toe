package main;

import auxiliar.Oxx;
import userInterface.*;
import gameMechanics.*;

public class Main {

	public static void main(String[] args) {
		Output.main(args);
		int twoPlayer = Output.twoPlayer();
		int[] score = new int[3];
		int game = 0;
		int first = 0;
		int level = 0;
		int again = 0;
		int round = 1;
		int choice = 1;
		if (twoPlayer == 0) {
			choice = Output.choice();
			first = Output.first1();
			level = Output.level();
		} else if (twoPlayer == 1) {
			first = Output.first2();
		}

		while (again == 0) {
			System.out.printf("Partida %02d", round);
			Oxx.enter();
			game = Game.game(twoPlayer, first, level, choice);
			if (game == 1) {
				score[0]++;
				first = choice;
				System.out.println("Jogador X ganhou a partida.");
			} else if (game == -1) {
				score[1]++;
				first = choice * (-1);
				System.out.println("Jogador O ganhou a partida.");
			} else {
				score[2]++;
				first = first * (-1);
				System.out.println("Deu Velha.");
			}
			Oxx.enter();
			round++;

			Output.score(score);

			Oxx.enter();
			again = Output.again();
			if (again == 0) {
				int config = Output.config();
				if (config == 1) {
					score = new int[3];
					round = 1;
					Output.score(score);
					Oxx.enter();
				} else if (config == 0) {
					twoPlayer = Output.twoPlayer();
					if (twoPlayer == 0) {
						choice = Output.choice();
						first = Output.first1();
						level = Output.level();
					} else if (twoPlayer == 1) {
						first = Output.first2();
					}
					int reset = Output.reset();
					if (reset == 0) {
						score = new int[3];
						round = 1;
						Output.score(score);
						Oxx.enter();
					}
				}
			}
		}

		int finalScore = 0;

		if (score[0] > score[1]) {
			finalScore = score[0];
			System.out.print("Jogador X ganhou, ");
		} else if (score[0] < score[1]) {
			finalScore = score[1];
			System.out.print("Jogador O ganhou, ");
		} else {
			finalScore = score[0];
			System.out.print("Os jogadores empataram ");
		}

		if (finalScore == 1) {
			System.out.printf("com %02d ponto.", finalScore);
		} else {
			System.out.printf("com %02d pontos.", finalScore);
		}
	}

}
