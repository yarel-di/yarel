package cantorPairing;

import tests.manual.CP_InvCU;
import yarelcore.InvDec;
import yarelcore.InvInc;
import yarelcore.RPP;

public class InvCu implements RPP {
	public InvCu() {
	}

	public Cu getInverse() {
		return new Cu();
	}

	private final RPP[] __steps__ = new RPP[] { new RPP() { // BodyPermImpl // index: 0
		private final int __a__ = 5;

		@Override
		public void b(int[] __x__, int __startIndex__, int __endIndex__) {
			int __tmp__ = 0;
			__tmp__ = __x__[__startIndex__ + 0];
			__x__[__startIndex__ + 0] = __x__[__startIndex__ + 1];
			__x__[__startIndex__ + 1] = __tmp__;
		}

		@Override
		public int getA() {
			return this.__a__;
		}
	},

			new RPP() { // BodyFunImpl // index: 1
				RPP __function__ = new boundedMin.InvMinH12();

				@Override
				public int getA() {
					return __function__.getA();
				}

				@Override
				public void b(int[] __x__, int __startIndex__, int __endIndex__) {
					this.__function__.b(__x__, __startIndex__, __endIndex__);
				}
			},

			new RPP() { // BodyPermImpl // index: 2
				private final int __a__ = 5;

				@Override
				public void b(int[] __x__, int __startIndex__, int __endIndex__) {
					int __tmp__ = 0;
					__tmp__ = __x__[__startIndex__ + 1];
					__x__[__startIndex__ + 1] = __x__[__startIndex__ + 4];
					__x__[__startIndex__ + 4] = __x__[__startIndex__ + 3];
					__x__[__startIndex__ + 3] = __x__[__startIndex__ + 2];
					__x__[__startIndex__ + 2] = __tmp__;
				}

				@Override
				public int getA() {
					return this.__a__;
				}
			},

			new RPP() { // BodyIfImpl // index: 3
				RPP __pos__ = new RPP() {
					@Override
					public int getA() {
						return 4;
					}

					@Override
					public void b(int[] __x__, int __startIndex__, int __endIndex__) {
						// There were only parallels identities, nothing interesting to show and run
					}
				};
				RPP __zero__ = new RPP() {
					private RPP __f__ = new RPP() {
						private RPP __f__ = InvInc.SINGLETON_InvInc;
						private final int __a__ = __f__.getA();

						@Override
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__f__.b(__x__, __startIndex__, __endIndex__);
						}

						@Override
						public int getA() {
							return this.__a__;
						}
					};

					@Override
					public int getA() {
						return 4;
					}

					@Override
					public void b(int[] __x__, int __startIndex__, int __endIndex__) {
						this.__f__.b(__x__, __startIndex__ + 0, __startIndex__ + (0) + this.__f__.getA());
					}
				};
				RPP __neg__ = new RPP() {
					@Override
					public int getA() {
						return 4;
					}

					@Override
					public void b(int[] __x__, int __startIndex__, int __endIndex__) {
						// There were only parallels identities, nothing interesting to show and run
					}
				};

				@Override
				public int getA() {
					return this.__pos__.getA() + 1;
				}

				@Override
				public void b(int[] __x__, int __startIndex__, int __endIndex__) {
					final int __testValue__ = __x__[(__startIndex__ + this.getA()) - 1];
					if (__testValue__ > 0) {
						__pos__.b(__x__, __startIndex__, __startIndex__ + __pos__.getA());
					} else if (__testValue__ == 0) {
						__zero__.b(__x__, __startIndex__, __startIndex__ + __zero__.getA());
					} else { // The "__testValue__<0" test is a tautology
						__neg__.b(__x__, __startIndex__, __startIndex__ + __neg__.getA());
					}
				}
			},

			new RPP() { // BodyPermImpl // index: 4
				private final int __a__ = 5;

				@Override
				public void b(int[] __x__, int __startIndex__, int __endIndex__) {
					int __tmp__ = 0;
					__tmp__ = __x__[__startIndex__ + 1];
					__x__[__startIndex__ + 1] = __x__[__startIndex__ + 2];
					__x__[__startIndex__ + 2] = __x__[__startIndex__ + 3];
					__x__[__startIndex__ + 3] = __x__[__startIndex__ + 4];
					__x__[__startIndex__ + 4] = __tmp__;
				}

				@Override
				public int getA() {
					return this.__a__;
				}
			},

			new RPP() { // ParCompImpl // index: 5
				private RPP __f__ = new RPP() {
					private RPP __f__ = InvDec.SINGLETON_InvDec;
					private final int __a__ = __f__.getA();

					@Override
					public void b(int[] __x__, int __startIndex__, int __endIndex__) {
						this.__f__.b(__x__, __startIndex__, __endIndex__);
					}

					@Override
					public int getA() {
						return this.__a__;
					}
				};

				@Override
				public int getA() {
					return 5;
				}

				@Override
				public void b(int[] __x__, int __startIndex__, int __endIndex__) {
					this.__f__.b(__x__, __startIndex__ + 0, __startIndex__ + (0) + this.__f__.getA());
				}
			},

			new RPP() { // ParCompImpl // index: 6
				private RPP __f__ = new RPP() {
					RPP __function__ = new funcH12.InvH12_v2();

					@Override
					public int getA() {
						return __function__.getA();
					}

					@Override
					public void b(int[] __x__, int __startIndex__, int __endIndex__) {
						this.__function__.b(__x__, __startIndex__, __endIndex__);
					}
				};

				@Override
				public int getA() {
					return 5;
				}

				@Override
				public void b(int[] __x__, int __startIndex__, int __endIndex__) {
					this.__f__.b(__x__, __startIndex__ + 0, __startIndex__ + (0) + this.__f__.getA());
				}
			},

			new RPP() { // ParCompImpl // index: 7
				private RPP __f__ = new RPP() {
					RPP __function__ = new arithNat.InvSubN();

					@Override
					public int getA() {
						return __function__.getA();
					}

					@Override
					public void b(int[] __x__, int __startIndex__, int __endIndex__) {
						this.__function__.b(__x__, __startIndex__, __endIndex__);
					}
				};

				@Override
				public int getA() {
					return 5;
				}

				@Override
				public void b(int[] __x__, int __startIndex__, int __endIndex__) {
					this.__f__.b(__x__, __startIndex__ + 0, __startIndex__ + (0) + this.__f__.getA());
				}
			},

			new RPP() { // BodyPermImpl // index: 8
				private final int __a__ = 5;

				@Override
				public void b(int[] __x__, int __startIndex__, int __endIndex__) {
					int __tmp__ = 0;
					__tmp__ = __x__[__startIndex__ + 0];
					__x__[__startIndex__ + 0] = __x__[__startIndex__ + 1];
					__x__[__startIndex__ + 1] = __tmp__;
				}

				@Override
				public int getA() {
					return this.__a__;
				}
			} };

	@Override
	public int getA() {
		return this.__steps__[0].getA();
	}

	@Override // CP // inv[CP]
	public void b(int[] __x__, int __startIndex__, int __endIndex__) { // Implements a serial composition.
//		int __i__;
//		__i__ = __steps__.length;
//		while( __i__-->0 ){
//			__steps__[__i__].b(__x__, __startIndex__, __endIndex__);
//		}
		__x__[__startIndex__] = CP_InvCU.cp(__x__[__startIndex__], __x__[__startIndex__ + 1]);
		__x__[__startIndex__ + 1] = 0;
	}

}