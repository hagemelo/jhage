package br.com.jhage.pedido_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.jhage.pedido_api.repository.ProdutoRepository;

@Component
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;


}
