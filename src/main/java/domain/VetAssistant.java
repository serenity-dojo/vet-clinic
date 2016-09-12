package domain;

/**
 * Created by pravyada on 9/12/2016.
 */
public class VetAssistant {
    ComplaintRegister complaintRegister;
    public VetAssistant(ComplaintRegister complaintRegister) {
        this.complaintRegister = complaintRegister;
    }

    public void recordComplainFrom(Animal someAnimal) {
    complaintRegister.registerComplain(someAnimal.complains());
    }
}
