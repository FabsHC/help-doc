package br.com.sysmap;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Main extends JFrame{

	private JPanel panel1;
	private JPanel panel2;
	
	public static void main(String[] args) {
		Main tela = new Main();
		tela.setVisible(true);
	}
	
	public Main() {
		this.definePropriedadesTela();
		this.criarCampos();
	}

	private void criarCampos() {
		// TODO Auto-generated method stub
		
	}

	private void definePropriedadesTela() {
		setSize(780,420);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("OAG/Omni");
	}
}
