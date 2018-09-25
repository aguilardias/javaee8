package javaee8;

import java.util.UUID;

import javax.ejb.Stateless;

@Stateless
public class FabricaCarro {

	public FabricaCarro() {
		super();
		System.out.println(UUID.randomUUID().toString());
	}

}
