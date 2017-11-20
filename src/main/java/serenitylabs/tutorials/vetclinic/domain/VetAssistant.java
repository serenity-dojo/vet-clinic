package serenitylabs.tutorials.vetclinic.domain;

public class VetAssistant {
    private ComplaintRegister complaintRegister;

    public VetAssistant(ComplaintRegister complaintRegister) {
        this.complaintRegister = complaintRegister;
    }

    public void recordComplaintrom(Animal pet) {
        complaintRegister.recordComplaint(pet.complains());
    }
}
