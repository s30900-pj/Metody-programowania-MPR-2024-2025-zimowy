package pl.edu.pjwstk.s30900.s30900Bank.Client;

import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final ClientStorage clientStorage;
    public ClientService(ClientStorage clientStorage) {
        this.clientStorage = clientStorage;
    }
    public Client findByClientID(int clientID) {
        Client selectedClient = null;
        for (Client client : clientStorage.getClients()) {
            if (client.getClientID() == clientID) {
                selectedClient = client;
            }
        }
        if (selectedClient == null) {
            throw new RuntimeException("No client with ID " + clientID + " found");
        }
        return selectedClient;
    }
    public void addClient(Client client) {
        clientStorage.addClient(client);
    }
}
