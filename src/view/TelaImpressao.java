package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaImpressao extends  javax.swing.JPanel {

		private static final long serialVersionUID = 1L;
		private JTextField textField;
		private JTextField textField_1;
		private JTextField textField_2;
		private JTextField textField_3;
		private JTextField textField_4;
		
		
		public TelaImpressao () {
			setLayout(null);
			
			javax.swing.JPanel panel = new javax.swing.JPanel();
			panel.setBounds(28, 11, 398, 391);
			add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("New label");
			lblNewLabel.setBounds(10, 11, 378, 14);
			panel.add(lblNewLabel);
			
			textField = new JTextField();
			textField.setBounds(10, 36, 378, 20);
			panel.add(textField);
			textField.setColumns(10);
			
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
