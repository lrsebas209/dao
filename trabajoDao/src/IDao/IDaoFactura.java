package IDao;

import java.util.List;
import Modelo.Factura;

public interface IDaoFactura {
	public boolean agregarFactura(Factura factura);
	public boolean elimianrFactura(Factura factura);
	public boolean editarFactura(Factura factura);
	public List<Factura> obtenerFactura();
}
