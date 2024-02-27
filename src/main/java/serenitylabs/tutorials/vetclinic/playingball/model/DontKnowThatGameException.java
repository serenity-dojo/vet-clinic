package serenitylabs.tutorials.vetclinic.playingball.model;

public class DontKnowThatGameException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String strMessage;
	public DontKnowThatGameException(String strMsg) {
		this.strMessage=strMsg;
	}

}
