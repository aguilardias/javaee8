package br.bc;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import javax.ejb.Stateless;

import br.entity.Carro;

@Stateless
public class CarroBC {

	private static final Logger LOGGER = Logger.getLogger(CarroBC.class.getName());

	public CarroBC() {
		super();
		System.out.println(UUID.randomUUID().toString());
	}

	public List<Carro> listarCarro() {

		Carro carro1 = new Carro(1L, "astra");
		Carro carro2 = new Carro(2L, "etios");
		return Arrays.asList(carro1, carro2);
	}

}
