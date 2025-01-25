package pl.edu.pjwstk.s30900.s30900Bank.Status;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StatusStorage {
    List<Status> statusList = new ArrayList<>();
    public StatusStorage() {
        statusList.add(new Status(1, "ACCEPTED"));
        statusList.add(new Status(2, "DECLINED"));
        statusList.add(new Status(3, "NOT_REGISTERED"));
        statusList.add(new Status(4, "INSUFFICIENT_FUNDS"));
    }
    public List<Status> getStatusList() {
        return statusList;
    }
}
