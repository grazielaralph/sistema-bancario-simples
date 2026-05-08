package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import model.Banco;
import model.Contax;

public class JContaNova extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldSaldo;

	private Banco banco;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Banco banco = new Banco();
					JContaNova frame = new JContaNova(banco);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JContaNova(Banco banco) {
		this.banco = banco;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 331, 404);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblTitulo = new JLabel("Tela de Cadastro");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitulo.setBounds(77, 25, 210, 46);
		contentPane.add(lblTitulo);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(63, 101, 69, 12);
		contentPane.add(lblNome);

		textFieldNome = new JTextField();
		textFieldNome.setBounds(63, 118, 196, 24);
		contentPane.add(textFieldNome);

		JLabel lblSaldo = new JLabel("Valor para depósito:");
		lblSaldo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSaldo.setBounds(63, 175, 150, 12);
		contentPane.add(lblSaldo);

		textFieldSaldo = new JTextField();
		textFieldSaldo.setBounds(63, 196, 196, 24);
		contentPane.add(textFieldSaldo);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setForeground(new Color(230, 230, 250));
		btnConfirmar.setBackground(new Color(0, 128, 128));
		btnConfirmar.setBounds(103, 275, 110, 24);
		contentPane.add(btnConfirmar);

		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String nome = textFieldNome.getText().trim();
					String saldoTexto = textFieldSaldo.getText().trim();

					if (nome.isEmpty() || saldoTexto.isEmpty()) {
						JOptionPane.showMessageDialog(
								null,
								"Verifique as informações! Preencha todos os campos.",
								"Aviso",
								JOptionPane.WARNING_MESSAGE);
						return;
					}

					double saldo = Double.parseDouble(saldoTexto);

					if (saldo < 0) {
						JOptionPane.showMessageDialog(
								null,
								"O saldo não pode ser negativo!",
								"Aviso",
								JOptionPane.WARNING_MESSAGE);
						return;
					}

					Contax contaCriada = banco.criarConta(nome, saldo);

					JOptionPane.showMessageDialog(
							null,
							"Conta criada com sucesso!\nNúmero da conta: "
									+ contaCriada.getNum_conta());

					jMenu tela = new jMenu(banco);
					tela.setLocationRelativeTo(null);
					tela.setVisible(true);
					dispose();

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(
							null,
							"Digite um valor numérico válido para o saldo!",
							"Erro",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}