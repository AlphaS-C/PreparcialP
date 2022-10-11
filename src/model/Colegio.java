package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Colegio implements Serializable{

	private static final long serialVersionUID = 1L;
	ArrayList<Estudiante> listaEstudiantes = new ArrayList<Estudiante>();

// constructor vacio
	public Colegio() {
		
	}

// metodo toString
	@Override
	public String toString() {
		return "Example [toString()=" + super.toString() + "]";
	}


	public ArrayList<Estudiante> getListaEstudiantes() {
		return listaEstudiantes;
	}

	public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
		this.listaEstudiantes = listaEstudiantes;
	}

	
	
}
