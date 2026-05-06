package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JTrans extends JFrame {

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
					JTrans frame = new JTrans();
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
	public JTrans() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSaldoDaConta = new JLabel("Saldo da Conta:");
		lblSaldoDaConta.setBounds(34, 42, 196, 36);
		contentPane.add(lblSaldoDaConta);
		
		JLabel lblNewLabel_1 = new JLabel("Insira o valor da Transferencia ");
		lblNewLabel_1.setBounds(138, 104, 144, 28);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(148, 142, 134, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setBounds(165, 180, 105, 20);
		contentPane.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(112, 51, 105, 18);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

	}

}
