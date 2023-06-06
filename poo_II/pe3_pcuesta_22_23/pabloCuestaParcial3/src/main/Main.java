package main;
import javax.swing.SwingUtilities;

import huerto.HuertoHelper;
import huerto.HuertoUrbano;
import ui.GUI;

/**
 * @author Pablo Cuesta Morer
 * @date 2023-06-02
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			HuertoUrbano huerto = HuertoHelper.createHuertoExamen();
			GUI gui = new GUI(huerto);
		});
	}

}
