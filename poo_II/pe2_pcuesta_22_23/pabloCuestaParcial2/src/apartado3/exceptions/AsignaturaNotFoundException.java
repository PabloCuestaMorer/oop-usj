package apartado3.exceptions;

/**
 * @author Pablo Cuesta Morer
 * @date 2023-05-02
 */
public class AsignaturaNotFoundException extends Exception {
	private static final long serialVersionUID = 8481190294528949024L;

	public AsignaturaNotFoundException(String message) {
		super(message);
	}
}
