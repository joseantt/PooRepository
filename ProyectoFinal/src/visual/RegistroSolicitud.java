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

public class RegistroSolicitud extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

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
		setBounds(100, 100, 697, 572);
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
			panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tipo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
			panel_1.setBounds(12, 13, 645, 94);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JRadioButton radioButton = new JRadioButton("Centro empleador");
			radioButton.setBounds(126, 34, 138, 25);
			panel_1.add(radioButton);
			
			JRadioButton radioButton_1 = new JRadioButton("Persona");
			radioButton_1.setBounds(390, 34, 127, 25);
			panel_1.add(radioButton_1);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Detalles", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
			panel_2.setBounds(12, 120, 645, 360);
			panel.add(panel_2);
			panel_2.setLayout(null);
			
			JLabel lblCode = new JLabel("C\u00F3digo de solicitud:");
			lblCode.setBounds(18, 38, 117, 16);
			panel_2.add(lblCode);
			
			JLabel lblNewLabel = new JLabel("Fecha de creaci\u00F3n:");
			lblNewLabel.setBounds(376, 38, 117, 16);
			panel_2.add(lblNewLabel);
			
			textField = new JTextField();
			textField.setEditable(false);
			textField.setBounds(147, 35, 205, 22);
			panel_2.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setEditable(false);
			textField_1.setBounds(505, 35, 122, 22);
			panel_2.add(textField_1);
			textField_1.setColumns(10);
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
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
}
