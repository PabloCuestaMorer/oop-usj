package pe2_pcuesta_20_21.apartado1;

import java.util.ArrayList;
import java.util.List;

import pe2_pcuesta_20_21.apartado2.NECESIDADES_AGUA;
import pe2_pcuesta_20_21.apartado4.AguaInsuficienteException;

/**
 * 1.3. Crea la clase HuertoUrbano, que contenga un tamaño (en metros cuadrados)
 * y una colección de Parcelas. Haz un método añadir parcela que reciba como
 * parámetro una Parcela y la añada a la colección.
 * 
 * @author Pablo Cuesta Morer
 * @date 2023-04-25
 */
public class HuertoUrbano {
	private double tamaño;
	private List<Parcela> parcelas;

	public HuertoUrbano(double tamaño) {
		this.tamaño = tamaño;
		this.parcelas = new ArrayList<>();
	}

	public double getTamaño() {
		return tamaño;
	}

	public void setTamaño(double tamaño) {
		this.tamaño = tamaño;
	}

	public List<Parcela> getParcelas() {
		return parcelas;
	}

	public void setParcelas(List<Parcela> parcelas) {
		this.parcelas = parcelas;
	}

	/**
	 * 1.3 ...Haz un método añadir parcela que reciba como parámetro una Parcela y
	 * la añada a la colección.
	 * 
	 * @param parcela
	 */
	public void agregarParcela(Parcela parcela) {
		parcelas.add(parcela);
	}

	/**
	 * 4.1 ...y un método en la clase HuertoUrbano llamado regar que reciba como
	 * parámetro de entrada un número de litros de agua. Cada cultivo con
	 * necesidades de agua altas consume 3 litros por planta, si las necesidades son
	 * medias 2 litros de agua por planta y si las necesidades son bajas 1 litro por
	 * planta. Cuando termine de regar todas las plantas de todos los cultivos de
	 * todas las parcelas del huerto imprimirá por pantalla un mensaje (“He regado
	 * todo”). Si se queda sin agua durante el riego haz que lance la excepción que
	 * has creado.
	 * 
	 * @param litrosDeAgua
	 * @throws AguaInsuficienteException
	 */
	public void regar(int litrosDeAgua) throws AguaInsuficienteException {
		for (Parcela parcela : parcelas) {
			for (Cultivo cultivo : parcela.getCultivos()) {
				int consumoDeAgua = 0;
				if (NECESIDADES_AGUA.ALTA.toString().equals(cultivo.getNecesidadesDeAgua())) {
					consumoDeAgua = 3;
				} else if (NECESIDADES_AGUA.MEDIA.toString().equals(cultivo.getNecesidadesDeAgua())) {
					consumoDeAgua = 2;
				} else if (NECESIDADES_AGUA.BAJA.toString().equals(cultivo.getNecesidadesDeAgua())) {
					consumoDeAgua = 1;
				}

				for (int i = 0; i < cultivo.getCantidadDePlantas(); i++) {
					if (litrosDeAgua >= consumoDeAgua) {
						litrosDeAgua -= consumoDeAgua;
					} else {
						throw new AguaInsuficienteException("No hay suficiente agua para regar todas las plantas");
					}
				}
			}
		}
		System.out.println("He regado todo!!");
	}

	@Override
	public String toString() {
		return "HuertoUrbano{" + "tamaño=" + tamaño + ", parcelas=\n" + parcelas + "}";
	}
}
