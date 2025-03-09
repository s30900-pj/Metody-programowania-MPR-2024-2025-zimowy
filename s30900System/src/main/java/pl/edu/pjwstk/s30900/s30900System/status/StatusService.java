package pl.edu.pjwstk.s30900.s30900System.status;

import org.springframework.stereotype.Service;

@Service
public class StatusService {
    private final StatusStorage statusStorage;

    public StatusService(StatusStorage statusStorage) {
        this.statusStorage = statusStorage;
    }

    public Status findByStatusID(int statusID) {
        Status selectedStatus = null;
        for (Status status : statusStorage.getStatusList()) {
            if (status.getStatusID() == statusID) {
                selectedStatus = status;
            }
        }
        if (selectedStatus == null) {
            throw new RuntimeException("No status with ID " + statusID + " found");
        }
        return selectedStatus;
    }
}
