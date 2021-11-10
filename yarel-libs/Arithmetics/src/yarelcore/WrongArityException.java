package yarelcore;
public class WrongArityException extends RuntimeException {
	private static final long serialVersionUID = -791345668149092L;
	public WrongArityException(){
	  super();
	}
	public WrongArityException(String message){
	  super(message);
	}
}
