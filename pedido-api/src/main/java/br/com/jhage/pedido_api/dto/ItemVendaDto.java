package br.com.jhage.pedido_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.jhage.pedido_api.helper.NumberHelp;

public class ItemVendaDto {

	String item;
	Integer quantidade;
	Double percentual;
	Double total;
	
	ItemVendaDto(){}
	
	public ItemVendaDto(Object[] ob) {
		
		item = ob[0].toString();
		quantidade = new Integer(ob[1].toString());
		percentual = new Double(ob[2].toString());
		total = new Double(ob[3].toString());
	}

	public String getItem() {
		return item;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public Double getPercentual() {
		return percentual;
	}

	public Double getTotal() {
		return total;
	}
	
	@JsonProperty
	public String getPercentualToString() {
		
		return NumberHelp.parseDoubleToString(this.percentual * 100);
	}
	
	@JsonProperty
	public String getTotalToString() {
		
		return NumberHelp.parseDoubleToString(this.total);
	}
	
}
