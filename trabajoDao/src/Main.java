import Modelo.Cliente;
import Dao.ClienteDao;

import java.sql.Date;



public class Main {
  
	public static void main(String args[]) {
		@SuppressWarnings("deprecation")
		Date fecha = new Date(2000,10,8);
		Cliente cl = new Cliente(10, "catalina", "patiño", "F",fecha, 1);
		
		ClienteDao cd = new ClienteDao();
		cd.agregarCliente(cl);
	}
}
