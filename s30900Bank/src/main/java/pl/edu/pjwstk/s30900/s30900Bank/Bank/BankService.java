package pl.edu.pjwstk.s30900.s30900Bank.Bank;

import org.springframework.stereotype.Service;
import pl.edu.pjwstk.s30900.s30900Bank.Client.Client;
import pl.edu.pjwstk.s30900.s30900Bank.Client.ClientService;
import pl.edu.pjwstk.s30900.s30900Bank.Status.StatusService;
import pl.edu.pjwstk.s30900.s30900Bank.Transaction.TransactionResponse;

@Service
public class BankService {
    private final ClientService clientService;
    private final StatusService statusService;
    public BankService(ClientService clientService, StatusService statusService) {
        this.clientService = clientService;
        this.statusService = statusService;
    }
    public Client registerClient(int clientID, double initialBalance) {
        Client newClient = new Client(clientID, initialBalance);
        clientService.addClient(newClient);
        return newClient;
    }
    public TransactionResponse transfer(int clientID, double amount) {
        try {
            Client client = clientService.findByClientID(clientID);
            if (client.getBalance() < amount) {
                return new TransactionResponse(4, client.getBalance());
            }
            client.setBalance(client.getBalance() - amount);
            return new TransactionResponse(1, client.getBalance());
        } catch (RuntimeException e) {
            return new TransactionResponse(3, 0);
        }
    }
    public TransactionResponse deposit(int clientID, double amount) {
        try {
            Client client = clientService.findByClientID(clientID);
            client.setBalance(client.getBalance() + amount);
            return new TransactionResponse(1, client.getBalance());
        } catch (RuntimeException e) {
            return new TransactionResponse(3, 0);
        }
    }
    public Client getClient(int clientID) {
        return clientService.findByClientID(clientID);
    }
}
