package br.com.jhage.pedido;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.jhage.pedido_api.PedidoApplication;
import br.com.jhage.pedido_api.helper.Helper;
import br.com.jhage.pedido_api.modelo.ItemPedido;
import br.com.jhage.pedido_api.modelo.Pedido;

/**
 * 
 * @author Alexsander Melo
 * @since 11/02/2018
 *
 */


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=PedidoApplication.class, webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AtendimentoControllerTest {
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	private final Long LONG_ZERO = new Long(0);
	
	private final int RESPONSE_CODE = 200;
	
	@Before
	public void deveRegistrarPedido() {
		
		String url = "/atendimento";
		Pedido teste = new Pedido("9898989898", "apt 344 bl3", 3.0, 0.0);
		teste.addItemPedido(new ItemPedido("Teste", 2.8, 1).comPedido(teste));
		teste.addItemPedido(new ItemPedido("Teste", 2.8, 1).comPedido(teste));
		ResponseEntity<Pedido> response = testRestTemplate.postForEntity(url, teste, Pedido.class);
		assertTrue(response.getBody().getId() > LONG_ZERO);
		assertTrue(!Helper.ENULO.enulo(response));
	}
	
	@Test
	public void atendimentoDeveListarPedidos(){

		String url = "/atendimento/pedidosdodia";
		ResponseEntity<String> response = testRestTemplate.getForEntity(url,  String.class) ;
		assertTrue(response.getStatusCodeValue() == RESPONSE_CODE);
	}
	

}
