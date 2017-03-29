package es.urjc.ssii.Practica2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public class IntentoRestController {
	@Autowired
	private IntentoService intentoService;

	@RequestMapping(value = "/intento", method = RequestMethod.GET)
	public List<Intento> getPeliculas() {
		return intentoService.getIntento();
	}

	@RequestMapping(value = "/intento/{index}", method = RequestMethod.GET)
	public Intento getIntento(@PathVariable("index") int index) {
		return intentoService.getIntento(index);
	}
}
