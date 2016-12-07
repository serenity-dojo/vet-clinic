package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pravyada on 9/12/2016.
 */
public class ComplaintRegister {
    List<String> complaintList = new ArrayList<>();
    public void registerComplain(String complains) {
        complaintList.add(complains);
    }

    public List<String> getComplains(){
        return complaintList;
    }
}
