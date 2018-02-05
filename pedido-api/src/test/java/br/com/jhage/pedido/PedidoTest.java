package br.com.jhage.pedido;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.jhage.pedido_api.modelo.ItemPedido;
import br.com.jhage.pedido_api.modelo.Pedido;
import br.com.jhage.pedido_api.modelo.Produto;

public class PedidoTest {

	private static final Double VALOR_DEFAUL = 5.6;
	
	@Mock
	private ItemPedido itemmok;
	
	@Mock
	private Pedido pedidomok;
	
	@Before
	public void before(){
		
		MockitoAnnotations.initMocks(this);
		pedidomok.getItens().add(itemmok);
	}
	
//	@Test
//	public void TotalPedidoDeveSerZero(){
//		
//		Double zero = 0.;
//		Assert.assertTrue(Double.compare(zero, buildPedidoZero().total()) ==0);
//	}
//	
//	@Test
//	public void naoDevehaverNullnosCampos(){
//		
//		Pedido ped = new Pedido(null, null, null, null);
//		Assert.assertNotNull(ped.getCadastro());
//		Assert.assertNotNull(ped.getTelefone());
//		Assert.assertNotNull(ped.getMovimento());
//		Assert.assertNotNull(ped.getItens());
//		Assert.assertNotNull(ped.getId());
//		Assert.assertNotNull(ped.getCliente());
//		Assert.assertNotNull(ped.getStatus());
//		Assert.assertNotNull(ped.getTroco());
//		Assert.assertNotNull(ped.getEntrega());
//	}
//	
//	@Test
//	public void totalPedidoDeverSerIgualAoValorDefaulPedidoModelo1(){
//		
//		Pedido pedidoModelo1 = new Pedido(909, "", "", null);
//		pedidoModelo1.getItens().add(new ItemPedido(2).comProduto(new Produto("Teste", 1.4)));
//		pedidoModelo1.getItens().add(new ItemPedido(null).comProduto(new Produto("Teste", 2.8)));
//		Assert.assertEquals(VALOR_DEFAUL, pedidoModelo1.total());
//	}
//	
//	@Test
//	public void totalPedidoDeverSerIgualAoValorDefaulPedidoModelo2(){
//		
//		Pedido pedidoModelo2 = new Pedido(909, "", "", null);
//		pedidoModelo2.getItens().add(new ItemPedido(1).comProduto(new Produto("Teste", 2.8)));
//		pedidoModelo2.getItens().add(null);
//		pedidoModelo2.getItens().add(new ItemPedido(1).comProduto(new Produto("Teste", 2.8)));
//		Assert.assertEquals(VALOR_DEFAUL, pedidoModelo2.total());
//	}
//	
//	@Test
//	public void testarMokito(){
//		
//		when(itemmok.getValor()).thenReturn(2.8);
//		when(itemmok.getQuantidade()).thenReturn(2);
//		System.out.println("Valor pedimok::" + itemmok.getValor());
//		
//		Assert.assertEquals(pedidomok.total(), new Double(5.6));
//		
//		Assert.assertNotNull(pedidomok);
//	}
//	
//	private Pedido buildPedidoZero(){
//		
//		return new Pedido(null, null, null, null);
//	}
}
