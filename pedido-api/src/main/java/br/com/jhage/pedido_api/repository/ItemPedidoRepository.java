package br.com.jhage.pedido_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.jhage.pedido_api.constante.ValoresConstantes;
import br.com.jhage.pedido_api.excecao.PedidoException;
import br.com.jhage.pedido_api.modelo.ItemPedido;

/**
 * 
 * @author Alexsander Melo
 * @since 11/02/2018
 *
 */
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long>{
	
	
	@Query(ValoresConstantes.QUERY_CARREGAR_ITENS_DO_PEDIDO)
	public List<ItemPedido> carregarItensDoPedido(@Param("idPedido") Long idPedido)  throws PedidoException;
	

}
