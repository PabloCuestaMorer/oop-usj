package ui;

import java.util.List;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import huerto.HuertoUrbano;
import huerto.Parcela;

/**
 * @author Pablo Cuesta Morer
 * @date 2023-06-02
 */

public class MyDataModel implements TreeModel {
	private HuertoUrbano huerto;

	public MyDataModel(HuertoUrbano huerto) {
		this.huerto = huerto;
	}

	@Override
	public Object getRoot() {
		return "Huerto Urbano - " + huerto.getTam();
	}

	@Override
	public Object getChild(Object parent, int index) {
		if (parent.equals(getRoot())) {
			Parcela parcela = huerto.getParcelas().get(index);
			return "Parcela del cliente con id " + parcela.getCliente().getID();
		}
		return null;
	}

	@Override
	public int getChildCount(Object parent) {
		if (parent.equals(getRoot())) {
			return huerto.getParcelas().size();
		}
		return 0;
	}

	@Override
	public boolean isLeaf(Object node) {
		return !node.equals(getRoot());
	}

	@Override
	public void valueForPathChanged(TreePath path, Object newValue) {
	}

	@Override
	public int getIndexOfChild(Object parent, Object child) {
		if (parent.equals(getRoot())) {
			List<Parcela> parcelas = huerto.getParcelas();
			for (int i = 0; i < parcelas.size(); i++) {
				if (("Parcela del cliente con id " + parcelas.get(i).getCliente().getID()).equals(child)) {
					return i;
				}
			}
		}
		return -1;
	}

	@Override
	public void addTreeModelListener(TreeModelListener l) {
	}

	@Override
	public void removeTreeModelListener(TreeModelListener l) {
	}
}
