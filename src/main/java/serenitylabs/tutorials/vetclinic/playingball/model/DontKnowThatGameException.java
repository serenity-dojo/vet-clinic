package serenitylabs.tutorials.vetclinic.playingball.model;

public class DontKnowThatGameException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DontKnowThatGameException(String strMsg) {
		super(strMsg);
	}

}