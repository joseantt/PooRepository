package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import logical.BolsaLaboral;
import logical.User;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListarUsuarios extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] rows;
	private User selected = null;
	private JButton btnEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarUsuarios dialog = new ListarUsuarios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarUsuarios() {
		setTitle("Listado de usuarios");
		setBounds(100, 100, 498, 320);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				model = new DefaultTableModel();
				String[] columnas = {"Nombre de usuario", "Tipo"};
				model.setColumnIdentifiers(columnas);
				table = new JTable();
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int rowSelected = -1;
						rowSelected = table.getSelectedRow();
						if(rowSelected >= 0) {
							btnEliminar.setEnabled(true);
							selected = BolsaLaboral.getInstance().buscarUsuarioByNombre(table.getValueAt(rowSelected, 0).toString());
						}
					}
				});
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table.setModel(model);
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setEnabled(false);
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnEliminar.setEnabled(false);
						int aux;
						if (selected != null) {
							aux = JOptionPane.showConfirmDialog(null, "¿Está seguro que quiere elimninar este Usuario?", "Confirmación", JOptionPane.YES_NO_OPTION);   
							if (aux == JOptionPane.OK_OPTION) {
								BolsaLaboral.getInstance().getMisUsers().remove(selected);
								loadUsers();
								btnEliminar.setEnabled(false);
							}
					}
				}
				});
				btnEliminar.setActionCommand("OK");
				buttonPane.add(btnEliminar);
				getRootPane().setDefaultButton(btnEliminar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		loadUsers();
	}
	
	public static void loadUsers() {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		for(User usuarioAux : BolsaLaboral.getInstance().getMisUsers()) {
			rows[0] = usuarioAux.getUserName();
			rows[1] = usuarioAux.getTipo();
			model.addRow(rows);
		}
	}
	
}
