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
	public static final String REQUESTMAPPING_RELATORIO = "/relatorio";
	public static final String REQUESTMAPPING_CADASTROPRODUTO = "/cadastro/produto";
	public static final String REQUESTMAPPING_PEDIDOS_DO_DIA = "/pedidosdodia";
	public static final String REQUESTMAPPING_PEDIDOS_CANCELADOS = "/pedidoscancelados";
	public static final String REQUESTMAPPING_ITENS_DO_PEDIDO = "/itensdopedido/{id}";
	public static final String REQUESTMAPPING_PEDIDO_PRONTO = "/pedidopronto/{id}";
	public static final String REQUESTMAPPING_PEDIDO_ENTREGUE = "/pedidoentregue/{id}";
	public static final String REQUESTMAPPING_PEDIDO_CANCELADO = "/pedidocancelado/{id}";
	public static final String REQUESTMAPPING_VENDAS_DIA = "/vendasdia";
	public static final String REQUESTMAPPING_ITENS_PEDIDO_DIA = "/itenspedidodia/{datapedido}";
	/**
	 * QUERIES
	 */
	
	public static final String QUERY_CARREGAR_PEDIDOS_PORDATA = "select p "
															  + "from Pedido p "
															  + "where to_char(p.cadastro, 'dd/MM/yyyy') = :hoje "
															  + "and not p.status like 'CANCELADO' "
															  + "order by p.cadastro";
	
	
	public static final String QUERY_CARREGAR_PEDIDOS_CANCELADOS = "select p "
																  + "from Pedido p "
																  + "where to_char(p.cadastro, 'dd/MM/yyyy') = :hoje "
																  + "and p.status like 'CANCELADO'"
																  + " order by p.cadastro";
	
	
	public static final String QUERY_CARREGAR_ITENS_DO_PEDIDO = "select i "
															  + "from ItemPedido i join i.pedido p "
															  + "where p.id =:idPedido";
	
	
	public static final String QUERY_TOTAL_PEDIDOS_DIA ="Select "+
															"to_char(p.cadastro, 'dd/MM/yyyy') dia, "+
															"count(p.pedido_id) quantidade, "+
															"round(cast(sum(i.quantidade * i.valor) as decimal)) total "+
															"from "+
																"Pedido p "+
																"join item_pedido i on (i.pedido_pedido_id = p.pedido_id) "+
															"where "+
																"not p.status like 'CANCELADO' "+
															"group by 1 " +
															"order by 1 desc";
	
	public static final String QUERY_ITENS_PEDIDOS_DIA ="Select " + 
			"	i.descricao item, " + 
			"	count(p.pedido_id) quantidade, " + 
			"	round(cast(count(i.itempedido_id)as decimal)/cast(max(tudo.qtdtotal)as decimal),2)  Percentual, " + 
			"	round(cast(sum(i.quantidade * i.valor) as decimal)) total " + 
			
			"from  " + 
			"	Pedido p  " + 
			"	join item_pedido i on (i.pedido_pedido_id = p.pedido_id) " + 
			"	join (Select to_char(pp.cadastro, 'dd/MM/yyyy') datas,  " + 
			"	count(ii.itempedido_id) qtdtotal " + 
			"from  " + 
			"	Pedido pp  " + 
			"	join item_pedido ii on (ii.pedido_pedido_id = pp.pedido_id)  " + 
			"where  " + 
			"	not pp.status like 'CANCELADO' group by 1) as tudo on (tudo.datas = to_char(p.cadastro, 'dd/MM/yyyy')) " + 
		
			"where  " + 
			"	to_char(p.cadastro, 'dd-MM-yyyy') = :hoje " + 
			"	and not p.status like 'CANCELADO' " + 
			"group by i.descricao";
	
}
