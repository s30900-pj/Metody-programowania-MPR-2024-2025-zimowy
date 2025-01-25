package pl.edu.pjwstk.s30900.s30900Bank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.edu.pjwstk.s30900.s30900Bank.Bank.BankService;
import pl.edu.pjwstk.s30900.s30900Bank.Client.Client;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class S30900BankApplicationTests {
	@Autowired
	BankService bankService;
	@Test
	void shouldRegisterClient() {
		Client c = bankService.registerClient(100, 500);
		assertThat(c.getClientID()).isEqualTo(100);
		assertThat(c.getBalance()).isEqualTo(500);
	}
	@Test
	void shouldTransferMoney() {
		bankService.registerClient(101, 500);
		bankService.transfer(101, 300);
		assertThat(bankService.getClient(101).getBalance()).isEqualTo(200);
	}
	@Test
	void shouldDepositMoney() {
		bankService.registerClient(102, 100);
		bankService.deposit(102, 400);
		assertThat(bankService.getClient(102).getBalance()).isEqualTo(500);
	}
	@Test
	void contextLoads() {
	}

}
