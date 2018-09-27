mvn archetype:generate -Dfilter=com.airhacks:

http://localhost:8080/javaee-8/api/carro
http://localhost:8080/javaee-8/api/carro/lista-assincrono

curl localhost:8080/javaee-8/api/carro-evento -i
curl localhost:8080/javaee-8/api/carro-evento -i -H 'Last-Event-ID: 0'

https://www.packtpub.com/mapt/video/video/9781788831130

####################################################################################
section 1: core java ee components
utilizar @Stateless em BC e @Inject para injetar dependências

@Stateless: são classes mantidas pelo servidor, várias classes são criadas pelo servidor,
ao utilizar anotação, garante que a instância retornada não contém informação de outra execução

@Produces
anotar método, irá retornar objeto para interface, enum, ...

utilizar @Name("nome"), tanto no método gerador, quando no atributo a ser injetado,
porém não é typesafe

escopos EJB managend beans: 
@Stateless
@Statefull: guarda estado, uma instância para cada sessão de usuário
@Singleton: uma instância para todo servidor, métodos são acessados um por vez, por vários usuário

escopos CDI managend beans:
@ApplicationScoped, similiar ao @Singleton
@RequestScoped, @SessionScoped
@Depend

CDI event 
1.comportamento sincrono
classe dispara evento
@Inject
Event<ClasseQualquer> obj;
obj.fire(new ClasseQualquer());

Outra classe escuta evento:
public void onEvento(@Observes ClasseQualquer obj) {
}

2.comportamento assincrono
	1.utilizar @Asynchronous com @Stateless
	2.obj.fireAsync(new ClasseQualquer());
	
	Outra classe escuta evento:
	public void onEvento(@ObservesAsync ClasseQualquer obj) {
	}


####################################################################################
section 2: http endpoints

JsonB
@JsonbTransient: anotar atributo classe que não será serializado
@JsonbProperty("nome"): alterar nome propriedade serializada

JsonP
Json.createObjectBuilder().add("nome",valor)

ao utilizar JsonArray, JsonObject, como entrada ou saída de método jax-rs, não é necessário definir
consumes, produces

####################################################################################
section 3: persistence

###
section 4: cross-cutting concerns
@Interceptors, @Interceptor, @AroundInvoke

jcache

####################################################################################
section 5: asynchronous behavior

@Asynchronous em métodos de classe EJB, ou na própria classe

executar algo em sua própria thread
@Resource
ManagedExecutorService service;

service.execute(() -> metodoSincrono);

//agendar tarefas sem utilizar ejb
@Resource
ManagedScheduledExecutorService service;
service.schedule(

####################################################################################
section 6: acessing external systems

acessar outro servidor via jax-rs

JsonObject json = Json.createObjectBuilder().add("mensagem", mensagem).build();

GenericType<List<String>>

####################################################################################
section 7: asynchronous communication protocols

SSE - Server sent events
