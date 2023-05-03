package apartado2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import apartado1.Alumno;
import apartado1.Asignatura;
import apartado1.Matricula;
import apartado1.Universidad;

/**
 * @author Pablo Cuesta Morer
 * @date 2023-05-02
 */
public class HelperUniversidad {

	public static Set<Alumno> createAlumnos(Set<Integer> ids) {
		Set<Alumno> alumnos = new HashSet<>();
		Random rand = new Random();

		for (Integer id : ids) {
			int unidades = id % 10;
			int decenas = (id / 10) % 10;

			StringBuilder nombreBuilder = new StringBuilder();
			StringBuilder apellidoBuilder = new StringBuilder();

			for (int i = 0; i < unidades; i++) {
				char randomChar = (char) (rand.nextInt(26) + 'a');
				nombreBuilder.append(randomChar);
			}

			for (int i = 0; i < decenas; i++) {
				char randomChar = (char) (rand.nextInt(26) + 'a');
				apellidoBuilder.append(randomChar);
			}

			Alumno alumno = new Alumno(id, nombreBuilder.toString(), apellidoBuilder.toString());
			alumnos.add(alumno);
		}

		return alumnos;
	}

	public static List<Asignatura> createAsignaturas(int totalCreditos, int minCreditos, int maxCreditos) {
		List<Asignatura> asignaturas = new ArrayList<>();
		Random rand = new Random();
		int creditosRestantes = totalCreditos;
		int contador = 1;

		while (creditosRestantes > 0) {
			int creditosAsignatura = rand.nextInt((maxCreditos - minCreditos) + 1) + minCreditos;

			if (creditosAsignatura <= creditosRestantes) {
				Asignatura asignatura = new Asignatura("Asignatura" + contador, creditosAsignatura);
				asignaturas.add(asignatura);
				creditosRestantes -= creditosAsignatura;
				contador++;
			} else {
				// Si los créditos de la asignatura superan los créditos restantes, ajustamos el
				// valor
				Asignatura asignatura = new Asignatura("Asignatura" + contador, creditosRestantes);
				asignaturas.add(asignatura);
				creditosRestantes = 0;
			}
		}

		return asignaturas;
	}

	public static Universidad createUniversidad(List<Asignatura> asignaturas, Set<Alumno> alumnos,
			int asignaturasPorAlumno) {
		Universidad universidad = new Universidad();

		for (Asignatura asignatura : asignaturas) {
			universidad.agregarAsignatura(asignatura);
		}

		for (Alumno alumno : alumnos) {
			Matricula matricula = new Matricula(alumno);

			List<Asignatura> asignaturasDisponibles = new ArrayList<>(asignaturas);
			Collections.shuffle(asignaturasDisponibles);
			for (int i = 0; i < asignaturasPorAlumno && i < asignaturasDisponibles.size(); i++) {
				matricula.agregarAsignatura(asignaturasDisponibles.get(i));
			}

			universidad.agregarMatricula(matricula);
		}

		return universidad;
	}

}
