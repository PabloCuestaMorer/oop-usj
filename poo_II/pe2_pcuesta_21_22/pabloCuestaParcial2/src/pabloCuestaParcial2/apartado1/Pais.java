package pabloCuestaParcial2.apartado1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pablo Cuesta Morer
 * @date 2023-04-26
 */
public class Pais {

	private String nombrePais;
	private List<Provincia> provincias;

	/**
	 * @param nombrePais
	 * @param provincias
	 */
	public Pais(String nombrePais) {
		this.nombrePais = nombrePais;
		this.provincias = new ArrayList<>();
	}

	/**
	 * @return the nombrePais
	 */
	public String getNombrePais() {
		return nombrePais;
	}

	/**
	 * @param nombrePais the nombrePais to set
	 */
	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

	/**
	 * @return the provincias
	 */
	public List<Provincia> getProvincias() {
		return provincias;
	}

	/**
	 * @param provincias the provincias to set
	 */
	public void setProvincias(List<Provincia> provincias) {
		this.provincias = provincias;
	}

	/**
	 * Agrega una provincia a la lista de provincias disponibles.
	 * 
	 * @param provincia La provincia a agregar.
	 */
	public void agregarProvincia(Provincia provincia) {
		provincias.add(provincia);
	}

	@Override
	public String toString() {
		return "Pais [nombrePais=" + nombrePais + ", provincias=" + provincias + "]";
	}

}
