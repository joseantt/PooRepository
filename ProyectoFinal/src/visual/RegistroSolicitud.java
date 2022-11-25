package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logical.BolsaLaboral;

import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTextField; 
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegistroSolicitud extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ButtonGroup btnGroup_1 = new ButtonGroup();
	private ButtonGroup btnGroup_2 = new ButtonGroup();
	private JPanel panelDetalles2;
	private JRadioButton rdbtnUniversitario;
	private JRadioButton rdbtnTecnico;
	private JRadioButton rdbtnObrero;
	private JPanel panel_2;
	private JSpinner spnGraduacion;
	private JComboBox cbxCarrera;
	private JSpinner spnExperiencia;
	private JComboBox cbxEspecialidad;
	private JPanel panelObrero;
	private JPanel panelTecnico;
	private JPanel panelUniversitario;
	private DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
	private JList listOficiosDisp;
	private JList listOficiosSelected;
	private DefaultListModel<String> modelDisponibles;
	private DefaultListModel<String> modelSelected;
	private DefaultListModel<String> modelIdiomasDisponibles;
	private DefaultListModel<String> modelIdiomasSelected;
	private ArrayList<String> stringDisponibles = new ArrayList<String>();
	private ArrayList<String> stringSelected = new ArrayList<String>();
	private ArrayList<String> stringIdiomasDisponibles = new ArrayList<String>();
	private ArrayList<String> stringIdiomasSelected = new ArrayList<String>();
	private int selected = -1;
	private int selected2 = -1;
	private JButton btnAdd;
	private JButton btnRemove;
	private JTextField txtCodigoSol;
	private JTextField txtFecha;
	private JTextField txtCodigoTipo;
	private JPanel panelDetalles1;
	private JButton btnSiguiente;
	private JLabel lblCedulaCodigo;
	private JList listIdiomasDisponibles;
	private JList listIdiomasSelected;
	private JComboBox cbxTipoContrato;
	private JComboBox cbxCondFisica;
	private JCheckBox chkbxMudarse;
	private JCheckBox chkbxLicencia;
	private JCheckBox chkbxVehiculo;
	private JButton btnAddIdiomas;
	private JButton btnRemoveIdiomas;
	private JSpinner spnSueldoMin;
	private JSpinner spnSueldoMax;
	private JSpinner spnEmpleados;
	private JRadioButton rdbtnCentroEmp;
	private JRadioButton rdbtnPersona;
	private JSlider sliderMatcheo;
	

	public static void main(String[] args) {
		try {
			RegistroSolicitud dialog = new RegistroSolicitud();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public RegistroSolicitud() {
		setTitle("Registro de solicitud");
		setBounds(100, 100, 697, 840);
		modelDisponibles = new DefaultListModel<String>();
		modelSelected = new DefaultListModel<String>();
		modelIdiomasDisponibles = new DefaultListModel<String>();
		modelIdiomasSelected = new DefaultListModel<String>();
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Formato", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
			panel_1.setBounds(12, 13, 645, 69);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			rdbtnCentroEmp = new JRadioButton("Centro empleador");
			rdbtnCentroEmp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnSiguiente.setEnabled(true);
					lblCedulaCodigo.setText("C\u00F3digo del centro empleador:");
					rdbtnUniversitario.setEnabled(true);
					rdbtnTecnico.setEnabled(true);
					rdbtnObrero.setEnabled(true);
					cbxCarrera.setEnabled(true);
					spnGraduacion.setEnabled(true);
					cbxEspecialidad.setEnabled(true);
					spnExperiencia.setEnabled(true);
				}
			});
			rdbtnCentroEmp.setSelected(true);
			rdbtnCentroEmp.setBounds(126, 22, 138, 25);
			panel_1.add(rdbtnCentroEmp);
			
			rdbtnPersona = new JRadioButton("Persona");
			rdbtnPersona.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelDetalles1.setVisible(true);
					panelDetalles2.setVisible(false);
					btnSiguiente.setEnabled(false);
					lblCedulaCodigo.setText("Cédula:");
					rdbtnUniversitario.setEnabled(false);
					rdbtnTecnico.setEnabled(false);
					rdbtnObrero.setEnabled(false);
					cbxCarrera.setEnabled(false);
					spnGraduacion.setEnabled(false);
					cbxEspecialidad.setEnabled(false);
					spnExperiencia.setEnabled(false);
				}
			});
			rdbtnPersona.setBounds(390, 22, 127, 25);
			panel_1.add(rdbtnPersona);
			
			btnGroup_1.add(rdbtnCentroEmp);
			btnGroup_1.add(rdbtnPersona);
			
			JPanel panel_3 = new JPanel();
			panel_3.setLayout(null);
			panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tipo de persona", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
			panel_3.setBounds(12, 484, 645, 77);
			panel.add(panel_3);
			
			rdbtnUniversitario = new JRadioButton("Universitario");
			rdbtnUniversitario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelUniversitario.setVisible(true);
					panelObrero.setVisible(false);
					panelTecnico.setVisible(false);
				}
			});
			rdbtnUniversitario.setSelected(true);
			rdbtnUniversitario.setBounds(63, 26, 138, 25);
			panel_3.add(rdbtnUniversitario);
			
			rdbtnTecnico = new JRadioButton("T\u00E9cnico");
			rdbtnTecnico.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelUniversitario.setVisible(false);
					panelObrero.setVisible(false);
					panelTecnico.setVisible(true);
				}
			});
			rdbtnTecnico.setBounds(264, 26, 127, 25);
			panel_3.add(rdbtnTecnico);
			
			rdbtnObrero = new JRadioButton("Obrero");
			rdbtnObrero.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelUniversitario.setVisible(false);
					panelObrero.setVisible(true);
					panelTecnico.setVisible(false);
				}
			});
			rdbtnObrero.setBounds(454, 26, 127, 25);
			panel_3.add(rdbtnObrero);
			
			btnGroup_2.add(rdbtnUniversitario);
			btnGroup_2.add(rdbtnTecnico);
			btnGroup_2.add(rdbtnObrero);
			
			panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Detalles", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
			panel_2.setBounds(12, 574, 645, 164);
			panel.add(panel_2);
			panel_2.setLayout(new CardLayout(0, 0));
			
			panelUniversitario = new JPanel();
			panel_2.add(panelUniversitario, "name_368647319830800");
			panelUniversitario.setLayout(null);
			
			JLabel lblNewLabel_5 = new JLabel("Carrera:");
			lblNewLabel_5.setBounds(12, 62, 56, 16);
			panelUniversitario.add(lblNewLabel_5);
			
			cbxCarrera = new JComboBox();
			cbxCarrera.setModel(new DefaultComboBoxModel(new String[] {"Direcci\u00F3n Empresarial", "Administraci\u00F3n Hotelera", "Arquitectura", "Comunicaci\u00F3n Social", "Derecho", "Dise\u00F1o e Interiorismo", "Econom\u00EDa", "Educaci\u00F3n", "Estomatolog\u00EDa", "Filosof\u00EDa", "Gesti\u00F3n Financiera y Auditor\u00EDa", "Ingenier\u00EDa Civil", "Ingenier\u00EDa Mec\u00E1nica", "Ingenier\u00EDa El\u00E9ctrica", "Ingenier\u00EDa Industrial", "Ingenier\u00EDa Mecatr\u00F3nica", "Ingenier\u00EDa de Ciencias de la Computaci\u00F3n", "Ingenier\u00EDa Telem\u00E1tica", "Medicina", "Marketing", "Nutrici\u00F3n y Diet\u00E9tica", "Terapia F\u00EDsica", "Trabajo Social", "Hospitalidad y Turismo"}));
			cbxCarrera.setBounds(80, 59, 222, 22);
			panelUniversitario.add(cbxCarrera);
			
			JLabel lblNewLabel_6 = new JLabel("A\u00F1o de graduaci\u00F3n:");
			lblNewLabel_6.setBounds(330, 62, 114, 16);
			panelUniversitario.add(lblNewLabel_6);
			
			spnGraduacion = new JSpinner();
			spnGraduacion.setModel(new SpinnerNumberModel(new Integer(2017), new Integer(2017), null, new Integer(1)));
			spnGraduacion.setBounds(456, 59, 165, 22);
			JSpinner.NumberEditor ne_spnGraduacion = new JSpinner.NumberEditor(spnGraduacion, "#");
			spnGraduacion.setEditor(ne_spnGraduacion);
			panelUniversitario.add(spnGraduacion);
			
			panelTecnico = new JPanel();
			panel_2.add(panelTecnico, "name_368667454194800");
			panelTecnico.setLayout(null);
			
			JLabel lblAreaDeEspecialidad = new JLabel("Area de especialidad:");
			lblAreaDeEspecialidad.setBounds(12, 62, 134, 16);
			panelTecnico.add(lblAreaDeEspecialidad);
			
			cbxEspecialidad = new JComboBox();
			cbxEspecialidad.setModel(new DefaultComboBoxModel(new String[] {"Electricidad Industrial", "Electricidad Residencial", "Electricidad Automotriz", "Mec\u00E1nica Automotriz", "Mec\u00E1nica Industrial", "Inform\u00E1tica", "Producci\u00F3n Audiovisual", "Confecci\u00F3n y Patronaje", "Reparaci\u00F3n de Equipos Electr\u00F3nicos", "Ebanister\u00EDa", "Reposter\u00EDa"}));
			cbxEspecialidad.setBounds(153, 59, 165, 22);
			panelTecnico.add(cbxEspecialidad);
			
			JLabel lblAosDeExperiencia = new JLabel("A\u00F1os de experiencia:");
			lblAosDeExperiencia.setBounds(355, 62, 120, 16);
			panelTecnico.add(lblAosDeExperiencia);
			
			spnExperiencia = new JSpinner();
			spnExperiencia.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spnExperiencia.setBounds(487, 59, 134, 22);
			panelTecnico.add(spnExperiencia);
			
			panelObrero = new JPanel();
			panel_2.add(panelObrero, "name_368670109865500");
			panelObrero.setLayout(null);
			
			JPanel panel_4 = new JPanel();
			panel_4.setBounds(12, 13, 255, 115);
			panelObrero.add(panel_4);
			panel_4.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel_4.add(scrollPane, BorderLayout.CENTER);
			
			listOficiosDisp = new JList();
			listOficiosDisp.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					selected = listOficiosDisp.getSelectedIndex();
					if(selected > -1) {
						btnAdd.setEnabled(true);
					}
				}
			});
			listOficiosDisp.setModel(modelDisponibles);
			listOficiosDisp.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollPane.setViewportView(listOficiosDisp);
			
			JPanel panel_5 = new JPanel();
			panel_5.setBounds(366, 13, 255, 115);
			panelObrero.add(panel_5);
			panel_5.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel_5.add(scrollPane_1, BorderLayout.CENTER);
			
			listOficiosSelected = new JList();
			listOficiosSelected.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					selected = listOficiosSelected.getSelectedIndex();
					if(selected > -1) {
						btnRemove.setEnabled(true);
					}
				}
			});
			listOficiosSelected.setModel(modelSelected);
			listOficiosSelected.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollPane_1.setViewportView(listOficiosSelected);
			
			btnAdd = new JButton(">");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnAdd.setEnabled(false);
					String temp = stringDisponibles.get(selected);
					stringSelected.add(temp);
					modelSelected.addElement(temp);
					stringDisponibles.remove(selected);
					reloadDisponibles(modelDisponibles, stringDisponibles);
					reloadSelected(modelSelected, stringSelected);
					selected = -1;
				}
			});
			btnAdd.setEnabled(false);
			btnAdd.setBounds(279, 30, 75, 25);
			panelObrero.add(btnAdd);
			
			btnRemove = new JButton("<");
			btnRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnRemove.setEnabled(false);
					String temp = stringSelected.get(selected);
					stringDisponibles.add(temp);
					modelDisponibles.addElement(temp);
					stringSelected.remove(selected);
					reloadDisponibles(modelDisponibles, stringDisponibles);
					reloadSelected(modelSelected, stringSelected);
					selected = -1;
				}
			});
			btnRemove.setEnabled(false);
			btnRemove.setBounds(279, 85, 75, 25);
			panelObrero.add(btnRemove);
			
			panelDetalles2 = new JPanel();
			panelDetalles2.setBorder(new TitledBorder(null, "Detalles", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
			panelDetalles2.setLayout(null);
			panelDetalles2.setBounds(12, 95, 645, 376);
			panel.add(panelDetalles2);
			panelDetalles2.setVisible(false);
			
			JButton btnAtras = new JButton("<<");
			btnAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelDetalles2.setVisible(false);
					panelDetalles1.setVisible(true);
				}
			});
			btnAtras.setBounds(552, 317, 65, 25);
			panelDetalles2.add(btnAtras);
			
			JLabel label_7 = new JLabel("Cantidad de empleados:");
			label_7.setHorizontalAlignment(SwingConstants.CENTER);
			label_7.setBounds(12, 291, 633, 16);
			panelDetalles2.add(label_7);
			
			sliderMatcheo = new JSlider();
			sliderMatcheo.setPaintTicks(true);
			sliderMatcheo.setBounds(109, 218, 450, 43);
			sliderMatcheo.setMinorTickSpacing(2);  
			sliderMatcheo.setMajorTickSpacing(10);  
			sliderMatcheo.setPaintLabels(true);
			panelDetalles2.add(sliderMatcheo);
			
			JLabel label_8 = new JLabel("Porcentaje de Matching:");
			label_8.setHorizontalAlignment(SwingConstants.CENTER);
			label_8.setBounds(12, 189, 633, 16);
			panelDetalles2.add(label_8);
			
			spnEmpleados = new JSpinner();
			spnEmpleados.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spnEmpleados.setBounds(239, 320, 179, 22);
			panelDetalles2.add(spnEmpleados);
			
			JLabel lblNewLabel = new JLabel("Idiomas:");
			lblNewLabel.setBounds(22, 26, 56, 16);
			panelDetalles2.add(lblNewLabel);
			
			JPanel panel_6 = new JPanel();
			panel_6.setBounds(22, 48, 240, 128);
			panelDetalles2.add(panel_6);
			panel_6.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane_2 = new JScrollPane();
			panel_6.add(scrollPane_2, BorderLayout.CENTER);
			
			listIdiomasDisponibles = new JList();
			listIdiomasDisponibles.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					selected2 = listIdiomasDisponibles.getSelectedIndex();
					if(selected2 > -1) {
						btnAddIdiomas.setEnabled(true);
					}
				}
			});
			listIdiomasDisponibles.setModel(modelIdiomasDisponibles);
			listIdiomasDisponibles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollPane_2.setViewportView(listIdiomasDisponibles);
			
			JPanel panel_7 = new JPanel();
			panel_7.setBounds(383, 48, 234, 128);
			panelDetalles2.add(panel_7);
			panel_7.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane_3 = new JScrollPane();
			panel_7.add(scrollPane_3, BorderLayout.CENTER);
			
			listIdiomasSelected = new JList();
			listIdiomasSelected.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					selected2 = listIdiomasSelected.getSelectedIndex();
					if(selected2 > -1) {
						btnRemoveIdiomas.setEnabled(true);
					}
				}
			});
			listIdiomasSelected.setModel(modelIdiomasSelected);
			listIdiomasSelected.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollPane_3.setViewportView(listIdiomasSelected);
			
			btnAddIdiomas = new JButton(">");
			btnAddIdiomas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnAddIdiomas.setEnabled(false);
					String temp = stringIdiomasDisponibles.get(selected2);
					stringIdiomasSelected.add(temp);
					modelIdiomasSelected.addElement(temp);
					stringIdiomasDisponibles.remove(selected2);
					reloadDisponibles(modelIdiomasDisponibles, stringIdiomasDisponibles);
					reloadSelected(modelIdiomasSelected, stringIdiomasSelected);
					selected2 = -1;
				}
			});
			btnAddIdiomas.setEnabled(false);
			btnAddIdiomas.setBounds(290, 81, 65, 25);
			panelDetalles2.add(btnAddIdiomas);
			
			btnRemoveIdiomas = new JButton("<");
			btnRemoveIdiomas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnRemoveIdiomas.setEnabled(false);
					String temp = stringIdiomasSelected.get(selected2);
					stringIdiomasDisponibles.add(temp);
					modelIdiomasDisponibles.addElement(temp);
					stringIdiomasSelected.remove(selected2);
					reloadDisponibles(modelIdiomasDisponibles, stringIdiomasDisponibles);
					reloadSelected(modelIdiomasSelected, stringIdiomasSelected);
					selected2 = -1;
				}
			});
			btnRemoveIdiomas.setEnabled(false);
			btnRemoveIdiomas.setBounds(290, 119, 65, 25);
			panelDetalles2.add(btnRemoveIdiomas);
			
			panelDetalles1 = new JPanel();
			panelDetalles1.setLayout(null);
			panelDetalles1.setBorder(new TitledBorder(null, "Detalles", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
			panelDetalles1.setBounds(12, 95, 645, 356);
			panel.add(panelDetalles1);
			
			JLabel label = new JLabel("C\u00F3digo de solicitud:");
			label.setBounds(12, 40, 117, 16);
			panelDetalles1.add(label);
			
			txtCodigoSol = new JTextField();
			txtCodigoSol.setText("SOL-1");
			txtCodigoSol.setEditable(false);
			txtCodigoSol.setColumns(10);
			txtCodigoSol.setBounds(141, 37, 179, 22);
			panelDetalles1.add(txtCodigoSol);
			
			JLabel label_1 = new JLabel("Fecha de creaci\u00F3n:");
			label_1.setBounds(366, 40, 117, 16);
			panelDetalles1.add(label_1);
			
			txtFecha = new JTextField();
			txtFecha.setText("24/13/2022");
			txtFecha.setEditable(false);
			txtFecha.setColumns(10);
			txtFecha.setBounds(495, 37, 122, 22);
			panelDetalles1.add(txtFecha);
			
			chkbxMudarse = new JCheckBox("\u00BFPuede mudarse?");
			chkbxMudarse.setBounds(12, 95, 136, 25);
			panelDetalles1.add(chkbxMudarse);
			
			chkbxLicencia = new JCheckBox("\u00BFTiene licencia de conducir?");
			chkbxLicencia.setBounds(214, 95, 194, 25);
			panelDetalles1.add(chkbxLicencia);
			
			chkbxVehiculo = new JCheckBox("\u00BFTiene veh\u00EDculo?");
			chkbxVehiculo.setBounds(481, 95, 136, 25);
			panelDetalles1.add(chkbxVehiculo);
			
			cbxCondFisica = new JComboBox();
			cbxCondFisica.setModel(new DefaultComboBoxModel(new String[] {"Muy buena", "Buena", "Intermedia", "Mala"}));
			cbxCondFisica.setBounds(454, 159, 163, 22);
			panelDetalles1.add(cbxCondFisica);
			
			JLabel label_2 = new JLabel("Condici\u00F3n f\u00EDsica:");
			label_2.setBounds(344, 162, 105, 16);
			panelDetalles1.add(label_2);
			
			cbxTipoContrato = new JComboBox();
			cbxTipoContrato.setModel(new DefaultComboBoxModel(new String[] {"Tiempo completo", "Tiempo parcial", "A distancia"}));
			cbxTipoContrato.setBounds(122, 159, 198, 22);
			panelDetalles1.add(cbxTipoContrato);
			
			JLabel label_3 = new JLabel("Tipo de contrato:");
			label_3.setBounds(12, 159, 117, 16);
			panelDetalles1.add(label_3);
			
			JLabel label_4 = new JLabel("Sueldo m\u00EDnimo:");
			label_4.setBounds(12, 224, 105, 16);
			panelDetalles1.add(label_4);
			
			spnSueldoMin = new JSpinner();
			spnSueldoMin.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
			spnSueldoMin.setBounds(122, 221, 198, 22);
			panelDetalles1.add(spnSueldoMin);
			
			JLabel label_5 = new JLabel("Sueldo m\u00E1ximo:");
			label_5.setBounds(344, 224, 105, 16);
			panelDetalles1.add(label_5);
			
			spnSueldoMax = new JSpinner();
			spnSueldoMax.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
			spnSueldoMax.setBounds(454, 221, 163, 22);
			panelDetalles1.add(spnSueldoMax);
			
			txtCodigoTipo = new JTextField();
			txtCodigoTipo.setColumns(10);
			txtCodigoTipo.setBounds(168, 303, 308, 22);
			panelDetalles1.add(txtCodigoTipo);
			
			lblCedulaCodigo = new JLabel("C\u00F3digo del centro empleador:");
			lblCedulaCodigo.setHorizontalAlignment(SwingConstants.CENTER);
			lblCedulaCodigo.setBounds(168, 278, 308, 16);
			panelDetalles1.add(lblCedulaCodigo);
			
			btnSiguiente = new JButton(">>");
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelDetalles2.setVisible(true);
					panelDetalles1.setVisible(false);
				}
			});
			btnSiguiente.setBounds(552, 317, 65, 25);
			panelDetalles1.add(btnSiguiente);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null, "Solicitud realizada exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
						clean();
					}
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
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
		clean();
		loadDisponibles();
		loadDisponiblesIdiomas();
	}
	private void clean() {
		txtCodigoSol.setText("SOL-"+(BolsaLaboral.getInstance().getSolicitudes().size()+1));
		txtFecha.setText(dateFormat.format(new Date()));
		chkbxLicencia.setSelected(false);
		chkbxMudarse.setSelected(false);
		chkbxVehiculo.setSelected(false);
		cbxCarrera.setSelectedIndex(0);
		cbxCondFisica.setSelectedIndex(0);
		cbxEspecialidad.setSelectedIndex(0);
		cbxTipoContrato.setSelectedIndex(0);
		spnExperiencia.setValue(0);
		spnGraduacion.setValue(2017);
		spnSueldoMax.setValue(1);
		spnSueldoMin.setValue(1);
		txtCodigoTipo.setText("");
		spnEmpleados.setValue(1);
		limpiarSelected();
		panelObrero.setVisible(false);
		panelTecnico.setVisible(false);
		btnGroup_1.setSelected(rdbtnCentroEmp.getModel(), true);
		btnGroup_2.setSelected(rdbtnUniversitario.getModel(), true);
		btnSiguiente.setEnabled(true);
		lblCedulaCodigo.setText("C\u00F3digo del centro empleador:");
		rdbtnUniversitario.setEnabled(true);
		rdbtnTecnico.setEnabled(true);
		rdbtnObrero.setEnabled(true);
		cbxCarrera.setEnabled(true);
		spnGraduacion.setEnabled(true);
		cbxEspecialidad.setEnabled(true);
		spnExperiencia.setEnabled(true);
		panelDetalles2.setVisible(false);
		panelDetalles1.setVisible(true);
		sliderMatcheo.setValue(50);
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
	
	private void loadDisponiblesIdiomas(){
		modelIdiomasDisponibles.removeAllElements();
		String aux = "";
		stringIdiomasDisponibles.removeAll(stringIdiomasDisponibles);
		stringIdiomasDisponibles.add("Español");stringIdiomasDisponibles.add("Inglés");stringIdiomasDisponibles.add("Francés");stringIdiomasDisponibles.add("Alemán");stringIdiomasDisponibles.add("Mandarín");stringIdiomasDisponibles.add("Hindi");stringIdiomasDisponibles.add("Árabe");stringIdiomasDisponibles.add("Bengalí");stringIdiomasDisponibles.add("Portugués");stringIdiomasDisponibles.add("Ruso");	
		for(int i = 0; i < stringIdiomasDisponibles.size(); i++) {
			aux = stringIdiomasDisponibles.get(i);
			modelIdiomasDisponibles.addElement(aux);
		}
	}
	
	private void reloadDisponibles(DefaultListModel<String> modelDisponibles, ArrayList<String> stringDisponibles){
		modelDisponibles.removeAllElements();
		String aux = "";
		for(int i = 0; i < stringDisponibles.size(); i++) {
			aux = stringDisponibles.get(i);
			modelDisponibles.addElement(aux);
		}
	}
	
	private void reloadSelected(DefaultListModel<String> modelSelected, ArrayList<String> stringSelected) {
		modelSelected.removeAllElements();
		String aux = "";
		for(int i = 0; i < stringSelected.size(); i++) {
			aux = stringSelected.get(i);
			modelSelected.addElement(aux);
		}
	}
	private void limpiarSelected() {
		stringSelected = new ArrayList<String>();
		stringIdiomasSelected = new ArrayList<String>();
		reloadSelected(modelSelected, stringSelected);
		reloadSelected(modelIdiomasSelected, stringIdiomasSelected);
		loadDisponiblesIdiomas();
		loadDisponibles();
	}
}
