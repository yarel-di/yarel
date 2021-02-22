package cantorPairing;

import yarelcore.InvDec;
import yarelcore.InvInc;
import yarelcore.RPP;

public class InvCu implements RPP {
	public InvCu() {
	}

	public Cu getInverse() {
		return new Cu();
	}

	RPP l = new RPP() { // SerCompImpl
		RPP l = new RPP() { // SerCompImpl
			RPP l = new RPP() { // SerCompImpl
				RPP l = new RPP() { // SerCompImpl
					RPP l = new RPP() { // SerCompImpl
						RPP l = new RPP() { // SerCompImpl
							RPP l = new RPP() { // SerCompImpl
								RPP l = new RPP() { // BodyPermImpl
									private final int a = 5;

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
								};
								RPP r = new RPP() { // BodyFunImpl
									RPP function = new boundedMin.InvMinH12();
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
								private final int a = l.getA();

								@Override
								public int getA() {
									return this.a;
								}

								@Override
								public void b(int[] x, int startIndex, int endIndex) { // Implements a serial
																						// composition.
									this.r.b(x, startIndex, endIndex);
									this.l.b(x, startIndex, endIndex);
								}
							};
							RPP r = new RPP() { // BodyPermImpl
								private final int a = 5;

								@Override
								public void b(int[] x, int startIndex, int endIndex) {
									int tmp = 0;
									tmp = x[startIndex + 1];
									x[startIndex + 1] = x[startIndex + 4];
									x[startIndex + 4] = x[startIndex + 3];
									x[startIndex + 3] = x[startIndex + 2];
									x[startIndex + 2] = tmp;
								}

								@Override
								public int getA() {
									return this.a;
								}
							};
							private final int a = l.getA();

							@Override
							public int getA() {
								return this.a;
							}

							@Override
							public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
								this.r.b(x, startIndex, endIndex);
								this.l.b(x, startIndex, endIndex);
							}
						};
						RPP r = new RPP() { // BodyIfImpl
							RPP pos = new RPP() {
								private final int a = 4;

								@Override
								public int getA() {
									return this.a;
								}

								@Override
								public void b(int[] x, int startIndex, int endIndex) {
									// There were only parallels identities, nothing interesting to show and run
								}
							};
							RPP zero = new RPP() {
								private RPP f = new RPP() {
									private RPP f = new InvInc();
									private final int a = f.getA();

									@Override
									public void b(int[] x, int startIndex, int endIndex) {
										this.f.b(x, startIndex, endIndex);
									}

									@Override
									public int getA() {
										return this.a;
									}
								};
								private final int a = 4;

								@Override
								public int getA() {
									return this.a;
								}

								@Override
								public void b(int[] x, int startIndex, int endIndex) {
									this.f.b(x, startIndex + 0, startIndex + this.a + 0);
								}
							};
							RPP neg = new RPP() {
								private final int a = 4;

								@Override
								public int getA() {
									return this.a;
								}

								@Override
								public void b(int[] x, int startIndex, int endIndex) {
									// There were only parallels identities, nothing interesting to show and run
								}
							};
							private final int a = pos.getA() + 1;

							@Override
							public int getA() {
								return this.a;
							}

							@Override
							public void b(int[] x, int startIndex, int endIndex) {
								final int testValue = x[(startIndex + a) - 1];
								if (testValue > 0) {
									pos.b(x, startIndex, startIndex + pos.getA());
								} else if (testValue == 0) {
									zero.b(x, startIndex, startIndex + zero.getA());
								} else { // The "testValue<0" test is a tautology
									neg.b(x, startIndex, startIndex + neg.getA());
								}
							}
						};
						private final int a = l.getA();

						@Override
						public int getA() {
							return this.a;
						}

						@Override
						public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
							this.r.b(x, startIndex, endIndex);
							this.l.b(x, startIndex, endIndex);
						}
					};
					RPP r = new RPP() { // BodyPermImpl
						private final int a = 5;

						@Override
						public void b(int[] x, int startIndex, int endIndex) {
							int tmp = 0;
							tmp = x[startIndex + 1];
							x[startIndex + 1] = x[startIndex + 2];
							x[startIndex + 2] = x[startIndex + 3];
							x[startIndex + 3] = x[startIndex + 4];
							x[startIndex + 4] = tmp;
						}

						@Override
						public int getA() {
							return this.a;
						}
					};
					private final int a = l.getA();

					@Override
					public int getA() {
						return this.a;
					}

					@Override
					public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
						this.r.b(x, startIndex, endIndex);
						this.l.b(x, startIndex, endIndex);
					}
				};
				RPP r = new RPP() { // ParCompImpl
					private RPP f = new RPP() {
						private RPP f = new InvDec();
						private final int a = f.getA();

						@Override
						public void b(int[] x, int startIndex, int endIndex) {
							this.f.b(x, startIndex, endIndex);
						}

						@Override
						public int getA() {
							return this.a;
						}
					};
					private final int a = 5;

					@Override
					public int getA() {
						return this.a;
					}

					@Override
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x, startIndex + 0, startIndex + this.a + 0);
					}
				};
				private final int a = l.getA();

				@Override
				public int getA() {
					return this.a;
				}

				@Override
				public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
					this.r.b(x, startIndex, endIndex);
					this.l.b(x, startIndex, endIndex);
				}
			};
			RPP r = new RPP() { // ParCompImpl
				private RPP f = new RPP() {
					RPP function = new funcH12.InvH12_v2();
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
				private final int a = 5;

				@Override
				public int getA() {
					return this.a;
				}

				@Override
				public void b(int[] x, int startIndex, int endIndex) {
					this.f.b(x, startIndex + 0, startIndex + this.a + 0);
				}
			};
			private final int a = l.getA();

			@Override
			public int getA() {
				return this.a;
			}

			@Override
			public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
				this.r.b(x, startIndex, endIndex);
				this.l.b(x, startIndex, endIndex);
			}
		};
		RPP r = new RPP() { // ParCompImpl
			private RPP f = new RPP() {
				RPP function = new arithNat.InvSubN();
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
			private final int a = 5;

			@Override
			public int getA() {
				return this.a;
			}

			@Override
			public void b(int[] x, int startIndex, int endIndex) {
				this.f.b(x, startIndex + 0, startIndex + this.a + 0);
			}
		};
		private final int a = l.getA();

		@Override
		public int getA() {
			return this.a;
		}

		@Override
		public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
			this.r.b(x, startIndex, endIndex);
			this.l.b(x, startIndex, endIndex);
		}
	};
	RPP r = new RPP() { // BodyPermImpl
		private final int a = 5;

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
	};
	private final int a = l.getA();

	@Override
	public int getA() {
		return this.a;
	}
//	public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
//		this.r.b(x, startIndex, endIndex);
//		this.l.b(x, startIndex, endIndex);
//	}

	@Override
	public void b(int[] x, int startIndex, int endIndex) {
		x[startIndex] = cp(x[startIndex], x[startIndex + 1]);
		x[startIndex + 1] = 0;
	}

	public static int cp(int x, int y) {
		int t = x + y;
		return x + ((t * (t + 1)) >> 1);
	}
}