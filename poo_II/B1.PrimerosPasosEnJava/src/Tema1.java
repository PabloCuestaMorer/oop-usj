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
		System.out.printf("El número de Fibonacci para la posicion %d es %d.\n", fibonacciIndex, fibonacci(fibonacciIndex));

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

	public static boolean isPrime(int n) {
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
	public static int fibonacci(int n) {
		// limits negatives
	    if (n <= 1) {
	        return n;
	    }
	    return fibonacci(n - 1) + fibonacci(n - 2);
	}
}
