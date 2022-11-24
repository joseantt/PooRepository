package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logical.Control;

import javax.swing.JMenuBar;
import javax.swing.JMenu; 
import javax.swing.JMenuItem;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim = null;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Principal() {
		if(Control.getInstance().getLoginUser()!= null)
		{
		setResizable(false);
		setTitle("Bolsa Laboral");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 303);
		dim = getToolkit().getScreenSize();
		setSize(dim.width-20, dim.height-70);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		if(Control.getInstance().getLoginUser().getTipo().equalsIgnoreCase("Admin") || Control.getInstance().getLoginUser().getTipo().equalsIgnoreCase("Secretaria") || Control.getInstance().getLoginUser().getUserName().equalsIgnoreCase("Admin"))
		{
			JMenu mnNewMenu_3 = new JMenu("Administraci\u00F3n");
			menuBar.add(mnNewMenu_3);
			JMenuItem mntmNewMenuItem = new JMenuItem("Realizar Matching");
			mnNewMenu_3.add(mntmNewMenuItem);
		}
		
		JMenu mnNewMenu_2 = new JMenu("Solicitud");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Realizar Solicitud");
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Listado Solicitudes de Personas");
		mnNewMenu_2.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Listado Solicitudes de Centros");
		mnNewMenu_2.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_1 = new JMenu("Centro Empleador");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Registrar Centro Empleador");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Listado de Centros Empleadores");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu = new JMenu("Persona");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Registrar Persona");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Listado de Personas");
		mnNewMenu.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		}
	}
}
