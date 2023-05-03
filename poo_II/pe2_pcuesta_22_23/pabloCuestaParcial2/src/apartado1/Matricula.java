package apartado1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pablo Cuesta Morer
 * @date 2023-05-02
 */
public class Matricula {
	private Alumno alumno;
	private List<Asignatura> asignaturas;

	/**
	 * @param alumno
	 * @param asignaturas
	 */
	public Matricula(Alumno alumno) {
		this.alumno = alumno;
		this.asignaturas = new ArrayList<>();
	}

	/**
	 * Agrega una asignatura a la lista de asignaturas disponibles.
	 * 
	 * @param asignatura La asignatra a agregar.
	 */
	public void agregarAsignatura(Asignatura asignatura) {
		asignaturas.add(asignatura);
	}

	/**
	 * Devuelve el numero de asignaturas de las que esta matriculado el alumno.
	 * 
	 * @return int numero de asignaturas
	 */
	public int getNumeroAsignaturas() {
		return this.asignaturas.size();

	}

	/**
	 * @return the alumno
	 */
	public Alumno getAlumno() {
		return alumno;
	}

	/**
	 * @param alumno the alumno to set
	 */
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
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

	@Override
	public String toString() {
		return "\n\t\tMatricula [alumno=" + alumno + ", asignaturas=" + asignaturas + "]";
	}

}
