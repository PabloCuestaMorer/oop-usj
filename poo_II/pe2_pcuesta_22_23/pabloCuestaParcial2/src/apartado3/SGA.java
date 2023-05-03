package apartado3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import apartado1.Asignatura;
import apartado1.Matricula;
import apartado1.Universidad;
import apartado3.exceptions.AsignaturaNotFoundException;
import apartado3.exceptions.AsignaturaSinAlumnosException;
import apartado3.exceptions.DobleMatriculaException;

/**
 * @author Pablo Cuesta Morer
 * @date 2023-05-02
 */
public class SGA {

	public static void informeMatricula(Path path, Universidad universidad) {
		if (!Files.exists(path)) {
			try {
				Files.createDirectories(path);
			} catch (IOException e) {
				System.err.println("Error al crear el directorio: " + e.getMessage());
				return;
			}
		}

		for (Matricula matricula : universidad.getMatriculas()) {
			int idAlumno = matricula.getAlumno().getId();
			Path alumnoPath = path.resolve(String.valueOf(idAlumno));

			if (!Files.exists(alumnoPath)) {
				try {
					Files.createDirectory(alumnoPath);
				} catch (IOException e) {
					System.err.println("Error al crear el directorio del alumno: " + e.getMessage());
					continue;
				}
			}

			matricula.getAsignaturas().forEach(asignatura -> {
				File file = new File(alumnoPath.toFile(), String.valueOf(asignatura.getId()));
				try (FileWriter writer = new FileWriter(file)) {
					writer.write(asignatura.getNombre() + " " + asignatura.getCreditosECTS() + " creditos ECTS");
				} catch (IOException e) {
					System.err.println("Error al escribir el archivo de la asignatura: " + e.getMessage());
				}
			});
		}
	}

	public static void informeProfesores(Universidad universidad) {
		Map<Integer, Integer> asignaturaAlumnos = new HashMap<>();

		for (Matricula matricula : universidad.getMatriculas()) {
			for (Asignatura asignatura : matricula.getAsignaturas()) {
				int idAsignatura = asignatura.getId();
				asignaturaAlumnos.put(idAsignatura, asignaturaAlumnos.getOrDefault(idAsignatura, 0) + 1);
			}
		}

		for (Asignatura asignatura : universidad.getAsignaturas()) {
			int idAsignatura = asignatura.getId();
			int numAlumnosMatriculados = asignaturaAlumnos.getOrDefault(idAsignatura, 0);
			System.out.println(idAsignatura + " " + numAlumnosMatriculados);
		}
	}

	public static void validarDatos(Universidad universidad)
			throws DobleMatriculaException, AsignaturaNotFoundException, AsignaturaSinAlumnosException {
		Set<Integer> asignaturas = new HashSet<>();
		Map<Integer, Integer> asignaturaAlumnos = new HashMap<>();

		for (Asignatura asignatura : universidad.getAsignaturas()) {
			asignaturas.add(asignatura.getId());
		}

		for (Matricula matricula : universidad.getMatriculas()) {
			Set<Integer> asignaturasMatriculadas = new HashSet<>();
			for (Asignatura asignatura : matricula.getAsignaturas()) {
				int idAsignatura = asignatura.getId();

				if (!asignaturas.contains(idAsignatura)) {
					throw new AsignaturaNotFoundException(
							"Alumno con matricula en una asignatura que no existe: " + idAsignatura);
				}

				if (asignaturasMatriculadas.contains(idAsignatura)) {
					throw new DobleMatriculaException(
							"Alumno matriculado dos veces en la misma asignatura: " + idAsignatura);
				}

				asignaturasMatriculadas.add(idAsignatura);
				asignaturaAlumnos.put(idAsignatura, asignaturaAlumnos.getOrDefault(idAsignatura, 0) + 1);
			}
		}

		for (Asignatura asignatura : universidad.getAsignaturas()) {
			int idAsignatura = asignatura.getId();
			int numAlumnosMatriculados = asignaturaAlumnos.getOrDefault(idAsignatura, 0);
			if (numAlumnosMatriculados == 0) {
				throw new AsignaturaSinAlumnosException(
						"Una asignatura no tiene ningun alumno matriculado: " + idAsignatura);
			}
		}
	}

}
