package br.bc;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;

import br.entity.Carro;

@Stateless
public class CarroBC {

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
