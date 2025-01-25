package pl.edu.pjwstk.s30900.s30900Bank.Client;

public class Client {
    int clientID;
    double balance;
    public Client(int clientID, double balance) {
        this.clientID = clientID;
        this.balance = balance;
    }
    public int getClientID() {
        return clientID;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
