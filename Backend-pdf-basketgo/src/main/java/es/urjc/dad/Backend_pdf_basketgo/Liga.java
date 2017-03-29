package es.urjc.dad.Backend_pdf_basketgo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Liga {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	
	private String nombre;
	
	@OneToOne (cascade=CascadeType.ALL)
	private Clasificacion clasificacion;

	public Liga() {
		
	}
	
	public Liga(String nombre, Clasificacion clasificacion) {
		this.nombre = nombre;
		this.clasificacion = clasificacion;
	}

	public Clasificacion getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(Clasificacion clasificacion) {
		this.clasificacion = clasificacion;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Liga [nombre=" + nombre + ", clasificacion=" + clasificacion + "]";
	}
	
}

