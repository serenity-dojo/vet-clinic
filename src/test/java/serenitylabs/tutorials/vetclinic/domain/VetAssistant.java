package serenitylabs.tutorials.vetclinic.domain;

import java.util.ArrayList;

public class VetAssistant {
    private final ComplaintRegister complaintRegister;
    public VetAssistant(ComplaintRegister complaintRegister) {
        this.complaintRegister = complaintRegister;
    }
    public void recordComplainFrom(Animal someAnimal) {
        complaintRegister.recordComplaint(someAnimal.complaint());

    }
}
