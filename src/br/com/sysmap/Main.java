package br.com.sysmap;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import br.com.sysmap.tablemodel.QueryStringTableModel;
import br.com.sysmap.vo.QueryString;

@SuppressWarnings("serial")
public class Main extends JFrame{
	
	private String[] nmLbls= {"Nome do serviço: ", "URL do Serviço: ", "Método HTTP: "};
	private String[] httpMethods = {"POST", "PUT", "GET"};

	private JSplitPane panelGeral;
	private JPanel panel1FormSpringLayout;
	private JScrollPane panel2TableQueryString;
	private JButton btnGerar;
	private JTextField txtNomeServiço;
	private JTextField txtUrl;
	private JComboBox<String> cboHttpMethod;
	private JTable tblQueryString;
	private QueryStringTableModel qsTableModel;
	private List<QueryString> listQueryStrings;
	
	
	public static void main(String[] args) {
		Main tela = new Main();
		tela.setVisible(true);
	}
	
	public Main() {
		super();
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
		ajuda.setEnabled(false);
		JMenuItem sair = new JMenuItem("Sair");
		sair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int escolha = JOptionPane.showConfirmDialog(
						null, 
						"Deseja fechar o sistema?", 
						"Mensagem", 
						JOptionPane.YES_NO_OPTION, 
						JOptionPane.QUESTION_MESSAGE);
				if(escolha==JOptionPane.YES_OPTION)
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
		
		JLabel lblNomeServico = new JLabel(nmLbls[0]);
		lblNomeServico.setLabelFor(txtNomeServiço);
		txtNomeServiço = new JTextField(50);
		this.addComponentToGrid(panel1FormSpringLayout, lblNomeServico, txtNomeServiço);
		
		JLabel lblUrl = new JLabel(nmLbls[1]);
		lblUrl.setLabelFor(txtUrl);
		txtUrl = new JTextField(50);
		this.addComponentToGrid(panel1FormSpringLayout, lblUrl, txtUrl);
		
		JLabel lblHttpMethod = new JLabel(nmLbls[2]);
		lblHttpMethod.setLabelFor(cboHttpMethod);
		cboHttpMethod = new JComboBox<>(httpMethods);
		this.addComponentToGrid(panel1FormSpringLayout, lblHttpMethod, cboHttpMethod);
		
		listQueryStrings = new ArrayList<>();
		qsTableModel = new QueryStringTableModel(listQueryStrings);
		tblQueryString = new JTable(qsTableModel);
		panel2TableQueryString.add(tblQueryString);
		
		this.add(btnGerar, BorderLayout.PAGE_END);
		
	}

	private void addComponentToGrid(Container container, Component...components) {
		JPanel aux = new JPanel(new GridLayout(1, 4, -150, -150));
		for (Component component : components) {
			aux.add(component);
		}
		container.add(aux);
	}

	private void definePropriedadesTela() {
		this.setSize(780,420);
		this.setResizable(false);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("OAG/Omni");
		
		//JPanels
		panel1FormSpringLayout = new JPanel(new GridLayout(10, 1, 10, 10));
		panel2TableQueryString = new JScrollPane();
		panel1FormSpringLayout.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panelGeral = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panel1FormSpringLayout, panel2TableQueryString);
		panelGeral.setOneTouchExpandable(false);
		panelGeral.setEnabled(false);
		panelGeral.setDividerLocation(this.getWidth()/2);
		this.add(panelGeral);
	}
}
