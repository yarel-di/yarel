package tests.manual;

import java.math.BigInteger;
import java.util.Arrays;

import fibonacci.Fibonacci;
import yarelcore.RPP;

public class TestFibonacci {
	static final int MAX_FIBONACCI_INDEX = 40;

	static int fib(int n) {
		int a = 0, b = 1, t;
		while (n-- > 0) {
			a += b;
			t = a;
			a = b;
			b = t;
		}
		return a;
	}

	public static void main(String[] args) {
		int fibReal;
		BigInteger[] registers = new BigInteger[4];
		Fibonacci fibYarel = new Fibonacci();
		RPP fibYarelInv = fibYarel.getInverse();
		registers[1] = registers[2] = registers[3] = BigInteger.ZERO;
		for (int i = 0; i <= MAX_FIBONACCI_INDEX; i++) {
			registers[0] = BigInteger.valueOf(i);
			fibYarel.b(registers);
			fibReal = fib(i);
			System.out.println();
			System.out.println(i + " -> " + fibReal + ", computed: " + Arrays.toString(registers) + " equal? : "
					+ (fibReal == registers[1].intValue()));
			fibYarelInv.b(registers);
			System.out.println("\t inverted " + Arrays.toString(registers));
		}
	}
}