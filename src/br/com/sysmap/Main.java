package br.com.sysmap;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class Main extends JFrame{

	private JPanel panelGeral;
	private JPanel panel1FormSpringLayout;
	private JPanel panel2TableQueryString;
	private JButton btnGerar;
	private JTextField txtNomeServiço;
	private JTextField txtUrl;
	private JSpinner spnMetodoHttp;
	
	
	public static void main(String[] args) {
		Main tela = new Main();
		tela.setVisible(true);
	}
	
	public Main() {
		this.definePropriedadesTela();
		this.criarMenu();
		this.criarCampos();
	}

	private void criarMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		JMenuItem ajuda = new JMenuItem("Ajuda");
		ajuda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {}
		});
		JMenuItem sair = new JMenuItem("Sair");
		sair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Deseja fechar o sistema?", "Mensagem", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
		menu.add(ajuda);
		menu.add(sair);
		menuBar.add(menu);
		this.setJMenuBar(menuBar);
	}

	private void criarCampos() {
		btnGerar = new JButton("Gerar");
		
		this.add(btnGerar, BorderLayout.PAGE_END);
		
	}

	private void definePropriedadesTela() {
		setSize(780,420);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("OAG/Omni");
		
		//JPanels
		panelGeral = new JPanel(new BorderLayout());
		panel1FormSpringLayout = new JPanel(new SpringLayout());
		panel2TableQueryString = new JPanel();
		panelGeral.add(panel1FormSpringLayout, BorderLayout.WEST);
		panelGeral.add(panel2TableQueryString, BorderLayout.EAST);
		
		this.add(panelGeral);
	}
	/*
	 * //Lay out the panel.
SpringUtilities.makeCompactGrid(p,
                                numPairs, 2, //rows, cols
                                6, 6,        //initX, initY
                                6, 6);       //xPad, yPad
	 */
}
