package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JSacar extends JFrame {

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
					JSacar frame = new JSacar();
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
	public JSacar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Saldo da Conta:");
		lblNewLabel.setBounds(34, 30, 196, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Insira o valor do saque ");
		lblNewLabel_1.setBounds(142, 104, 136, 28);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(142, 143, 136, 18);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setBounds(157, 183, 104, 20);
		contentPane.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(117, 39, 73, 18);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

	}

}
