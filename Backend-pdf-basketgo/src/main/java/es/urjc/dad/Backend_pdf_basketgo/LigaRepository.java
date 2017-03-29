package es.urjc.dad.Backend_pdf_basketgo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LigaRepository extends CrudRepository<Liga, Long> {
	List<Liga> findByNombre(String nombre);

}
