package br.com.jhage.pedido_api.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.jhage.pedido_api.modelo.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long>{
	
	

}
