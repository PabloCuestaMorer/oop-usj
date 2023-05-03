package apartado3.exceptions;

/**
 * @author Pablo Cuesta Morer
 * @date 2023-05-02
 */
public class AsignaturaSinAlumnosException extends Exception {
	private static final long serialVersionUID = 7066488577932395846L;

	public AsignaturaSinAlumnosException(String message) {
		super(message);
	}
}
