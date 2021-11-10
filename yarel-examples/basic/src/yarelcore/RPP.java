package yarelcore;

import java.math.BigInteger;
/** Definition of an operator in RPP context. */
public interface RPP {
	/**
	 * "Arity".
	 * <p>
	 * Returns the arity of this operator.<br>
	 * For instance, <i>increment</i> has <code>1</code> as arity.
	 */
	public int getA();
	
	/**
	 * "Behaves".
	 * <p>
	 * Implements the behavior of this statements, i.e. what it should do (for
	 * instance, an increment increments some values), applied to some of the given
	 * registers (which is the parameter).<br>
	 * Invokes {@link #b(BigInteger[], int, int)} passing <code>0</code> and
	 * <code>{@link #getA()}</code> as parameters.
	 * Notice that not all registers are forced to be considered.
	 * 
	 * @param x the vector of "registers", in particular their values.
	 */
	public default void b(BigInteger[] x) { this.b(x, 0, this.getA()); }
	
	/**
	 * As like as {@link #b(BigInteger[])}, but operating over a restricted subset of
	 * contiguous registers.<br>
	 * ALL of the indexes <b>MUST</b> be considered as <i>inclusive</i> and bounded
	 * to <code>0</code> and <code>x.length - 1</code>.
	 * 
	 * @param x			the vector of "registers", in particular their values.
	 * @param startIndex the minimum register's index considered by this operator,
	 *				   i.e. the first register affected by this call, which is inclusive.
	 *				   The {@link #b(BigInteger[])} implementation assign <code>0</code> to it.
	 *				   It's the most important index.
	 * @param endIndex   the maximum register's index considered by this operator, 
	 *				   i.e. the last register affected by this call, which is exclusive.
	 *				   The {@link #b(BigInteger[])} implementation assign <code>{@link #getA()}</code> to it.
	 *				   Usually this index is ignored.
	 */
	public void b(BigInteger[] x, int startIndex, int endIndex);
}
