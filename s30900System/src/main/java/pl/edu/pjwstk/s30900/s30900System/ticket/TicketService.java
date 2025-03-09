package pl.edu.pjwstk.s30900.s30900System.ticket;

import org.springframework.stereotype.Service;
import pl.edu.pjwstk.s30900.s30900System.status.Status;
import pl.edu.pjwstk.s30900.s30900System.status.StatusService;
import pl.edu.pjwstk.s30900.s30900System.worker.Worker;
import pl.edu.pjwstk.s30900.s30900System.worker.WorkerService;

@Service

public class TicketService {
    private final TicketStorage ticketStorage;
    private final WorkerService workerService;
    private final StatusService statusService;

    public TicketService(WorkerService workerService, TicketStorage ticketStorage, StatusService statusService) {
        this.ticketStorage = ticketStorage;
        this.workerService = workerService;
        this.statusService = statusService;
    }

    public Ticket findbyID(int ticketID) {
        Ticket selectedTicket = null;
        for (Ticket ticket : ticketStorage.getTickets()) {
            if (ticket.getTicketID() == ticketID) {
                selectedTicket = ticket;
            }
        }
        if (selectedTicket == null) {
            throw new RuntimeException("No ticket found with ID " + ticketID);
        }
        return selectedTicket;
    }

    //drukuje ticketID drukuje statusName workerID workerName workerSurname workerPosition
// ticketDescription
    public void printTicket(Ticket ticket) {
        Status status = statusService.findByStatusID(ticket.getStatusID());
        Worker worker = workerService.findByWorkerID(ticket.getWorkerID());
        System.out.println("Ticket ID: " + ticket.getTicketID() + " " +
                status.getStatusName() + " " + worker.getWorkerID() + " " +
                worker.getWorkerName() + " " + worker.getWorkerSurname() + " "
                + worker.getWorkerPosition());

        System.out.println(ticket.getDescription());
    }


    public void changeWorker(Ticket ticket, int newWorker) {
        printTicket(ticket);
        ticket.workerID = newWorker;
        printTicket(ticket);
    }

    public void changeStatus(Ticket ticket, int newStatus) {
        printTicket(ticket);
        ticket.statusID = newStatus;
        printTicket(ticket);
    }

    public void newTicket(int submittingPartyID, String description, int workerID) {
        int newTicketID = 1;
        for (Ticket ticket : ticketStorage.getTickets()) {
            newTicketID++;
        }

        ticketStorage.addTicket(new Ticket(newTicketID, 1, submittingPartyID, workerID, description));
        System.out.println("Wake up "+ workerService.findByWorkerID(workerID).getWorkerName()+"!!! A new ticket by the ID "+ newTicketID + "just arrived!");
    }
}