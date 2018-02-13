package br.com.jhage.pedido_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.jhage.pedido_api.constante.ValoresConstantes;
import br.com.jhage.pedido_api.excecao.PedidoException;
import br.com.jhage.pedido_api.modelo.Pedido;
import br.com.jhage.pedido_api.negocio.PedidoON;
import br.com.jhage.pedido_api.repository.PedidoRepository;

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
	private PedidoON on;
	
	@Autowired
	private PedidoRepository repository;
	
	@GetMapping(path= ValoresConstantes.REQUESTMAPPING_PEDIDOS_DO_DIA)
	public @ResponseBody Iterable<Pedido> carregarPedidosDodia()  throws PedidoException{

		return on.carregarPedidoDeHoje();
	}
	
	
	@PostMapping
	@Transactional
	public @ResponseBody Pedido registrarPedido(@RequestBody Pedido pedido) {

		return repository.save(pedido);
	}
	

}
