package pl.edu.pjwstk.s30900.s30900System.ticket;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.edu.pjwstk.s30900.s30900System.status.StatusService;
import pl.edu.pjwstk.s30900.s30900System.worker.WorkerService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TicketServiceTest {
    @Mock
    private StatusService statusService;
    @Mock
    private WorkerService workerService;
    @Mock
    private TicketStorage ticketStorage;

    @InjectMocks
    private TicketService ticketService;


    @Test
    void shouldFindTicket() {
        //given
        int testID = 1;
        when(ticketStorage.getTickets()).thenReturn(List.of(
                new Ticket(1, 1, 22, 1, "Gra crashuje, nie działa."),
                new Ticket(2, 3, 31, 2, "Jestem niewidziany w lobby"),
                new Ticket(3, 2, 69, 3, "Gamertag się nie wyświetla")));
        //when
        Ticket ticket = ticketService.findbyID(testID);
        //then
        assertThat(ticket.getTicketID()).isEqualTo(testID);
    }

    @Test
    void shouldWrongID() {
        int testID = 5;
        when(ticketStorage.getTickets()).thenReturn(List.of(
                new Ticket(1, 1, 22, 1, "Gra crashuje, nie działa."),
                new Ticket(2, 3, 31, 2, "Jestem niewidziany w lobby"),
                new Ticket(3, 2, 69, 3, "Gamertag się nie wyświetla")));

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> ticketService.findbyID(testID))
                .withMessage("No ticket found with ID " + testID);
    }

    @Test
    void shouldChangeWorker() {
        Ticket ticket = new Ticket(1, 1, 22, 1, "Gra crashuje, nie działa.");
        int testWorkerID = 1;
    }
}