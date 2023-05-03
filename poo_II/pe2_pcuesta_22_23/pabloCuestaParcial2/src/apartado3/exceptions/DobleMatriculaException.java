package apartado3.exceptions;

/**
 * @author Pablo Cuesta Morer
 * @date 2023-05-02
 */
public class DobleMatriculaException extends Exception {
	private static final long serialVersionUID = -2225499854515478158L;

	public DobleMatriculaException(String message) {
		super(message);
	}
}
