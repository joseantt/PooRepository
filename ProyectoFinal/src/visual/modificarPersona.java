package visual;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logical.BolsaLaboral;
import logical.Obrero;
import logical.Persona;
import logical.Tecnico;
import logical.Universitario;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import javax.swing.ScrollPaneConstants;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.SpinnerNumberModel;
import java.awt.CardLayout;

public class modificarPersona extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JSpinner spnFechaNacimiento;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JRadioButton rdbtnHombre;
	private JRadioButton rdbtnMujer;
	private ButtonGroup btngroup = new ButtonGroup();
	private JSpinner spnAñoGraduacion;
	private JSpinner spnAñosExperiencia;
	private ArrayList<String> stringDisponibles = new ArrayList<String>();
	private ArrayList<String> stringSelected = new ArrayList<String>();
	private DefaultListModel<String> modelDisponibles;
	private DefaultListModel<String> modelSelected;
	private ArrayList<String> stringIdiomasDisponibles = new ArrayList<String>();
	private ArrayList<String> stringIdiomasSelected = new ArrayList<String>();
	private DefaultListModel<String> modelIdiomasDisponibles;
	private DefaultListModel<String> modelIdiomasSelected;
	private int selected = -1;
	private int idiomaSelected = -1;
	private JButton btnAgregar2;
	private JButton btnQuitar2;
	private JList JlistIdiomasDisponibles;
	private JList JlistIdiomasSeleccionados;
	private Persona TestPersona = null;
	private JButton btnRegistrar;
	private JButton btnCancelar;
	private Persona persona;
	private JButton btnNewButton;
	
	public modificarPersona(final Persona persona) {
		this.persona = persona;
		setResizable(false);
		setTitle("Modificar Persona");
		setBounds(100, 100, 583, 376);
		setLocationRelativeTo(null);;
		modelDisponibles = new DefaultListModel<String>();
		modelSelected = new DefaultListModel<String>();
		modelIdiomasDisponibles = new DefaultListModel<String>();
		modelIdiomasSelected = new DefaultListModel<String>();
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos de la Persona", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1.setBounds(12, 13, 537, 266);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			spnFechaNacimiento = new JSpinner();
			spnFechaNacimiento.setBounds(386, 91, 127, 22);
			panel_1.add(spnFechaNacimiento);
			spnFechaNacimiento.setModel(new SpinnerDateModel(new Date(), new Date(), null, Calendar.MONTH));
			JSpinner.DateEditor de_spnFechaNacimiento = new JSpinner.DateEditor(spnFechaNacimiento, "dd/MM/yyyy");
			spnFechaNacimiento.setEditor(de_spnFechaNacimiento);
			
			JLabel lblNewLabel = new JLabel("C\u00E9dula:");
			lblNewLabel.setBounds(12, 26, 56, 16);
			panel_1.add(lblNewLabel);
			
			txtCedula = new JTextField();
			txtCedula.setEditable(false);
			txtCedula.setBounds(72, 23, 167, 22);
			panel_1.add(txtCedula);
			txtCedula.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setBounds(251, 23, 56, 16);
			panel_1.add(lblNewLabel_1);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(317, 23, 196, 22);
			panel_1.add(txtNombre);
			txtNombre.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Apellidos:");
			lblNewLabel_2.setBounds(12, 62, 56, 16);
			panel_1.add(lblNewLabel_2);
			
			txtApellidos = new JTextField();
			txtApellidos.setBounds(72, 59, 167, 22);
			panel_1.add(txtApellidos);
			txtApellidos.setColumns(10);
			
			JLabel lblNewLabel_3 = new JLabel("Direcci\u00F3n:");
			lblNewLabel_3.setBounds(251, 62, 67, 16);
			panel_1.add(lblNewLabel_3);
			
			txtDireccion = new JTextField();
			txtDireccion.setBounds(317, 59, 196, 22);
			panel_1.add(txtDireccion);
			txtDireccion.setColumns(10);
			
			JLabel lblNewLabel_4 = new JLabel("Tel\u00E9fono:");
			lblNewLabel_4.setBounds(12, 94, 56, 16);
			panel_1.add(lblNewLabel_4);
			
			txtTelefono = new JTextField();
			txtTelefono.setBounds(72, 91, 167, 22);
			panel_1.add(txtTelefono);
			txtTelefono.setColumns(10);
			
			JLabel lblNewLabel_5 = new JLabel("Fecha de Nacimiento:");
			lblNewLabel_5.setBounds(251, 94, 135, 16);
			panel_1.add(lblNewLabel_5);
			
			JLabel lblNewLabel_6 = new JLabel("Sexo:");
			lblNewLabel_6.setBounds(159, 136, 56, 16);
			panel_1.add(lblNewLabel_6);
			
			rdbtnHombre = new JRadioButton("Hombre");
			rdbtnHombre.setSelected(true);
			rdbtnHombre.setBounds(219, 132, 84, 25);
			panel_1.add(rdbtnHombre);
			
			rdbtnMujer = new JRadioButton("Mujer");
			rdbtnMujer.setBounds(319, 132, 67, 25);
			panel_1.add(rdbtnMujer);
			
			JLabel lblNewLabel_7 = new JLabel("Idiomas:");
			lblNewLabel_7.setBounds(12, 208, 56, 16);
			panel_1.add(lblNewLabel_7);
			
			JPanel panel_4 = new JPanel();
			panel_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_4.setBounds(69, 178, 167, 73);
			panel_1.add(panel_4);
			panel_4.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel_4.add(scrollPane, BorderLayout.CENTER);
			
			JlistIdiomasDisponibles = new JList();
			JlistIdiomasDisponibles.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					idiomaSelected = JlistIdiomasDisponibles.getSelectedIndex();
					if(idiomaSelected > -1) {
						btnAgregar2.setEnabled(true);
					}
				}
			});
			JlistIdiomasDisponibles.setModel(modelIdiomasDisponibles);
			JlistIdiomasDisponibles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollPane.setViewportView(JlistIdiomasDisponibles);
			
		
			JPanel panel_5 = new JPanel();
			panel_5.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_5.setBounds(346, 178, 167, 73);
			panel_1.add(panel_5);
			panel_5.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane_1 = new JScrollPane();
			panel_5.add(scrollPane_1, BorderLayout.CENTER);
			
			JlistIdiomasSeleccionados = new JList();
			JlistIdiomasSeleccionados.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					idiomaSelected = JlistIdiomasSeleccionados.getSelectedIndex();
					if(idiomaSelected > -1) {
						btnQuitar2.setEnabled(true);
					}
				}
			});
			JlistIdiomasSeleccionados.setModel(modelIdiomasSelected);
			JlistIdiomasSeleccionados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollPane_1.setViewportView(JlistIdiomasSeleccionados);
			
			Component horizontalStrut = Box.createHorizontalStrut(20);
			horizontalStrut.setBackground(Color.BLACK);
			horizontalStrut.setBounds(0, 178, 537, -12);
			panel_1.add(horizontalStrut);
			
			btnAgregar2 = new JButton(">>");
			btnAgregar2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnAgregar2.setEnabled(false);
					String temp = stringIdiomasDisponibles.get(idiomaSelected);
					stringIdiomasSelected.add(temp);
					modelIdiomasSelected.addElement(temp);
					stringIdiomasDisponibles.remove(idiomaSelected);
					reloadIdiomasDisponibles();
					reloadIdiomasSelected();
					idiomaSelected = -1;
				}
			});
			btnAgregar2.setBounds(267, 182, 51, 25);
			panel_1.add(btnAgregar2);
			btnAgregar2.setEnabled(false);
			
			btnQuitar2 = new JButton("<<");
			btnQuitar2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnQuitar2.setEnabled(false);
					String temp = stringIdiomasSelected.get(idiomaSelected);
					stringIdiomasDisponibles.add(temp);
					modelIdiomasDisponibles.addElement(temp);
					stringIdiomasSelected.remove(idiomaSelected);
					reloadIdiomasDisponibles();
					reloadIdiomasSelected();
					idiomaSelected = -1;
				}
			});
			btnQuitar2.setBounds(267, 226, 51, 25);
			panel_1.add(btnQuitar2);
			btnQuitar2.setEnabled(false);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{		
				btnNewButton = new JButton("Modificar");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						persona.setNombres(txtNombre.getText());
						persona.setApellidos(txtApellidos.getText());
						persona.setDireccion(txtDireccion.getText());
						persona.setTelefono(txtTelefono.getText());
						if(persona.getSexo() == 'H') {
							persona.setSexo('H');
						}else{
							persona.setSexo('M');
						}
						persona.setIdiomas(stringIdiomasDisponibles);
						ListarPersona.loadPersona();
						dispose();
					}
				});
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					dispose();
					}
				});
				
				
				buttonPane.add(btnNewButton);
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		loadPersona();
		loadIdiomasDisponibles();
		loadDisponibles();
	}
	private void loadPersona() {
		txtCedula.setText(persona.getCedula());
		txtNombre.setText(persona.getNombres());
		txtApellidos.setText(persona.getApellidos());
		txtDireccion.setText(persona.getDireccion());
		txtTelefono.setText(persona.getTelefono());
		if(persona.getSexo() == 'H') {
			btngroup.setSelected(rdbtnHombre.getModel(), true);
		}else{
			btngroup.setSelected(rdbtnMujer.getModel(), true);
		}
		stringIdiomasDisponibles = persona.getIdiomas();
	}
	
	private void loadDisponibles(){
		modelDisponibles.removeAllElements();
		String aux = "";
		stringDisponibles.removeAll(stringDisponibles);
		stringDisponibles.add("Albañil");stringDisponibles.add("Pintor");stringDisponibles.add("Servicio de Limpieza");stringDisponibles.add("Vigilante");stringDisponibles.add("Sastre");stringDisponibles.add("Carnicero");stringDisponibles.add("Panadero");stringDisponibles.add("Repartidor");stringDisponibles.add("Agricultor");stringDisponibles.add("Vendedor");	
		for(int i = 0; i < stringDisponibles.size(); i++) {
			aux = stringDisponibles.get(i);
			modelDisponibles.addElement(aux);
		}
	}
	
	private void reloadDisponibles(){
		modelDisponibles.removeAllElements();
		String aux = "";
		for(int i = 0; i < stringDisponibles.size(); i++) {
			aux = stringDisponibles.get(i);
			modelDisponibles.addElement(aux);
		}
	}
	
	private void reloadSelected() {
		modelSelected.removeAllElements();
		String aux = "";
		for(int i = 0; i < stringSelected.size(); i++) {
			aux = stringSelected.get(i);
			modelSelected.addElement(aux);
		}
	}
	private void limpiarSelected() {
		stringSelected = new ArrayList<String>();
		reloadSelected();
	}
	
	private void loadIdiomasDisponibles(){
		modelIdiomasDisponibles.removeAllElements();
		String aux = "";
		stringIdiomasDisponibles.removeAll(stringIdiomasDisponibles);
		stringIdiomasDisponibles.add("Español");stringIdiomasDisponibles.add("Inglés");stringIdiomasDisponibles.add("Francés");stringIdiomasDisponibles.add("Alemán");stringIdiomasDisponibles.add("Mandarín");stringIdiomasDisponibles.add("Hindi");stringIdiomasDisponibles.add("Árabe");stringIdiomasDisponibles.add("Bengalí");stringIdiomasDisponibles.add("Portugués");stringIdiomasDisponibles.add("Ruso");	
		for(int i = 0; i < stringIdiomasDisponibles.size(); i++) {
			aux = stringIdiomasDisponibles.get(i);
			modelIdiomasDisponibles.addElement(aux);
		}
	}
	
	private void reloadIdiomasDisponibles(){
		modelIdiomasDisponibles.removeAllElements();
		String aux = "";
		for(int i = 0; i < stringIdiomasDisponibles.size(); i++) {
			aux = stringIdiomasDisponibles.get(i);
			modelIdiomasDisponibles.addElement(aux);
		}
	}
	
	private void reloadIdiomasSelected() {
		modelIdiomasSelected.removeAllElements();
		String aux = "";
		for(int i = 0; i < stringIdiomasSelected.size(); i++) {
			aux = stringIdiomasSelected.get(i);
			modelIdiomasSelected.addElement(aux);
		}
	}
	private void limpiarIdiomasSelected() {
		stringIdiomasSelected = new ArrayList<String>();
		reloadIdiomasSelected();
	}
	
	
	
}
