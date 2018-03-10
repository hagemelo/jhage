package br.com.jhage.pedido_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.jhage.pedido_api.constante.ValoresConstantes;
import br.com.jhage.pedido_api.modelo.Pedido;

/**
 * 
 * @author Alexsander Melo
 * @since 11/02/2018
 *
 */
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	
	@Query(ValoresConstantes.QUERY_CARREGAR_PEDIDOS_PORDATA)
	public List<Pedido> carregarPedidoPorData(@Param("hoje") String data);
	
	@Query(ValoresConstantes.QUERY_CARREGAR_PEDIDOS_CANCELADOS)
	public List<Pedido> carregarPedidoCancelados(@Param("hoje") String data);
	
	
	@Query(value = ValoresConstantes.QUERY_TOTAL_PEDIDOS_DIA, nativeQuery = true)
	public List<Object> vendasdia();
	
	
	@Query(value = ValoresConstantes.QUERY_ITENS_PEDIDOS_DIA, nativeQuery = true)
	public List<Object> itenspedidosdia(@Param("hoje") String data);
}
