package tests.manual;

import java.util.Arrays;
import java.util.Random;

import bitStack.Bitpush;

public class TestBitPush {

	public static void main(String[] args) {
		int i, b, m;
		int[] r, e;
		Random rand;
		Bitpush bp;
		r = new int[5];
		e = new int[5];
		rand = new Random();
		bp = new Bitpush();
		m = 28;
		i = -1;
		while (++i < m) {
			b = rand.nextBoolean() ? 1 : 0;
			System.out.print("i: " + i + " , b: " + b + " ---> ");
			r[1] = b;
			bp.b(r);
			e[0] = b + (e[0] << 1);
			System.out.print(Arrays.equals(r, e) ? "ok" : " NOt equal!!!");
			System.out.print(".. regiters: r:" + Arrays.toString(r) + " - e:" + Arrays.toString(e));
			System.out.println();
			System.out.println();
		}
	}
}