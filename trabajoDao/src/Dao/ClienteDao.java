package Dao;
import java.util.List;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conexion.Conexion;
import IDao.IDaoCliente;
import Modelo.Cliente;


public class ClienteDao implements IDaoCliente {

	public ClienteDao(){}
	@Override
	public boolean agregarCliente(Cliente cliente) {
		boolean completo = false;
		
		Statement stm = null;
		Connection con = null;
		
		String sql = "INSERT INTO facturas.cliente values ( '" + cliente.getIdCliente() +"','"+ cliente.getNombre() +"','"+ cliente.getApellido()+"','"+ cliente.getGenero()+"','"+cliente.getFechaNacimiento()+"','" +cliente.getIdEstado()+"')"; 
        try{
            con = Conexion.conectar();
            stm = con.createStatement();
            stm.execute(sql);
            completo = true;
            stm.close();
            con.close();
        } catch( SQLException e){
            System.out.println("a ocurrido un error  y es este   " + e);
        }
		return completo;
	}

	@Override
	public boolean editarCliente(Cliente cliente) {
		Connection con = null;
		Statement stm = null;
		boolean completo = false;

		String sql = "UPDATE facturas.cliente SET nombre='" + cliente.getNombre() + "', apellido='" + cliente.getApellido()
				+ "',genero='" + cliente.getGenero() + "',fecha_nacimiento='" + cliente.getFechaNacimiento() + "',estado_civil='"+cliente.getIdEstado()+"' WHERE idCliente="
				+ cliente.getIdCliente();
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
	public boolean eliminarCliente(Cliente cliente) {
		Connection con =  null;
        Statement stm = null;
        
        boolean completado = false;
        
        String sql = "DELETE FROM factura.cliente WHERE idCliente="+cliente.getIdCliente();
        
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
	public List<Cliente> obtenerCLiente() {
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM factura.cliente ORDER BY idCliente";

		List<Cliente> listaClientes = new ArrayList<Cliente>();

		try {
			con = Conexion.conectar();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				Cliente cl = new Cliente(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getInt(6));
				listaClientes.add(cl);
			}
			stm.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("error en obteenr y es  " + e);
		}
		return listaClientes;
	}
       
}
