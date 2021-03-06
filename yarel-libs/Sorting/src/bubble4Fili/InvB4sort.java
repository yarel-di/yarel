package bubble4Fili;
import yarelcore.*;	

public class InvB4sort implements RPP {
	public InvB4sort() { }
	
	
	

	
	public B4sort getInverse(){
		return new B4sort();
	}
	
	private final RPP[] __steps__ = new RPP[]{
		new RPP() { // BodyFunImpl // index: 0
			RPP __function__ = new InvB4sort_p1();
			public int getA() { return __function__.getA(); }
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				this.__function__.b(__x__, __startIndex__, __endIndex__);
			}
		},
		
		new RPP() { // BodyFunImpl // index: 1
			RPP __function__ = new InvB4sort_p1();
			public int getA() { return __function__.getA(); }
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				this.__function__.b(__x__, __startIndex__, __endIndex__);
			}
		},
		
		new RPP() { // BodyFunImpl // index: 2
			RPP __function__ = new InvB4sort_p1();
			public int getA() { return __function__.getA(); }
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				this.__function__.b(__x__, __startIndex__, __endIndex__);
			}
		},
		
		new RPP() { // BodyFunImpl // index: 3
			RPP __function__ = new InvB4sort_p2();
			public int getA() { return __function__.getA(); }
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				this.__function__.b(__x__, __startIndex__, __endIndex__);
			}
		},
		
		new RPP() { // BodyFunImpl // index: 4
			RPP __function__ = new InvB4sort_p2();
			public int getA() { return __function__.getA(); }
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				this.__function__.b(__x__, __startIndex__, __endIndex__);
			}
		},
		
		new RPP() { // BodyFunImpl // index: 5
			RPP __function__ = new InvB4sort_p3();
			public int getA() { return __function__.getA(); }
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				this.__function__.b(__x__, __startIndex__, __endIndex__);
			}
		}
	};
	public int getA() { return this.__steps__[0].getA(); }
	public void b(int[] __x__, int __startIndex__, int __endIndex__) { // Implements a serial composition.
		int __i__;
		__i__ = __steps__.length;
		while( __i__-->0 ){
			__steps__[__i__].b(__x__, __startIndex__, __endIndex__);
		}
	}
}