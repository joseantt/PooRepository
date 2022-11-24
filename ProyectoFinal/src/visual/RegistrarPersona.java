package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import javax.swing.ScrollPaneConstants;
import java.awt.Component;
import javax.swing.Box;

public class RegistrarPersona extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JSpinner spnFechaNacimiento;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JRadioButton rdbtnObrero;
	private JRadioButton rdbtnTcnico;
	private JRadioButton rdbtnUniversitario;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnMujer;
	private JSpinner spnAñoGraduacion;
	private ButtonGroup btngroup = new ButtonGroup();
	private JLabel lblCarrera;
	private JLabel lblAñoGraduacion;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarPersona dialog = new RegistrarPersona();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarPersona() {
		setTitle("Registrar Persona");
		setBounds(100, 100, 583, 553);
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
			panel_1.setBounds(12, 13, 537, 279);
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
			
			textField = new JTextField();
			textField.setBounds(72, 23, 167, 22);
			panel_1.add(textField);
			textField.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setBounds(251, 23, 56, 16);
			panel_1.add(lblNewLabel_1);
			
			textField_1 = new JTextField();
			textField_1.setBounds(317, 23, 196, 22);
			panel_1.add(textField_1);
			textField_1.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Apellidos:");
			lblNewLabel_2.setBounds(12, 62, 56, 16);
			panel_1.add(lblNewLabel_2);
			
			textField_2 = new JTextField();
			textField_2.setBounds(72, 59, 167, 22);
			panel_1.add(textField_2);
			textField_2.setColumns(10);
			
			JLabel lblNewLabel_3 = new JLabel("Direcci\u00F3n:");
			lblNewLabel_3.setBounds(251, 62, 67, 16);
			panel_1.add(lblNewLabel_3);
			
			textField_3 = new JTextField();
			textField_3.setBounds(317, 59, 196, 22);
			panel_1.add(textField_3);
			textField_3.setColumns(10);
			
			JLabel lblNewLabel_4 = new JLabel("Tel\u00E9fono:");
			lblNewLabel_4.setBounds(12, 94, 56, 16);
			panel_1.add(lblNewLabel_4);
			
			textField_4 = new JTextField();
			textField_4.setBounds(72, 91, 167, 22);
			panel_1.add(textField_4);
			textField_4.setColumns(10);
			
			JLabel lblNewLabel_5 = new JLabel("Fecha de Nacimiento:");
			lblNewLabel_5.setBounds(251, 94, 135, 16);
			panel_1.add(lblNewLabel_5);
			
			JLabel lblNewLabel_6 = new JLabel("Sexo:");
			lblNewLabel_6.setBounds(148, 139, 56, 16);
			panel_1.add(lblNewLabel_6);
			
			rdbtnNewRadioButton = new JRadioButton("Hombre");
			rdbtnNewRadioButton.setBounds(208, 135, 84, 25);
			panel_1.add(rdbtnNewRadioButton);
			
			rdbtnMujer = new JRadioButton("Mujer");
			rdbtnMujer.setBounds(308, 135, 67, 25);
			panel_1.add(rdbtnMujer);
			
			JLabel lblNewLabel_7 = new JLabel("Idiomas:");
			lblNewLabel_7.setBounds(12, 223, 56, 16);
			panel_1.add(lblNewLabel_7);
			
			JPanel panel_4 = new JPanel();
			panel_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_4.setBounds(69, 193, 167, 73);
			panel_1.add(panel_4);
			panel_4.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel_4.add(scrollPane, BorderLayout.CENTER);
			
			JList JlistDisponibles = new JList();
			JlistDisponibles.setModel(new AbstractListModel() {
				String[] values = new String[] {"Espa\u00F1ol", "Ingl\u00E9s", "Franc\u00E9s", "Aleman"};
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
			scrollPane.setViewportView(JlistDisponibles);
			
			JPanel panel_5 = new JPanel();
			panel_5.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_5.setBounds(346, 193, 167, 73);
			panel_1.add(panel_5);
			panel_5.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane_1 = new JScrollPane();
			panel_5.add(scrollPane_1, BorderLayout.CENTER);
			
			JList JlistSeleccionados = new JList();
			scrollPane_1.setViewportView(JlistSeleccionados);
			
			JButton btnNewButton = new JButton(">>");
			btnNewButton.setBounds(266, 193, 51, 25);
			panel_1.add(btnNewButton);
			
			JButton button = new JButton("<<");
			button.setBounds(266, 231, 51, 25);
			panel_1.add(button);
			
			Component horizontalStrut = Box.createHorizontalStrut(20);
			horizontalStrut.setBackground(Color.BLACK);
			horizontalStrut.setBounds(0, 178, 537, -12);
			panel_1.add(horizontalStrut);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tipo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_2.setBounds(12, 305, 537, 65);
			panel.add(panel_2);
			panel_2.setLayout(null);
			
			rdbtnUniversitario = new JRadioButton("Universitario");
			rdbtnUniversitario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblCarrera.setText("Carrera:");	
					lblAñoGraduacion.setText("Años de Graduación");
					lblAñoGraduacion.setVisible(true);
					spnAñoGraduacion.setVisible(true);
				}
			});
			rdbtnUniversitario.setSelected(true);
			rdbtnUniversitario.setBounds(8, 20, 127, 25);
			panel_2.add(rdbtnUniversitario);
			
			rdbtnTcnico = new JRadioButton("T\u00E9cnico");
			rdbtnTcnico.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblCarrera.setText("Area de Especialidad:");	
					lblAñoGraduacion.setText("Años de experiencia:");
					lblAñoGraduacion.setVisible(true);
					spnAñoGraduacion.setVisible(true);
				}
			});
			rdbtnTcnico.setBounds(204, 20, 127, 25);
			panel_2.add(rdbtnTcnico);
			
			rdbtnObrero = new JRadioButton("Obrero");
			rdbtnObrero.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblCarrera.setText("Oficios");
					lblAñoGraduacion.setVisible(false);
					spnAñoGraduacion.setVisible(false);
				}
			});
			rdbtnObrero.setBounds(402, 20, 127, 25);
			panel_2.add(rdbtnObrero);
			
			btngroup.add(rdbtnUniversitario);
			btngroup.add(rdbtnTcnico);
			btngroup.add(rdbtnObrero);

			
			JPanel panel_3 = new JPanel();
			panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Extra", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_3.setBounds(12, 383, 537, 65);
			panel.add(panel_3);
			panel_3.setLayout(null);
			
			lblCarrera = new JLabel("Carrera:");
			lblCarrera.setBounds(12, 25, 132, 16);
			panel_3.add(lblCarrera);
			
			lblAñoGraduacion = new JLabel("A\u00F1o de Graduaci\u00F3n:");
			lblAñoGraduacion.setBounds(288, 25, 120, 16);
			panel_3.add(lblAñoGraduacion);
			
			spnAñoGraduacion = new JSpinner();
			spnAñoGraduacion.setBounds(428, 22, 97, 22);
			spnAñoGraduacion.setModel(new SpinnerDateModel(new Date(), new Date(), null, Calendar.MONTH));
			JSpinner.DateEditor de_spnAñoGraduacion = new JSpinner.DateEditor(spnAñoGraduacion, "dd/MM/yyyy");
			spnAñoGraduacion.setEditor(de_spnAñoGraduacion);
			panel_3.add(spnAñoGraduacion);
			
			JComboBox cbxCarrera = 	new JComboBox();
			cbxCarrera.setBounds(144, 22, 132, 22);
			panel_3.add(cbxCarrera);
			

		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
}
