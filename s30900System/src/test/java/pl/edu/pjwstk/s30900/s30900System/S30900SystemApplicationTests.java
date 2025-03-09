package pl.edu.pjwstk.s30900.s30900System;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.edu.pjwstk.s30900.s30900System.ticket.Ticket;
import pl.edu.pjwstk.s30900.s30900System.ticket.TicketService;
import pl.edu.pjwstk.s30900.s30900System.ticket.TicketStorage;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
class S30900SystemApplicationTests {
	@Autowired
	private S30900SystemApplication application;
	@Autowired
	private TicketService ticketService;
	@Autowired
	private TicketStorage ticketStorage;

	@Test
	void shouldAddTicket(){

		List<Ticket> testTicketList = ticketStorage.getTickets();
		assertThat(testTicketList.size()).isEqualTo(4);
	}

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
//	@Test
//	void shouldPrintTicket(){
//		System.setOut(new PrintStream(outputStreamCaptor));
//		Ticket testTicket = ticketService.findbyID(1);
//		ticketService.printTicket(testTicket);
//		assertThat(outputStreamCaptor.toString().trim()).isEqualTo("Ticket ID: 1 Open 1 Bartuś Chełminiak QA Specialist  ");
//	}

	@Test
	void contextLoads() {

	}

}
