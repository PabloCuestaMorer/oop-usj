/**
 * 
 */
package pe2_pcuesta_20_21.apartado1;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.2. Crea la clase Parcela, que contenga un tamaño (en metros cuadrados), un
 * Cliente a cargo de la Parcela y una colección de Cultivos. Haz un método
 * añadir Cultivo que reciba como parámetro un Cultivo y lo añada a la
 * colección.
 * 
 * @author Pablo Cuesta Morer
 * @date 2023-04-25
 */
public class Parcela {
	private double dimension;
	private Cliente cliente;
	private List<Cultivo> cultivos;

	public Parcela(double tamaño, Cliente cliente) {
		this.dimension = tamaño;
		this.cliente = cliente;
		this.cultivos = new ArrayList<>();
	}

	public double getDimension() {
		return dimension;
	}

	public void setDimension(double tamaño) {
		this.dimension = tamaño;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cultivo> getCultivos() {
		return cultivos;
	}

	public void setCultivos(List<Cultivo> cultivos) {
		this.cultivos = cultivos;
	}

	/**
	 * 1.2. ...Haz un método añadir Cultivo que reciba como parámetro un Cultivo y
	 * lo añada a la colección
	 * 
	 * @param cultivo
	 */
	public void agregarCultivo(Cultivo cultivo) {
		cultivos.add(cultivo);
	}

	@Override
	public String toString() {
		return "\n\tParcela{" + "dimension=" + dimension + ", cliente='" + cliente + '\'' + ", cultivos=" + cultivos
				+ '}';
	}
}
