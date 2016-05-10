package br.fa7.ejb.loja.resource;

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

import br.fa7.ejb.loja.entity.Compra;
import br.fa7.ejb.loja.services.CompraService;

@Path("/compras")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CompraResource {

	@Inject
	private CompraService compraService;

	@GET
	public List<Compra> findAll() {
		return compraService.findAll();
	}
	

	@GET
	@Path("{id}")
	public Response get(@PathParam("id") Long id){
		Compra compra = compraService.findById(id);
		if(compra==null){
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(compra).build();
	}
	
	@POST
	public Compra insert(Compra compra){
		compraService.insert(compra);
		return compra;
	}
}
