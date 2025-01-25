package pl.edu.pjwstk.s30900.s30900Bank.Transaction;

public class TransactionResponse {
    int statusID;
    double newBalance;
    public TransactionResponse(int statusID, double newBalance) {
        this.statusID = statusID;
        this.newBalance = newBalance;
    }
    public int getStatusID() {
        return statusID;
    }
    public double getNewBalance() {
        return newBalance;
    }
}
