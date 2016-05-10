package br.fa7.ejb.loja.services;

import java.util.List;

import br.fa7.ejb.loja.entity.Produto;

public interface ProdutoService {

	public List<Produto> findAll();
	
	public Produto findById(Long id);
	
	public void insert(Produto produto);
	
}
