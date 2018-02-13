package br.com.jhage.pedido_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.jhage.pedido_api.constante.ValoresConstantes;
import br.com.jhage.pedido_api.modelo.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	
	@Query(ValoresConstantes.QUERY_CARREGAR_PEDIDOS_PORDATA)
	public List<Pedido> carregarPedidoPorData(@Param("hoje") String data);
	
}
