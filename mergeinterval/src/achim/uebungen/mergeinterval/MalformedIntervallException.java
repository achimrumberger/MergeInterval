package achim.uebungen.mergeinterval;

@SuppressWarnings("serial")
public class MalformedIntervallException extends Exception {
	
	public MalformedIntervallException(String message) {
		
		super(message);
		System.out.println(message);
	}

}
