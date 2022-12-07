package com.proyecto.spring.event;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.proyecto.spring.event.model.Event;
import com.proyecto.spring.event.repository.EventRepository;

@SpringBootTest
public class Test07_DatabaseConContenido {
	@Autowired
	private EventRepository repository;
	
	@Test
	void contextLoads() {
		List<Event> users = repository.findAll();
		assertFalse(users.size() == 0);
	}
}
