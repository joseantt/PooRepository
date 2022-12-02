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
import logical.Solicitud;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class ListarSolicitud extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] rows;
	private Solicitud selected = null;
	private JButton btnEliminar;
	private JButton btnCancelar;
	private JButton btnDetalles;

	public ListarSolicitud() {
		setTitle("Listado de solicitudes");
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
					String[] columnas = {"Código", "Fecha", "Sueldo", "Estado", "Mudarse", "Licencia", "Condición Física"};
					model.setColumnIdentifiers(columnas);
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							int rowSelected = -1;
							rowSelected = table.getSelectedRow();
							if(rowSelected >= 0) {
								btnEliminar.setEnabled(true);
								btnDetalles.setEnabled(true);

								selected = BolsaLaboral.getInstance().buscarSolicitud(table.getValueAt(rowSelected, 0).toString());
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
				{
					btnEliminar = new JButton("Eliminar");
					btnEliminar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							int aux;
							if (selected != null) {
								aux = JOptionPane.showConfirmDialog(null, "Está seguro que quiere elimninar esta persona", "Confirmación", JOptionPane.YES_NO_OPTION);   
								if (aux == JOptionPane.OK_OPTION) {
									BolsaLaboral.getInstance().eliminarSolicitud(selected);
									loadPersona();
									btnEliminar.setEnabled(false);
								}
							}
						}
					});
					btnEliminar.setHorizontalAlignment(SwingConstants.LEFT);
					buttonPane.add(btnEliminar);
				}
				{
					btnDetalles = new JButton("Detalles");
					btnDetalles.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (selected != null) {
								RegistroSolicitud modSolicitud = new RegistroSolicitud(selected);
								modSolicitud.setModal(true);
								modSolicitud.setVisible(true);
							}
						}
					});
					btnEliminar.setHorizontalAlignment(SwingConstants.LEFT);
					buttonPane.add(btnDetalles);
				}
				btnEliminar.setEnabled(false);
				btnDetalles.setEnabled(false);
			}
		}
		loadPersona();
	}

		public static void loadPersona() {
			model.setRowCount(0);
			rows = new Object[model.getColumnCount()];
			for (Solicitud solicitudaux : BolsaLaboral.getInstance().getSolicitudes()) {
				
				rows[0] = solicitudaux.getCodigoSolicitud();
				rows[1] = solicitudaux.getFechaCreacion();
				rows[2] = solicitudaux.getSueldo();
				rows[3] = solicitudaux.isEstado();
				rows[4] = solicitudaux.isPuedeMudarse();
				rows[5] = solicitudaux.isLicenciaConducir();
				rows[6] = solicitudaux.getCondicionFisica();
				/*
				if (solicitudaux.isEstado() == true) {
					rows [6] = "Empleado";
				}
				else {
					rows [6] = "Desempleado";
				}
				*/
				model.addRow(rows);
				
			}
	}

}
