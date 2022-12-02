package visual;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logical.BolsaLaboral;
import logical.CentroEmpleador;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ListarCentros extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] rows;
	private CentroEmpleador selected = null;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnSolicitud;
	private JButton btnCancelar;
	
	public static final int PORDEFECTO = 0;
	public static final int SOLICITUD = 1;

	/**
	 * Create the dialog.
	 */
	public ListarCentros(final int modo) {
		this.addWindowFocusListener(new WindowAdapter() {
		    public void windowGainedFocus(WindowEvent e) {
		        loadClientes();
		    }
		});
		setTitle("Listado de Centros");
		setBounds(100, 100, 753, 436);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					model = new DefaultTableModel();
					String[] columnas = {"Código", "Nombre", "Dirección","Teléfono", "Tipo" };
					model.setColumnIdentifiers(columnas);
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							int rowSelected = -1;
							rowSelected = table.getSelectedRow();
							if(rowSelected >= 0) {
								if(modo == SOLICITUD) {
									btnSolicitud.setEnabled(true);
								}
								btnEliminar.setEnabled(true);
								btnModificar.setEnabled(true);
								selected = BolsaLaboral.getInstance().buscarCentro(table.getValueAt(rowSelected, 0).toString());
							}
						}
					});
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table.setModel(model);
					scrollPane.setViewportView(table);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int option;
						if (selected != null) {
							option = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar el centro con código: "+selected.getCodigo(),"Confirmación",JOptionPane.YES_NO_OPTION);
							if (option == JOptionPane.OK_OPTION) {
								BolsaLaboral.getInstance().eliminarCentro(selected);
								loadClientes();
								btnEliminar.setEnabled(false);
								btnModificar.setEnabled(false);
							}
						}  
					}
				});
				btnEliminar.setEnabled(false);
				btnEliminar.setActionCommand("Cancel");
				buttonPane.add(btnEliminar);
			}
			{
				btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						RegistrarCentroEmpleador modCliente = new RegistrarCentroEmpleador(selected);
						modCliente.setModal(true);
						modCliente.setVisible(true);
						btnEliminar.setEnabled(false);
						btnModificar.setEnabled(false);
					}
				});
				btnModificar.setEnabled(false);
				btnModificar.setActionCommand("Cancel");
				buttonPane.add(btnModificar);
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
			if(modo == SOLICITUD) {
				btnSolicitud = new JButton("Ver solicitudes");
				btnEliminar.setVisible(false);
				btnModificar.setVisible(false);
				btnSolicitud.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ListarSolicitud solicitudes = new ListarSolicitud("", selected.getCodigo());
						solicitudes.setModal(true);
						solicitudes.setVisible(true);
						btnSolicitud.setEnabled(false);
					}
				});
				btnSolicitud.setEnabled(false);
				buttonPane.add(btnSolicitud);
			}
			
		}
		loadClientes();
		
	}

		public static void loadClientes() {
			model.setRowCount(0);
			rows = new Object[model.getColumnCount()];
			for (CentroEmpleador Centro : BolsaLaboral.getInstance().getCentroEmpleados()) {
				
				rows[0] = Centro.getCodigo();
				rows[1] = Centro.getNombre();
				rows[2] = Centro.getDireccion();
				rows[3] = Centro.getTelefono();
				rows[4] = Centro.getTipo();
				
				model.addRow(rows);
			}
		
	}

}
