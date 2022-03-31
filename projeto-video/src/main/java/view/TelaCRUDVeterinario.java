package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import control.VeterinarioControle;
import model.Veterinario;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCRUDVeterinario extends JInternalFrame {
	private Veterinario objeto;
	private VeterinarioControle controle = new VeterinarioControle();
	
	private JTextField txtIdVeterinario;
	private JTextField txtNome;
	private JTextField txtEspecialidade;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCRUDVeterinario frame = new TelaCRUDVeterinario();
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
	public TelaCRUDVeterinario() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("Tela de Veterinários");
		setBounds(100, 100, 507, 278);
		
		JLabel lblTitulo = new JLabel("Veterinário");
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblTitulo, BorderLayout.NORTH);
		
		JPanel painelCampos = new JPanel();
		getContentPane().add(painelCampos, BorderLayout.EAST);
		
		JLabel lblIdVeterinario = new JLabel("Id :");
		
		txtIdVeterinario = new JTextField();
		txtIdVeterinario.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome : ");
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		JLabel lblEspecialidade = new JLabel("Especialidade : ");
		
		txtEspecialidade = new JTextField();
		txtEspecialidade.setColumns(10);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				objeto = new Veterinario(null, txtNome.getText(), txtEspecialidade.getText());
				controle.inserir(objeto);
				JOptionPane.showMessageDialog(null, "Veterinário cadastrado com sucesso.");
				txtIdVeterinario.setText(String.valueOf(objeto.getIdVeterinario()));
				
			}
		});
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (objeto != null) {
					objeto.setNome(txtNome.getText());
					objeto.setEspecialidade(txtEspecialidade.getText());
					controle.alterar(objeto);
					JOptionPane.showMessageDialog(null, "Veterinário alterado com sucesso.");
				}else {
					JOptionPane.showMessageDialog(null, "Não há veterinário para ser modificado.");
					limparTela();
				}
				
				
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (objeto!=null) {
					controle.excluir(objeto);					
					JOptionPane.showMessageDialog(null, "Veterinário excluído com sucesso.");
				}else {
					JOptionPane.showMessageDialog(null, "Não há veterinário para ser excluído.");					
				}
				limparTela();
				

			}
		});
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer valor = Integer.parseInt(txtIdVeterinario.getText());
				objeto = controle.buscarPorId(valor);
				if (objeto != null) {
					txtIdVeterinario.setText(String.valueOf(objeto.getIdVeterinario()));
					txtNome.setText(objeto.getNome());
					txtEspecialidade.setText(objeto.getEspecialidade());
				}else {
					JOptionPane.showMessageDialog(null, "Não existe veterinário com o código digitado.");
					txtIdVeterinario.setText("");
				}
			}
		});
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparTela();
				
			}
		});
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		
		GroupLayout gl_painelCampos = new GroupLayout(painelCampos);
		gl_painelCampos.setHorizontalGroup(
			gl_painelCampos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelCampos.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_painelCampos.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_painelCampos.createSequentialGroup()
							.addGroup(gl_painelCampos.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_painelCampos.createSequentialGroup()
									.addComponent(lblNome)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_painelCampos.createSequentialGroup()
									.addComponent(lblIdVeterinario)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtIdVeterinario, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(gl_painelCampos.createParallelGroup(Alignment.LEADING)
								.addComponent(btnAlterar, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
								.addComponent(btnInserir, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
								.addComponent(btnExcluir, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(gl_painelCampos.createSequentialGroup()
							.addComponent(lblEspecialidade, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtEspecialidade, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_painelCampos.createParallelGroup(Alignment.LEADING)
								.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnConsultar)
								.addComponent(btnFechar, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))))
					.addGap(27))
		);
		gl_painelCampos.setVerticalGroup(
			gl_painelCampos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelCampos.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_painelCampos.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdVeterinario)
						.addComponent(txtIdVeterinario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnInserir))
					.addGroup(gl_painelCampos.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painelCampos.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_painelCampos.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNome)
								.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_painelCampos.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAlterar)))
					.addGroup(gl_painelCampos.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painelCampos.createSequentialGroup()
							.addGap(23)
							.addGroup(gl_painelCampos.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEspecialidade)
								.addComponent(txtEspecialidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_painelCampos.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnExcluir)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnConsultar)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLimpar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnFechar)
					.addContainerGap(29, Short.MAX_VALUE))
		);
		painelCampos.setLayout(gl_painelCampos);

	}
	
	public void limparTela() {
		objeto = null;
		txtIdVeterinario.setText("");
		txtNome.setText("");
		txtEspecialidade.setText("");
	}
	
}
