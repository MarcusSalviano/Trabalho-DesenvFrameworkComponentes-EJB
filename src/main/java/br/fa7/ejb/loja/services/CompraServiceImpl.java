package br.fa7.ejb.loja.services;

import java.util.List;

import javax.ejb.Asynchronous;
import javax.ejb.Remote;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

import br.fa7.ejb.loja.entity.Compra;
import br.fa7.spring.loja.entity.Cliente;

@Remote
public class CompraServiceImpl implements CompraService {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Asynchronous
	public List<Compra> findAll() {
		List<Compra> compras = entityManager.createQuery("From Compra e", Compra.class).getResultList();

		for (Compra compra : compras) {
			try {				
				HttpResponse<Cliente> clienteResponse = Unirest.get("http://localhost:8082/clientes/"+compra.getCliente().getId())
						.asObject(Cliente.class);
				Cliente cliente = clienteResponse.getBody();
				compra.setCliente(cliente);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return compras;
	}

	@Override
	public Compra findById(Long id) {
		return entityManager.find(Compra.class, id);
	}

	@Override
	public void insert(Compra compra) {
		entityManager.persist(compra);
	}

}
