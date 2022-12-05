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
import logical.Persona;
import logical.Solicitud;
import logical.SolicitudEmpresa;
import logical.SolicitudPersona;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
	private static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy") ;
	private static String cedula = null;
	private static String codigoCentro = null;
	private JButton btnMatcheo;

	
	public ListarSolicitud(String cedula, final String codigoCentro, boolean matcheo) {
		this.cedula = cedula;
		this.codigoCentro = codigoCentro;
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
							if(rowSelected >= 0 ) {
								if (BolsaLaboral.getInstance().getLoginUser().getTipo().equalsIgnoreCase("Administrador")) {
									btnEliminar.setEnabled(true);
									btnMatcheo.setEnabled(true);
								}
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
									loadSolicitudes();
									btnEliminar.setEnabled(false);
								}
							}
						}
					});
					{
						btnMatcheo = new JButton("Buscar solicitudes");
						btnMatcheo.setEnabled(false);
						btnMatcheo.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								btnMatcheo.setEnabled(false);
								ListadoMatching listMatch = new ListadoMatching((SolicitudEmpresa) selected);
								listMatch.setModal(true);
								listMatch.setLocationRelativeTo(null);
								listMatch.setVisible(true);
							}
						});
						buttonPane.add(btnMatcheo);
						
					}
					btnEliminar.setHorizontalAlignment(SwingConstants.LEFT);
					buttonPane.add(btnEliminar);
				}
				{
					btnDetalles = new JButton("Detalles");
					btnDetalles.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (selected != null) {
								Solicitud solicitudempresa = BolsaLaboral.getInstance().buscarSolicitudByCode(codigoCentro);
								RegistroSolicitud modSolicitud = new RegistroSolicitud(selected, false, solicitudempresa);
								modSolicitud.setLocationRelativeTo(null);
								modSolicitud.setModal(true);
								modSolicitud.setVisible(true);
								for(Solicitud soli : BolsaLaboral.getInstance().getSolicitudes()) {
									if(soli instanceof SolicitudPersona) {
										System.out.println(BolsaLaboral.getInstance().matching((SolicitudEmpresa)selected, (SolicitudPersona)soli));
									}
								}
							}
						}
					});
					btnEliminar.setHorizontalAlignment(SwingConstants.LEFT);
					buttonPane.add(btnDetalles);
				}
				btnEliminar.setEnabled(false);
				btnDetalles.setEnabled(false);
				
				if(!matcheo) {
					btnMatcheo.setVisible(false);
				}else {
					btnDetalles.setVisible(false);
					btnEliminar.setVisible(false);
				}
			}
		}
		loadSolicitudes();
	}

		public static void loadSolicitudes() {
			String condFisica = "";
			model.setRowCount(0);
			rows = new Object[model.getColumnCount()];
			ArrayList<Solicitud> solicitudes = null; 
			if(!cedula.equals("")) {
				solicitudes = BolsaLaboral.getInstance().buscarPersonadByCedula(cedula).getSolicitudes();
			}else {
				solicitudes = BolsaLaboral.getInstance().buscarCentro(codigoCentro).getSolicitudes();
			}
			for (Solicitud solicitudaux : solicitudes) {
				rows[0] = solicitudaux.getCodigoSolicitud();
				rows[1] = formato.format(solicitudaux.getFechaCreacion());
				rows[2] = solicitudaux.getSueldo();
				if(solicitudaux.isEstado()) {
					rows[3] = "Activa";
				}else {
					rows[3] = "Inactiva";
				}
				if(solicitudaux.isPuedeMudarse()) {
					rows[4] = "Sí";
				}else {
					rows[4] = "No";
				}
				if(solicitudaux.isLicenciaConducir()) {
					rows[5] = "Sí";
				}else {
					rows[5] = "No";
				}
				switch(solicitudaux.getCondicionFisica()) {
					case ('M'):
						condFisica = "Muy buena";
						break;
					case('B'):
						condFisica = "Buena";
						break;
					case('I'):
						condFisica = "Intermedia";
						break;
					case('R'):
						condFisica = "Regular";
						break;
				}
				rows[6] = condFisica;
				model.addRow(rows);
			}
			
	}

}
