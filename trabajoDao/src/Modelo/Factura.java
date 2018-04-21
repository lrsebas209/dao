package Modelo;

import java.util.ArrayList;
import java.util.Date;

public class Factura {
	
	private int idFactura;
	private Date fechaFactura;
	private Cliente cliente;
	private double totalFactura;
	private String estado;
	private ArrayList<Item>items = new ArrayList<>();
	
	
	public Factura(int idFactura, Date fechaFactura, Cliente Cliente, double totalFactura, String estado) {
		this.idFactura = idFactura;
		this.fechaFactura = fechaFactura;
		this.cliente = Cliente;
		this.totalFactura = totalFactura;
		this.estado = estado;
	}
	
	public int getIdFactura () {
		return this.idFactura;
	}
	
	public Date getFechaFactura() {
		return this.fechaFactura;
	}
	public Cliente getCliente() {
		return this.cliente;
	}
	public double getTotalFactura() {
		return this.totalFactura;
	}
	public String getEstado() {
		return this.estado;
	}
	
	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}
	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
}
