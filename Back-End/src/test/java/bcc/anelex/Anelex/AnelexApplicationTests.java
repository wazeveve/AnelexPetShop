package bcc.anelex.Anelex;

import bcc.anelex.Anelex.controller.ClienteController;
import bcc.anelex.Anelex.model.entities.Cliente;
import bcc.anelex.Anelex.model.entities.role.Role;
import bcc.anelex.Anelex.model.repositories.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AnelexApplicationTests {

	@Test
	void testGetAndSet() {
		Cliente cliente = new Cliente();
		cliente.setUsername("Username de teste!");
		cliente.setPassword("Senha de teste!");
		cliente.setName("Nome de teste");

		assertEquals(cliente.getUsername(), "Username de teste!");
		assertEquals(cliente.getPassword(), "Senha de teste!");
		assertEquals(cliente.getName(), "Nome de teste");
	}
}
