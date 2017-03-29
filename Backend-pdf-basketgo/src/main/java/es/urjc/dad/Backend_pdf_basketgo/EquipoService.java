package es.urjc.dad.Backend_pdf_basketgo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipoService {
	@Autowired
	private EquipoRepository repositorio;
	
	public List<Equipo> getEquipo(){
		return (List<Equipo>) repositorio.findAll();
	}
	
	public Equipo getEquipo(long id){
		return repositorio.findOne(id);
	}
}
