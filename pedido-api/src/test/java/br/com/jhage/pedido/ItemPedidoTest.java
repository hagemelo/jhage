package br.com.jhage.pedido;

import org.junit.Assert;
import org.junit.Test;

import br.com.jhage.pedido_api.modelo.ItemPedido;
import br.com.jhage.pedido_api.modelo.Produto;

public class ItemPedidoTest {
	
	private final static Double VALOR_DEFAULT = 2.8;
	private final static Double ZERO = 0.;
	
	@Test
	public void totalItemPedidoIgualaZero(){
		
		Assert.assertEquals(ZERO, new ItemPedido(null).total());
	}
	
//	@Test
//	public void totalItemPedidoIgualaValorDefaultCenarioFeliz(){
//		
//		Assert.assertEquals(VALOR_DEFAULT, new ItemPedido(2).comProduto(new Produto("Teste", 1.4)).total());
//	}
	
//	@Test
//	public void totalItemPedidoIgualaValorDefaultComQtdNull(){
//		
//		Assert.assertEquals(VALOR_DEFAULT, new ItemPedido(null).comProduto(new Produto("Teste", 2.8)).total());
//	}
//	
//	@Test
//	public void totalItemPedidoIgualaValorDefaultComValorNull(){
//		
//		Assert.assertEquals(ZERO, new ItemPedido(2).comProduto(new Produto("Teste", null)).total());
//	}
	
}
