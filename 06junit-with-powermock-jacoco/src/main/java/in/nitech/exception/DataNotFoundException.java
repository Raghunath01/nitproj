package in.nitech.exception;

public class DataNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 2912270214759138658L;

	public DataNotFoundException() {
		super();
	}
	
	public DataNotFoundException(String message) {
		super(message);
	}
	
	
}
