package serenitylabs.tutorials.vetclinic.domain;

import java.util.ArrayList;
import java.util.List;

public class ComplaintRegister {

	List<String> complaints = new ArrayList<>();
	public void recordComplaint(String complaint) {
		// TODO Auto-generated method stub
		complaints.add(complaint);
		
	}

	public List<String> getComplaints() {
		// TODO Auto-generated method stub
		return this.complaints;
	}
	
	

}
