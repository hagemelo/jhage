package br.com.jhage.pedido_api.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.jhage.pedido_api.dto.ItemVendaDto;
import br.com.jhage.pedido_api.dto.VendaDTO;
import br.com.jhage.pedido_api.excecao.PedidoException;
import br.com.jhage.pedido_api.helper.RetirarAspas;
import br.com.jhage.pedido_api.repository.PedidoRepository;

/**
 * 
 * @author Alexsander Melo
 * @since 10/03/2018
 *
 */

@Component
public class RelatorioON {

	@Autowired
	private PedidoRepository repository;
	private List<VendaDTO> vendas;
	private List<Object> vendasObject;
	private List<ItemVendaDto> itensVendas;
	private String diaPesquisa;
    private List<Object> itensVendasObject;
	
	public RelatorioON(){
	}
	
	public List<VendaDTO> vendasDia(){
		
		inicializarListVendas();
		carregarVendasObjectBancoDeDados();
		converterObjectToVendasDto();
		return vendas;
	}
	
	public List<ItemVendaDto> itenspedidosdia(String dia) throws PedidoException{
		
		inicializarListItensVendas();
		diaPesquisa = RetirarAspas.retirarAspasSimples(dia);
		carregarItensVendasBancoDeDados();
		converterObjecttoItemVendaDto();
		return itensVendas;
	}
	
	private void inicializarListVendas() {
		
		this.vendas = new ArrayList<VendaDTO>();
	}
	
	private void carregarVendasObjectBancoDeDados() {
		
		this.vendasObject = repository.vendasdia();
	}
	
	private void converterObjectToVendasDto() {
		
		vendasObject.forEach(obj ->{
			vendas.add(new VendaDTO((Object[]) obj));
		});
	}
	
	private void inicializarListItensVendas() {
		
		this.itensVendas = new ArrayList<ItemVendaDto>();
	}
	
	private void carregarItensVendasBancoDeDados() {
		
		this.itensVendasObject = repository.itenspedidosdia(this.diaPesquisa);
	}
	
	private void converterObjecttoItemVendaDto() {
		
		itensVendasObject.forEach(obj ->{
	    	itensVendas.add(new ItemVendaDto((Object[]) obj));
		});
	}
}
