package userInterface;

import java.util.Scanner;
import auxiliar.*;

public class Input {

	public static String read() {
		Scanner in = new Scanner(System.in);
		String read = in.next();
		return read;
	}

	public static int answer(int tipe) {
		int answer = 0;
		try {
			answer = aux1(tipe);
		} catch (Exception error) {
			System.out.println(error);
			System.out.println("Responda novamente.");
			answer = answer(tipe);
		}
		return answer;
	}

	public static int aux1(int tipe) throws Exception {
		boolean error = false;
		int answer = 0;
		String aux = read();
		char read = 'x';

		if (aux.length() > 1 || aux.length() < 1) {
			error = true;
		} else {
			read = aux.charAt(0);
		}

		if (read == 'A' || read == 'a' || read == '1') {
			answer = 0;
		} else if (read == 'B' || read == 'b' || read == '2') {
			answer = 1;
		} else if (tipe == 2) {
			if (read == 'C' || read == 'c' || read == '3') {
				answer = 2;
			} else {
				error = true;
			}
		} else {
			error = true;
		}

		if (error) {
			throw new ErrorException("Entrada Invalida.");
		}
		return answer;
	}

	public static int[] playerMove(int who) throws Exception {
		int x = -1;
		int y = -1;

		if (who == 1) {
			System.out.print("Movimento do Jogador X: ");
		} else if (who == -1) {
			System.out.print("Movimento do Jogador O: ");
		}

		String move = read();
		int mx1 = move.charAt(0);
		int mx2 = move.charAt(1);
		boolean pos = false;

		if (mx1 >= 49 && mx1 <= 51) {
			pos = true;
		} else if (mx2 >= 49 && mx2 <= 51) {
			pos = false;
		} else {
			throw new ErrorException("Movimento Inválido. Esta linha não existe.");
		}

		if (pos) {
			char aux = move.charAt(1);
			x = aux2(aux);
			y = mx1 - 49;
		} else {
			char aux = move.charAt(0);
			x = aux2(aux);
			y = mx2 - 49;
		}

		int[] movement = { x, y };
		return movement;
	}

	public static int aux2(char x) throws Exception {
		int result = -1;

		if (x == 'a' || x == 'A' || x == '1') {
			result = 0;
		} else if (x == 'b' || x == 'B' || x == '2') {
			result = 1;
		} else if (x == 'c' || x == 'C' || x == '3') {
			result = 2;
		} else {
			throw new ErrorException("Movimento Inválido. Esta coluna não existe.");
		}

		return result;
	}

}
