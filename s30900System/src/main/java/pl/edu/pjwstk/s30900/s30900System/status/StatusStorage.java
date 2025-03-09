package pl.edu.pjwstk.s30900.s30900System.status;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StatusStorage {
    List<Status> statusList = new ArrayList<Status>();

    public StatusStorage(List<Status> statusList) {
        this.statusList = statusList;
        statusList.add(new Status(1, "Open"));
        statusList.add(new Status(2, "In Progress"));
        statusList.add(new Status(3, "Closed"));
    }

    public List<Status> getStatusList() {
        return statusList;
    }
}
