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
	@Mock
	ClienteRepository clienteRepository;

	@InjectMocks
	ClienteController clienteController;

	@Test
	void testeSoma(){
		Cliente cliente = new Cliente();
		cliente.setName("Cliente");
		cliente.setUsername("Cliente");
		cliente.setPassword("cliente123");
		cliente.setRole(Role.USER);
		cliente.setEmail("cliente@gmail");

		var clientes = clienteController.pegarClientes();

		int cont = 0;
		assertEquals(cont, 0);
	}
}
