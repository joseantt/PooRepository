package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logical.*;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListadoMatching extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] rows;
	private Solicitud solicitudEmpresa = null; 
	private Solicitud selected = null;
	private JButton btnDetalles;

	/**
	 * Create the dialog.
	 */
	public ListadoMatching(final SolicitudEmpresa solicitudEmpresa) {
		this.solicitudEmpresa = solicitudEmpresa;
		setTitle("Solicitudes convergentes");
		setBounds(100, 100, 753, 436);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					model = new DefaultTableModel();
					String[] columnas = {"Código", "Fecha", "Nombre", "Sueldo", "Porc. Matcheo"};
					model.setColumnIdentifiers(columnas);
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int rowSelected = -1;
							rowSelected = table.getSelectedRow();
							if(rowSelected >= 0) {
								selected = BolsaLaboral.getInstance().buscarSolicitudByCode(table.getValueAt(rowSelected, 0).toString());
								btnDetalles.setEnabled(true);
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
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnDetalles = new JButton("Ver detalles");
				btnDetalles.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnDetalles.setEnabled(false);
						RegistroSolicitud regSoli = new RegistroSolicitud(selected, true, solicitudEmpresa);
						regSoli.setLocationRelativeTo(null);
						regSoli.setModal(true);
						regSoli.setVisible(true);
						loadSolicitudMatch();
					}
				});
				btnDetalles.setEnabled(false);
				btnDetalles.setActionCommand("OK");
				buttonPane.add(btnDetalles);
				getRootPane().setDefaultButton(btnDetalles);
			}
		}
		loadSolicitudMatch();
	}
	
	public void loadSolicitudMatch() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		for(Solicitud soliAux : BolsaLaboral.getInstance().solicitudesMatchean((SolicitudEmpresa) solicitudEmpresa)) {
			rows[0] = soliAux.getCodigoSolicitud();
			rows[1] = formato.format(soliAux.getFechaCreacion());
			rows[2] = BolsaLaboral.getInstance().buscarPersonadByCedula(((SolicitudPersona)soliAux).getCedula()).getNombres();
			rows[3] = soliAux.getSueldo();
			rows[4] = BolsaLaboral.getInstance().matching((SolicitudEmpresa)solicitudEmpresa, (SolicitudPersona)soliAux)+"%";
			model.addRow(rows);
		}
	}
}
