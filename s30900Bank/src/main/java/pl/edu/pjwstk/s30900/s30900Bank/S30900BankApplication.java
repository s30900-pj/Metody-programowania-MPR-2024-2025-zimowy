package pl.edu.pjwstk.s30900.s30900Bank;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.edu.pjwstk.s30900.s30900Bank.Bank.BankService;
import pl.edu.pjwstk.s30900.s30900Bank.Client.Client;
import pl.edu.pjwstk.s30900.s30900Bank.Transaction.TransactionResponse;

@SpringBootApplication
public class S30900BankApplication {
	private final BankService bankService;
	public S30900BankApplication(BankService bankService) {
		this.bankService = bankService;
	}
	@PostConstruct
	public void init() {
		bankService.registerClient(1, 3000);
		TransactionResponse transfer1 = bankService.transfer(1, 500);
		System.out.println("Transfer klienta 1 na 500, status: " + transfer1.getStatusID() + ", nowe saldo: " + transfer1.getNewBalance());
		TransactionResponse deposit1 = bankService.deposit(1, 300);
		System.out.println("Wpłata klienta 1 na 300, status: " + deposit1.getStatusID() + ", nowe saldo: " + deposit1.getNewBalance());
		TransactionResponse transfer2 = bankService.transfer(2, 100);
		System.out.println("Transfer klienta 2 na 100, status: " + transfer2.getStatusID() + ", nowe saldo: " + transfer2.getNewBalance());
		Client c1 = bankService.getClient(1);
		System.out.println("Dane klienta 1: ID=" + c1.getClientID() + ", saldo=" + c1.getBalance());
		bankService.registerClient(3, 2000);
		TransactionResponse transfer3 = bankService.transfer(3, 2500);
		System.out.println("Transfer klienta 3 na 2500, status: " + transfer3.getStatusID() + ", nowe saldo: " + transfer3.getNewBalance());
		Client c3 = bankService.getClient(3);
		System.out.println("Dane klienta 3: ID=" + c3.getClientID() + ", saldo=" + c3.getBalance());
	}

	public static void main(String[] args) {
		SpringApplication.run(S30900BankApplication.class, args);
	}

}
