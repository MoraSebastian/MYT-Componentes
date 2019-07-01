package edu.conexionH;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import edu.cableado.consultarHorario;
import edu.conexion.Gestor;

public class GestorH extends Gestor implements consultarHorario {

	@Override
	public void consultaH() {
		JOptionPane.showMessageDialog(null, "DBHorario");

	}	
	/**
	 * Método encargado de consultar todas las tareas pendientes, sin importar ningún otro atributo
	 */
	public ArrayList<String[]> CtotalFranjas() {
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
	
	@Override
	public void RegistrarH(String[] datos, String tabla, boolean[] dias) {
		// TODO Auto-generated method stub
		Conectar();
		ps = null;
		switch (tabla) {
		case "bloque":
			script = "insert into bloque (id_bloque, hora_inicio, hora_fin, aprovechabilidad, " + 
					" id_tipob)" + 
					"	values(" + datos[0] + ", " + datos[1] + ", " + datos[2] + ", "
							 + datos[3] +", " + datos[4] + ");";
						
			try {
				ps = conexion.prepareStatement(script);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "SE HIZO EL REGISTRO DE LA FRANJA");
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "NO SE PUDO HACER EL REGISTRO DE LA FRANJA :(");
			}
			String script2 = "";
			for (int i = 0; i < dias.length; i++) {
				if(dias[i]==true) {
					script2 = "insert into diafranja (id_df, id_dia, id_bloque) values "
							+ " (" + datos[0] + ", " + (i+1) + ", " + datos[0] + ");";
					try {
						ps = conexion.prepareStatement(script2);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "SE HIZO LA RELACION CON DIAFRANJA");
					}catch(Exception e) {
						JOptionPane.showMessageDialog(null, "NO SE PUDO HACER LA RELACION CON DIAFRANJA :(");
					}					
				}
			}
			break;
		case "tipobloque":
			script = "insert into tipobloque (id_tipob, nombre)" + 
					"	values(" + datos[0] + ", " + datos[1] + ");";
			try {
				ps = conexion.prepareStatement(script);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "SE HIZO EL REGISTRO DEL TIPO DE FRANJA");
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "NO SE PUDO HACER EL REGISTRO DEL TIPO DE F :(");
			}
			break;
		}
	}
	public ArrayList<String> consultas(String caso, String tabla){
		Conectar();
		//CONSULTA SOLO PARA OBTENER EL MAXIMO ID POR AHORA
		java.sql.Statement codigoSQL = null;
		ResultSet resultados = null;
		script = "";
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
}
