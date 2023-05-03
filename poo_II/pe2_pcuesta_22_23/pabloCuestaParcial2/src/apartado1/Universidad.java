package apartado1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pablo Cuesta Morer
 * @date 2023-05-02
 */
public class Universidad {

	private List<Asignatura> asignaturas;
	private List<Matricula> matriculas;

	/**
	 * @param asignaturas
	 * @param matriculas
	 */
	public Universidad() {
		this.asignaturas = new ArrayList<>();
		this.matriculas = new ArrayList<>();
	}

	/**
	 * Agrega una asignatura a la lista de asignaturas disponibles.
	 * 
	 * @param asignatura La asignatura a agregar.
	 */
	public void agregarAsignatura(Asignatura asignatura) {
		asignaturas.add(asignatura);
	}

	/**
	 * Agrega una matricula a la lista de matriculas disponibles.
	 * 
	 * @param matricula La matricula a agregar.
	 */
	public void agregarMatricula(Matricula matricula) {
		matriculas.add(matricula);
	}

	/**
	 * @return the asignaturas
	 */
	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	/**
	 * @param asignaturas the asignaturas to set
	 */
	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	/**
	 * @return the matriculas
	 */
	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	/**
	 * @param matriculas the matriculas to set
	 */
	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	@Override
	public String toString() {
		return "Universidad [asignaturas=" + asignaturas + ", \n\n\tmatriculas=" + matriculas + "]";
	}

}
