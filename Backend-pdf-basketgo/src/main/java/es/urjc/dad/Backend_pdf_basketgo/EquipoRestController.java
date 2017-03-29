package es.urjc.dad.Backend_pdf_basketgo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class EquipoRestController {
	@Autowired
	private EquipoService equipoService;
	
	@RequestMapping(value="/ver-equipo", method = RequestMethod.GET)
	public List<Equipo> getEquipo(){
		return equipoService.getEquipo();
	}
	
	@RequestMapping(value = "/ver-equipo/{index}", method = RequestMethod.GET)
	public Equipo getEquipo(@PathVariable("index") long index){
		return equipoService.getEquipo(index);
	}
}
