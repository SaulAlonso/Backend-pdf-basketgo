package es.urjc.dad.Backend_pdf_basketgo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Equipo {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long fichaEquipo;
	private String nombreEquipo;
	private int puntuacion;
	private int numeroDerrotas;
	private int numeroVictorias;
	@OneToMany (cascade=CascadeType.ALL)
	private List<Jugador> listaJugadores;
	

	public Equipo() {
		
	}
	
	public Equipo(String nombreEquipo, int puntuacion,
			int numeroDerrotas, int numeroVictorias, List<Jugador> listaJugadores) {
		
		this.nombreEquipo = nombreEquipo;
		this.puntuacion = puntuacion;
		this.numeroDerrotas = numeroDerrotas;
		this.numeroVictorias = numeroVictorias;
		this.listaJugadores = listaJugadores;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public int getNumeroDerrotas() {
		return numeroDerrotas;
	}

	public void setNumeroDerrotas(int numeroDerrotas) {
		this.numeroDerrotas = numeroDerrotas;
	}

	public int getNumeroVictorias() {
		return numeroVictorias;
	}

	public void setNumeroVictorias(int numeroVictorias) {
		this.numeroVictorias = numeroVictorias;
	}
	
	public String getNombreEquipo() {
		return nombreEquipo;
	}
	
	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}
	
	public List<Jugador> getListaJugadores() {
		return listaJugadores;
	}
	
	public void setListaJugadores(List<Jugador> listaJugadores) {
		this.listaJugadores = listaJugadores;
	}

	@Override
	public String toString() {
		return "Equipo [fichaEquipo=" + fichaEquipo + ", nombreEquipo=" + nombreEquipo + ", puntuacion="
				+ puntuacion + ", numeroDerrotas=" + numeroDerrotas + ", numeroVictorias=" + numeroVictorias
				+ ", listaJugadores=" + listaJugadores + "]";
	}

}
