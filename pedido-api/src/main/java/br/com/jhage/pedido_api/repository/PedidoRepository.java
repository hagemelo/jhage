package br.com.jhage.pedido_api.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.jhage.pedido_api.modelo.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long>{
	

}
