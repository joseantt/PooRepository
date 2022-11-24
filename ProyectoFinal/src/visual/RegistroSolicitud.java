package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
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

public class RegistroSolicitud extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ButtonGroup btnGroup_1 = new ButtonGroup();
	private ButtonGroup btnGroup_2 = new ButtonGroup();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblCedulaCodigo;
	private JButton btnSiguiente;
	private JCheckBox chkbxVehiculo;
	private JCheckBox chkbxLicencia;
	private JCheckBox chkbxMudarse;
	private JPanel panelDetalles1;
	private JPanel panelDetalles2;

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
		setBounds(100, 100, 697, 850);
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
			
			JRadioButton rdbtnUniversitario = new JRadioButton("Universitario");
			rdbtnUniversitario.setSelected(true);
			rdbtnUniversitario.setBounds(63, 26, 138, 25);
			panel_3.add(rdbtnUniversitario);
			
			JRadioButton rdbtnTcnico = new JRadioButton("T\u00E9cnico");
			rdbtnTcnico.setBounds(264, 26, 127, 25);
			panel_3.add(rdbtnTcnico);
			
			JRadioButton rdbtnObrero = new JRadioButton("Obrero");
			rdbtnObrero.setBounds(454, 26, 127, 25);
			panel_3.add(rdbtnObrero);
			
			btnGroup_2.add(rdbtnUniversitario);
			btnGroup_2.add(rdbtnTcnico);
			btnGroup_2.add(rdbtnObrero);
			
			JPanel panel_4 = new JPanel();
			panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Detalles", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
			panel_4.setBounds(12, 579, 645, 166);
			panel.add(panel_4);
			panel_4.setLayout(new CardLayout(0, 0));
			
			JPanel panel_5 = new JPanel();
			panel_4.add(panel_5, "name_368647319830800");
			panel_5.setLayout(null);
			
			JLabel lblNewLabel_5 = new JLabel("Carrera:");
			lblNewLabel_5.setBounds(12, 65, 56, 16);
			panel_5.add(lblNewLabel_5);
			
			JComboBox comboBox_2 = new JComboBox();
			comboBox_2.setBounds(80, 62, 165, 22);
			panel_5.add(comboBox_2);
			
			JLabel lblNewLabel_6 = new JLabel("A\u00F1o de graduaci\u00F3n:");
			lblNewLabel_6.setBounds(330, 65, 114, 16);
			panel_5.add(lblNewLabel_6);
			
			JSpinner spinner_2 = new JSpinner();
			spinner_2.setModel(new SpinnerNumberModel(new Integer(2017), new Integer(2017), null, new Integer(1)));
			spinner_2.setBounds(456, 62, 165, 22);
			JSpinner.NumberEditor editor = new JSpinner.NumberEditor(spinner_2, "#");
			spinner_2.setEditor(editor);
			panel_5.add(spinner_2);
			
			JPanel panel_6 = new JPanel();
			panel_4.add(panel_6, "name_368667454194800");
			panel_6.setLayout(null);
			
			JLabel lblAreaDeEspecialidad = new JLabel("Area de especialidad:");
			lblAreaDeEspecialidad.setBounds(12, 62, 134, 16);
			panel_6.add(lblAreaDeEspecialidad);
			
			JComboBox comboBox_3 = new JComboBox();
			comboBox_3.setBounds(153, 59, 165, 22);
			panel_6.add(comboBox_3);
			
			JLabel lblAosDeExperiencia = new JLabel("A\u00F1os de experiencia:");
			lblAosDeExperiencia.setBounds(355, 62, 120, 16);
			panel_6.add(lblAosDeExperiencia);
			
			JSpinner spinner_3 = new JSpinner();
			spinner_3.setBounds(487, 59, 134, 22);
			panel_6.add(spinner_3);
			
			JPanel panel_7 = new JPanel();
			panel_4.add(panel_7, "name_368670109865500");
			panel_7.setLayout(null);
			
			panelDetalles1 = new JPanel();
			panelDetalles1.setBorder(new TitledBorder(null, "Detalles", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
			panelDetalles1.setLayout(null);
			panelDetalles1.setBounds(12, 95, 645, 356);
			panel.add(panelDetalles1);
			
			JLabel label = new JLabel("C\u00F3digo de solicitud:");
			label.setBounds(12, 40, 117, 16);
			panelDetalles1.add(label);
			
			textField = new JTextField();
			textField.setEditable(false);
			textField.setColumns(10);
			textField.setBounds(141, 37, 179, 22);
			panelDetalles1.add(textField);
			
			JLabel label_1 = new JLabel("Fecha de creaci\u00F3n:");
			label_1.setBounds(366, 40, 117, 16);
			panelDetalles1.add(label_1);
			
			textField_1 = new JTextField();
			textField_1.setEditable(false);
			textField_1.setColumns(10);
			textField_1.setBounds(495, 37, 122, 22);
			panelDetalles1.add(textField_1);
			
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
			textField_2.setBounds(12, 303, 308, 22);
			panelDetalles1.add(textField_2);
			
			lblCedulaCodigo = new JLabel("C\u00F3digo del centro empleador:");
			lblCedulaCodigo.setHorizontalAlignment(SwingConstants.CENTER);
			lblCedulaCodigo.setBounds(12, 278, 308, 16);
			panelDetalles1.add(lblCedulaCodigo);
			
			btnSiguiente = new JButton(">>");
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelDetalles1.setVisible(false);
				}
			});
			btnSiguiente.setBounds(552, 300, 65, 25);
			panelDetalles1.add(btnSiguiente);
			
			panelDetalles2 = new JPanel();
			panelDetalles2.setBorder(new TitledBorder(null, "Detalles", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
			panelDetalles2.setLayout(null);
			panelDetalles2.setBounds(12, 95, 645, 356);
			panel.add(panelDetalles2);
			
			JButton btnAtras = new JButton("<<");
			btnAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelDetalles1.setVisible(true);
				}
			});
			btnAtras.setBounds(552, 300, 65, 25);
			panelDetalles2.add(btnAtras);
			
			JLabel label_7 = new JLabel("Cantidad de empleados:");
			label_7.setHorizontalAlignment(SwingConstants.CENTER);
			label_7.setBounds(0, 196, 633, 16);
			panelDetalles2.add(label_7);
			
			JSlider slider = new JSlider();
			slider.setPaintTicks(true);
			slider.setBounds(12, 123, 605, 43);
			panelDetalles2.add(slider);
			
			JLabel label_8 = new JLabel("Porcentaje de Matching:");
			label_8.setHorizontalAlignment(SwingConstants.CENTER);
			label_8.setBounds(0, 94, 633, 16);
			panelDetalles2.add(label_8);
			
			JSpinner spinner_4 = new JSpinner();
			spinner_4.setBounds(227, 225, 179, 22);
			panelDetalles2.add(spinner_4);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
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
	}
}
