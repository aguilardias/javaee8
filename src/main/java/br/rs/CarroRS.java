package br.rs;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.stream.JsonCollectors;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.bc.CarroBC;
import br.entity.Carro;

@Path("carro")
@Produces(MediaType.APPLICATION_JSON)
public class CarroRS {

	@Inject
	CarroBC carroBC;

	@GET
	public List<Carro> listarCarro() {
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
}
