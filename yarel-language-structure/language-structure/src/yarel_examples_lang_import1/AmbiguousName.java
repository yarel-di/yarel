package yarel_examples_lang_import1;
import java.util.Arrays;
import java.lang.Math;
import yarelcore.*;	
public class AmbiguousName implements RPP {
    public AmbiguousName() { }
    private RPP f = new Id();
    private final int a = f.getA();
    public int[] b(int[] x) {
    	return this.f.b(x);
    }
    public int getA() { return this.a; }
}