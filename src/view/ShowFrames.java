package view;

import javax.swing.JPanel;

public class ShowFrames implements Runnable {
	
	
	JPanel tela = new TelaCadastro();
	 
	public ShowFrames() {} 
	
	public ShowFrames(JPanel tela) {
		this.tela = tela;
	}

	public JPanel getTela() {
		return tela;
	}


	public void setTela(JPanel tela) {
		this.tela = tela;
	}

	@Override
	public void run() {
		
		
	}
	
	
	
	

	

}
