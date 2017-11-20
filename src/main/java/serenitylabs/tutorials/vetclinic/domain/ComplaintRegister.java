package serenitylabs.tutorials.vetclinic.domain;

import java.util.ArrayList;
import java.util.List;

public class ComplaintRegister {

    private final List<String> complaints = new ArrayList<>();

    public List<String> getCompaints() {
        return new ArrayList(complaints);
    }

    public void recordComplaint(String complaint) {
        complaints.add(complaint);
    }
}
