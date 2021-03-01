package org.di.unito.yarel.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.di.unito.yarel.utils.ComposedArity;
import org.junit.Test;

public class TestComposedArity {

	@Test
	public void testZero() {
		ComposedArity ca;
		ca = new ComposedArity(0);
		assertEquals(ca.toString(), "0");
	}

	@Test
	public void testScalar() {
		ComposedArity ca;
		ca = new ComposedArity(7);
		assertEquals(ca.toString(), "7");
	}

	@Test
	public void testSingleParam() {
		ComposedArity ca;
		ca = new ComposedArity(0);
		ca.addParameterCoefficient("K");
		assertEquals(ca.toString(), "0 + (1*K)");
	}

	@Test
	public void testSingleParamNonOne() {
		ComposedArity ca;
		ca = new ComposedArity(0);
		ca.addParameterCoefficient("K", -3);
		assertEquals(ca.toString(), "0 + ((-3)*K)");
	}

	@Test
	public void testTwoParams() {
		ComposedArity ca;
		ca = new ComposedArity(-14);
		ca.addParameterCoefficient("K", -3);
		ca.addParameterCoefficient("J", 7);
		assertEquals(ca.toString(), "-14 + (7*J) + ((-3)*K)");
	}

	@Test
	public void testThreeParam() {
		ComposedArity ca;
		ca = new ComposedArity(-2);
		ca.addParameterCoefficient("I", 2);
		ca.addParameterCoefficient("J", 10);
		ca.addParameterCoefficient("K", -3);
		assertEquals(ca.toString(), "-2 + (2*I) + (10*J) + ((-3)*K)");
	}

	@Test
	public void testThreeParamFourthInvalid() {
		ComposedArity ca;
		ca = new ComposedArity(-2);
		ca.addParameterCoefficient("I", 2);
		ca.addParameterCoefficient("J", 10);
		ca.addParameterCoefficient("K", -3);
		ca.addParameterCoefficient("should also be an invalid name", 0);
		assertEquals(ca.toString(), "-2 + (2*I) + (10*J) + ((-3)*K)");
	}

	@Test
	public void testSubtract() {
		ComposedArity ca;
		ca = new ComposedArity(7);
		ca.addParameterCoefficient("I", 1);
		ca.addParameterCoefficient("J", 2);
		ca.addParameterCoefficient("K", -3);
		ca.subtract(//
				(new ComposedArity(3))//
						.addParameterCoefficient("eheh", 77)//
						.addParameterCoefficient("J", 2)//
						.addParameterCoefficient("K", -13)//
		);
		assertEquals(ca.toString(), "4 + (1*I) + (10*K) + ((-77)*eheh)");
	}

	@Test
	public void testSum() {
		ComposedArity ca;
		ca = new ComposedArity(-8);
		ca.addParameterCoefficient("Io", 6);
		ca.addParameterCoefficient("Jojo", 13);
		ca.addParameterCoefficient("Ken", 121);
		ca.sum(//
				(new ComposedArity(0))//
						.addParameterCoefficient("eheh", 77)//
						.addParameterCoefficient("Jojo", 7)//
						.addParameterCoefficient("Ken", -21)//
		);
		assertEquals(ca.toString(), "-8 + (6*Io) + (20*Jojo) + (100*Ken) + (77*eheh)");
	}

	@Test
	public void testSumWithItself() {
		ComposedArity ca;
		ca = new ComposedArity(7);
		ca.addParameterCoefficient("I", 1);
		ca.addParameterCoefficient("J", 2);
		ca.addParameterCoefficient("K", -3);
		ca.sum(ca);
		assertEquals(ca.toString(), "14 + (2*I) + (4*J) + ((-6)*K)");
	}

	@Test
	public void testSubtractWithItself() {
		ComposedArity ca;
		ca = new ComposedArity(7);
		ca.addParameterCoefficient("I", 1);
		ca.addParameterCoefficient("J", 2);
		ca.addParameterCoefficient("K", -3);
		ca.subtract(ca);
		assertEquals(ca.toString(), "0");
	}
}