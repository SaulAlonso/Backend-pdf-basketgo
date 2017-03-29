package es.urjc.dad.Backend_pdf_basketgo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ClasificacionRepository extends CrudRepository<Clasificacion, Long> {
	
	List<Clasificacion> findByNombreClasificacion(String nombreClasificacion);
	
}
