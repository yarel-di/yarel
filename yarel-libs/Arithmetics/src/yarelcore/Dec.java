package yarelcore;
import java.math.BigInteger;
public class Dec implements RPP {
	public static final RPP SINGLETON_Dec = new Dec();
	private final int __a__ = 1;
	public int getA() { return this.__a__; }
	public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
		__x__[__startIndex__] = __x__[__startIndex__].subtract(BigInteger.ONE);
	}
}
