package br.com.jhage.pedido_api.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TempoPedidoDto {
	
	String tipo;
	
	@JsonFormat(pattern="HH:mm:ss.SSS")
	Date tempo;
	
	TempoPedidoDto(){}
	
	
	public TempoPedidoDto(Object[] ob){
		
		tipo = ob[0].toString();
		tempo = new Date(ob[1].toString());
	}

	public String getTipo() {
		return tipo;
	}


	public Date getTempo() {
		return tempo;
	}

}
