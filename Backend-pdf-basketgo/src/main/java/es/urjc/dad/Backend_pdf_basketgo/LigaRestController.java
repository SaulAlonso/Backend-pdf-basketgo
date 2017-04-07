package es.urjc.dad.Backend_pdf_basketgo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LigaRestController {
	@Autowired
	private LigaService ligaService;
	
	@RequestMapping(value="/ver-liga", method = RequestMethod.GET)
	public List<Liga> getLiga(){
		return ligaService.getLiga();
	}
	
	@RequestMapping(value = "/ver-liga/{index}", method = RequestMethod.GET)
	public Liga getLiga(@PathVariable("index") long index){
		return ligaService.getLiga(index);
	}
	
	/*@RequestMapping(value = "/verpdf", method = RequestMethod.GET)
	public Liga getLigaNombre(HttpServletResponse response){
		
		 return ligaService.getLigaNombre("Liga1");
	}*/
	
	@RequestMapping(value = "/verpdf/{nombre}", method = RequestMethod.GET)
	public Clasificacion getLigaNombre(@PathVariable("nombre") String nombre){
		
		List<Liga> liga = ligaService.getLigaNombre(nombre);
		
		return liga.get(0).getClasificacion();
	}
}
