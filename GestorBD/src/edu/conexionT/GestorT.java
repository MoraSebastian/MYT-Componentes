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
	public Connection conexion = null;
	Connection cnx = null;
	PreparedStatement ps = null;
	String pass = "CualColoco";
	String user = "postgres";
	
	@Override
	public void consultaT() {
		//JOptionPane.showMessageDialog(null, "DBTarea");
		Conectar();
		//CONSULTA SOLO PARA OBTENER EL MAXIMO ID POR AHORA
		java.sql.Statement codigoSQL = null;
		ResultSet resultados = null;
		
		String script = "select max(id_materia) from materia;";
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
	public ArrayList<String> consultas(String caso, String tabla){
		Conectar();
		//CONSULTA SOLO PARA OBTENER EL MAXIMO ID POR AHORA
		java.sql.Statement codigoSQL = null;
		ResultSet resultados = null;
		String script = "";
		ArrayList<String> array = new ArrayList<String>();
		
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
	public void ModifciarT() {
		// TODO Auto-generated method stub
		
	}

	public void RegistrarT(String[] datos, String tabla) {
		Conectar();
		ps = null;
		String script = "";
		switch(tabla) {
		case "tarea":
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
			break;
		case "tipotarea":
			script = "insert into tipotarea (id_tipot, nombre)" + 
					" values(" +datos[0] + ", " +datos[1] + ");";
			try {
				ps = conexion.prepareStatement(script);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "SE HIZO EL REGISTRO DE LA TAREA");
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "PAILA NO SE PUDO HACER EL REGISTRO XD");
			}
			break;
		}
		
		Desconectar();
	}
	public void Borrar() {
		
	}
	public void Conectar() {
		try {
			conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Agenda", user, pass);
			JOptionPane.showMessageDialog(null, "Estas conectado");
		}catch(SQLException e) {
			Crear();
			JOptionPane.showMessageDialog(null, e);
		}
	}
	public void Crear() {
		String drive = "jdbc:postgresql://localhost:5432/";		
	    try {
	        cnx = (Connection) DriverManager.getConnection(drive,user,pass);
	        ps = cnx.prepareStatement("CREATE DATABASE Agenda");
	        ps.executeUpdate();
	        ps.close();
	        JOptionPane.showMessageDialog(null, "Se creo agenda");
	    } catch (SQLException ex) {
	        System.out.println(ex);
	        System.out.println("SE JODIO LA CREACION DE LA BASE XD");
	    }
	}
	public void Desconectar() {
		conexion = null;
	}
	public Connection getConnection() {
		return conexion;
	}
	@Override
	public void RegistrarT() {
		// TODO Auto-generated method stub
		
	}
}
