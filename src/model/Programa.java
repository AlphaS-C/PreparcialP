package model;

import java.io.Serializable;
import java.util.Objects;

public class Programa implements Serializable{
	
	String codigo;
	String nombre;
	String modalidad;

// constructor vacio
	public Programa() {
		
	}

	
	
public Programa(String codigo, String nombre, String modalidad) {
	super();
	this.codigo = codigo;
	this.nombre = nombre;
	this.modalidad = modalidad;
}



// metodo toString
	@Override
	public String toString() {
		return codigo + "," + nombre + "," + modalidad;
	}

// metodo equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Programa other = (Programa) obj;
		return Objects.equals(codigo, other.codigo);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getModalidad() {
		return modalidad;
	}



	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}


	
	
}
