package br.fa7.ejb.loja.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.fa7.ejb.loja.entity.Produto;

@Path("/produtos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProdutoResource {

	//private ProdutoService produtoService;

	@GET
	public List<Produto> findAll() {
		//return clienteService.findAll();
		System.out.println("findAll");
		return new ArrayList<Produto>();
	}

}
