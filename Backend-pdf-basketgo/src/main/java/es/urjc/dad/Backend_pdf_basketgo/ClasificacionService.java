package es.urjc.dad.Backend_pdf_basketgo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClasificacionService {
	@Autowired
	private ClasificacionRepository repositorio;
	
	public List<Clasificacion> getClasificacion(){
		return (List<Clasificacion>) repositorio.findAll();
	}
	
	public Clasificacion getClasificacion(long id){
		return repositorio.findOne(id);
	}

}
