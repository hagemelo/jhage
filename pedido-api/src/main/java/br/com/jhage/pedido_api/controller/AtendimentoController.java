package br.com.jhage.pedido_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.jhage.pedido_api.constante.ValoresConstantes;
import br.com.jhage.pedido_api.excecao.PedidoException;
import br.com.jhage.pedido_api.modelo.ItemPedido;
import br.com.jhage.pedido_api.modelo.Pedido;
import br.com.jhage.pedido_api.negocio.AtendimentoON;

/**
 * 
 * @author Alexsander Melo
 * @since 11/02/2018
 *
 */
@CrossOrigin(origins = { ValoresConstantes.ORINGINS }, maxAge = 3000)
@RequestMapping(ValoresConstantes.REQUESTMAPPING_ATENDIMENTO)
@RestController
public class AtendimentoController extends DefaultController{
	
	@Autowired
	private AtendimentoON on;
	
	@GetMapping(path= ValoresConstantes.REQUESTMAPPING_PEDIDOS_DO_DIA)
	public @ResponseBody Iterable<Pedido> carregarPedidosDodia()  throws PedidoException{

		return on.carregarPedidoDeHoje();
	}
	
	@GetMapping(path= ValoresConstantes.REQUESTMAPPING_PEDIDOS_CANCELADOS)
	public @ResponseBody Iterable<Pedido> carregarPedidosCancelados()  throws PedidoException{

		return on.carregarPedidoCancelados();
	}
	
	@PostMapping
	@Transactional
	public @ResponseBody Pedido registrarPedido(@RequestBody Pedido pedido) {

		return on.registrarPedido(pedido);
	}
	
	@GetMapping(path= ValoresConstantes.REQUESTMAPPING_ITENS_DO_PEDIDO)
	public @ResponseBody Iterable<ItemPedido> carregarItensDoPedido(@PathVariable("id") Long idPedido)  throws PedidoException{

		return on.carregarItensDoPedido(idPedido) ;
	}

	@PostMapping(path= ValoresConstantes.REQUESTMAPPING_PEDIDO_PRONTO)
	@Transactional
	public @ResponseBody Pedido pedidoPronto(@PathVariable("id") Long idPedido) throws PedidoException{

		return on.pedidoPronto(idPedido);
	}
	
	@PostMapping(path= ValoresConstantes.REQUESTMAPPING_PEDIDO_ENTREGUE)
	@Transactional
	public @ResponseBody Pedido pedidoEntregue(@PathVariable("id") Long idPedido) throws PedidoException{

		return on.pedidoEntregue(idPedido);
	}
	
	@PostMapping(path= ValoresConstantes.REQUESTMAPPING_PEDIDO_CANCELADO)
	@Transactional
	public @ResponseBody Pedido pedidoCancelado(@PathVariable("id") Long idPedido) throws PedidoException{

		return on.pedidoCancelado(idPedido);
	}
	
}
