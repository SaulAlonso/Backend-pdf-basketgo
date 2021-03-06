package es.urjc.dad.Backend_pdf_basketgo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Jugador {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int numeroFicha;
	
	private String nombre;
	private double altura; 
	private int edad;
	
	
	public Jugador() {
		
	}
	
	public Jugador(String nombre, double altura, int edad) {
		this.nombre = nombre;
		this.altura = altura;
		this.edad = edad;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double getAltura() {
		return altura;
	}
	
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Jugador [numeroFicha=" + numeroFicha + ", nombre=" + nombre + ", altura=" + altura
				+ ", edad=" + edad + "]";
	}

}

