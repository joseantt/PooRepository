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

public class RegistrarPersona extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JSpinner spnFechaNacimiento;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JRadioButton rdbtnObrero;
	private JRadioButton rdbtnTcnico;
	private JRadioButton rdbtnUniversitario;
	private JRadioButton rdbtnHombre;
	private JRadioButton rdbtnMujer;
	private ButtonGroup btngroup = new ButtonGroup();
	private JSpinner spnAñoGraduacion;
	private JComboBox cbxCarrera;
	private JSpinner spnAñosExperiencia;
	private JPanel panel_7;
	private JPanel panel_6;
	private JPanel panel_8;
	private ArrayList<String> stringDisponibles = new ArrayList<String>();
	private ArrayList<String> stringSelected = new ArrayList<String>();
	private DefaultListModel<String> modelDisponibles;
	private DefaultListModel<String> modelSelected;
	private JList JlistOficiosSeleccionados;
	private JList JlistOficiosDisponibles;
	private ArrayList<String> stringIdiomasDisponibles = new ArrayList<String>();
	private ArrayList<String> stringIdiomasSelected = new ArrayList<String>();
	private DefaultListModel<String> modelIdiomasDisponibles;
	private DefaultListModel<String> modelIdiomasSelected;
	private int selected = -1;
	private int idiomaSelected = -1;
	private JButton btnAgregar;
	private JButton btnQuitar;
	private JButton btnAgregar2;
	private JButton btnQuitar2;
	private JList JlistIdiomasDisponibles;
	private JList JlistIdiomasSeleccionados;
	private Persona TestPersona = null;
	private JButton btnRegistrar;
	private JButton btnCancelar;

	public RegistrarPersona() {
		setResizable(false);
		setTitle("Registrar Persona");
		setBounds(100, 100, 583, 601);
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
			spnFechaNacimiento.setModel(new SpinnerDateModel(new Date(1669660052532L), new Date(1669660052406L), null, Calendar.MONTH));
			JSpinner.DateEditor de_spnFechaNacimiento = new JSpinner.DateEditor(spnFechaNacimiento, "dd/MM/yy");
			spnFechaNacimiento.setEditor(de_spnFechaNacimiento);
			
			JLabel lblNewLabel = new JLabel("C\u00E9dula:");
			lblNewLabel.setBounds(12, 26, 56, 16);
			panel_1.add(lblNewLabel);
			
			txtCedula = new JTextField();
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
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tipo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_2.setBounds(12, 292, 537, 65);
			panel.add(panel_2);
			panel_2.setLayout(null);
			
			
			
			rdbtnUniversitario = new JRadioButton("Universitario");
			rdbtnUniversitario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel_6.setVisible(true);
					panel_7.setVisible(false);
					panel_8.setVisible(false);
					
				}
			});
			rdbtnUniversitario.setBounds(8, 20, 127, 25);
			panel_2.add(rdbtnUniversitario);
			
			rdbtnTcnico = new JRadioButton("T\u00E9cnico");
			rdbtnTcnico.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel_7.setVisible(true);
					panel_6.setVisible(false);
					panel_8.setVisible(false);
				}
			});
			rdbtnTcnico.setBounds(204, 20, 127, 25);
			panel_2.add(rdbtnTcnico);
			
			rdbtnObrero = new JRadioButton("Obrero");
			rdbtnObrero.setSelected(true);
			rdbtnObrero.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel_8.setVisible(true);
					panel_7.setVisible(false);
					panel_6.setVisible(false);

				}
			});
			rdbtnObrero.setBounds(402, 20, 127, 25);
			panel_2.add(rdbtnObrero);
			
			btngroup.add(rdbtnUniversitario);
			btngroup.add(rdbtnTcnico);
			btngroup.add(rdbtnObrero);

			
			JPanel panel_3 = new JPanel();
			panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Extra", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_3.setBounds(12, 370, 537, 131);
			panel.add(panel_3);
			panel_3.setLayout(new CardLayout(0, 0));
			
			panel_8 = new JPanel();
			panel_3.add(panel_8, "name_128748216872200");
			panel_8.setLayout(null);
			
			JLabel lblNewLabel_10 = new JLabel("Oficios:");
			lblNewLabel_10.setBounds(12, 53, 56, 16);
			panel_8.add(lblNewLabel_10);
			
			JPanel panel_9 = new JPanel();
			panel_9.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_9.setBounds(71, 13, 179, 80);
			panel_8.add(panel_9);
			panel_9.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane_2 = new JScrollPane();
			panel_9.add(scrollPane_2, BorderLayout.CENTER);
			
			JlistOficiosDisponibles = new JList();
			JlistOficiosDisponibles.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					selected = JlistOficiosDisponibles.getSelectedIndex();
					if(selected > -1) {
						btnAgregar.setEnabled(true);
					}
				}
			});
			JlistOficiosDisponibles.setModel(modelDisponibles);
			JlistOficiosDisponibles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollPane_2.setViewportView(JlistOficiosDisponibles);
			
			JPanel panel_10 = new JPanel();
			panel_10.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_10.setBounds(334, 13, 179, 80);
			panel_8.add(panel_10);
			panel_10.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane_3 = new JScrollPane();
			scrollPane_3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel_10.add(scrollPane_3, BorderLayout.CENTER);
			
			JlistOficiosSeleccionados = new JList();
			JlistOficiosSeleccionados.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					selected = JlistOficiosSeleccionados.getSelectedIndex();
					if(selected > -1) {
						btnQuitar.setEnabled(true);
					}
				}
			});
			JlistOficiosSeleccionados.setModel(modelSelected);
			JlistOficiosSeleccionados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollPane_3.setViewportView(JlistOficiosSeleccionados);
			
			btnAgregar = new JButton(">>");
			btnAgregar.setBounds(271, 13, 51, 25);
			panel_8.add(btnAgregar);
			btnAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnAgregar.setEnabled(false);
					String temp = stringDisponibles.get(selected);
					stringSelected.add(temp);
					modelSelected.addElement(temp);
					stringDisponibles.remove(selected);
					reloadDisponibles();
					reloadSelected();
					selected = -1;
				}
			});
			btnAgregar.setEnabled(false);
			
			btnQuitar = new JButton("<<");
			btnQuitar.setBounds(271, 68, 51, 25);
			panel_8.add(btnQuitar);
			btnQuitar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnQuitar.setEnabled(false);
					String temp = stringSelected.get(selected);
					stringDisponibles.add(temp);
					modelDisponibles.addElement(temp);
					stringSelected.remove(selected);
					reloadDisponibles();
					reloadSelected();
					selected = -1;
				}
			});
			btnQuitar.setEnabled(false);
			
			panel_7 = new JPanel();
			panel_3.add(panel_7, "name_128060057537800");
			panel_7.setLayout(null);
			
			JLabel lblNewLabel_8 = new JLabel("Area de Especialidad:");
			lblNewLabel_8.setBounds(12, 55, 131, 16);
			panel_7.add(lblNewLabel_8);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Electricidad Industrial", "Electricidad Residencial", "Electricidad Automotriz", "Mec\u00E1nica Automotriz", "Mec\u00E1nica Industrial", "Inform\u00E1tica", "Producci\u00F3n Audiovisual", "Confecci\u00F3n y Patronaje", "Reparaci\u00F3n de Equipos", "Electr\u00F3nicos", "Ebanister\u00EDa", "Reposter\u00EDa"}));
			comboBox.setBounds(140, 52, 143, 22);
			panel_7.add(comboBox);
			
			JLabel lblNewLabel_9 = new JLabel("A\u00F1os de Experiencia:");
			lblNewLabel_9.setBounds(295, 55, 131, 16);
			panel_7.add(lblNewLabel_9);
			
			spnAñosExperiencia = new JSpinner();
			spnAñosExperiencia.setModel(new SpinnerNumberModel(new Integer(2017), new Integer(2017), null, new Integer(1)));
			spnAñosExperiencia.setBounds(427, 52, 86, 22);
			JSpinner.NumberEditor editor = new JSpinner.NumberEditor(spnAñosExperiencia, "#");
			spnAñosExperiencia.setEditor(editor);
			panel_7.add(spnAñosExperiencia);
			
			panel_6 = new JPanel();
			panel_3.add(panel_6, "name_127485802592200");
			panel_6.setLayout(null);
			
			JLabel lblCarrera = new JLabel("Carrera:");
			lblCarrera.setBounds(12, 53, 56, 16);
			panel_6.add(lblCarrera);
			
			cbxCarrera = new JComboBox();
			cbxCarrera.setModel(new DefaultComboBoxModel(new String[] {"Direcci\u00F3n Empresarial", "Administraci\u00F3n Hotelera", "Arquitectura", "Comunicaci\u00F3n", "Social", "Derecho", "Dise\u00F1o e Interiorismo", "Econom\u00EDa", "Educaci\u00F3n", "Estomatolog\u00EDa", "Filosof\u00EDa", "Gesti\u00F3n Financiera y Auditor\u00EDa", "Ingenier\u00EDa Civil", "Ingenier\u00EDa Mec\u00E1nica", "Ingenier\u00EDa El\u00E9ctrica", "Ingenier\u00EDa Industrial", "Ingenier\u00EDa Mecatr\u00F3nica", "Ingenier\u00EDa de Ciencias de la Computaci\u00F3n", "Ingenier\u00EDa Telem\u00E1tica", "Medicina", "Marketing", "Nutrici\u00F3n y Diet\u00E9tica", "Terapia F\u00EDsica", "Trabajo Social", "Hospitalidad\u00A0y\u00A0Turismo"}));
			cbxCarrera.setBounds(65, 50, 211, 22);
			panel_6.add(cbxCarrera);
			
			JLabel lblAñoGraduacion = new JLabel("A\u00F1o de Graduaci\u00F3n:\r\n");
			lblAñoGraduacion.setBounds(288, 53, 123, 16);
			panel_6.add(lblAñoGraduacion);
			
			spnAñoGraduacion = new JSpinner();
			spnAñoGraduacion.setModel(new SpinnerNumberModel(new Integer(2017), new Integer(2017), null, new Integer(1)));
			spnAñoGraduacion.setBounds(423, 50, 90, 22);
			JSpinner.NumberEditor ne_spnAñoGraduacion = new JSpinner.NumberEditor(spnAñoGraduacion, "#");
			spnAñoGraduacion.setEditor(ne_spnAñoGraduacion);
			panel_6.add(spnAñoGraduacion);
			

		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{			
				btnRegistrar = new JButton("Registrar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						char sexo = 'A';
						ArrayList<String> auxIdioma = new ArrayList<>();
						ArrayList<String> auxOficio = new ArrayList<>();
						Persona personaAux = null;
						if (rdbtnHombre.isSelected()) {
							sexo = 'H';
						}
						else if (rdbtnMujer.isSelected()) {
							sexo = 'M';
						}
						
						if (rdbtnObrero.isSelected())
						{
							personaAux = new Obrero(txtCedula.getText(), txtNombre.getText(), txtApellidos.getText(), txtDireccion.getText(),
								txtTelefono.getText(), (Date)spnFechaNacimiento.getValue(), sexo, stringIdiomasSelected, stringSelected);
								JOptionPane.showMessageDialog(null, "Registro Satisfactorio", "Información",JOptionPane.INFORMATION_MESSAGE);
						}
						else if (rdbtnUniversitario.isSelected())
						{
							personaAux = new Universitario(txtCedula.getText(), txtNombre.getText(), txtApellidos.getText(), txtDireccion.getText(),
								txtTelefono.getText(), (Date)spnFechaNacimiento.getValue(), sexo, stringIdiomasSelected, cbxCarrera.getSelectedItem().toString() , Integer.valueOf(spnAñoGraduacion.getValue().toString()));
								JOptionPane.showMessageDialog(null, "Registro Satisfactorio", "Información",JOptionPane.INFORMATION_MESSAGE);
						}
						else if (rdbtnTcnico.isSelected())
						{
							personaAux = new Tecnico(txtCedula.getText(), txtNombre.getText(), txtApellidos.getText(), txtDireccion.getText(),
								txtTelefono.getText(), (Date)spnFechaNacimiento.getValue(), sexo, stringIdiomasSelected, spnFechaNacimiento.getValue().toString(), Integer.valueOf(spnAñoGraduacion.getValue().toString())) ;
								JOptionPane.showMessageDialog(null, "Registro Satisfactorio", "Información",JOptionPane.INFORMATION_MESSAGE);
						}
						
						BolsaLaboral.getInstance().getPersonas().add(personaAux);
						loadDisponibles();
						loadIdiomasDisponibles();
						limpiarIdiomasSelected();
						limpiarSelected();
						clean();		
					}
					
						
					
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		clean();
		loadIdiomasDisponibles();
		loadDisponibles();
	}
	private void clean() {
		txtCedula.setText("");
		txtNombre.setText("");
		txtApellidos.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		spnAñoGraduacion.setValue(new Float("2017"));
		spnFechaNacimiento.setValue(new Date());
		rdbtnHombre.setSelected(true);
		cbxCarrera.setSelectedIndex(1);
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
