package huerto;

import java.util.ArrayList;
import java.util.List;

public class Parcela {

	private float tam;
	private Cliente cliente;
	private ArrayList<Cultivo> cultivos;

	public Parcela(float tam, Cliente cliente) {
		cultivos = new ArrayList<Cultivo>();
		this.tam = tam;
		this.cliente = cliente;
	}

	public void addCultivo(Cultivo c) {
		cultivos.add(c);
	}

	public List<Cultivo> getCultivos() {
		return cultivos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente newCliente) {
		this.cliente = newCliente;
	}

}
