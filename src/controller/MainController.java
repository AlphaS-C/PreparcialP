package controller;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import model.Colegio;
import model.Estudiante;

public class MainController {

	ObservableList<Estudiante> estudiantes = FXCollections.observableArrayList();

	
	
	
	@FXML TextField codigo;
	@FXML TextField nombre;
	@FXML TextField nota1;
	@FXML TextField nota2;
	@FXML TextField nota3;
	@FXML ListView list;
	
    public void initialize() {
        list.setItems(estudiantes);
        list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
	
	public void agregarEstudiante() {

	estudiantes.add(new Estudiante(codigo.getText(), nombre.getText(), Integer.parseInt(nota1.getText()), Integer.parseInt(nota2.getText()), Integer.parseInt(nota3.getText())));
	list.setItems(estudiantes);
	}
}