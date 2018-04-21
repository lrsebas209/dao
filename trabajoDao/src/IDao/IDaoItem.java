package IDao;

import java.util.List;
import Modelo.Item;

public interface IDaoItem {
	public boolean agregarItem(Item item);
	public boolean editarItem(Item item);
	public boolean eliminarItem(Item item);
	public List<Item> obtenerItems();
}
