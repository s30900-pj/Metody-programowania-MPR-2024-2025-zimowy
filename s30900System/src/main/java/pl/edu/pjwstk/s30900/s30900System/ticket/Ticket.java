package pl.edu.pjwstk.s30900.s30900System.ticket;

public class Ticket {
    int ticketID;
    int statusID;
    int submittingPartyID;
    int workerID;
    String description;

    public Ticket(int ticketID, int statusID, int submittingPartyID, int workerID, String description) {
        this.ticketID = ticketID;
        this.statusID = statusID;
        this.submittingPartyID = submittingPartyID;
        this.workerID = workerID;
        this.description = description;
    }

    public int getTicketID() {
        return ticketID;
    }

    public int getStatusID() {
        return statusID;
    }

    public int getSubmittingPartyID() {
        return submittingPartyID;
    }

    public int getWorkerID() {
        return workerID;
    }

    public String getDescription() {
        return description;
    }
}
