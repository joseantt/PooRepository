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
import java.util.Calendar;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class RegistroSolicitud extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ButtonGroup btnGroup_1 = new ButtonGroup();
	private ButtonGroup btnGroup_2 = new ButtonGroup();
	private JTextField txtCodigoSoli;
	private JTextField txtFechaCreacion;
	private JTextField textField_2;
	private JLabel lblCedulaCodigo;
	private JButton btnSiguiente;
	private JCheckBox chkbxVehiculo;
	private JCheckBox chkbxLicencia;
	private JCheckBox chkbxMudarse;
	private JPanel panelDetalles1;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistroSolicitud dialog = new RegistroSolicitud();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistroSolicitud() {
		setTitle("Registro de solicitud");
		setBounds(100, 100, 697, 819);
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
			
			JRadioButton rdbtnCentroEmp = new JRadioButton("Centro empleador");
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
			
			JRadioButton rdbtnPersona = new JRadioButton("Persona");
			rdbtnPersona.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
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
			panel_3.setBounds(12, 464, 645, 77);
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
			panel_2.setBounds(12, 554, 645, 166);
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
			
			JPanel panel_5 = new JPanel();
			panel_5.setBounds(366, 13, 255, 115);
			panelObrero.add(panel_5);
			panel_5.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel_5.add(scrollPane_1, BorderLayout.CENTER);
			
			JButton btnNewButton = new JButton(">");
			btnNewButton.setBounds(279, 30, 75, 25);
			panelObrero.add(btnNewButton);
			
			JButton button = new JButton("<");
			button.setBounds(279, 85, 75, 25);
			panelObrero.add(button);
			
			panelDetalles1 = new JPanel();
			panelDetalles1.setBorder(new TitledBorder(null, "Detalles", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
			panelDetalles1.setLayout(null);
			panelDetalles1.setBounds(12, 95, 645, 356);
			panel.add(panelDetalles1);
			
			JLabel label = new JLabel("C\u00F3digo de solicitud:");
			label.setBounds(12, 40, 117, 16);
			panelDetalles1.add(label);
			
			txtCodigoSoli = new JTextField();
			txtCodigoSoli.setEditable(false);
			txtCodigoSoli.setColumns(10);
			txtCodigoSoli.setBounds(141, 37, 179, 22);
			panelDetalles1.add(txtCodigoSoli);
			
			JLabel label_1 = new JLabel("Fecha de creaci\u00F3n:");
			label_1.setBounds(366, 40, 117, 16);
			panelDetalles1.add(label_1);
			
			txtFechaCreacion = new JTextField();
			txtFechaCreacion.setEditable(false);
			txtFechaCreacion.setColumns(10);
			txtFechaCreacion.setBounds(495, 37, 122, 22);
			panelDetalles1.add(txtFechaCreacion);
			
			chkbxMudarse = new JCheckBox("\u00BFPuede mudarse?");
			chkbxMudarse.setBounds(12, 95, 136, 25);
			panelDetalles1.add(chkbxMudarse);
			
			chkbxLicencia = new JCheckBox("\u00BFTiene licencia de conducir?");
			chkbxLicencia.setBounds(214, 95, 194, 25);
			panelDetalles1.add(chkbxLicencia);
			
			chkbxVehiculo = new JCheckBox("\u00BFTiene veh\u00EDculo?");
			chkbxVehiculo.setBounds(481, 95, 136, 25);
			panelDetalles1.add(chkbxVehiculo);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Muy buena", "Buena", "Intermedia", "Mala"}));
			comboBox.setBounds(454, 159, 163, 22);
			panelDetalles1.add(comboBox);
			
			JLabel label_2 = new JLabel("Condici\u00F3n f\u00EDsica:");
			label_2.setBounds(344, 162, 105, 16);
			panelDetalles1.add(label_2);
			
			JComboBox comboBox_1 = new JComboBox();
			comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Tiempo completo", "Tiempo parcial", "A distancia"}));
			comboBox_1.setBounds(122, 159, 198, 22);
			panelDetalles1.add(comboBox_1);
			
			JLabel label_3 = new JLabel("Tipo de contrato:");
			label_3.setBounds(12, 159, 117, 16);
			panelDetalles1.add(label_3);
			
			JLabel label_4 = new JLabel("Sueldo m\u00EDnimo:");
			label_4.setBounds(12, 224, 105, 16);
			panelDetalles1.add(label_4);
			
			JSpinner spinner = new JSpinner();
			spinner.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
			spinner.setBounds(122, 221, 198, 22);
			panelDetalles1.add(spinner);
			
			JLabel label_5 = new JLabel("Sueldo m\u00E1ximo:");
			label_5.setBounds(344, 224, 105, 16);
			panelDetalles1.add(label_5);
			
			JSpinner spinner_1 = new JSpinner();
			spinner_1.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spinner_1.setBounds(454, 221, 163, 22);
			panelDetalles1.add(spinner_1);
			
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(168, 303, 308, 22);
			panelDetalles1.add(textField_2);
			
			lblCedulaCodigo = new JLabel("C\u00F3digo del centro empleador:");
			lblCedulaCodigo.setHorizontalAlignment(SwingConstants.CENTER);
			lblCedulaCodigo.setBounds(168, 278, 308, 16);
			panelDetalles1.add(lblCedulaCodigo);
			
			btnSiguiente = new JButton(">>");
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelDetalles1.setVisible(false);
					panelDetalles2.setVisible(true);
				}
			});
			btnSiguiente.setBounds(552, 300, 65, 25);
			panelDetalles1.add(btnSiguiente);
			
			panelDetalles2 = new JPanel();
			panelDetalles2.setBorder(new TitledBorder(null, "Detalles", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
			panelDetalles2.setLayout(null);
			panelDetalles2.setBounds(12, 95, 645, 356);
			panel.add(panelDetalles2);
			panelDetalles2.setVisible(false);
			
			JButton btnAtras = new JButton("<<");
			btnAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelDetalles2.setVisible(false);
					panelDetalles1.setVisible(true);
				}
			});
			btnAtras.setBounds(552, 300, 65, 25);
			panelDetalles2.add(btnAtras);
			
			JLabel label_7 = new JLabel("Cantidad de empleados:");
			label_7.setHorizontalAlignment(SwingConstants.CENTER);
			label_7.setBounds(0, 196, 633, 16);
			panelDetalles2.add(label_7);
			
			JSlider sliderMatcheo = new JSlider();
			sliderMatcheo.setPaintTicks(true);
			sliderMatcheo.setBounds(97, 123, 450, 43);
			sliderMatcheo.setMinorTickSpacing(2);  
			sliderMatcheo.setMajorTickSpacing(10);  
			sliderMatcheo.setPaintLabels(true);
			panelDetalles2.add(sliderMatcheo);
			
			JLabel label_8 = new JLabel("Porcentaje de Matching:");
			label_8.setHorizontalAlignment(SwingConstants.CENTER);
			label_8.setBounds(0, 94, 633, 16);
			panelDetalles2.add(label_8);
			
			JSpinner spnEmpleados = new JSpinner();
			spnEmpleados.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spnEmpleados.setBounds(227, 225, 179, 22);
			panelDetalles2.add(spnEmpleados);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
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
	}
	private void clean() {
		txtCodigoSoli.setText("SOL-" + (BolsaLaboral.getInstance().getSolicitudes().size()+1));
		Date date = Calendar.getInstance().getTime();
		txtFechaCreacion.setText(dateFormat.format(date));
	}
}
