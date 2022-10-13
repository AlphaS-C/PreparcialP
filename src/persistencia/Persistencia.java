package persistencia;

import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;

import controller.Ej2Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import model.Estudiante;
import model.Programa;


public class Persistencia {

	public static final String RUTA_ARCHIVO_ESTUDIANTES = "src/persistencia/estudiantes.txt";
	public static final String RUTA_ARCHIVO_PROGRAMAS = "src/persistencia/programas.txt";
//	public static final String RUTA_ARCHIVO_EMPLEADOS = "src/resources/archivoEmpleados.txt";
//	public static final String RUTA_ARCHIVO_USUARIOS = "src/resources/archivoUsuarios.txt";
	public static final String RUTA_ARCHIVO_LOG = "src/persistencia/log.txt";
//	public static final String RUTA_ARCHIVO_OBJETOS = "src/resources/archivoObjetos.txt";
//	public static final String RUTA_ARCHIVO_MODELO_BANCO_BINARIO = "src/resources/model.dat";
//	public static final String RUTA_ARCHIVO_MODELO_BANCO_XML = "src/resources/model.xml";


	
	
//	public static void cargarDatosArchivos(Banco banco) throws FileNotFoundException, IOException {
//		
//		
//		//cargar archivo de clientes
//		ArrayList<Cliente> clientesCargados = cargarClientes();
//		
//		if(clientesCargados.size() > 0)
//			banco.getListaClientes().addAll(clientesCargados);
//
//		
//		//cargar archivos empleados
//		ArrayList<Empleado> empleadosCargados = cargarEmpleados();
//		
//		if(empleadosCargados.size() > 0)
//			banco.getListaEmpleados().addAll(empleadosCargados);
//		
//		//cargar archivo objetos
//		
//		//cargar archivo empleados
//		
//		//cargar archivo prestamo
//		
//	}
	
	
	


	/**
	 * Guarda en un archivo de texto todos la información de las personas almacenadas en el ArrayList
	 * @param objetos
	 * @param ruta
	 * @throws IOException
	 */
	
	public static void guardarEstudiantes(List<Estudiante> listaEstudiantes) throws IOException {
//		// TODO Auto-generated method stub
		String contenido = "";
//		
	for(Estudiante est:listaEstudiantes) 
		{
		contenido += est.toString() + "\n";
//			contenido+= cliente.getNombre()+","+cliente.getApellido()+","+cliente.getCedula()+","+cliente.getDireccion()
//		     +","+cliente.getCorreo()+","+cliente.getFechaNacimiento()+","+cliente.getTelefono()+"\n";
		}
		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_ESTUDIANTES, contenido, false);
//		
	}
	
	
//	public static void guardarEmpleados(ArrayList<Empleado> listaEmpleados) throws IOException {
//		
//		// TODO Auto-generated method stub
//		String contenido = "";
//		
//		for(Empleado empleado:listaEmpleados) 
//		{
//			contenido+= empleado.getNombre()+","+empleado.getApellido()+","+empleado.getCedula()+","+empleado.getFechaNacimiento()+"\n";
//		}
//		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_EMPLEADOS, contenido, false);
//	}
	
	
	
//	----------------------LOADS------------------------
	
	/**
	 * 
	 * @param tipoPersona
	 * @param ruta
	 * @return un Arraylist de personas con los datos obtenidos del archivo de texto indicado
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
//	public static ArrayList<Cliente> cargarClientes() throws FileNotFoundException, IOException 
//	{
//		ArrayList<Cliente> clientes =new ArrayList<Cliente>();
//		
//		ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_CLIENTES);
//		String linea="";
//		
//		for (int i = 0; i < contenido.size(); i++)
//		{
//			linea = contenido.get(i);
//			Cliente cliente = new Cliente();
//			cliente.setNombre(linea.split(",")[0]);
//			cliente.setApellido(linea.split(",")[1]);
//			cliente.setCedula(linea.split(",")[2]);
//			cliente.setDireccion(linea.split(",")[3]);
//			cliente.setCorreo(linea.split(",")[4]);
//			cliente.setFechaNacimiento(linea.split(",")[5]);
//			cliente.setTelefono(linea.split(",")[6]);
//			clientes.add(cliente);
//		}
//		return clientes;
//	}
	
	
	
	public static ObservableList<Estudiante> cargarEstudiantes() throws IOException {
//		
		ObservableList<Estudiante> estudiantes = FXCollections.observableArrayList();
		
		ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_ESTUDIANTES);
		String linea="";
		for (int i = 0; i < contenido.size(); i++)
		{
			linea = contenido.get(i);
			Estudiante estudiante = new Estudiante();
			estudiante.setCodigo(linea.split(",")[0]);
			estudiante.setNombre(linea.split(",")[1]);
			estudiante.setNota1(Integer.parseInt(linea.split(",")[2]));
			estudiante.setNota2(Integer.parseInt(linea.split(",")[3]));
			estudiante.setNota3(Integer.parseInt(linea.split(",")[4]));
			estudiantes.add(estudiante);
		}
		return estudiantes;
	}
	
	public static Estudiante buscarEstudiante(String codigo) throws IOException {
//		
		Estudiante estudiante = new Estudiante();
		ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_ESTUDIANTES);
		String linea="";
		for (int i = 0; i < contenido.size(); i++)
		{
			linea = contenido.get(i);
			if ((linea.split(",")[0].equals(codigo))) {
				estudiante.setCodigo(linea.split(",")[0]);
				estudiante.setNombre(linea.split(",")[1]);
				estudiante.setNota1(Integer.parseInt(linea.split(",")[2]));
				estudiante.setNota2(Integer.parseInt(linea.split(",")[3]));
				estudiante.setNota3(Integer.parseInt(linea.split(",")[4]));
				return estudiante;
			}
		}
		return null;
	}


	public static void guardaRegistroLog(String mensajeLog, int nivel, String accion)
	{
		
		ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);
	}


//	public static boolean iniciarSesion(String usuario, String contrasenia) throws FileNotFoundException, IOException, UsuarioExcepcion {
//		
//		if(validarUsuario(usuario,contrasenia)) {
//			return true;
//		}else {
//			throw new UsuarioExcepcion("Usuario no existe");
//		}
//		
//	}
	
//	private static boolean validarUsuario(String usuario, String contrasenia) throws FileNotFoundException, IOException 
//	{
//		ArrayList<Usuario> usuarios = Persistencia.cargarUsuarios(RUTA_ARCHIVO_USUARIOS);
//		
//		for (int indiceUsuario = 0; indiceUsuario < usuarios.size(); indiceUsuario++) 
//		{
//			Usuario usuarioAux = usuarios.get(indiceUsuario);
//			if(usuarioAux.getUsuario().equalsIgnoreCase(usuario) && usuarioAux.getContrasenia().equalsIgnoreCase(contrasenia)) {
//				return true;
//			}
//		}
//		return false;
//	}

//	public static ArrayList<Usuario> cargarUsuarios(String ruta) throws FileNotFoundException, IOException {
//		ArrayList<Usuario> usuarios =new ArrayList<Usuario>();
//		
//		ArrayList<String> contenido = ArchivoUtil.leerArchivo(ruta);
//		String linea="";
//		
//		for (int i = 0; i < contenido.size(); i++) {
//			linea = contenido.get(i);
//			
//			Usuario usuario = new Usuario();
//			usuario.setUsuario(linea.split(",")[0]);
//			usuario.setContrasenia(linea.split(",")[1]);
//			
//			usuarios.add(usuario);
//		}
//		return usuarios;
//	}
	
	
//	----------------------SAVES------------------------
	
	/**
	 * Guarda en un archivo de texto todos la información de las personas almacenadas en el ArrayList
	 * @param objetos
	 * @param ruta
	 * @throws IOException
	 */
	
//	public static void guardarObjetos(ArrayList<Cliente> listaClientes, String ruta) throws IOException  {
//		String contenido = "";
//		
//		for(Cliente clienteAux:listaClientes) {
//			contenido+= clienteAux.getNombre()+","+clienteAux.getApellido()+","+clienteAux.getCedula()+clienteAux.getDireccion()
//					     +","+clienteAux.getCorreo()+","+clienteAux.getFechaNacimiento()+","+clienteAux.getTelefono()+"\n";
//		}
//		ArchivoUtil.guardarArchivo(ruta, contenido, true);
//	}


	
	
	
	//------------------------------------SERIALIZACIÓN  y XML
	
	
//	public static Banco cargarRecursoBancoBinario() {
//		
//		Banco banco = null;
//		
//		try {
//			banco = (Banco)ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_MODELO_BANCO_BINARIO);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return banco;
//	}
	
//	public static void guardarRecursoBancoBinario(Banco banco) {
//		
//		try {
//			ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_MODELO_BANCO_BINARIO, banco);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	
	// GUARDA LA LISTA COMO ARRAYLIST PORQUE UNA OBSERVABLE LIST NO ES SERIALIZABLE AKSJDHASJD
	public static void guardarProgramas(ObservableList<Programa> lista) {
	try {
		List<Programa> list = lista.stream().collect(Collectors.toList());
		ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_PROGRAMAS, list);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	
	public static ObservableList<Programa> cargarProgramasXML() {
		
		ObservableList<Programa> lista = FXCollections.observableArrayList();
		List<Programa> list = null;
		
		try {
			list = (List<Programa>)ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_PROGRAMAS);
			lista.addAll(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;

	}

	
	
//	public static void guardarRecursoBancoXML(Banco banco) {
//		
//		try {
//			ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_BANCO_XML, banco);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}