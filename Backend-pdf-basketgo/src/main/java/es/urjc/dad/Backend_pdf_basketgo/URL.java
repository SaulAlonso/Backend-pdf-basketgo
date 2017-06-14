package es.urjc.dad.Backend_pdf_basketgo;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class URL {
	private String nombre;
	private String url;
	
	public URL() {
		
	}
	
	public URL(String nombreURL, String direccionURL) {
		this.nombre = nombreURL;
		this.url = direccionURL;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombreURL){
		this.nombre = nombreURL;
	}
	public String getUrl() {
		return this.url;
	}
	public void setUrl(String direccionURL){
		this.url = direccionURL;
	}

}
