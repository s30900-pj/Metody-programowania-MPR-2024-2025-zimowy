package pl.edu.pjwstk.s30900.s30900System.ticket;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class TicketStorage {
List<Ticket> tickets = new ArrayList<Ticket>();

public TicketStorage(List<Ticket> tickets) {
    this.tickets = tickets;
    tickets.add(new Ticket(1, 1, 22, 1, "Gra crashuje, nie działa."));
    tickets.add(new Ticket(2, 3, 31, 2, "Jestem niewidziany w lobby"));
    tickets.add(new Ticket(3, 2, 69, 3, "Gamertag się nie wyświetla"));
}
public void addTicket(Ticket ticket) {tickets.add(ticket);}
    public List<Ticket> getTickets() {
        return tickets;
    }
}
