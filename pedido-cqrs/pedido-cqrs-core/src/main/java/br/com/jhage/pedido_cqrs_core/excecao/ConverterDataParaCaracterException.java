package br.com.jhage.pedido_cqrs_core.excecao;

public class ConverterDataParaCaracterException extends PedidoException{
	
	private static final long serialVersionUID = 1L;

	private final static String MENSAGEM = "Erro ao Converter Data para Caracter";
	
	public ConverterDataParaCaracterException(){
	
		super(MENSAGEM);
	}
	
	

}
