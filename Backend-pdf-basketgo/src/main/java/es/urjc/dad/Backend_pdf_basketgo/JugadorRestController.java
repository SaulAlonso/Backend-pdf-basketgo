package es.urjc.dad.Backend_pdf_basketgo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JugadorRestController {
	@Autowired
	private JugadorService jugadorService;
	
	@RequestMapping(value="/ver-jugador", method = RequestMethod.GET)
	public List<Jugador> getJugador(){
		return jugadorService.getJugador();
	}
	
	@RequestMapping(value = "/ver-jugador/{index}", method = RequestMethod.GET)
	public Jugador getJugador(@PathVariable("index") long index){
		return jugadorService.getJugador(index);
	}
}
