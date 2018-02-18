package br.com.jhage.pedido_api.constante;


/**
 * 
 * @author Alexsander Melo
 * @since 05/02/2018
 *
 */
public class ValoresConstantes {
	
	public static final Double DOUBLE_ZERO = 0.;
	public static final Long LONG_ZERO = new Long(0);
	public static final Integer ZERO = 0;
	public static final Integer UM = 1;
	public static final String STRING_VAZIO = "";
	public static final String USER_SENHA_INVALIDO ="Usuário e/ou senha inválidos";
	public static final String USER_NAO_AUTORIZADO="Usuário nâo autorizado";
	public static final String SESSAO_INVALIDA="Sessão inválida";
	public static final String ORINGINS ="http://localhost:8080";
	
	public static final String REQUESTMAPPING_ATENDIMENTO = "/atendimento";
	public static final String REQUESTMAPPING_CADASTROPRODUTO = "/cadastro/produto";
	public static final String REQUESTMAPPING_PEDIDOS_DO_DIA = "/pedidosdodia";
	public static final String REQUESTMAPPING_ITENS_DO_PEDIDO = "/itensdopedido/{id}";
	public static final String REQUESTMAPPING_PEDIDO_PRONTO = "/pedidopronto/{id}";
	public static final String REQUESTMAPPING_PEDIDO_ENTREGUE = "/pedidoentregue/{id}";
	public static final String REQUESTMAPPING_PEDIDO_CANCELADO = "/pedidocancelado/{id}";
	
	/**
	 * QUERIES
	 */
	
	public static final String QUERY_CARREGAR_PEDIDOS_PORDATA = "select p "
															  + "from Pedido p "
															  + "where to_char(p.cadastro, 'dd/MM/yyyy') = :hoje "
															  + "and not p.status like 'CANCELADO'";
	
	public static final String QUERY_CARREGAR_ITENS_DO_PEDIDO = "select i "
															  + "from ItemPedido i join i.pedido p "
															  + "where p.id =:idPedido";
}
