package apartado2;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import apartado1.Alumno;
import apartado1.Asignatura;
import apartado1.Universidad;

/**
 * @author Pablo Cuesta Morer
 * @date 2023-05-02
 */
public class Ejercicio2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int totalCreditos = 240;
		int minCreditos = 3;
		int maxCreditos = 9;
		int asignaturasPorAlumno = 10;

		Set<Integer> ids = generarIdsAleatorios(10, 1000, 9999);
		Set<Alumno> alumnos = HelperUniversidad.createAlumnos(ids);
		List<Asignatura> asignaturas = HelperUniversidad.createAsignaturas(totalCreditos, minCreditos, maxCreditos);

		Universidad universidad = HelperUniversidad.createUniversidad(asignaturas, alumnos, asignaturasPorAlumno);

		int sumaEcts = 0;
		for (Asignatura asignatura : universidad.getAsignaturas()) {
			sumaEcts += asignatura.getCreditosECTS();
		}

		System.out.println("Suma de ECTS de todas las asignaturas: " + sumaEcts);
		System.out.println(universidad);
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
