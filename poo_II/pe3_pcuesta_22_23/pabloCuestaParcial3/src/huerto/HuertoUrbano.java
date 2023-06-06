package huerto;

import java.util.ArrayList;
import java.util.List;

public class HuertoUrbano {

	private float tam;
	private ArrayList<Parcela> parcelas;
		
	public HuertoUrbano(float tam) {
		parcelas = new ArrayList<Parcela>();
		this.tam = tam;
	}

	public void addParcela(Parcela p) {
		parcelas.add(p);	
	}

	public float getTam() {		
		return tam;
	}

	public List<Parcela> getParcelas() {
		return parcelas;
	}
}
