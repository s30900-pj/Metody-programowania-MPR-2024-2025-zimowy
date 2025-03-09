package pl.edu.pjwstk.s30900.s30900System;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.edu.pjwstk.s30900.s30900System.ticket.Ticket;
import pl.edu.pjwstk.s30900.s30900System.ticket.TicketService;

@SpringBootApplication
public class S30900SystemApplication {

	public S30900SystemApplication(TicketService ticketService) {
		Ticket selectedTicket = ticketService.findbyID(1);
		ticketService.printTicket(selectedTicket);
		ticketService.changeStatus(selectedTicket,3);
		ticketService.newTicket(69,"my computer doesn't work after cleaning hard drives(i've put them into dishwasher)",3);
		Ticket selectedTicket2 = ticketService.findbyID(4);
		ticketService.printTicket(selectedTicket2);
	}

	public static void main(String[] args) {
		SpringApplication.run(S30900SystemApplication.class, args);
	}

}
