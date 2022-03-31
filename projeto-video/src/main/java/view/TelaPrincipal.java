package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JSeparator;

public class TelaPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

		JDesktopPane desktop = new JDesktopPane();
		frame.getContentPane().add(desktop, BorderLayout.CENTER);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu menuCadastro = new JMenu("Cadastro");
		menuBar.add(menuCadastro);

		JMenuItem menuVeterinario = new JMenuItem("Veterinário");
		menuVeterinario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				minimizarFrames(desktop);
				// programar o tratamento desse evento
				// Criar um objeto da tela de cadastro de veterinário
				TelaCRUDVeterinario tela = new TelaCRUDVeterinario();
				// tonar o objeto visível
				tela.setVisible(true);
				// inserir esse objeto no desktop
				desktop.add(tela);
			}
		});
		menuCadastro.add(menuVeterinario);

		JMenuItem menuCliente = new JMenuItem("Cliente");
		menuCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				minimizarFrames(desktop);
				TelaCRUDCliente tela = new TelaCRUDCliente();
				tela.setVisible(true);
				desktop.add(tela);
			}
		});
		menuCadastro.add(menuCliente);

		JMenuItem menuRemedio = new JMenuItem("Remédio");
		menuRemedio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				minimizarFrames(desktop);
				TelaCRUDRemedio tela = new TelaCRUDRemedio();
				tela.setVisible(true);
				desktop.add(tela);
			}
		});
		menuCadastro.add(menuRemedio);

		JSeparator separator = new JSeparator();
		menuCadastro.add(separator);

		JMenuItem menuSair = new JMenuItem("Sair");
		menuSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuCadastro.add(menuSair);

		JMenu menuConsulta = new JMenu("Consulta");
		menuBar.add(menuConsulta);

		JMenu menuAjuda = new JMenu("Ajuda");
		
		menuBar.add(menuAjuda);
		
		JMenuItem menuSobre = new JMenuItem("Sobre");
		menuSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSobre frameAjuda;
				frameAjuda = existeFrameSobre(desktop);
				minimizarFrames(desktop);
				if (frameAjuda == null) {
					frameAjuda = new TelaSobre();
					frameAjuda.setVisible(true);
					frameAjuda.setLocation(0, 0);
					desktop.add(frameAjuda);
				} else {
					desktop.setSelectedFrame(frameAjuda);
					try {
						frameAjuda.setIcon(false);
					} catch (Exception ev) {
					}
				}
			}
		});
		menuAjuda.add(menuSobre);

	}

	private void minimizarFrames(JDesktopPane desktop) {
		JInternalFrame frames[] = desktop.getAllFrames();
		for (JInternalFrame frame : frames) {
			try {
				frame.setIcon(true);
			} catch (Exception e) {
			}
		}
	}

	private TelaSobre existeFrameSobre(JDesktopPane desktop) {
		JInternalFrame frames[] = desktop.getAllFrames();
		for (JInternalFrame frame : frames) {
			try {
				if (frame instanceof TelaSobre)
					return (TelaSobre) frame;
			} catch (Exception e) {
				return null;
			}
		}
		return null;
	}

}
