package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JDepositar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JDepositar frame = new JDepositar();
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
	public JDepositar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSaldoDaConta = new JLabel("Saldo da Conta:");
		lblSaldoDaConta.setBounds(27, 30, 196, 36);
		contentPane.add(lblSaldoDaConta);
		
		JLabel lblNewLabel_1 = new JLabel("Insira o valor do Deposito");
		lblNewLabel_1.setBounds(143, 92, 177, 28);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(143, 126, 130, 20);
		contentPane.add(textField);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(156, 168, 105, 20);
		contentPane.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(109, 39, 105, 18);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

	}

}
