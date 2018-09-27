package br.rs;

import java.util.UUID;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.sse.OutboundSseEvent;
import javax.ws.rs.sse.Sse;
import javax.ws.rs.sse.SseBroadcaster;
import javax.ws.rs.sse.SseEventSink;

@Singleton
@Path("carro-evento")
public class CarroEventsRS {

	private static final Logger LOGGER = Logger.getLogger(CarroEventsRS.class.getName());

	@Context
	Sse sse;

	private SseBroadcaster broadcaster;

	@PostConstruct
	private void init() {
		broadcaster = sse.newBroadcaster();
	}

	@GET
	@Produces(MediaType.SERVER_SENT_EVENTS)
	public void listarCarro(@Context SseEventSink eventSink) {
		broadcaster.register(eventSink);
	}

	@Schedule(hour = "*", minute = "*", second = "*/5")
	public void enviarEvento() {
		broadcaster.broadcast(criarEvento());
	}

	private OutboundSseEvent criarEvento() {
		LOGGER.info("criarEvento");
		String id = UUID.randomUUID().toString();
		return sse.newEventBuilder().id("id=" + id).data("data=" + id).name("name=" + id).build();
	}

}
