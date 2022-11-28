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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



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
			addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					FileOutputStream empresa2;
					ObjectOutputStream empresaWrite;
					try {
						empresa2 = new  FileOutputStream("empresa.dat");
						empresaWrite = new ObjectOutputStream(empresa2);
						empresaWrite.writeObject(Control.getInstance());
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
		setResizable(false);
		setTitle("Bolsa Laboral");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 303);
		dim = getToolkit().getScreenSize();
		setSize(dim.width-20, dim.height-70);
		setLocationRelativeTo(null); 
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		if(Control.getInstance().getLoginUser().getTipo().equalsIgnoreCase("Administrador") || Control.getInstance().getLoginUser().getTipo().equalsIgnoreCase("Secretaria"))
		{
			JMenu mnNewMenu_3 = new JMenu("Administraci\u00F3n");
			menuBar.add(mnNewMenu_3);
			JMenuItem mntmNewMenuItem = new JMenuItem("Realizar Matching");
			mnNewMenu_3.add(mntmNewMenuItem);
		}
		
		JMenu mnNewMenu_2 = new JMenu("Solicitud");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Realizar Solicitud");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroSolicitud rS = new RegistroSolicitud();
				rS.setModal(true);
				rS.setLocationRelativeTo(null);
				rS.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Listado Solicitudes de Personas");

		mnNewMenu_2.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Listado Solicitudes de Centros");
		mnNewMenu_2.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_1 = new JMenu("Centro Empleador");
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_8 = new JMenu("Usuarios");
		menuBar.add(mnNewMenu_8);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Registrar Usuario");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regUser rCE = new regUser();
				rCE.setModal(true);
				rCE.setLocationRelativeTo(null);
				rCE.setVisible(true);
			}
		});
		
		mnNewMenu_8.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Registrar Centro Empleador");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarCentroEmpleador rCE = new RegistrarCentroEmpleador(null);
				rCE.setModal(true);
				rCE.setLocationRelativeTo(null);
				rCE.setVisible(true);
			}
		});
		
		
		
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Listar Centros");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarCentros lCE = new ListarCentros();
				lCE.setModal(true);
				lCE.setLocationRelativeTo(null);
				lCE.setVisible(true);
			}
		});
		
		JMenu mnNewMenu = new JMenu("Persona");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Registrar Persona");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarPersona regPersona = new RegistrarPersona();
				regPersona.setModal(true);
				regPersona.setLocationRelativeTo(null);
				regPersona.setVisible(true);
			
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Listado de Personas");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarPersona ListPersona = new ListarPersona();
				ListPersona.setModal(true);
				ListPersona.setLocationRelativeTo(null);
				ListPersona.setVisible(true);
			}
		});
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