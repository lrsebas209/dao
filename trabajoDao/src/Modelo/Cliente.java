package Modelo;

import java.util.Date;
import java.util.HashMap;

public class Cliente {
	
	private int idCliente;
	private String nombre;
	private String apellido;
	private Date fecha_nacimiento;
	private String genero;
	private int idEstado;
	HashMap<Integer,String> estados;
	
	public Cliente(int idCliente, String nombre, String apellido,  String genero, Date fecha_nacimiento,int idEstado){
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_nacimiento = fecha_nacimiento;
		this.genero = genero;
		this.idEstado = idEstado;
		estados = new HashMap<>();
		estados.put(1,"casado");
		estados.put(2,"soltero");
		estados.put(3,"otro");
	}
	
	public int getIdCliente() {
		return this.idCliente;
	}
	public String getNombre() {
		return this.nombre;
	}
	public String getApellido() {
		return this.apellido;
	}
	public Date getFechaNacimiento() {
		return this.fecha_nacimiento;
	}
	public String getGenero() {
		return this.genero;
	}
	public int getIdEstado() {
		return this.idEstado;
	}
	
	public void setIdCliente(int idCliente) {
		 this.idCliente = idCliente;
	}
	public void setNombre(String nombre) {
	    this.nombre = nombre;
	}
	public void setApellido(String apellido) {
	    this.apellido = apellido;
	}
	public void setFechaNacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	
}
