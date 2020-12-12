package yarel_examples_lang_import2;
import java.util.Arrays;
import java.lang.Math;
import yarelcore.*;	
public class InvAmbiguousName implements RPP {
    public InvAmbiguousName() { }
    private RPP f = new InvNeg();
    private final int a = f.getA();
    public int[] b(int[] x) {
    	return this.f.b(x);
    }
    public int getA() { return this.a; }
}