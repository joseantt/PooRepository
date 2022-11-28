package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logical.BolsaLaboral;
import logical.CentroEmpleador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarCentroEmpleador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JComboBox cbxTipo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarCentroEmpleador dialog = new RegistrarCentroEmpleador(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarCentroEmpleador(final CentroEmpleador Centro)
	{
		CentroEmpleador TestCentro = Centro;
		if (TestCentro == null ) {
			setTitle("Registro de Centro Empleador");
		}else {
			setTitle("Modificar Centro Empleador: " +TestCentro.getCodigo());
		}
		setBounds(100, 100, 535, 399);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("C\u00F3digo:");
			lblNewLabel.setBounds(12, 37, 56, 16);
			panel.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setBounds(12, 90, 56, 16);
			panel.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Direcci\u00F3n");
			lblNewLabel_2.setBounds(12, 143, 56, 16);
			panel.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("Tel\u00E9fono:");
			lblNewLabel_3.setBounds(12, 196, 56, 16);
			panel.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("Tipo:");
			lblNewLabel_4.setBounds(12, 249, 56, 16);
			panel.add(lblNewLabel_4);
			
			txtCodigo = new JTextField();
			txtCodigo.setEditable(false);
			txtCodigo.setBounds(80, 34, 235, 22);
			panel.add(txtCodigo);
			txtCodigo.setColumns(10);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(80, 87, 235, 22);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			txtDireccion = new JTextField();
			txtDireccion.setBounds(80, 140, 412, 22);
			panel.add(txtDireccion);
			txtDireccion.setColumns(10);
			
			txtTelefono = new JTextField();
			txtTelefono.setBounds(80, 193, 235, 22);
			panel.add(txtTelefono);
			txtTelefono.setColumns(10);
			
			cbxTipo = new JComboBox();
			cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"Inform\u00E1tica", "Marketing", "Zona Franca", "Construcci\u00F3n", "Mec\u00E1nica", "Electromec\u00E1nica", "Limpieza", "Contabilidad", "Turismo", "Firma de abogados", "Administraci\u00F3n"}));
			cbxTipo.setBounds(80, 246, 235, 22);
			panel.add(cbxTipo);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				if (TestCentro != null) {
					okButton.setText("Modificar");
				}
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(camposVacios()) {
							JOptionPane.showMessageDialog(null, "Existen campos vacíos. Inténtelo de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
						}else {
							BolsaLaboral.getInstance().eliminarCentro(Centro);
							CentroEmpleador centroEmp = new CentroEmpleador(txtCodigo.getText(), txtNombre.getText(), txtDireccion.getText(), txtTelefono.getText(), cbxTipo.getSelectedItem().toString());
							BolsaLaboral.getInstance().getCentroEmpleados().add(centroEmp);
							clean();
							JOptionPane.showMessageDialog(null, "Registro realizado exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
						}
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		clean();
		if(Centro!=null)
		{
			txtCodigo.setText(Centro.getCodigo());
			txtNombre.setText(Centro.getNombre());
			txtDireccion.setText(Centro.getDireccion());
			txtTelefono.setText(Centro.getTelefono());
		}
	}
	
	public void clean() {
		txtCodigo.setText("CEMP-"+(BolsaLaboral.getInstance().getCentroEmpleados().size()+1));
		txtTelefono.setText("");
		txtDireccion.setText("");
		txtNombre.setText("");
		cbxTipo.setSelectedIndex(0);
		txtNombre.requestFocus();
	}
	
	public boolean camposVacios() {
		boolean existeVacio = false;
		if(txtCodigo.getText().equals("") || txtNombre.getText().equals("") || 
				txtDireccion.getText().equals("") || txtTelefono.getText().equals("")) {
			existeVacio = true;
		}
		return existeVacio;
	}
}
