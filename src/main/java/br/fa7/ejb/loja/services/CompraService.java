package br.fa7.ejb.loja.services;

import java.util.List;

import br.fa7.ejb.loja.entity.Compra;

public interface CompraService {

	public List<Compra> findAll();
	
	public Compra findById(Long id);
	
	public void insert(Compra compra);
	
}
