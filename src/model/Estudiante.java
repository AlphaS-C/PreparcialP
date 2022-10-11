package model;

import java.io.Serializable;
import java.util.Objects;

public class Estudiante implements Serializable{

	private static final long serialVersionUID = 1L;
	String codigo;
	String nombre;
	int nota1, nota2, nota3;

// constructor vacio
	public Estudiante() {
		
	}

	
	
public Estudiante(String codigo, String nombre, int nota1, int nota2, int nota3) {
	super();
	this.codigo = codigo;
	this.nombre = nombre;
	this.nota1 = nota1;
	this.nota2 = nota2;
	this.nota3 = nota3;
}



// metodo toString
	@Override
	public String toString() {
		return "Example [toString()=" + super.toString() + "]";
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
		Estudiante other = (Estudiante) obj;
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

	public int getNota1() {
		return nota1;
	}

	public void setNota1(int nota1) {
		this.nota1 = nota1;
	}

	public int getNota2() {
		return nota2;
	}

	public void setNota2(int nota2) {
		this.nota2 = nota2;
	}

	public int getNota3() {
		return nota3;
	}

	public void setNota3(int nota3) {
		this.nota3 = nota3;
	}

	
	
}
