package br.rs;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.stream.JsonCollectors;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.bc.CarroBC;
import br.entity.Carro;

@Path("carro")
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class CarroRS {

	@Inject
	// @Any
	// @BatchProperty
	Logger logger;

	@Inject
	CarroBC carroBC;

	@Resource
	ManagedExecutorService service;

	@GET
	public List<Carro> listarCarro() {
		logger.info("listarCarro");
		return carroBC.listarCarro();
	}

	@GET
	@Path("lista")
	public JsonArray listaOutroCarro() {
		return carroBC.listarCarro().stream().map(c -> Json.createObjectBuilder().add("modelo", c.getModelo()).build())
				.collect(JsonCollectors.toJsonArray());
	}

	@GET
	@Path("objeto")
	public JsonObject objeto() {
		return Json.createObjectBuilder().add("nome", UUID.randomUUID().toString()).build();
	}

	@Asynchronous
	@GET
	@Path("lista-assincrono")
	public void listaCarroAssincrono(@Suspended AsyncResponse asyncResponse) {

		service.execute(() -> asyncResponse.resume(listar()));
	}

	private Response listar() {
		List<Carro> listaCarro = carroBC.listarCarroSincrono();
		return Response.status(Response.Status.ACCEPTED).entity(listaCarro).build();
	}
}
