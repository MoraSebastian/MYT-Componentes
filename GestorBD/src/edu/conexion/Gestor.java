package edu.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Gestor {
	public Connection conexion = null;	
	protected PreparedStatement ps = null;
	protected java.sql.Statement codigoSQL = null;
	protected ResultSet resultados = null;
	String pass = "CualColoco";
	String user = "postgres";
	protected String script = "";
	public void Conectar() {
		try {
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
	    	System.out.println("EMPEZANDO A CREAR");
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
