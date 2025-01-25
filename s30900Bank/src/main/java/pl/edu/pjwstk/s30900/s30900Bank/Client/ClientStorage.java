package pl.edu.pjwstk.s30900.s30900Bank.Client;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository

public class ClientStorage {
    List<Client> clients = new ArrayList<>();
    public void addClient(Client client) {
        clients.add(client);
    }
    public List<Client> getClients() {
        return clients;
    }
}
