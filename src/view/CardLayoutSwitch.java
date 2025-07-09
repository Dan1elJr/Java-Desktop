package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.*;

public class CardLayoutSwitch extends JFrame{
	
    
	private static final long serialVersionUID = 1L;
	
	private JPanel cadastro = new TelaCadastro();
	private JPanel impressao = new TelaImpressao();

	CardLayoutSwitch() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(cardLayout);

        // Create Card One

        cadastro.add(new JButton());
        cardPanel.add(cadastro,"CardOne");

        // Create Card Two
        
        impressao.add(new JButton());
        cardPanel.add(impressao, "CardTwo");

        // Add buttons to switch cards
        JPanel buttonPanel = new JPanel();
        JButton showCardOneButton = new JButton("Next");
        showCardOneButton.addActionListener(e -> cardLayout.next(cardPanel));
        
        //JButton showCardTwoButton = new JButton("Show Card Two");
        //showCardTwoButton.addActionListener(e -> cardLayout.show(cardPanel, "CardTwo"));
        
        buttonPanel.add(showCardOneButton);
        
       // buttonPanel.add(showCardTwoButton);

        frame.add(cardPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setSize(750, 750);
        frame.setVisible(true);
    }
}