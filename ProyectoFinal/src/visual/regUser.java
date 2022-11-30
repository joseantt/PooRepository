package visual;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logical.BolsaLaboral;
import logical.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.Color;

public class regUser extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JComboBox cbxTipo;
	private JPasswordField txtPassword;
	private JPasswordField txtConfirmPassword;
	private JButton btnRegistrar;
	private JButton btnCancelar;

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
		setTitle("Registrar Usuario");
		setBounds(100, 100, 450, 228);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNombreUsuario = new JLabel("Nombre Usuario:");
		lblNombreUsuario.setBounds(45, 25, 97, 14);
		contentPanel.add(lblNombreUsuario);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(45, 48, 127, 20);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		cbxTipo = new JComboBox();
		cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Administrador", "Secretario"}));
		cbxTipo.setBounds(45, 112, 127, 20);
		contentPanel.add(cbxTipo);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(45, 87, 97, 14);
		contentPanel.add(lblTipo);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(214, 25, 97, 14);
		contentPanel.add(lblPassword);
		
		JLabel lblConfirmarPassword = new JLabel("Confirmar Password:");
		lblConfirmarPassword.setBounds(214, 87, 167, 14);
		contentPanel.add(lblConfirmarPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(214, 47, 148, 22);
		contentPanel.add(txtPassword);
		
		txtConfirmPassword = new JPasswordField();
		txtConfirmPassword.setBounds(214, 111, 148, 22);
		contentPanel.add(txtConfirmPassword);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnRegistrar = new JButton("Registrar");
				btnRegistrar.setForeground(Color.BLACK);
				btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						User user = new User(cbxTipo.getSelectedItem().toString(),txtNombre.getText(),txtPassword.getText());
						JOptionPane.showMessageDialog(null, "Registro Satisfactorio", "Información",JOptionPane.INFORMATION_MESSAGE);
						BolsaLaboral.getInstance().regUser(user);
						clean();
					}
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				btnCancelar = new JButton("Cancel");
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
	public void clean () {
		txtNombre.setText("");
		txtPassword.setText("");
		cbxTipo.setSelectedIndex(0);
		txtConfirmPassword.setText("");
	}
	
}
