package pl.edu.pjwstk.s30900.s30900System.status;

public class Status {
    int statusID;
    String statusName;

    public Status(int statusID, String statusName) {
        this.statusID = statusID;
        this.statusName = statusName;
    }

    public int getStatusID() {
        return statusID;
    }

    public String getStatusName() {
        return statusName;
    }
}


