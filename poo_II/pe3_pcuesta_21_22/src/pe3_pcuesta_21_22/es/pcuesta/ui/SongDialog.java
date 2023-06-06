package pe3_pcuesta_21_22.es.pcuesta.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import pe3_pcuesta_21_22.es.pcuesta.music.Cancion;
import pe3_pcuesta_21_22.es.pcuesta.music.Style;

/**
 * @author Pablo Cuesta Morer
 * @date 2023-06-01
 */

public class SongDialog extends JDialog {

	private static final long serialVersionUID = -6672080399037540991L;

	private JTextField txtNombre;
	private JSpinner spnDuracion;
	private JSpinner spnYear;
	private JComboBox<Style> cboEstilo;
	private boolean confirmed = false;
	private Cancion cancion;

	public SongDialog(JFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		setSize(300, 200);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel(new GridLayout(5, 2));

		panel.add(new JLabel("Nombre:"));
		txtNombre = new JTextField();
		panel.add(txtNombre);

		panel.add(new JLabel("Duración:"));
		spnDuracion = new JSpinner(new SpinnerNumberModel(1, 1, 600, 1));
		panel.add(spnDuracion);

		panel.add(new JLabel("Año:"));
		spnYear = new JSpinner(new SpinnerNumberModel(1900, 1900, 2050, 1));
		panel.add(spnYear);

		panel.add(new JLabel("Estilo:"));
		cboEstilo = new JComboBox<>(Style.values());
		panel.add(cboEstilo);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(e -> {
			cancion = new Cancion(txtNombre.getText(), (int) spnDuracion.getValue(), (int) spnYear.getValue(),
					(Style) cboEstilo.getSelectedItem());
			confirmed = true;
			setVisible(false);
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(e -> {
			confirmed = false;
			setVisible(false);
		});

		panel.add(btnAceptar);
		panel.add(btnCancelar);

		getContentPane().add(panel, BorderLayout.CENTER);
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public Cancion getCancion() {
		return cancion;
	}
}
