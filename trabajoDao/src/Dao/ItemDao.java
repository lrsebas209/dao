package Dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Conexion.Conexion;
import IDao.IDaoItem;
import Modelo.Item;

public class ItemDao implements IDaoItem{

	@Override
	public boolean agregarItem(Item item) {
		boolean completo = false;
		Statement stm = null;
		Connection con = null;

		String sql = "INSERT INTO facturas.item values ( '" + item.getIdItem() + "','" + item.getIdTipoItem()+ "','" + item.getDescripcion() + "','" + item.getValor() + "')";
		try {
			con = Conexion.conectar();
			stm = con.createStatement();
			stm.execute(sql);
			completo = true;
			stm.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("a ocurrido un error  y es este   " + e);
		}
		return completo;

	}

	@Override
	public boolean editarItem(Item item) {
		Connection con = null;
		Statement stm = null;
		boolean completo = false;

		String sql = "UPDATE facturas.item SET tipo_item='" + item.getIdTipoItem() + "', descripcion='" + item.getDescripcion()
				+ "',valor='" + item.getValor() + "' WHERE idCliente="
				+ item.getIdItem();
		try {
			con = Conexion.conectar();
			stm = con.createStatement();
			stm.execute(sql);
			completo = true;
		} catch (SQLException e) {
			System.out.println("a ocurrido un error y es este " + e);
		}
		return completo;
	}

	@Override
	public boolean eliminarItem(Item item) {
		Connection con =  null;
        Statement stm = null;
        
        boolean completado = false;
        
        String sql = "DELETE FROM factura.item WHERE iditem="+item.getIdItem();
        
        try{
            con = Conexion.conectar();
            stm = con.createStatement();
            stm.execute(sql);
            completado = false;
        }catch( SQLException e){
            System.out.println("error de eliminar por " + e);
        }
        return completado;
	}

	@Override
	public List<Item> obtenerItems() {
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM factura.item ORDER BY iditem";

		List<Item> listaItems= new ArrayList<Item>();

		try {
			con = Conexion.conectar();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				Item it = new Item(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getDouble(4));
				listaItems.add(it);
			}
			stm.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("error en obteenr y es  " + e);
		}
		return listaItems;
		
	}

}
