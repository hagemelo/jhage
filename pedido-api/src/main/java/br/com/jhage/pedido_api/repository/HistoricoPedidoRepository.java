package br.com.jhage.pedido_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.jhage.pedido_api.constante.ValoresConstantes;
import br.com.jhage.pedido_api.modelo.HistoricoPedido;

/**
 * 
 * @author Alexsander Melo
 * @since 18/02/2018
 *
 */
public interface HistoricoPedidoRepository extends JpaRepository<HistoricoPedido, Long>{
	
	@Query(ValoresConstantes.QUERY_HISTORICO_DO_PEDIDO)
	public List<HistoricoPedido> historicoDoPedido(@Param("id") Long idpedido);
	
	@Query(value = ValoresConstantes.QUERY_TEMPO_PEDIDO, nativeQuery = true)
	public  List<Object> tempoPedido();
}
