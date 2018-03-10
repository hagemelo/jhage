package br.com.jhage.pedido_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.jhage.pedido_api.constante.ValoresConstantes;
import br.com.jhage.pedido_api.excecao.PedidoException;
import br.com.jhage.pedido_api.helper.RetirarAspas;
import br.com.jhage.pedido_api.repository.PedidoRepository;

@CrossOrigin(origins = { ValoresConstantes.ORINGINS }, maxAge = 3000)
@RequestMapping(ValoresConstantes.REQUESTMAPPING_RELATORIO)
@RestController
public class RelatorioController extends DefaultController{
	
	
	@Autowired
	private PedidoRepository repository;
	
	@GetMapping(path= ValoresConstantes.REQUESTMAPPING_VENDAS_DIA)
	public @ResponseBody Iterable<Object> vendasDia()  throws PedidoException{

		return repository.vendasdia();
	}

	
	@GetMapping(path= ValoresConstantes.REQUESTMAPPING_ITENS_PEDIDO_DIA)
	public @ResponseBody Iterable<Object> itensPedidosDia(@PathVariable("datapedido") String dataPedido)  throws PedidoException{

		System.out.println(dataPedido);
		try {
			dataPedido = RetirarAspas.retirarAspasSimples(dataPedido);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return repository.itenspedidosdia(dataPedido);
	}
}
