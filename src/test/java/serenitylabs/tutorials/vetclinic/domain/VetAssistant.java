package serenitylabs.tutorials.vetclinic.domain;

public class VetAssistant {

	private final ComplaintRegister complaintregister;

	public VetAssistant(ComplaintRegister complaintregister) {
		// TODO Auto-generated constructor stub
		this.complaintregister=complaintregister;
	}

	public void recordComlainFrom(Animal someAnimal) {
		// TODO Auto-generated method stub
		complaintregister.recordComplaint(someAnimal.complaint());
		
	}

}
