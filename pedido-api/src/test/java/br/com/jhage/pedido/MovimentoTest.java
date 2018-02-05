package br.com.jhage.pedido;

import org.junit.Assert;
import org.junit.Test;

import br.com.jhage.pedido_api.modelo.ItemPedido;
//import br.com.jhage.pedido_api.modelo.Movimento;
import br.com.jhage.pedido_api.modelo.Pedido;
import br.com.jhage.pedido_api.modelo.Produto;

public class MovimentoTest {
	
	private static final Double VALOR_DEFAUL = 13.6;
	private static final Double VALOR_ZERO = 0.;
	
//	@Test
//	public void naoDevehaverNullnosCampos(){
//		
//		Movimento mov = new Movimento(null);
//		Assert.assertNotNull(mov.getOcorrencia());
//		Assert.assertNotNull(mov.getOcorrencia());
//		Assert.assertNotNull(mov.getPedidos());
//		Assert.assertNotNull(mov.getStatus());
//	}
//
//	@Test
//	public void subTotalPedidoDeverSerZero(){
//		
//		Movimento mov = new Movimento(null);
//		Assert.assertEquals(VALOR_ZERO, mov.total());
//	}
//	
//	@Test
//	public void subTotalPedidoDeverSerIgualAoValorDefaul(){
//		
//		Movimento mov = new Movimento(1);
//		Pedido pedidoModelo1 = new Pedido(909, "", "", null);
//		pedidoModelo1.getItens().add(new ItemPedido(1).comProduto(new Produto("Teste", 6.8)));
//		pedidoModelo1.getItens().add(new ItemPedido(1).comProduto(new Produto("Teste", 6.8)));
//		pedidoModelo1.finalizado();
//		mov.getPedidos().add(pedidoModelo1);
//		pedidoModelo1 = new Pedido(55555, "", "", null);
//		pedidoModelo1.getItens().add(new ItemPedido(1).comProduto(new Produto("Teste", 6.8)));
//		pedidoModelo1.getItens().add(new ItemPedido(1).comProduto(new Produto("Teste", 6.8)));
//		mov.getPedidos().add(pedidoModelo1);
//		Assert.assertEquals(VALOR_DEFAUL, mov.total());
//	}
	
	
}
