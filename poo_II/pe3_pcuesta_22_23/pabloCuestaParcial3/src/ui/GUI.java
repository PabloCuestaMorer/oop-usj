package ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import huerto.Agua;
import huerto.Cultivo;
import huerto.HuertoHelper;
import huerto.HuertoUrbano;
import huerto.Parcela;

/**
 * Esta clase se encarga de crear la interfaz gráfica para administrar un huerto
 * urbano.
 * 
 * @author Pablo Cuesta Morer
 * @date 2023-06-02
 */
public class GUI extends JFrame {
	private static final long serialVersionUID = 1L;

	// Componentes de la interfaz

	JSplitPane splitPane;
	private JLabel statusLabel;
	private MyTableModel tableModel;
	private HuertoUrbano huerto;

	public GUI(HuertoUrbano huerto) {
		this.huerto = huerto;
		initialize(huerto);
	}

	private void initialize(HuertoUrbano huerto) {
		setTitle("Huerto Urbano");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		addMenuBar();

		addStatusLabel();
		addSplitPane(huerto);

		setVisible(true);
	}

	private void addStatusLabel() {
		statusLabel = new JLabel("Status:");
		add(statusLabel, BorderLayout.SOUTH);
	}

	public void setStatus(String status) {
		statusLabel.setText("Status: " + status);
	}

	private void addSplitPane(HuertoUrbano huerto) {
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setDividerLocation(0.3); // establecer la división inicial en 30%
		add(splitPane, BorderLayout.CENTER);

		splitPane.setLeftComponent(createTree(huerto));
		splitPane.setRightComponent(createTable());
	}

	private JScrollPane createTree(HuertoUrbano huerto) {
		MyDataModel dataModel = new MyDataModel(huerto);
		JTree tree = new JTree(dataModel);
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				handleTreeSelection(e, huerto);
			}
		});
		return new JScrollPane(tree);
	}

	private void handleTreeSelection(TreeSelectionEvent e, HuertoUrbano huerto) {
		String selectedNode = e.getPath().getLastPathComponent().toString();
		if (selectedNode.startsWith("Parcela del cliente con id ")) {
			try {
				int id = Integer.parseInt(selectedNode.substring(26).trim());
				updateParcelInfo(id, huerto);
			} catch (NumberFormatException exception) {
				tableModel.setParcela(null, huerto.getParcelas());
			}
		} else {
			tableModel.setParcela(null, huerto.getParcelas());
		}
	}

	private JScrollPane createTable() {
		tableModel = new MyTableModel(null, huerto.getParcelas());
		JTable table = new JTable(tableModel);
		return new JScrollPane(table);
	}

	private void updateParcelInfo(int id, HuertoUrbano huerto) {
		for (Parcela parcela : huerto.getParcelas()) {
			if (parcela.getCliente().getID() == id) {
				setStatus("Parcela del cliente " + id + " con " + parcela.getCultivos().size()
						+ " cultivos seleccionada.");
				// Setea parcelas a la tabla una vez clickado el huerto
				tableModel.setParcela(parcela, huerto.getParcelas());
				break;
			}
		}
	}

	private void addMenuBar() {
		JMenuBar menuBar = new JMenuBar();

		JMenu optionsMenu = new JMenu("Options");
		JMenuItem resetMenuItem = new JMenuItem("Reset");
		JMenuItem addCultivoMenuItem = new JMenuItem("AddCultivo");

		resetMenuItem.addActionListener(e -> resetHuerto());
		addCultivoMenuItem.addActionListener(e -> new AddCultivoDialog(huerto));

		optionsMenu.add(resetMenuItem);
		optionsMenu.add(addCultivoMenuItem);

		menuBar.add(optionsMenu);
		setJMenuBar(menuBar);
	}

	private void resetHuerto() {
		huerto = HuertoHelper.createHuertoExamen();
		// Notifco al JTree y al JTable
		updateTree(huerto);
		updateTable(huerto);
	}

	private void updateTree(HuertoUrbano huerto) {
		MyDataModel dataModel = new MyDataModel(huerto);
		JTree tree = new JTree(dataModel);
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				handleTreeSelection(e, huerto);
			}
		});
		JScrollPane treeScrollPane = new JScrollPane(tree);
		splitPane.setLeftComponent(treeScrollPane);
	}

	private void updateTable(HuertoUrbano huerto) {
		tableModel = new MyTableModel(null, huerto.getParcelas());
		JTable table = new JTable(tableModel);
		JScrollPane tableScrollPane = new JScrollPane(table);
		splitPane.setRightComponent(tableScrollPane);
	}

	private class AddCultivoDialog extends JDialog {
		private JTextField nombreCultivo;
		private JSlider plantasSlider;
		private ButtonGroup aguaButtGroup;

		public AddCultivoDialog(HuertoUrbano huerto) {
			super(GUI.this, "Añadir Cultivo", true);
			// 4.2.1 Layout de 4 filas y 2 columnas
			setLayout(new GridLayout(4, 2));

			/*
			 * 4.2.2. La primera fila mostrará un label para el nombre y un textfield para
			 * escribir el nombre.
			 */
			add(new JLabel("Nombre: "));
			nombreCultivo = new JTextField(10);
			add(nombreCultivo);
			/*
			 * 4.2.3. La segunda fila mostrará un label para el Agua y un grupo de 3 radio
			 * buttons que permitan seleccionar las necesidades de agua (alta/media/baja).
			 * Solo una puede estar seleccionada al mismo tiempo.
			 */
			add(new JLabel("Agua: "));
			aguaButtGroup = new ButtonGroup();
			JPanel radioPanel = new JPanel(new GridLayout(1, 3));
			JRadioButton botonAlta = new JRadioButton("Alta");
			botonAlta.setActionCommand(Agua.alta.toString());
			JRadioButton botonMedia = new JRadioButton("Media");
			botonMedia.setActionCommand(Agua.media.toString());
			JRadioButton botonBaja = new JRadioButton("Baja");
			botonBaja.setActionCommand(Agua.baja.toString());
			aguaButtGroup.add(botonAlta);
			aguaButtGroup.add(botonMedia);
			aguaButtGroup.add(botonBaja);
			radioPanel.add(botonAlta);
			radioPanel.add(botonMedia);
			radioPanel.add(botonBaja);
			add(radioPanel);

			/*
			 * 4.2.4. La tercera fila mostrará una label para el número de plantas y un
			 * slider que permita seleccionar de 0 a 100 plantas. El slider debe mostrar los
			 * valores de 10 en 10
			 */
			add(new JLabel("Número de plantas: "));
			plantasSlider = new JSlider(0, 100, 10);
			plantasSlider.setMajorTickSpacing(10);
			plantasSlider.setPaintTicks(true);
			plantasSlider.setPaintLabels(true);
			add(plantasSlider);

			/*
			 * 4.2.5. La última fila mostrará dos botones, uno para aceptar y otro para
			 * cancelar. Si se cancela, el dialogo se cierra. Si se acepta, se crea un
			 * Cultivo con los datos introducidos por el usuario y se añade a una Parcela al
			 * azar de las existentes en el HuertoUrbano actual. Debes mostrar por la línea
			 * de status la parcela a la que ha sido asignado.
			 * 
			 */
			JButton acceptButton = new JButton("Aceptar");
			JButton cancelButton = new JButton("Cancelar");
			acceptButton.addActionListener(e -> acceptAction(huerto));
			cancelButton.addActionListener(e -> dispose());
			add(acceptButton);
			add(cancelButton);

			pack();
			setLocationRelativeTo(GUI.this);
			setVisible(true);
		}

		private void acceptAction(HuertoUrbano huerto) {
			String nombre = nombreCultivo.getText();
			Agua necesidadesAgua = null;
			ButtonModel seleccion = aguaButtGroup.getSelection();
			if (seleccion != null) {
				String seleccionAgua = seleccion.getActionCommand();
				if ("alta".equals(seleccionAgua)) {
					necesidadesAgua = Agua.alta;
				} else if ("media".equals(seleccionAgua)) {
					necesidadesAgua = Agua.media;
				} else if ("baja".equals(seleccionAgua)) {
					necesidadesAgua = Agua.baja;
				}
			}
			int numeroPlantas = plantasSlider.getValue();

			Cultivo nuevoCultivo = new Cultivo(nombre, necesidadesAgua, numeroPlantas);

			List<Parcela> parcelas = huerto.getParcelas();
			if (!parcelas.isEmpty()) {
				int randomIndex = ThreadLocalRandom.current().nextInt(parcelas.size());
				Parcela parcelaAleatoria = parcelas.get(randomIndex);
				parcelaAleatoria.addCultivo(nuevoCultivo);
				setStatus("Añadido a la parcela: Parcela de cliente con id " + parcelaAleatoria.getCliente().getID());
			}

			dispose();
		}

	}

}
