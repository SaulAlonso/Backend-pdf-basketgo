package es.urjc.dad.Backend_pdf_basketgo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LigaRepository extends CrudRepository<Liga, Long> {
	//Liga findByNombre(String nombre);
	
	List<Liga> findByNombre(String nombre);

}
