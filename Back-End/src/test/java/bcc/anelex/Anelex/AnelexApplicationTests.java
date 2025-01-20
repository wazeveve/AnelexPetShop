package bcc.anelex.Anelex;

import bcc.anelex.Anelex.controller.ClienteController;
import bcc.anelex.Anelex.model.entities.Cliente;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AnelexApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	public void Test(){
		new ClienteController();
		Cliente cliente = new Cliente();
		cliente.setEmail();
		cliente.setName();
		cliente.setPets();
		cliente.setPassword();
		cliente.setUsername();
	}
}
