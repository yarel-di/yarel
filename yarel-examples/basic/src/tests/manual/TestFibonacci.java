package tests.manual;

import java.util.Arrays;

import fibonacci.Fibonacci;
import yarelcore.RPP;

public class TestFibonacci {
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
		int[] registers = new int[4];
		Fibonacci fibYarel = new Fibonacci();
		RPP fibYarelInv = fibYarel.getInverse();
		registers[1] = registers[2] = registers[3] = 0;
		for (int i = 0; i <= 40; i++) {
			registers[0] = i;
			fibYarel.b(registers);
			System.out.println();
			System.out.println(i + " -> " + fib(i) + ", computed: " + Arrays.toString(registers));
			fibYarelInv.b(registers);
			System.out.println("\t inverted " + Arrays.toString(registers));
		}
	}
}