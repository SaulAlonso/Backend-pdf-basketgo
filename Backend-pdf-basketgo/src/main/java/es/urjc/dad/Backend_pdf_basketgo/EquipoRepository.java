package es.urjc.dad.Backend_pdf_basketgo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EquipoRepository extends CrudRepository<Equipo, Long> {
	
	List<Equipo> findByNombreEquipo(String nombreEquipo);
	
}
