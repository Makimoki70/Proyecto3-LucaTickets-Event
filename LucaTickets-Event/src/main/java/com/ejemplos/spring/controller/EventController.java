package com.ejemplos.spring.controller;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ejemplos.spring.controller.error.EventNotFoundException;
import com.ejemplos.spring.model.Event;
import com.ejemplos.spring.service.EventService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Validated
@RequestMapping("/events")
@Tag(name = "event", description = "the Event API")
public class EventController {

	private static final Logger logger = LoggerFactory.getLogger(EventController.class);

	@Autowired
	private EventService serv;

	@GetMapping
	// @RequestMapping(method = RequestMethod.GET)
	public Collection<Event> readStudents() {
		return serv.findAll();
	}

	@Operation(summary = "Buscar eventos por ID", description = "Dado un ID, devuelve un objeto Event", tags= {"evento"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Evento localizado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Event.class)) }),
			@ApiResponse(responseCode = "400", description = "No válido (NO implementado) ", content = @Content),
			@ApiResponse(responseCode = "404", description = "Evento no encontrado (NO implementado)", content = @Content) })
	
	@GetMapping("/{id}")
	public Event readStudent(
			@Parameter(description = "ID del evento a localizar", required=true) 
			@PathVariable Long id) {			
		logger.info("------ readEvent (GET) ");
		return serv.findById(id).orElseThrow(()->new EventNotFoundException(id));
	}
	
	// Mapeado de la busqueda por tipo.
	@GetMapping("/tipo/{tipo}")
	public Collection<Event> readTipo(
			@Parameter(description = "Tipo del lugar del evento", required=true) 
			@PathVariable String tipo){
		logger.info("------ readTipo (GET) ");
		return serv.findByTipo(tipo);
	}

	// @RequestBody Student student significa que un estudiante será el cuerpo de la
	// respuesta
	// Devuelve en la cabecera la URL
	// Añado ahora la validacion
	@PostMapping
	public ResponseEntity<?> addStudent(@Valid @RequestBody Event event) {
		// Si hubiera habido algun error, hubiera saltado una excepcion antes de entrar
		// Y como las capturo con CustomGlobalException, no pasa por aqui
		logger.info("------ addEvento (POST)");
		Event result = this.serv.save(event);
		logger.info("------ Dato Salvado " + result);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId())
				.toUri();

		/*
		 * Inside the method body, we build a java.net.URI object using
		 * ServletUriComponentsBuilder. It builds the object by capturing the URI of the
		 * current request and appending the placeholder /{id} to create a template.
		 * buildAndExpand(result.getId()) inserts the id of the newly created student
		 * into the template. The result is the URI of the new resource.
		 */

		// Nosotros podemos devolver 2 cosas siempre; o bien una URI o un recurso.
		// En este caso devolvemos la URI
		// Y marcamos de vuelta un 201
		return ResponseEntity.created(location).build();
	}

	/*
	 * @PostMapping public Student addStudent(@RequestBody Student student) { return
	 * serv.save(student); }
	 */

	// Actualizar un usuario
	@PutMapping
	public Event updateStudent(@RequestBody Event event) {
		logger.info("------ updateEvento (PUT)");
		return this.serv.update(event).orElseThrow(EventNotFoundException::new);
	}

	// Una segunda forma no tan personalizada
	@PutMapping("/add")
	public ResponseEntity<Event> updateStudent2(@RequestBody Event event) {
		Optional<Event> st = this.serv.update(event);
		if (st.isEmpty()) {
			// No encontrado
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.of(st);

	}

	// Borrar un usuario
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Long id) {
		serv.deleteById(id);
	}

}
