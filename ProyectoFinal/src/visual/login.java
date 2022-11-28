package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logical.Control;
import logical.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream empresa;
				FileOutputStream empresa2;
				ObjectInputStream empresaRead;
				ObjectOutputStream empresaWrite;
				try {
					empresa = new FileInputStream ("empresa.dat");
					empresaRead = new ObjectInputStream(empresa);
					Control temp = (Control)empresaRead.readObject();
					Control.setControl(temp);
					empresa.close();
					empresaRead.close();
				} catch (FileNotFoundException e) {
					try {
						empresa2 = new  FileOutputStream("empresa.dat");
						empresaWrite = new ObjectOutputStream(empresa2);
						User aux = new User("Administrador", "Admin", "Admin");
						Control.getInstance().regUser(aux);
						empresaWrite.writeObject(Control.getInstance());
						empresa2.close();
						empresaWrite.close();
					} catch (FileNotFoundException e1) {
					} catch (IOException e1) {
						// TODO Auto-generated catch block
					}
				} catch (IOException e) {
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setTitle("Iniciar Sesi\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 383, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(149, 37, 57, 14);
		panel.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(137, 95, 81, 14);
		panel.add(lblContrasea);
		
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(82, 62, 191, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String myPass=String.valueOf(txtContraseña.getPassword());
				if(Control.getInstance().confirmLogin(txtUsuario.getText(),myPass)){
					JOptionPane.showMessageDialog(null, "Bienvenido señor/a "+txtUsuario.getText(), "Información", JOptionPane.INFORMATION_MESSAGE);
					Principal frame = new Principal();
					dispose();
					frame.setVisible(true);
				}else {
				JOptionPane.showMessageDialog(null, "El nombre de usuario o la contraseña son incorrectas, intente de nuevo", "Información", JOptionPane.INFORMATION_MESSAGE);
				clean();

				};
				
				
			}
		});
	

		btnLogin.setBounds(133, 173, 89, 23);
		panel.add(btnLogin);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setBounds(82, 123, 191, 22);
		panel.add(txtContraseña);
		
		txtContraseña.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String myPass=String.valueOf(txtContraseña.getPassword());
				if(Control.getInstance().confirmLogin(txtUsuario.getText(),myPass)){
					JOptionPane.showMessageDialog(null, "Bienvenido señor/a "+txtUsuario.getText(), "Información", JOptionPane.INFORMATION_MESSAGE);
					Principal frame = new Principal();
					dispose();
					frame.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "El nombre de usuario o la contraseña son incorrectas, intente de nuevo", "Información", JOptionPane.INFORMATION_MESSAGE);
					clean();
				};
			}

			

		});
	}
	private void clean() {
		txtContraseña.setText("");
		txtUsuario.setText("");
		txtUsuario.requestFocus();
	}
}