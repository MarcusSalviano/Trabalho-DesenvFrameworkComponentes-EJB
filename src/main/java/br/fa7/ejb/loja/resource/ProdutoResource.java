package br.fa7.ejb.loja.resource;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.fa7.ejb.loja.entity.Produto;
import br.fa7.ejb.loja.services.ProdutoService;
import br.fa7.spring.loja.entity.Endereco;

@Path("/produtos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProdutoResource {

	@Inject
	private ProdutoService produtoService;

	@GET
	public List<Produto> findAll() {
		return produtoService.findAll();
	}
	
	@GET
	@Path("{id}")
	public Response get(@PathParam("id") Long id){
		Produto produto = produtoService.findById(id);
		if(produto==null){
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(produto).build();
	}
	
	@POST
	public Produto insert(Produto produto){
		produtoService.insert(produto);
		return produto;
	}
}
