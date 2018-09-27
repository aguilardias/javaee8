package br.bc;

import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Logger;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

import br.entity.Carro;

@Stateless
public class ProcessamentoCarro {

	private static final Logger LOGGER = Logger.getLogger(ProcessamentoCarro.class.getName());

	public void processarCarrosSincrono(List<Carro> lista) {
		LOGGER.info("processamentoCarroSincrosno.inicio");
		LockSupport.parkNanos(5_000_000_000L);

		LOGGER.info("processamentoCarroSincrosno.fim");
	}

	@Asynchronous
	public void processarCarros(List<Carro> lista) {
		LOGGER.info("processamentoCarro.inicio");
		LockSupport.parkNanos(5_000_000_000L);

		LOGGER.info("processamentoCarro.fim");
	}

	@Asynchronous
	public Future<String> processarCarrosComResposta(List<Carro> lista) {
		LOGGER.info("processamentoCarroComResposta.inicio");
		LockSupport.parkNanos(5_000_000_000L);

		LOGGER.info("processamentoCarroComResposta.fim");

		return new AsyncResult<>("teste");
	}

}
