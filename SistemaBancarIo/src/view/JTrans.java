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

public class JTrans extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textValor;
	private JTextField textContaDestino;
	private JTextField textSaldo;

	private Banco banco;
	private int numConta;

	public JTrans(Banco banco, int numConta) {
		this.banco = banco;
		this.numConta = numConta;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblSaldo = new JLabel("Saldo da Conta:");
		lblSaldo.setBounds(20, 30, 150, 20);
		contentPane.add(lblSaldo);

		textSaldo = new JTextField();
		textSaldo.setBounds(150, 30, 120, 20);
		Contax c = banco.consultarConta(numConta);
		textSaldo.setText("R$ "+c.getSaldo());
		textSaldo.setEditable(false);
		contentPane.add(textSaldo);

		JLabel lblConta = new JLabel("Número da conta destino:");
		lblConta.setBounds(150, 70, 200, 20);
		contentPane.add(lblConta);

		textContaDestino = new JTextField();
		textContaDestino.setBounds(150, 95, 120, 20);
		contentPane.add(textContaDestino);

		JLabel lblValor = new JLabel("Valor da transferência:");
		lblValor.setBounds(150, 130, 200, 20);
		contentPane.add(lblValor);

		textValor = new JTextField();
		textValor.setBounds(150, 155, 120, 20);
		contentPane.add(textValor);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(160, 200, 110, 25);
		contentPane.add(btnConfirmar);

		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					int contaDestino = Integer.parseInt(textContaDestino.getText());
					double valor = Double.parseDouble(textValor.getText());

					boolean ok = banco.transferir(numConta, contaDestino, valor);

					if (ok) {
						JOptionPane.showMessageDialog(null, "Transferência realizada!");
					} else {
						JOptionPane.showMessageDialog(null, "Erro na transferência!");
					}

					jMenu tela = new jMenu(banco);
					tela.setLocationRelativeTo(null);
					tela.setVisible(true);
					dispose();

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Dados inválidos!");
				}
			}
		});
	}
}