package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Estudiante;
import persistencia.Persistencia;

public class MainController {

	ObservableList<Estudiante> estudiantes = FXCollections.observableArrayList();
	Persistencia persistencia = new Persistencia();

	@FXML TextField codigo;
	@FXML TextField nombre;
	@FXML TextField nota1;
	@FXML TextField nota2;
	@FXML TextField nota3;
	@FXML Text feedback;
	@FXML TextField busqueda;
	@FXML ListView list;
	
    public void initialize() {
        list.setItems(estudiantes);
        list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
	
	public void agregarEstudiante() {
	Estudiante estudiante = new Estudiante(codigo.getText(), nombre.getText(), Integer.parseInt(nota1.getText()), Integer.parseInt(nota2.getText()), Integer.parseInt(nota3.getText()));
	estudiantes.add(estudiante);
	persistencia.guardaRegistroLog("Estudiante añadido al ObservableList", 1, "agregar estudiantee");
	list.setItems(estudiantes);
	persistencia.guardaRegistroLog("ListView Actualizado", 1, "set listview");
	}
	
	public void guardar() {
		try {
			persistencia.guardarEstudiantes(estudiantes);
			persistencia.guardaRegistroLog("Archivo Guardado", 1, "guardar txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			persistencia.guardaRegistroLog("Archivo Fallo al guardar", 2, "guardar txt");
			e.printStackTrace();
		}
	}
	
	public void cargar() {
		try {
			estudiantes = persistencia.cargarEstudiantes();
			list.setItems(estudiantes);
			persistencia.guardaRegistroLog("Estudiantes Cargados", 1, "cargar txt");
			
		} catch (IOException e) {
			persistencia.guardaRegistroLog("Fallo al cargar estudiantes", 2, "cargar txt");
			e.printStackTrace();
		}
		
	}
	
	public void buscar() {
		
		try {
			Estudiante est = persistencia.buscarEstudiante(busqueda.getText());
			persistencia.guardaRegistroLog("Estudiante buscado", 1, "buscar estudiante");
			if (est != null) {
				feedback.setText("Usuario encontrado!");
				persistencia.guardaRegistroLog("Estudiante encontrado", 1, "buscar estudiante");
				codigo.setText(est.getCodigo());
				nombre.setText(est.getNombre());
				nota1.setText("" + est.getNota1());
				nota2.setText("" + est.getNota2());
				nota3.setText("" +est.getNota3());
			}
			else { feedback.setText("Estudiante no encontrado"); 
			persistencia.guardaRegistroLog("Estudiante no encontrado", 1, "buscar estudiante");}
		} catch (IOException e) {
			persistencia.guardaRegistroLog("Excepcion de archivo", 2, "buscar estudiante");
			e.printStackTrace();
		}
		
	}
	
}