package br.bc;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;

import br.entity.Carro;

@Stateless
public class CarroBC {

	private static final Logger LOGGER = Logger.getLogger(CarroBC.class.getName());

	@Inject
	ProcessamentoCarro processamentoCarro;

	@Resource
	ManagedExecutorService service;

	public CarroBC() {
		super();
		System.out.println(UUID.randomUUID().toString());
	}

	public List<Carro> listarCarro() {
		Carro carro1 = new Carro(1L, "astra");
		Carro carro2 = new Carro(2L, "etios");
		List<Carro> lista = Arrays.asList(carro1, carro2);

		// Future<String> resposta =
		// processamentoCarro.processarCarrosComResposta(lista);
		// try {
		// LOGGER.info("resposta thread=" + resposta.get());
		// } catch (InterruptedException | ExecutionException e) {
		// e.printStackTrace();
		// }

		// processamentoCarro.processarCarrosComResposta(lista);

		service.execute(() -> processamentoCarro.processarCarrosSincrono(lista));

		return lista;
	}

	public List<Carro> listarCarroSincrono() {
		LOGGER.info("listarCarroSincrono.inicio");
		LockSupport.parkNanos(5_000_000_000L);
		Carro carro1 = new Carro(1L, "astra");
		Carro carro2 = new Carro(2L, "etios");
		LOGGER.info("listarCarroSincrono.fim");
		return Arrays.asList(carro1, carro2);
	}

}
