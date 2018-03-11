package br.com.jhage.pedido_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.jhage.pedido_api.constante.ValoresConstantes;
import br.com.jhage.pedido_api.dto.ItemVendaDto;
import br.com.jhage.pedido_api.dto.VendaDTO;
import br.com.jhage.pedido_api.excecao.PedidoException;
import br.com.jhage.pedido_api.negocio.RelatorioON;

@CrossOrigin(origins = { ValoresConstantes.ORINGINS }, maxAge = 3000)
@RequestMapping(ValoresConstantes.REQUESTMAPPING_RELATORIO)
@RestController
public class RelatorioController extends DefaultController{
	
	@Autowired
	private RelatorioON on;
	
	@GetMapping(path= ValoresConstantes.REQUESTMAPPING_VENDAS_DIA)
	public @ResponseBody Iterable<VendaDTO> vendasDia()  throws PedidoException{

		return on.vendasDia();
	}
	
	@GetMapping(path= ValoresConstantes.REQUESTMAPPING_ITENS_PEDIDO_DIA)
	public @ResponseBody Iterable<ItemVendaDto> itensPedidosDia(@PathVariable("datapedido") String dataPedido)  throws PedidoException{

		return on.itenspedidosdia(dataPedido);
	}
}
