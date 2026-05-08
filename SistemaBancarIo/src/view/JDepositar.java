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

public class JDepositar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textValor;
	private JTextField textSaldo;

	private Banco banco;
	private int numConta;

	public JDepositar(Banco banco, int numConta) {
		this.banco = banco;
		this.numConta = numConta;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblSaldo = new JLabel("Saldo da Conta:");
		lblSaldo.setBounds(27, 30, 120, 20);
		contentPane.add(lblSaldo);

		textSaldo = new JTextField();
		textSaldo.setBounds(150, 30, 120, 20);
		textSaldo.setEditable(false);
		contentPane.add(textSaldo);

		JLabel lblValor = new JLabel("Valor do depósito:");
		lblValor.setBounds(150, 80, 200, 20);
		contentPane.add(lblValor);

		textValor = new JTextField();
		textValor.setBounds(150, 110, 120, 20);
		contentPane.add(textValor);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(160, 160, 110, 25);
		contentPane.add(btnConfirmar);

		Contax conta = banco.consultarConta(numConta);

		if (conta != null) {
			textSaldo.setText(String.valueOf(conta.getSaldo()));
		} else {
			textSaldo.setText("Conta não encontrada");
		}

		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					double valor = Double.parseDouble(textValor.getText());

					boolean ok = banco.depositar(numConta, valor);

					if (ok) {
						JOptionPane.showMessageDialog(null, "Depósito realizado!");
						
						// atualizar saldo
						Contax c = banco.consultarConta(numConta);
						textSaldo.setText(String.valueOf(c.getSaldo()));

					} else {
						JOptionPane.showMessageDialog(null, "Conta não encontrada!");
					}

					jMenu tela = new jMenu(banco);
					tela.setLocationRelativeTo(null);
					tela.setVisible(true);
					dispose();

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Valor inválido!");
				}
			}
		});
	}
}