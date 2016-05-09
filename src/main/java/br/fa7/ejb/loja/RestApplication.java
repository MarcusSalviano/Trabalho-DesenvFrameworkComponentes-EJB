package br.fa7.ejb.loja;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import br.fa7.ejb.loja.resource.ProdutoResource;

@ApplicationPath("/api")
public class RestApplication extends Application {

	public Set<Class<?>> getClasses(){
		return new HashSet(Arrays.asList(ProdutoResource.class));
	}
}
