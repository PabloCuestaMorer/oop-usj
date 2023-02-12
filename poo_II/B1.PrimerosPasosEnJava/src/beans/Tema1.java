package beans;

import java.util.Arrays;

/**
 * 
 */

/**
 * @author pablo
 *
 */
public class Tema1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ejercicio1();

		ejercicio2();

		System.out.println("Tema1. ejercicio3");
		int a = 120;
		int b = 50;
		int mcd = mcd(a, b);
		System.out.printf("El MCD de %d y %d es %d.\n", a, b, mcd);
		long num = 4;
		System.out.printf("El factorial de %d es %d.\n", num, factorial(num));
		int primeNum = 11;
		String isPrime = isPrime(primeNum) ? "es primo." : "no es primo.";
		System.out.printf("El numero %d %s\n", primeNum, isPrime);
		int fibonacciIndex = 6;
		System.out.printf("El número de Fibonacci para la posicion %d es %d.\n\n", fibonacciIndex,
				fibonacci(fibonacciIndex));

		ejercicio4();

		ejercicio5();

		int boardSize = 8;
		ejercicio6(boardSize);

		int altura = 4;
		int orientation = 360;
		ejercicio7(altura, orientation);
	}

	private static void ejercicio1() {
		System.out.println("Tema1.ejercicio1()");
		int n = 20;
		for (int i = 0; i < n; i++) {
			System.out.println(i + 1);
		}
		System.out.println();
	}

	private static void ejercicio2() {
		System.out.println("Tema1.ejercicio2()");
		int n = 20;
		for (int i = 1; i < n + 1; i++) {
			System.out.print(i + ":\t");
			if (i % 2 == 0) {
				System.out.print(" PAR");
			}
			if (i % 3 == 0) {
				System.out.print(" TRIO");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static int mcd(int a, int b) {
		if (b == 0)
			return a;
		return mcd(b, a % b);
	}

	private static long factorial(long num) {
		if (num <= 1)
			return 1;
		return num * factorial(num - 1);
	}

	private static boolean isPrime(int n) {
		// limits negatives
		if (n <= 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	private static int fibonacci(int n) {
		// limits negatives
		if (n <= 1) {
			return n;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	private static void ejercicio4() {
		System.out.println("Tema1.ejercicio4()");
		System.out.println("Salto de línea: System.out.println(...) or \"\\n\"");
		System.out.println("Salto de línea: \n -\n -\n fin salto de línea");
		System.out.println("Escape characters en java con \"\\\" ej: \"\"\"\"\"");
		System.out.println("Imprimir la secuencia que permite imprimir saltos de línea: \\n");
		System.out.println();
	}

	private static void ejercicio5() {
		System.out.println("Tema1.ejercicio5()");
		System.out.println();
		System.out.println("*******************");
		System.out.println("****ASCII TABLE****");
		System.out.println("*******************");
		System.out.println("Value \t HEX \t Symbol");
		for (int i = 0; i < 256; i++) {
			char asciiSymbol = (char) i;
			String hex = Integer.toHexString(i);
			System.out.println(i + " \t " + hex + " \t " + asciiSymbol);
		}
		System.out.println();
	}

	private static void ejercicio6(int n) {
		System.out.println("Tema1.ejercicio6()");
		char[][] board = new char[n][n];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if ((j % 2 == 0 && i % 2 == 0) || (j % 2 != 0 && i % 2 != 0)) {
					board[i][j] = 'X';
				} else {
					board[i][j] = 'O';
				}
				System.out.print(board[i][j] + " ");
			}
			System.out.println(" ");
		}
		System.out.println();
	}

	private static void ejercicio7(int rows, int orientation) {
		System.out.println("Tema1.ejercicio5():");
		System.out.println("Imprimir pirámide altura " + rows + " rotación " + orientation + "º:");
		switch (orientation) {
		case 90:
			for (int i = 1; i <= rows; i++) {
				for (int j = 1; j <= rows - i; j++) {
					System.out.print("-");
				}
				for (int j = 1; j <= 2 * i - 1; j++) {
					System.out.print("*");
				}
				for (int j = 1; j <= rows - i; j++) {
					System.out.print("-");
				}
				System.out.println();
			}
			break;
		case 270:
			for (int i = 1; i <= rows; i++) {
				for (int j = 1; j <= i - 1; j++) {
					System.out.print("-");
				}
				for (int j = 1; j <= 2 * (rows - i) + 1; j++) {
					System.out.print("*");
				}
				for (int j = 1; j <= i - 1; j++) {
					System.out.print("-");
				}
				System.out.println();
			}
			break;
		case 180:
			for (int i = 1; i <= rows; i++) {
				for (int j = 1; j <= i; j++) {
					System.out.print("* ");
				}
				for (int j = 1; j <= rows - i; j++) {
					System.out.print("' ");
				}
				System.out.println();
			}

			for (int i = rows - 1; i >= 1; i--) {
				for (int j = 1; j <= i; j++) {
					System.out.print("* ");
				}
				for (int j = 1; j <= rows - i; j++) {
					System.out.print("' ");
				}
				System.out.println();
			}
			break;
		case 360:
			for (int i = 1; i <= rows; i++) {
				for (int j = 1; j <= rows - i; j++) {
					System.out.print("' ");
				}
				for (int j = 1; j <= i; j++) {
					System.out.print("* ");
				}
				System.out.println();
			}

			for (int i = rows - 1; i >= 1; i--) {
				for (int j = 1; j <= rows - i; j++) {
					System.out.print("' ");
				}
				for (int j = 1; j <= i; j++) {
					System.out.print("* ");
				}
				System.out.println();
			}
			break;
		default:
			System.out.println("Invalid rotation angle. Please choose a rotation angle of 0, 90, 180, or 270 degrees.");
			break;
		}
		System.out.println();
	}

}
