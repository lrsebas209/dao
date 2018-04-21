package IDao;

import java.util.List;

import Modelo.Cliente;
public interface IDaoCliente {
	public boolean agregarCliente(Cliente cliente);
	public boolean editarCliente(Cliente cliente);
	public boolean eliminarCliente(Cliente cliente);
	public List<Cliente> obtenerCLiente();
}
