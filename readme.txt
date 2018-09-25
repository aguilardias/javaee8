mvn archetype:generate -Dfilter=com.airhacks:

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

CDI event (comportamento sincrono)
classe dispara evento
@Inject
Event<ClasseQualquer> obj;
obj.fire(new ClasseQualquer());

Outra classe escuta evento:
public void onEvento(@Observes ClasseQualquer obj) {
}

###
section 2: http endpoints

JsonB
@JsonbTransient: anotar atributo classe que não será serializado
@JsonbProperty("nome"): alterar nome propriedade serializada

JsonP
Json.createObjectBuilder().add("nome",valor)

ao utilizar JsonArray, JsonObject, como entrada ou saída de método jax-rs, não é necessário definir
consumes, produces

###
section 3: persistence

###
section 4: cross-cutting concerns

###
section 5: asynchronous behavior

###
section 6: acessing external systems

###
section 7: asynchronous communication protocols