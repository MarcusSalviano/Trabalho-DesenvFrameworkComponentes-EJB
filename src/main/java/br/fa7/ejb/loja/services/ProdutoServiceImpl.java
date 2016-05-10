package br.fa7.ejb.loja.services;

import java.util.List;

import javax.ejb.Remote;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.fa7.ejb.loja.entity.Produto;

@Remote
public class ProdutoServiceImpl implements ProdutoService {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Produto> findAll() {
		return entityManager.createQuery("From Produto e", Produto.class).getResultList();
	}
	
	@Override
	public Produto findById(Long id) {
		return entityManager.find(Produto.class, id);
	}


	@Override
	public void insert(Produto produto) {
		entityManager.persist(produto);
	}
	
}
