package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Banco;
import model.Contax;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField textFieldSaldo;

	private Banco banco;
	private int numConta;

	public JPrincipal(Banco banco, int numConta) {

		this.banco = banco;
		this.numConta = numConta;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 442, 323);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblSaldo = new JLabel("Saldo da Conta:");
		lblSaldo.setBounds(47, 58, 120, 20);
		contentPane.add(lblSaldo);

		textFieldSaldo = new JTextField();
		textFieldSaldo.setBounds(160, 58, 120, 20);
		textFieldSaldo.setEditable(false);
		contentPane.add(textFieldSaldo);

		
		Contax conta = banco.consultarConta(numConta);

		if (conta != null) {
			textFieldSaldo.setText(String.valueOf(conta.getSaldo()));
		} else {
			textFieldSaldo.setText("Conta não encontrada");
		}

		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(170, 200, 90, 25);
		contentPane.add(btnSair);

		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				jMenu tela = new jMenu(banco);
				tela.setLocationRelativeTo(null);
				tela.setVisible(true);

				dispose();
			}
		});
	}
}