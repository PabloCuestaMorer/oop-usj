package ui;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import huerto.Agua;
import huerto.Cliente;
import huerto.Cultivo;
import huerto.Parcela;

public class MyTableModel extends AbstractTableModel {
	private static final long serialVersionUID = -1075759000928576938L;

	private Parcela parcela;
	private List<Parcela> allParcelas; // Nueva variable para almacenar todas las parcelas
	private static final String[] columnNames = { "Cultivo", "Agua", "Plantas", "ID Cliente", "Nombre", "Apellido",
			"Telefono" };

	public MyTableModel(Parcela parcela, List<Parcela> allParcelas) {
		this.parcela = parcela;
		this.allParcelas = allParcelas;
	}

	public void setParcela(Parcela parcela, List<Parcela> allParcelas) {
		this.parcela = parcela;
		this.allParcelas = allParcelas;
		fireTableDataChanged();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public int getRowCount() {
		return parcela != null ? parcela.getCultivos().size() : 0;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int row, int col) {
		Cultivo cultivo = parcela.getCultivos().get(row);
		Cliente cliente = parcela.getCliente();
		switch (col) {
		case 0:
			return cultivo.getNombre();
		case 1:
			return cultivo.getAgua().name();
		case 2:
			return cultivo.getNumPlantas();
		case 3:
			return cliente.getID();
		case 4:
			return cliente.getNombre();
		case 5:
			return cliente.getApellido();
		case 6:
			return cliente.getTelefono();
		default:
			return null;
		}
	}

	@Override
	public boolean isCellEditable(int row, int col) {
		return col != 3;
	}

	@Override
	public void setValueAt(Object value, int row, int col) {
		Cultivo cultivo = parcela.getCultivos().get(row);
		Cliente cliente = parcela.getCliente();
		switch (col) {
		case 0:
			cultivo.setNombre((String) value);
			break;
		case 1:
			String necesidadesAgua = (String) value;
			try {
				Agua agua = Agua.valueOf(necesidadesAgua.toLowerCase());
				cultivo.setAgua(agua);
			} catch (IllegalArgumentException e) {
				// Alerta al usuario si el valor del agua no es correcto
				JOptionPane.showMessageDialog(null, "El valor de agua debe ser 'alta', 'media' o 'baja'",
						"Error en la entrada", JOptionPane.ERROR_MESSAGE);
				return;
			}
			break;
		case 2:
			cultivo.setNumPlantas(Integer.valueOf((String) value));
			break;
		case 4:
			String newName = (String) value;
			cliente.setNombre(newName);
			break;
		case 5:
			cliente.setApellido((String) value);
			break;
		case 6:
			int newPhoneNumber = Integer.parseInt((String) value);
			cliente.setTelefono(newPhoneNumber);
			break;
		}
		//Actualizamos el cliente, por si se han modificado datos
		updateClientInAllParcelas(cliente);
		fireTableCellUpdated(row, col);
	}

	private void updateClientInAllParcelas(Cliente cliente) {
		for (Parcela parcela : allParcelas) {
			if (parcela.getCliente().getID() == cliente.getID()) {
				parcela.setCliente(cliente);
			}
		}
		// Informamos a la tabla de que los datos han cambiado
		fireTableDataChanged();
	}
}
