package controller;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Programa;
import persistencia.Persistencia;

public class Ej2Controller implements Serializable , Initializable {

	ObservableList<Programa> programas = FXCollections.observableArrayList();
	Persistencia persistencia = new Persistencia();

	@FXML TextField codigo;
	@FXML TextField nombre;
	@FXML ComboBox combo;
	@FXML Text feedback;
	@FXML TextField busqueda;
	@FXML ListView list;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	combo.getItems().setAll("Presencial", "Distancia");
	}
	
	public void agregarPrograma() {
	Programa programa = new Programa(codigo.getText(), nombre.getText(), "" + combo.getValue());
	programas.add(programa);
	persistencia.guardaRegistroLog("programa añadido al ObservableList", 1, "agregar programae");
	list.setItems(programas);
	persistencia.guardaRegistroLog("ListView Actualizado", 1, "set listview");
	}
	
	public void guardar() {
		persistencia.guardarProgramas(programas);
		persistencia.guardaRegistroLog("Archivo Guardado", 1, "guardar txt");
	}
	
	public void cargar() {
		programas = persistencia.cargarProgramasXML();
		list.setItems(programas);
		persistencia.guardaRegistroLog("programas Cargados", 1, "cargar txt");
		
	}
	
	public void buscar() {
		
		Programa prog = new Programa();
		for (Programa progInd: programas) {
			if (progInd.getCodigo().equals(busqueda.getText())) {
				prog = progInd;
			}
		}
		if (prog != null) {
			codigo.setText(prog.getCodigo());
			nombre.setText(prog.getNombre());
			combo.setValue(prog.getModalidad());
			feedback.setText("Programa encontrado");
		} else feedback.setText("Programa no encontrado");
		
		
		
		
//		try {
//			//programa est = persistencia.buscarprograma(busqueda.getText());
//			persistencia.guardaRegistroLog("programa buscado", 1, "buscar programa");
//			if (est != null) {
//				feedback.setText("Usuario encontrado!");
//				persistencia.guardaRegistroLog("programa encontrado", 1, "buscar programa");
//				codigo.setText(est.getCodigo());
//				nombre.setText(est.getNombre());
//			}
//			else { feedback.setText("programa no encontrado"); 
//			persistencia.guardaRegistroLog("programa no encontrado", 1, "buscar programa");}
//		} catch (IOException e) {
//			persistencia.guardaRegistroLog("Excepcion de archivo", 2, "buscar programa");
//			e.printStackTrace();
//		}
		
	}


	
}
