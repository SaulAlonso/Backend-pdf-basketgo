package es.urjc.dad.Backend_pdf_basketgo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LigaService {
	@Autowired
	private LigaRepository repositorio;
	
	public List<Liga> getLiga(){
		return (List<Liga>) repositorio.findAll();
	}
	
	public Liga getLiga(long id){
		return repositorio.findOne(id);
	}
}
