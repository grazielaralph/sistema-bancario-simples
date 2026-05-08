package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import model.Banco;
import model.Contax;

public class JSacar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textSaldo;
	private JTextField textValor;

	private Banco banco;
	private int numConta;

	public JSacar(Banco banco, int numConta) {
		this.banco = banco;
		this.numConta = numConta;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 220);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblSaldo = new JLabel("Saldo:");
		lblSaldo.setBounds(30, 20, 100, 25);
		contentPane.add(lblSaldo);

		textSaldo = new JTextField();
		textSaldo.setBounds(120, 20, 120, 25);
		textSaldo.setEditable(false);
		contentPane.add(textSaldo);

		JLabel lblValor = new JLabel("Valor saque:");
		lblValor.setBounds(30, 60, 100, 25);
		contentPane.add(lblValor);

		textValor = new JTextField();
		textValor.setBounds(120, 60, 120, 25);
		contentPane.add(textValor);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(120, 110, 110, 25);
		contentPane.add(btnConfirmar);

		atualizarSaldo();
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					double valor = Double.parseDouble(textValor.getText());

					if (valor <= 0) {
						JOptionPane.showMessageDialog(null, "Digite um valor maior que zero!");
						return;
					}

					boolean ok = banco.sacar(numConta, valor);

					if (ok) {
						JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!");
					} else {
						JOptionPane.showMessageDialog(null, "Saldo insuficiente ou conta inválida!");
					}

					// voltar para menu
					jMenu tela = new jMenu(banco);
					tela.setLocationRelativeTo(null);
					tela.setVisible(true);
					dispose();

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Digite um valor válido!");
				}
			}
		});
	}
	private void atualizarSaldo() {
		Contax conta = banco.consultarConta(numConta);

		if (conta != null) {
			textSaldo.setText(String.valueOf(conta.getSaldo()));
		} else {
			textSaldo.setText("Conta não encontrada");
		}
	}
}