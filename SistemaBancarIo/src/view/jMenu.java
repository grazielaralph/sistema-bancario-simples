package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class jMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JTextField textFieldConta;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jMenu frame = new jMenu();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public jMenu() {
		setBackground(new Color(95, 158, 160));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 511);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(214, 32, 277, 410);
		panel.setBackground(new Color(176, 196, 222));
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Bem-vindo ao Banco do Brasil!!");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		lblNewLabel.setBounds(31, 34, 211, 13);
		panel.add(lblNewLabel);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(34, 75, 81, 12);
		panel.add(lblNome);

		JLabel lblConta = new JLabel("Número da conta:");
		lblConta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblConta.setBounds(31, 130, 179, 12);
		panel.add(lblConta);

		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(31, 91, 194, 25);
		panel.add(textFieldUsuario);

		textFieldConta = new JTextField();
		textFieldConta.setBounds(31, 147, 194, 25);
		panel.add(textFieldConta);

		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Acessar Conta", "Transferencia", "Saque", "Depositar"}));
		comboBox.setBounds(69, 195, 132, 20);
		panel.add(comboBox);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnConfirmar.setBackground(new Color(95, 158, 160));
		btnConfirmar.setForeground(new Color(240, 255, 240));
		btnConfirmar.setBounds(81, 248, 115, 25);
		panel.add(btnConfirmar);

		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String itemSelecionado = comboBox.getSelectedItem().toString();

				if (!textFieldUsuario.getText().isEmpty() &&
					!textFieldConta.getText().isEmpty()) {

					switch (itemSelecionado) { 
					
					case "Acessar Conta":
						JPrincipal jPrincipal = new JPrincipal();
						jPrincipal.setLocationRelativeTo(null);
						jPrincipal.setVisible(true);
						break;
						
					case "Saque":
						JSacar jSacar = new JSacar();
						jSacar.setLocationRelativeTo(null);
						jSacar.setVisible(true);
						break;
						
					
					case"Transferencia":
						JTrans jTrans = new JTrans();
						jTrans.setLocationRelativeTo(null);
						jTrans.setVisible(true);
						break;
						
					case"Depositar":
						JDepositar jDepositar = new JDepositar();
						jDepositar.setLocationRelativeTo(null);
						jDepositar.setVisible(true);
						break;
					}

				} else {
					JOptionPane.showMessageDialog(
							null,
							"Informações inválidas",
							"Aviso",
							JOptionPane.WARNING_MESSAGE
					);
				}
			}
		});

		JButton btnCriar = new JButton("Criar nova conta");
		btnCriar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCriar.setBackground(new Color(95, 158, 160));
		btnCriar.setForeground(new Color(230, 230, 250));
		btnCriar.setBounds(69, 348, 138, 25);
		panel.add(btnCriar);

		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JContaNova jContaNova = new JContaNova();
				jContaNova.setLocationRelativeTo(null);
				jContaNova.setVisible(true);
			}
		});
	}
}