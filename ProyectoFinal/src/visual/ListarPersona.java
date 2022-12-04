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
import logical.Persona;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class ListarPersona extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] rows;
	private Persona selected = null;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnCancelar;
	private JButton btnSolicitudes;
	
	public static final int PORDEFECTO = 0;
	public static final int SOLICITUD = 1;

	public ListarPersona(final int modo) {
		setTitle("Listado de Personas");
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
					String[] columnas = {"Cédula", "Nombres", "Apellidos", "Dirección", "Teléfono", "Sexo", "Estado"};
					model.setColumnIdentifiers(columnas);
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							int rowSelected = -1;
							rowSelected = table.getSelectedRow();
							if(rowSelected >= 0) {
								if(modo == SOLICITUD) {
									btnSolicitudes.setEnabled(true);
								}
								btnEliminar.setEnabled(true);
								btnModificar.setEnabled(true);
								selected = BolsaLaboral.getInstance().buscarPersonadByCedula(table.getValueAt(rowSelected, 0).toString());
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
				btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					dispose();
					}
				});
				
					
				{
					btnModificar = new JButton("Modificar");
					btnModificar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							modificarPersona modPersona = new modificarPersona(selected);
							modPersona.setModal(true);
							modPersona.setVisible(true);
							btnEliminar.setEnabled(false);
							btnModificar.setEnabled(false);
							
						}
					});
					
					btnModificar.setEnabled(false);
					buttonPane.add(btnModificar);
				}
				{
					btnEliminar = new JButton("Eliminar");
					btnEliminar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							int aux;
							if (selected != null) {
								aux = JOptionPane.showConfirmDialog(null, "Está seguro que quiere elimninar esta persona", "Confirmación", JOptionPane.YES_NO_OPTION);   
								if (aux == JOptionPane.OK_OPTION) {
									BolsaLaboral.getInstance().eliminarPersona(selected);
									loadPersona();
									btnEliminar.setEnabled(false);
									btnModificar.setEnabled(false);
								}
							}
						}
					});
					btnEliminar.setHorizontalAlignment(SwingConstants.LEFT);
					buttonPane.add(btnEliminar);
				}
				btnEliminar.setEnabled(false);
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			
				if(modo == SOLICITUD){
				btnCancelar.setText("Cerrar");
				btnEliminar.setVisible(false);
				btnModificar.setVisible(false);
				btnSolicitudes = new JButton("Ver solicitudes");
				btnSolicitudes.setEnabled(false);
				btnSolicitudes.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ListarSolicitud solicitudes = new ListarSolicitud(selected.getCedula(), "");
						solicitudes.setModal(true);
						solicitudes.setVisible(true);
					}
				});
				
				buttonPane.add(btnSolicitudes);
			}
			}
		}
		loadPersona();
	}

		public static void loadPersona() {
			model.setRowCount(0);
			rows = new Object[model.getColumnCount()];
			for (Persona personaAux : BolsaLaboral.getInstance().getPersonas()) {
				
				rows[0] = personaAux.getCedula();
				rows[1] = personaAux.getNombres();
				rows[2] = personaAux.getApellidos();
				rows[3] = personaAux.getDireccion();
				rows[4] = personaAux.getTelefono();
				rows[5] = personaAux.getSexo();
				if (personaAux.isEstado() == true) {
					rows [6] = "Empleado";
				}
				else {
					rows [6] = "Desempleado";
				}
				model.addRow(rows);
				
			}
	}

}
