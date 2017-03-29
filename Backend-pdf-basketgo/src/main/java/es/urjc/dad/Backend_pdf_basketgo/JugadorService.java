package es.urjc.dad.Backend_pdf_basketgo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 @Service
public class JugadorService {
	@Autowired
	private JugadorRepository repositorio;
	
	public List<Jugador> getJugador(){
		return (List<Jugador>) repositorio.findAll();
	}
	
	public Jugador getJugador(long id){
		return repositorio.findOne(id);
	}
}
