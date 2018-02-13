package br.com.jhage.pedido_api.negocio;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.jhage.pedido_api.excecao.PedidoException;
import br.com.jhage.pedido_api.helper.FormatDateHelper;
import br.com.jhage.pedido_api.modelo.Pedido;
import br.com.jhage.pedido_api.repository.PedidoRepository;

/**
 * 
 * @author Alexsander Melo
 * @since 11/02/2018
 *
 */

@Component
public class PedidoON {
	
	@Autowired
	private PedidoRepository repository;
	
	
	public List<Pedido> carregarPedidoDeHoje() throws PedidoException{
		
		List<Pedido> result = null;
		String hoje;
		hoje = FormatDateHelper.converterDataParaCaracter(new Date());
		result = repository.carregarPedidoPorData(hoje);
		return result;
	}
	

}
