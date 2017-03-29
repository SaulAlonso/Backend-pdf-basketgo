package es.urjc.dad.Backend_pdf_basketgo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
