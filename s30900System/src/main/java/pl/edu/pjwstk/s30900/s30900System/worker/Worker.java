package pl.edu.pjwstk.s30900.s30900System.worker;

public class Worker {
    int workerID;
    String workerName;
    String workerSurname;
    String workerPosition;

    public Worker(int workerID, String workerName, String workerSurname, String workerPosition) {
        this.workerID = workerID;
        this.workerName = workerName;
        this.workerSurname = workerSurname;
        this.workerPosition = workerPosition;
    }

    public int getWorkerID() {return workerID;}
    public String getWorkerName() {return workerName;}
    public String getWorkerSurname() {return workerSurname;}
    public String getWorkerPosition() {return workerPosition;}
}
