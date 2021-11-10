package yarelcore;
public class WrongArityException extends RuntimeException {
	public WrongArityException(){
	  super();
	}
	public WrongArityException(String message){
	  super(message);
	}
}
