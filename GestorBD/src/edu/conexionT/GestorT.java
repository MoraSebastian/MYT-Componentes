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
import edu.conexion.Gestor;

public class GestorT extends Gestor implements consultarTarea {	
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
	 * Método encargado de consultar todas las tareas pendientes, sin importar ningún otro atributo
	 */
	public ArrayList<String[]> CtareasPendientes() {
		Conectar();				
		script = "select * from tarea;";
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
	 * Método encargado de consultar todas las tareas pendientes por materia
	 */
	public ArrayList<String[]> CtareasPMateria(String nombre) {
		Conectar();			
		String id = consultas(nombre, "materia").get(0);
		script = "select * from tarea" + 
				"where id_materia = " + id + ";";
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
	 * Método encargado de consultar todas las tareas pendientes por tipo
	 */
	public ArrayList<String[]> CtareasPTipo(String nombre) {
		Conectar();			
		String id = consultas(nombre, "tipotarea").get(0);
		script = "select * from tarea" + 
				"where id_tipot = " + id + ";";
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
	 * Método encargado de consultar todas las tareas pendientes para una fecha
	 */
	public ArrayList<String[]> CtareasPFecha(String nombre) {
		Conectar();			
		
		script = "select * from tarea" + 
				"where fecha = " + nombre + ";";
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
	 * Método encargado de consultar todas las tareas pendientes por dificultad
	 */
	public ArrayList<String[]> CtareasPDificultad(String nombre) {
		Conectar();			
		
		script = "select * from tarea" + 
				"where dificultad = " + nombre + ";";
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
	
	
}
