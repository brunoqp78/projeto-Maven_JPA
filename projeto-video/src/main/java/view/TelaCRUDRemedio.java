package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class TelaCRUDRemedio extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCRUDRemedio frame = new TelaCRUDRemedio();
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
	public TelaCRUDRemedio() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("Tela de Remédios");
		setBounds(100, 100, 450, 300);

	}

}
