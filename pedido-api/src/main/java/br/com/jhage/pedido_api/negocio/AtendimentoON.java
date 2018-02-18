package br.com.jhage.pedido_api.negocio;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.jhage.pedido_api.excecao.PedidoException;
import br.com.jhage.pedido_api.helper.FormatDateHelper;
import br.com.jhage.pedido_api.modelo.HistoricoPedido;
import br.com.jhage.pedido_api.modelo.ItemPedido;
import br.com.jhage.pedido_api.modelo.Pedido;
import br.com.jhage.pedido_api.repository.HistoricoPedidoRepository;
import br.com.jhage.pedido_api.repository.ItemPedidoRepository;
import br.com.jhage.pedido_api.repository.PedidoRepository;

/**
 * 
 * @author Alexsander Melo
 * @since 11/02/2018
 *
 */

@Component
public class AtendimentoON {
	
	@Autowired
	private PedidoRepository repository;
	
	@Autowired
	private ItemPedidoRepository itemRepository;
	
	@Autowired
	private HistoricoPedidoRepository historicorepository;
	
	public Pedido registrarPedido(Pedido pedido) {
		
		Pedido result =  repository.save(pedido);
		registrarHistorico(result);
		return result;
	}
	
	public Iterable<ItemPedido> carregarItensDoPedido(Long idPedido)  throws PedidoException{
		
		return itemRepository.carregarItensDoPedido(idPedido);
	}
	
	public List<Pedido> carregarPedidoDeHoje() throws PedidoException{
		
		List<Pedido> result = null;
		String hoje;
		hoje = FormatDateHelper.converterDataParaCaracter(new Date());
		result = repository.carregarPedidoPorData(hoje);
		return result;
	}
	
	public Pedido pedidoPronto(long idpedido) throws PedidoException{
		
		Pedido result = repository.findOne(idpedido);
		result.pronto();
		result = repository.save(result);
		registrarHistorico(result);
		return result;
	}
	
	public Pedido pedidoEntregue(long idpedido) throws PedidoException{
		
		Pedido result = repository.findOne(idpedido);
		result.entregue();
		result = repository.save(result);
		registrarHistorico(result);
		return result;
	}
	
	public Pedido pedidoCancelado(long idpedido) throws PedidoException{
		
		Pedido result = repository.findOne(idpedido);
		result.cancelado();
		result = repository.save(result);
		registrarHistorico(result);
		return result;
	}
	
	private void registrarHistorico(Pedido pedido) {
		
		HistoricoPedido hp = new HistoricoPedido(pedido);
		historicorepository.save(hp);
	}

}
