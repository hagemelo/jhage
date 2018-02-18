package br.com.jhage.pedido_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jhage.pedido_api.modelo.HistoricoPedido;

/**
 * 
 * @author Alexsander Melo
 * @since 18/02/2018
 *
 */
public interface HistoricoPedidoRepository extends JpaRepository<HistoricoPedido, Long>{
	
	
}
