package cantorPairing;

import yarelcore.RPP;

public class Cp implements RPP {
	public Cp() {
	}

	public InvCp getInverse() {
		return new InvCp();
	}

	private final RPP[] steps = new RPP[] { new RPP() { // BodyPermImpl
		private final int a = 3;

		@Override
		public void b(int[] x, int startIndex, int endIndex) {
			int tmp = 0;
			tmp = x[startIndex + 0];
			x[startIndex + 0] = x[startIndex + 1];
			x[startIndex + 1] = tmp;
		}

		@Override
		public int getA() {
			return this.a;
		}
	},

			new RPP() { // ParCompImpl
				private RPP f = new RPP() {
					RPP function = new arithNat.SumN();
					private final int a = function.getA();

					@Override
					public void b(int[] x, int startIndex, int endIndex) {
						this.function.b(x, startIndex, endIndex);
					}

					@Override
					public int getA() {
						return this.a;
					}
				};
				private final int a = 3;

				@Override
				public int getA() {
					return this.a;
				}

				@Override
				public void b(int[] x, int startIndex, int endIndex) {
					this.f.b(x, startIndex + 0, startIndex + this.a + 0);
				}
			},

			new RPP() { // BodyFunImpl
				RPP function = new funcH12.P3();
				private final int a = function.getA();

				@Override
				public void b(int[] x, int startIndex, int endIndex) {
					this.function.b(x, startIndex, endIndex);
				}

				@Override
				public int getA() {
					return this.a;
				}
			} };
	private final int a = steps[0].getA();

	@Override
	public int getA() {
		return this.a;
	}

	@Override
	public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
//		int i;
//		i = -1;
//		while( ++i < steps.length ){
//			steps[i].b(x, startIndex, endIndex);
//		}
		x[startIndex] = cp(x[startIndex], x[startIndex + 1]);
		x[startIndex + 1] = 0;
	}

	public static int cp(int x, int y) {
		int t = x + y;
		return x + ((t * (t + 1)) >> 1);
	}

}