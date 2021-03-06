package es.urjc.dad.Backend_pdf_basketgo;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClasificacionRestController {
	
	@Autowired
	private ClasificacionService clasificacionService;
	
	@RequestMapping(value="/clasificacion", method = RequestMethod.GET)
	public List<Clasificacion> getClasificacion(){
		return clasificacionService.getClasificacion();
	}
	
	@RequestMapping(value = "/clasificacion/{index}", method = RequestMethod.GET)
	public Clasificacion getClasificacion(@PathVariable("index") long index){
		return clasificacionService.getClasificacion(index);
	}

}
