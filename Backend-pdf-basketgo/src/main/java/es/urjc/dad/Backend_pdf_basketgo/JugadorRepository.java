package es.urjc.dad.Backend_pdf_basketgo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface JugadorRepository extends CrudRepository<Jugador, Long> {
	
	List<Jugador> findByNombre(String nombre);
	
}
