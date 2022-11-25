package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logical.Control;
import logical.User;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class regUser extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JComboBox comboBox;
	private JPasswordField textField_1;
	private JPasswordField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			regUser dialog = new regUser();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public regUser() {
		setBounds(100, 100, 450, 228);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNombreUsuario = new JLabel("Nombre Usuario:");
		lblNombreUsuario.setBounds(20, 26, 97, 14);
		contentPanel.add(lblNombreUsuario);
		
		textField = new JTextField();
		textField.setBounds(20, 49, 127, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Administrador", "Secretario"}));
		comboBox.setBounds(20, 113, 127, 20);
		contentPanel.add(comboBox);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(20, 88, 97, 14);
		contentPanel.add(lblTipo);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(189, 26, 97, 14);
		contentPanel.add(lblPassword);
		
		JLabel lblConfirmarPassword = new JLabel("Confirmar Password:");
		lblConfirmarPassword.setBounds(189, 88, 167, 14);
		contentPanel.add(lblConfirmarPassword);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(189, 48, 148, 22);
		contentPanel.add(textField_1);
		
		textField_2 = new JPasswordField();
		textField_2.setBounds(189, 112, 148, 22);
		contentPanel.add(textField_2);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						User user = new User(comboBox.getSelectedItem().toString(),textField.getText(),textField_1.getText());
					    Control.getInstance().regUser(user);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}