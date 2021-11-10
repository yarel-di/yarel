package yarelcore;
import java.math.BigInteger;
public class InvDec implements RPP {
	public static final RPP SINGLETON_InvDec = new InvDec();
	private RPP __f__ = Inc.SINGLETON_Inc;
	private final int __a__ = this.__f__.getA();
	public int getA() { return this.__a__; }
	public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
		this.__f__.b(__x__, __startIndex__, __endIndex__);
	}
}
