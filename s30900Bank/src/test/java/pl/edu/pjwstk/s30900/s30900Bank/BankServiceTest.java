package pl.edu.pjwstk.s30900.s30900Bank;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.edu.pjwstk.s30900.s30900Bank.Bank.BankService;
import pl.edu.pjwstk.s30900.s30900Bank.Client.Client;
import pl.edu.pjwstk.s30900.s30900Bank.Client.ClientService;
import pl.edu.pjwstk.s30900.s30900Bank.Status.StatusService;
import pl.edu.pjwstk.s30900.s30900Bank.Transaction.TransactionResponse;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BankServiceTest {
    @Mock
    ClientService clientService;
    @Mock
    StatusService statusService;
    @InjectMocks
    BankService bankService;
    @Test
    void shouldTransferAccepted() {
        when(clientService.findByClientID(1)).thenReturn(new Client(1, 1000));
        TransactionResponse response = bankService.transfer(1, 500);
        assertThat(response.getStatusID()).isEqualTo(1);
        assertThat(response.getNewBalance()).isEqualTo(500);
    }
    @Test
    void shouldTransferInsufficientFunds() {
        when(clientService.findByClientID(1)).thenReturn(new Client(1, 300));
        TransactionResponse response = bankService.transfer(1, 500);
        assertThat(response.getStatusID()).isEqualTo(4);
        assertThat(response.getNewBalance()).isEqualTo(300);
    }
    @Test
    void shouldTransferNotRegistered() {
        doThrow(new RuntimeException()).when(clientService).findByClientID(2);
        TransactionResponse response = bankService.transfer(2, 100);
        assertThat(response.getStatusID()).isEqualTo(3);
        assertThat(response.getNewBalance()).isEqualTo(0);
    }
    @Test
    void shouldDepositAccepted() {
        when(clientService.findByClientID(1)).thenReturn(new Client(1, 1000));
        TransactionResponse response = bankService.deposit(1, 200);
        assertThat(response.getStatusID()).isEqualTo(1);
        assertThat(response.getNewBalance()).isEqualTo(1200);
    }

}