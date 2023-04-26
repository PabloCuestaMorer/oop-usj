package pabloCuestaParcial2.apartado1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pablo Cuesta Morer
 * @date 2023-04-26
 */
public class Provincia {

	private String nombreProvincia;
	private List<Persona> personas;

	/**
	 * @param nombreProvincia
	 * @param personas
	 */
	public Provincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
		personas = new ArrayList<>();
	}

	/**
	 * @return the nombreProvincia
	 */
	public String getNombreProvincia() {
		return nombreProvincia;
	}

	/**
	 * @param nombreProvincia the nombreProvincia to set
	 */
	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}

	/**
	 * @return the personas
	 */
	public List<Persona> getPersonas() {
		return personas;
	}

	/**
	 * @param personas the personas to set
	 */
	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	/**
	 * Agrega una persona a la lista de personas disponibles.
	 * 
	 * @param persona La persona a agregar.
	 */
	public void agregarPersona(Persona persona) {
		personas.add(persona);
	}

	@Override
	public String toString() {
		return "\n\tProvincia [nombreProvincia=" + nombreProvincia + ", personas=" + personas + "]";
	}

}
