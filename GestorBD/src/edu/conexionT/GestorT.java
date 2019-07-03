package edu.conexionT;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import edu.cableado.consultarTarea;


public class GestorT implements consultarTarea {	
	ArrayList<String> array;
	
	@Override
	public void consultaT() {
		Conectar();				
		script = "select max(id_materia) from materia;";
		try {
			codigoSQL = conexion.createStatement();
			resultados = codigoSQL.executeQuery(script);
			ResultSetMetaData datos = resultados.getMetaData();
			
			String res ="";
			while (resultados.next())
		      {
		        res=resultados.getString(1);
		      }
			JOptionPane.showMessageDialog(null, "EL ULTIMO ID ES: "+res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}						
		Desconectar();
	}
	/**
	 * Método encargado de consultar todas las tareas pendientes, sin importar ningún otro atributo más que la fecha
	 */
	public ArrayList<String[]> cTareasPendientes(String fecha) {
		return consultarTareasPendientes(fecha, "tpendientes");
	}
	/**
	 * Método encargado de consultar todas las tareas que no tengan padre, sin importar ningún otro atributo
	 */
	public ArrayList<String[]> cTareasPadre(String fecha) {
		return consultarTareasPendientes(fecha, "tpendienteSinpadre");			
	}
	public ArrayList<String[]> cTareasPadre() {
		Conectar();	
		
		script = "select * from tarea where id_tareas is null;";
		ArrayList<String[]> array1 = new ArrayList<String[]>();
		try {
			codigoSQL = conexion.createStatement();
			resultados = codigoSQL.executeQuery(script);
			ResultSetMetaData datos = resultados.getMetaData();			
			int numeroColumnas = datos.getColumnCount();						
			String res ="";
			while (resultados.next())
		      {
				String[] f = new String[numeroColumnas];
				for (int i = 0; i < numeroColumnas; i++) {
					f[i] = resultados.getString(i+1);
				}				
		        res=resultados.getString(1);
		        array1.add(f);		       
		      }
			Desconectar();
			 return array1;
			//JOptionPane.showMessageDialog(null, "EL ULTIMO ID ES: "+res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
			return null;
		}									
	}
	/**
	 * Método encargado de consultar tareas pendientes GENERAL, sin importar más que la fecha
	 */
	public ArrayList<String[]> consultarTareasPendientes(String fecha, String caso) {
		Conectar();	
		switch (caso) {
		case "tpendientes":
			script = "select * from tarea where fecha = " + fecha + ";";
			break;			
		case "tpendienteSinpadre":
			script = "select * from tarea where fecha = " + fecha + " and id_tareas is null;";
		
		}		
		ArrayList<String[]> array1 = new ArrayList<String[]>();
		try {
			codigoSQL = conexion.createStatement();
			resultados = codigoSQL.executeQuery(script);
			ResultSetMetaData datos = resultados.getMetaData();
			
			int numeroColumnas = datos.getColumnCount();
			
			
			String res ="";
			while (resultados.next())
		      {
				String[] f = new String[numeroColumnas];
				for (int i = 0; i < numeroColumnas; i++) {
					f[i] = resultados.getString(i+1);
				}				
		        res=resultados.getString(1);
		        array1.add(f);
		        return array1;
		      }
			JOptionPane.showMessageDialog(null, "EL ULTIMO ID ES: "+res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}						
		Desconectar();
		return null;
	}
	
	/**
	 * Método encargado de consultar todas las tareas pendientes por MATERIA
	 */
	public ArrayList<String[]> cTareasPorMateria(String fecha, String nombre) {
		return consultarTareasSegun(fecha, nombre, "materia");
	}
	/**
	 * Método que se encarga de consultar las tareas pendientes para una fecha por su TIPO
	 */
	public ArrayList<String[]> cTareasPorTipo(String fecha, String nombre) {
		return consultarTareasSegun(fecha, nombre, "tipo");
	}	
	/**
	 * Método encargado de consultar todas las tareas pendientes por DIFICULTAD
	 */
	public ArrayList<String[]> cTareasPorDificultad(String fecha, String nombre) {
		return consultarTareasSegun(fecha, nombre, "dificultad");
	}	
	/**
	 * Método encargado de consultar tareas general
	 */
	public ArrayList<String[]> consultarTareasSegun (String fecha, String nombre, String caso){
		Conectar();	
		String id = "";
		switch (caso) {		
		case "tipo":
			id = consultas(nombre, "tipotarea").get(0);
			script = "select * from tarea" + 
					"where id_tipot = " + id + " and fecha = " + fecha + ";";
			break;
		case "dificultad":
			script = "select * from tarea" + 
					"where dificultad = " + nombre + " and fecha = " + fecha + ";";
			break;
		case "materia":
			id = consultas(nombre, "materia").get(0);
			script = "select * from tarea" + 
					"where id_materia = " + id + " and fecha = " + fecha + ";";
			break;
		}
		ArrayList<String[]> array1 = new ArrayList<String[]>();
		try {
			codigoSQL = conexion.createStatement();
			resultados = codigoSQL.executeQuery(script);
			ResultSetMetaData datos = resultados.getMetaData();
			
			int numeroColumnas = datos.getColumnCount();
			
			
			String res ="";
			while (resultados.next())
		      {
				String[] f = new String[numeroColumnas];
				for (int i = 0; i < numeroColumnas; i++) {
					f[i] = resultados.getString(i+1);
				}				
		        res=resultados.getString(1);
		        array1.add(f);
		        return array1;
		      }
			JOptionPane.showMessageDialog(null, "EL ULTIMO ID ES: "+res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}						
		Desconectar();
		return null;
	}
	
	/**
	 * Método que se encarga de consultar los nombres de las materias 
	 */
	public ArrayList<String> cNombreMaterias(){
		return consultarNombre("materia");									
	}
	/**
	 * Método que se encarga de consultar los nombres de las tareas padre
	 */
	public ArrayList<String> cNombreTareasPadre(){
		return consultarNombre("tareap");
	}
	public ArrayList<String> consultarNombre(String caso){
		Conectar();	
		switch (caso) {
		case "tareap":
			script = "select nombre from tarea where id_tareas is null;";
			break;
		case "materia":
			script = "select nombre from materia;";
		}		
		ArrayList<String> array1 = new ArrayList<String>();
		try {
			codigoSQL = conexion.createStatement();
			resultados = codigoSQL.executeQuery(script);
			ResultSetMetaData datos = resultados.getMetaData();
											
			String res ="";
			while (resultados.next())
		      {						
		        res=resultados.getString(1);
		        array1.add(res);		        
		      }
			Desconectar();
			return array1;			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
	}
	
	public ArrayList<String> consultas(String caso, String tabla){
		Conectar();
		//CONSULTA SOLO PARA OBTENER EL MAXIMO ID POR AHORA		
		script = "";
		array = new ArrayList<String>();
		
		String id = "";
		
		switch (caso) {
		case "maxid":
			if(tabla.contains("tipo")) {
				id = "tipo"+tabla.charAt(4);
				System.out.println("ID: "+"id_"+id);
				script = "select max(id_"+id+") from "+tabla+";";
			}else {
				script = "select max(id_"+tabla+") from "+tabla+";";
			}
			break;
		case "nombre":						
			script = "select nombre from "+tabla+";";
			break;
		case "id":
			if(tabla.contains("tipo")) {
				id = "tipo"+tabla.charAt(4);
				System.out.println("ID: "+"id_"+id);
				script = "select id_"+id+" from "+tabla+";";
			}else {
				script = "select id_"+tabla+" from "+tabla+";";
			}	
			break;
		case "nombrepadre":
			script = "select nombre from "+tabla+" where id_tareas is null;";
			break;		
		case "idmateria":
			script = "select materia.nombre " + 
					"from materia, tarea " + 
					"where materia.id_materia = tarea.id_materia and " + 
					"tarea.nombre = " + tabla + ";";
			break;
		default: 
			if(tabla.contains("tipo")) {
				id = "tipo"+tabla.charAt(4);
				System.out.println("ID: "+"id_"+id);
				script = "select " +tabla + ".id_"+id+" from "+tabla+" where " + tabla + ".nombre = '" + caso+ "';";
			}else {
				script = "select "+tabla+".id_" + tabla + " from "+tabla+" where " + tabla + ".nombre = '" + caso + "';";
			}
			break;
		}	
		try {
			codigoSQL = conexion.createStatement();
			resultados = codigoSQL.executeQuery(script);
			ResultSetMetaData datos = resultados.getMetaData();			
			String res ="";
			
			while (resultados.next())
		      {
		        res=resultados.getString(1);
		        array.add(res);
		      }				
			return array;				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();				
		}					
		
		Desconectar();
		return null;				
	}

	@Override
	public void ModificarT() {
		Conectar();				
	}
	/**
	 * Método que se encarga de registrar la tarea
	 */
	public void RegistrarT(String[] datos) {
		Conectar();
		ps = null;
		if(consultas("maxid", "tarea").get(0) == null) {
			datos[0] = "1";
		}else {
			datos[0] = consultas("maxid", "tarea").get(0);
		}
		script = "insert into tarea (id_tarea, descripcion, id_tareas, dificultad, id_tipot, fecha, hora, id_materia, nombre)" + 
				" values(" +datos[0] + ", " +datos[1] + ", " + datos[2] + ", " + datos[3] + ", " + datos[4] + 
				", " + datos[5] + ", " + datos[6] +  ", " + datos[7] + ", " + datos[8] + ");";
		try {
			ps = conexion.prepareStatement(script);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "SE HIZO EL REGISTRO DE LA TAREA");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "PAILA NO SE PUDO HACER EL REGISTRO XD");
		}															
		Desconectar();
	}
	public void Borrar() {
		
	}
	
	
	
	public Connection conexion = null;	
	public PreparedStatement ps = null;
	public java.sql.Statement codigoSQL = null;
	public ResultSet resultados = null;
	String pass = "CualColoco";
	String user = "postgres";
	public String script = "";
	
	public void Conectar() {
		try {
			JOptionPane.showMessageDialog(null, "DEBERIA EXISTIR, USER: "+user+" pass: "+ pass);
			conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/agenda", user, pass);
			JOptionPane.showMessageDialog(null, "Estas conectado");
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "NO EXISTE LA BASE DE DATOS");
			CrearBase();			
		}
	}
	public void CrearBase() {
		String drive = "jdbc:postgresql://localhost:5432/";		
	    try {
	    	conexion = null;
	    	ps = null;
	    	JOptionPane.showMessageDialog(null, "DEBERIA EMPEZAR A CREAR ");
	    	System.out.println("EMPEZANDO A CREAR");
	    	System.out.println("");
	        conexion = (Connection) DriverManager.getConnection(drive,user,pass);
	        ps = conexion.prepareStatement("CREATE DATABASE agenda " + 
	        		"    WITH " + 
	        		"    OWNER = postgres " + 
	        		"    ENCODING = 'UTF8'" + 
	        		"    CONNECTION LIMIT = -1;");
	       // Conectar();
	        System.out.println("HASTA ACA VA BIEN");
	        ps.executeUpdate();	       
	        //CREAR TABLA TAREA
	        ps.close();	 	       
	        CrearTablas();
	        JOptionPane.showMessageDialog(null, "Se creo agenda");
	        
	    } catch (SQLException ex) {
	        System.out.println(ex);
	        System.out.println("SE JODIO LA CREACION DE LA BASE XD");
	    }
	}
	public void CrearTablas() {
		try {
			Conectar();
			ps = conexion.prepareStatement("create table tarea( " + 
	        		"    id_tarea int primary key, " + 
	        		"	descripcion text, " + 
	        		"	id_tareaS int, " + 
	        		"	dificultad int, " + 
	        		"	id_tipot int, " + 
	        		"	fecha date, " + 
	        		"	hora time, " + 
	        		"	id_materia int, " + 
	        		"	nombre text " + 
	        		");");
	        ps.executeUpdate();	        
	        //CREAR TABLA TIPO TAREA
	        ps = conexion.prepareStatement("create table TipoTarea( " + 
	        		"	id_tipot int primary key, " + 
	        		"	nombre text " + 
	        		");");
	        ps.executeUpdate();	  
	        //CREAR TABLA MATERIA
	        ps = conexion.prepareStatement("create table Materia( " + 
	        		"	id_materia int primary key, " + 
	        		"	nombre text, " + 
	        		"	profesor text, " + 
	        		"	creditos int, " + 
	        		"	dificultad int, " + 
	        		"	id_tipom int not null " + 
	        		");");
	        ps.executeUpdate();	        
	        //CREAR TABLA TIPO MATERIA
	        ps = conexion.prepareStatement("create table tipoMateria( " + 
	        		"	id_tipom int primary key, " + 
	        		"	nombre text " + 
	        		");");
	        ps.executeUpdate();
	        //CREAR TABLA DIA
	        ps = conexion.prepareStatement("create table dia( " + 
	        		"	id_dia int primary key, " + 
	        		"	dia text not null, " + 
	        		"	id_tipod int " + 
	        		");");
	        ps.executeUpdate();
	        //CREAR TABLA TIPODIA
	        ps = conexion.prepareStatement("create table tipodia( " + 
	        		"	id_tipod int primary key, " + 
	        		"	nombre text " + 
	        		");");
	        ps.executeUpdate();
	        //CREAR TABLA DIAMATERIA
	        ps = conexion.prepareStatement("create table diamateria( " + 
	        		"	id_dm int primary key, " + 
	        		"	id_materia int, " + 
	        		"	id_dia int " + 
	        		");");
	        ps.executeUpdate();
	        //CREAR TABLA BLOQUE
	        ps = conexion.prepareStatement("create table Bloque( " + 
	        		"	id_bloque int primary key, " + 
	        		"	hora_inicio time, " + 
	        		"	hora_fin time, " + 
	        		"	aprovechabilidad int, " + 
	        		"	id_tipob int, " + 
	        		"	id_materia int " + 
	        		");");
	        ps.executeUpdate();
	        //CREAR TABLA TIPOBLOQUE
	        ps = conexion.prepareStatement("create table TipoBloque( " + 
	        		"	id_tipob int primary key, " + 
	        		"	nombre text " + 
	        		");");
	        ps.executeUpdate();
	        //CREAR TABLA ESPACIO
	        ps = conexion.prepareStatement("create table espacio( " + 
	        		"	id_espacio int primary key, " + 
	        		"	hora_inicio time, " + 
	        		"	hora_final time, " + 
	        		"	fecha date, " + 
	        		"	aprovechabilidad int, " + 
	        		"	id_tarea int, " + 
	        		"	id_tipoe int " + 
	        		");");
	        ps.executeUpdate();
	        //CREAR TABLA TIPOESPACIO
	        ps = conexion.prepareStatement("create table tipoespacio( " + 
	        		"	id_tipoe int primary key, " + 
	        		"	nombre text " + 
	        		");");
	        ps.executeUpdate();
	        //AGREGAR RELACIONES	  
	        ps = conexion.prepareStatement("alter table tarea " + 
	        		"	add constraint id_tipot " + 
	        		"	foreign key (id_tipot) " + 
	        		"	references TipoTarea(id_tipot) " + 
	        		"	on delete no action " + 
	        		"	on update no action;");
	        ps.executeUpdate();
	        ps = conexion.prepareStatement("alter table tarea " + 
	        		"	add constraint id_tareas " + 
	        		"	foreign key (id_tareas) " + 
	        		"	references tarea(id_tarea) " + 
	        		"	on delete  cascade " + 
	        		"	on update  cascade;");
	        ps.executeUpdate();
	        ps = conexion.prepareStatement("alter table tarea " + 
	        		"	add constraint id_materia " + 
	        		"	foreign key (id_materia) " + 
	        		"	references materia(id_materia) " + 
	        		"	on delete cascade " + 
	        		"	on update cascade;");
	        ps.executeUpdate();
	        ps = conexion.prepareStatement("alter table bloque " + 
	        		"	add constraint id_materia " + 
	        		"	foreign key (id_materia) " + 
	        		"	references materia(id_materia) " + 
	        		"	on delete cascade " + 
	        		"	on update cascade;");
	        ps.executeUpdate();
	        ps = conexion.prepareStatement("alter table bloque " + 
	        		"	add constraint id_tipob " + 
	        		"	foreign key (id_tipob) " + 
	        		"	references tipobloque(id_tipob) " + 
	        		"	on delete no action " + 
	        		"	on update no action;");
	        ps.executeUpdate();
	        ps = conexion.prepareStatement("alter table dia " + 
	        		"	add constraint id_tipod " + 
	        		"	foreign key (id_tipod) " + 
	        		"	references tipodia(id_tipod) " + 
	        		"	on delete no action " + 
	        		"	on update no action;");
	        ps.executeUpdate();
	        ps = conexion.prepareStatement("alter table materia " + 
	        		"	add constraint id_tipom " + 
	        		"	foreign key (id_tipom) " + 
	        		"	references tipomateria(id_tipom) " + 
	        		"	on delete no action " + 
	        		"	on update no action;");
	        ps.executeUpdate();
	        ps = conexion.prepareStatement("alter table diamateria " + 
	        		"	add constraint id_materia " + 
	        		"	foreign key (id_materia) " + 
	        		"	references materia(id_materia) " + 
	        		"	on delete cascade " + 
	        		"	on update cascade;");
	        ps.executeUpdate();
	        ps = conexion.prepareStatement("alter table diamateria " + 
	        		"	add constraint id_dia " + 
	        		"	foreign key (id_dia) " + 
	        		"	references dia(id_dia) " + 
	        		"	on delete cascade " + 
	        		"	on update cascade;");
	        ps.executeUpdate();
	        ps = conexion.prepareStatement("alter table espacio " + 
	        		"	add constraint id_tarea " + 
	        		"	foreign key (id_tarea) " + 
	        		"	references tarea(id_tarea) " + 
	        		"	on delete cascade " + 
	        		"	on update cascade;");
	        ps.executeUpdate();
	        ps = conexion.prepareStatement("alter table espacio " + 
	        		"	add constraint id_tipoe " + 
	        		"	foreign key (id_tipoe) " + 
	        		"	references tipoespacio(id_tipoe) " + 
	        		"	on delete no action " + 
	        		"	on update no action;");
	        ps.executeUpdate();
	        
	        JOptionPane.showMessageDialog(null, "EN TEORIA SE CREARON LAS TABLAS Y SUS RELACIONES");
	        ps.close();
	        Desconectar();
		}catch(SQLException e) {
			
		}
	}
	public void Desconectar() {
		conexion = null;
	}
	public Connection getConnection() {
		return conexion;
	}
	

	
}
