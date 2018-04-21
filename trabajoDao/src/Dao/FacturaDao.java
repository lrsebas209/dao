package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Conexion.Conexion;
import IDao.IDaoFactura;
import Modelo.Cliente;
import Modelo.Factura;

public class FacturaDao implements IDaoFactura{

	@Override
	public boolean agregarFactura(Factura factura) {
		boolean completo = false;
		Statement stm = null;
		Connection con = null;

		String sql = "INSERT INTO facturas.factura values ( '" + factura.getIdFactura() + "','" + factura.getFechaFactura()
			+ "','" + factura.getCliente().getIdCliente() + "','" + factura.getTotalFactura() + "','" + factura	.getEstado() + "')";
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
	public boolean elimianrFactura(Factura factura) {
		Connection con =  null;
        Statement stm = null;
        
        boolean completado = false;
        
        String sql = "DELETE FROM factura.factura WHERE idFactura="+factura.getIdFactura();
        
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
	public boolean editarFactura(Factura factura) {
		Connection con = null;
		Statement stm = null;
		boolean completo = false;

		String sql = "UPDATE facturas.factura SET fecha='" + factura.getIdFactura() + "', cliente='" + factura.getCliente().getIdCliente()
				+ "',total_factura='" + factura.getTotalFactura() + "',estado='" + factura.getEstado() + "' WHERE idFactura="
				+ factura.getIdFactura();
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
	public List<Factura> obtenerFactura() {
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM facturas.factura ORDER BY idFactura";

		List<Factura> listaFacturas = new ArrayList<Factura>();

		try {
			con = Conexion.conectar();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
			    String sql2 = "select * from facturas.cliente where idCliente='"+ rs.getInt(3)+"'";
			    Connection con2 = Conexion.conectar();
				Statement stm2 = con2.createStatement();
			    ResultSet rs2 = stm2.executeQuery(sql2);
			    Cliente cl = new Cliente(rs2.getInt(1),rs2.getString(2),rs2.getString(3),rs2.getString(4),rs2.getDate(5),rs2.getInt(6));		    
			    stm2.close();
				rs2.close();
				con2.close();			    
				Factura fa = new Factura(rs.getInt(1), rs.getDate(2), cl, rs.getDouble(4), rs.getString(5));
				listaFacturas.add(fa);
			}
			stm.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("error en mostrar   " + e);
		}
		return listaFacturas;
	}

}
