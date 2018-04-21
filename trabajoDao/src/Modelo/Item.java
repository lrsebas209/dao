package Modelo;

public class Item {
	
	private int idItem;
	private int tipoItem; 
	private String descripcion;
	private double valor;
    
	public Item(int idItem, int tipoItem, String descripcion, double valor) {
		this.idItem = idItem;
		this.tipoItem = tipoItem;
		this.descripcion = descripcion;
		this.valor = valor;
	}
	
	public int getIdItem() {
		return this.idItem;
	}
	public int getIdTipoItem() {
		return this.tipoItem;
	}
	public String getDescripcion() {
		return this.descripcion;
	}
	public double getValor() {
		return this.valor;
	}
	
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}
	public void setIdTipoItem(int tipoItem) {
		this.tipoItem = tipoItem;
	}
    public void setDescripcion(String descripcion) {
    	this.descripcion = descripcion;
    }
    public void setValor(double valor) {
    	this.valor = valor;
    }
}
