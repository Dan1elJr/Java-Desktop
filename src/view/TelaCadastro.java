package view;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TelaCadastro extends javax.swing.JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public TelaCadastro() {
		setLayout(null);
		
		javax.swing.JPanel panel = new javax.swing.JPanel();
		panel.setBounds(28, 11, 398, 391);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Linha");
		lblNewLabel.setBounds(10, 11, 378, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 36, 378, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Máquina");
		lblNewLabel_1.setBounds(10, 67, 378, 14);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 92, 378, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Problema");
		lblNewLabel_2.setBounds(10, 123, 378, 14);
		panel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 148, 378, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Causa");
		lblNewLabel_3.setBounds(10, 179, 378, 14);
		panel.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(10, 204, 378, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Solução");
		lblNewLabel_4.setBounds(10, 235, 378, 14);
		panel.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(10, 260, 378, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("Enviar Relatório");
		btnNewButton.setBounds(128, 291, 147, 23);
		panel.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
	      
	        public void actionPerformed(ActionEvent e) {
	        	System.out.println(textField.getText());
	        	
	        }
	    });

	}
}
