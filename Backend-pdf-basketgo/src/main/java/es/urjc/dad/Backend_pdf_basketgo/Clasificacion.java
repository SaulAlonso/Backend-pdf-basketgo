package es.urjc.dad.Backend_pdf_basketgo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Clasificacion {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	private String nombreClasificacion;
	
	@OneToMany (cascade=CascadeType.ALL)
	private List<Equipo> listaClasificacion;
	public Clasificacion() {
		
	}
	
	public Clasificacion(String nombreClasificacion, List<Equipo> listaClasificacion) {
		this.nombreClasificacion = nombreClasificacion;
		this.listaClasificacion = listaClasificacion;
	}
	
	public List<Equipo> getListaClasificacion() {
		
		Collections.sort(listaClasificacion, new Comparator<Equipo>() {
			@Override
			public int compare(Equipo arg0, Equipo arg1) {
				return new Integer(arg1.getPuntuacion()).compareTo(new Integer(arg0.getPuntuacion())) ;
			}
		});
		return listaClasificacion;
	}

	public void setListaClasificacion(ArrayList<Equipo> listaClasificacion) {
		this.listaClasificacion = listaClasificacion;
	}

	public String getNombreClasificacion() {
		return nombreClasificacion;
	}

	public void setNombreClasificacion(String nombreClasificacion) {
		this.nombreClasificacion = nombreClasificacion;
	}
	
	
}
