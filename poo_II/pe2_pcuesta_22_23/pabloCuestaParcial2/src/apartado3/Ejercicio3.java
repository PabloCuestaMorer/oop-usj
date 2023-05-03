package apartado3;

import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import apartado1.Alumno;
import apartado1.Asignatura;
import apartado1.Matricula;
import apartado1.Universidad;
import apartado2.HelperUniversidad;
import apartado3.exceptions.AsignaturaNotFoundException;
import apartado3.exceptions.AsignaturaSinAlumnosException;
import apartado3.exceptions.DobleMatriculaException;

/**
 * @author Pablo Cuesta Morer
 * @date 2023-05-02
 */
public class Ejercicio3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Universidad universidadValida = createUniversidadValida();

		// Probar informeMatricula
		SGA.informeMatricula(Paths.get("informe_matricula"), universidadValida);

		// Probar informeProfesores
		System.out.println(universidadValida.toString());
		SGA.informeProfesores(universidadValida);

		Universidad[] universidadesAnomalas = new Universidad[] { createUniversidadDobleMatricula(),
				createUniversidadAsignaturaNoEncontrada(), createUniversidadAsignaturaSinAlumnos() };

		for (Universidad universidad : universidadesAnomalas) {
			try {
				SGA.validarDatos(universidad);
			} catch (DobleMatriculaException | AsignaturaNotFoundException | AsignaturaSinAlumnosException e) {
				System.out.println("Error en la validación: " + e.getMessage());
			}
		}

	}

	public static Universidad createUniversidadDobleMatricula() {
		// Crea una Universidad con un Alumno matriculado dos veces en la misma
		// asignatura
		Universidad universidad = new Universidad();
		Asignatura asignatura = new Asignatura("Asignatura1", 6);
		universidad.agregarAsignatura(asignatura);

		Alumno alumno = new Alumno(1000, "John", "Doe");
		Matricula matricula = new Matricula(alumno);
		matricula.agregarAsignatura(asignatura);
		matricula.agregarAsignatura(asignatura);
		universidad.agregarMatricula(matricula);

		return universidad;
	}

	public static Universidad createUniversidadAsignaturaNoEncontrada() {
		// Crea una Universidad con un Alumno matriculado en una asignatura que no
		// existe
		Universidad universidad = new Universidad();
		Asignatura asignatura = new Asignatura("Asignatura1", 6);

		Alumno alumno = new Alumno(1000, "John", "Doe");
		Matricula matricula = new Matricula(alumno);
		matricula.agregarAsignatura(asignatura);
		universidad.agregarMatricula(matricula);

		return universidad;
	}

	public static Universidad createUniversidadAsignaturaSinAlumnos() {
		// Crea una Universidad con una asignatura sin alumnos matriculados
		Universidad universidad = new Universidad();
		Asignatura asignatura = new Asignatura("Asignatura1", 6);
		universidad.agregarAsignatura(asignatura);

		return universidad;
	}

	public static Universidad createUniversidadValida() {
		int totalCreditos = 240;
		int minCreditos = 3;
		int maxCreditos = 9;
		int asignaturasPorAlumno = 10;

		Set<Integer> ids = generarIdsAleatorios(10, 1000, 9999);
		Set<Alumno> alumnos = HelperUniversidad.createAlumnos(ids);
		List<Asignatura> asignaturas = HelperUniversidad.createAsignaturas(totalCreditos, minCreditos, maxCreditos);

		Universidad universidad = HelperUniversidad.createUniversidad(asignaturas, alumnos, asignaturasPorAlumno);

//		System.out.println(universidad);
		return universidad;
	}

	private static Set<Integer> generarIdsAleatorios(int numIds, int minValue, int maxValue) {
		Set<Integer> ids = new HashSet<>();
		Random rand = new Random();

		while (ids.size() < numIds) {
			int randomId = rand.nextInt(minValue, maxValue);
			ids.add(randomId);
		}

		return ids;
	}

}
