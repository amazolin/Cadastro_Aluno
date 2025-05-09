package br.edu.fatecgru.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.Component;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTable;

public class JanelaCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField txtRGM_Notas;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField nomeB;
	private JTextField semB;
	private JTextField curB;
	private JTable Bol_table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaCadastro frame = new JanelaCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// Função auxiliar para redimensionar ícones
			private ImageIcon redimensionarIcone(String caminho, int largura, int altura) {
			    ImageIcon iconeOriginal = new ImageIcon(JanelaCadastro.class.getResource(caminho));
			    Image imagemRedimensionada = iconeOriginal.getImage().getScaledInstance(largura, altura, Image.SCALE_SMOOTH);
			    return new ImageIcon(imagemRedimensionada);
			}

	/**
	 * Create the frame.
	 */
	public JanelaCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 497);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.setMinimumSize(new Dimension(11, 11));
		menuBar.setSize(new Dimension(0, 28));
		menuBar.setBackground(new Color(0, 128, 192));
		menuBar.setMargin(new Insets(6, 4, 6, 4));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Aluno");
		mnNewMenu.setForeground(new Color(255, 255, 255));
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Salvar");
		mntmNewMenuItem.setHorizontalTextPosition(SwingConstants.LEFT);
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Alterar");
		mntmNewMenuItem_1.setHorizontalTextPosition(SwingConstants.LEFT);
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmNewMenuItem_1.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Consultar");
		mntmNewMenuItem_2.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem_2.setHorizontalTextPosition(SwingConstants.LEFT);
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Excluir");
		mntmNewMenuItem_3.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem_3.setHorizontalTextPosition(SwingConstants.LEFT);
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Sair");
		mntmNewMenuItem_4.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem_4.setHorizontalTextPosition(SwingConstants.LEFT);
		mntmNewMenuItem_4.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmNewMenuItem_4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.SHIFT_DOWN_MASK));
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_1 = new JMenu("Notas e Faltas");
		mnNewMenu_1.setForeground(new Color(255, 255, 255));
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Salvar");
		mntmNewMenuItem_5.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Alterar");
		mntmNewMenuItem_6.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmNewMenuItem_6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		mnNewMenu_1.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Excluir");
		mntmNewMenuItem_7.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu_1.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Consultar");
		mntmNewMenuItem_8.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu_1.add(mntmNewMenuItem_8);
		
		JMenu mnNewMenu_2 = new JMenu("Ajuda");
		mnNewMenu_2.setForeground(new Color(255, 255, 255));
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Sobre");
		mntmNewMenuItem_9.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu_2.add(mntmNewMenuItem_9);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(10, 15));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(37, 40, 577, 366);
		contentPane.add(tabbedPane);
		
		JPanel panelDadosPessoais = new JPanel();
		panelDadosPessoais.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Dados pessoais", null, panelDadosPessoais, null);
		panelDadosPessoais.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(30, 34, 46, 14);
		panelDadosPessoais.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("RGM:");
		lblNewLabel_1.setBounds(354, 34, 46, 14);
		panelDadosPessoais.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(91, 31, 244, 20);
		panelDadosPessoais.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(392, 31, 150, 20);
		panelDadosPessoais.add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("Data de Nascimento:");
		lblNewLabel_2.setBounds(30, 82, 118, 14);
		panelDadosPessoais.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(155, 79, 150, 20);
		panelDadosPessoais.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("CPF:");
		lblNewLabel_3.setBounds(328, 82, 46, 14);
		panelDadosPessoais.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(371, 79, 171, 20);
		panelDadosPessoais.add(textField_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email:");
		lblNewLabel_4.setBounds(30, 136, 46, 14);
		panelDadosPessoais.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(91, 133, 451, 20);
		panelDadosPessoais.add(textField_4);
		
		JLabel lblNewLabel_5 = new JLabel("Endereço:");
		lblNewLabel_5.setBounds(30, 191, 68, 14);
		panelDadosPessoais.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(91, 188, 451, 20);
		panelDadosPessoais.add(textField_5);
		
		JLabel lblNewLabel_6 = new JLabel("Município:");
		lblNewLabel_6.setBounds(30, 249, 55, 14);
		panelDadosPessoais.add(lblNewLabel_6);
		
		textField_6 = new JTextField();
		textField_6.setBounds(91, 246, 125, 20);
		panelDadosPessoais.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("UF:");
		lblNewLabel_7.setBounds(237, 249, 25, 14);
		panelDadosPessoais.add(lblNewLabel_7);
		
		String[] estados = {
			    "","AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA",
			    "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN",
			    "RS", "RO", "RR", "SC", "SP", "SE", "TO"
			};
		JComboBox comboBox = new JComboBox<>(estados);
		comboBox.setBounds(264, 245, 54, 22);
		panelDadosPessoais.add(comboBox);
		
		JLabel lblNewLabel_8 = new JLabel("Telefone:");
		lblNewLabel_8.setBounds(341, 249, 46, 14);
		panelDadosPessoais.add(lblNewLabel_8);
		
		textField_7 = new JTextField();
		textField_7.setBounds(397, 246, 145, 20);
		panelDadosPessoais.add(textField_7);
		textField_7.setColumns(10);
		
		//Tela Curso
		JPanel panelCurso = new JPanel();
		panelCurso.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Curso", null, panelCurso, null);
		panelCurso.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Curso");
		lblNewLabel_9.setBounds(44, 44, 39, 14);
		panelCurso.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Campus");
		lblNewLabel_10.setBounds(44, 100, 62, 14);
		panelCurso.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Período");
		lblNewLabel_11.setBounds(44, 162, 46, 14);
		panelCurso.add(lblNewLabel_11);
		
		String[] cursos = {
			    "","Análise e Desenvolvimento de Sistemas", "Engenharia de Software", "Logística", "Logística Aeroportuária",
			    "Mecatrônica"
			};
		JComboBox comboBoxCurso = new JComboBox<>(cursos);
		comboBoxCurso.setBounds(129, 40, 379, 22);
		panelCurso.add(comboBoxCurso);
		
		String[] campus = {
			    "","Adamantina", "Araçatuba", "Birigui", "Campinas", "Diadema", "Fernandópolis", "Guarulhos", "Marília", "Pirituba", 
			    "Santos", "São Paulo", "Taubaté", 
			};
		JComboBox comboBoxCampus = new JComboBox(campus);
		comboBoxCampus.setBounds(129, 96, 379, 22);
		panelCurso.add(comboBoxCampus);
		
		// Criando os botões de turno
		JRadioButton rdbtnMatutino = new JRadioButton("Matutino");
		rdbtnMatutino.setBounds(129, 158, 83, 23);
		panelCurso.add(rdbtnMatutino);

		JRadioButton rdbtnVespertino = new JRadioButton("Vespertino");
		rdbtnVespertino.setBounds(245, 158, 100, 23); // Largura ajustada
		panelCurso.add(rdbtnVespertino);

		JRadioButton rdbtnNoturno = new JRadioButton("Noturno");
		rdbtnNoturno.setBounds(380, 158, 83, 23);
		panelCurso.add(rdbtnNoturno);

		// Agrupando os botões (para permitir apenas uma seleção)
		ButtonGroup grupoTurnos = new ButtonGroup();
		grupoTurnos.add(rdbtnMatutino);
		grupoTurnos.add(rdbtnVespertino);
		grupoTurnos.add(rdbtnNoturno);
		
		

		// Botão Salvar
		JButton btnSalvarCurso = new JButton("");
		btnSalvarCurso.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    }
		});
		btnSalvarCurso.setIcon(redimensionarIcone("/imagens/salvararquivo.png", 32, 32));
		btnSalvarCurso.setBounds(30, 236, 89, 62);
		panelCurso.add(btnSalvarCurso);

		// Botão Atualizar
		JButton btnAtualizarCurso = new JButton("");
		btnAtualizarCurso.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    }
		});
		btnAtualizarCurso.setIcon(redimensionarIcone("/imagens/setas-circulares.png", 32, 32));
		btnAtualizarCurso.setBounds(136, 236, 89, 62);
		panelCurso.add(btnAtualizarCurso);

		// Botão Listar
		JButton btnListarCurso = new JButton("");
		btnListarCurso.setIcon(redimensionarIcone("/imagens/lupa.png", 32, 32));
		btnListarCurso.setBounds(242, 236, 89, 62);
		panelCurso.add(btnListarCurso);

		// Botão Excluir
		JButton btnExcluirCurso = new JButton("");
		btnExcluirCurso.setIcon(redimensionarIcone("/imagens/lixo.png", 32, 32));
		btnExcluirCurso.setBounds(346, 236, 89, 62);
		panelCurso.add(btnExcluirCurso);

		// Botão Sair
		JButton btnSairCurso = new JButton("");
		btnSairCurso.setIcon(redimensionarIcone("/imagens/saida.png", 32, 32));
		btnSairCurso.setBounds(449, 236, 89, 62);
		panelCurso.add(btnSairCurso);


		//TelaNotas e Faltas
		JPanel panelNotasFaltas = new JPanel();
		panelNotasFaltas.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Notas e Faltas", null, panelNotasFaltas, null);
		panelNotasFaltas.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("RGM:");
		lblNewLabel_1_1.setBounds(20, 29, 46, 14);
		panelNotasFaltas.add(lblNewLabel_1_1);
		
		txtRGM_Notas = new JTextField();
		txtRGM_Notas.setColumns(10);
		txtRGM_Notas.setBounds(76, 26, 150, 20);
		panelNotasFaltas.add(txtRGM_Notas);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setBounds(257, 26, 281, 20);
		panelNotasFaltas.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setBounds(20, 78, 518, 20);
		panelNotasFaltas.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Disciplina");
		lblNewLabel_12.setBounds(20, 132, 62, 14);
		panelNotasFaltas.add(lblNewLabel_12);
		
		String[] disciplina = {
			    "","Algoritmos", "Banco de Dados", "Cálculo", "Engenharia de Software", "Estrutura de Dados", "Gestão de Equipes",
			    "Inglês III", "Inglês IV", "Linguagem de Programação", "Metodologia Científica", "Programação Orientada a Objetos",
			    "Sistemas Operacionais", 
			};
		JComboBox comboBoxDisciplina = new JComboBox<>(disciplina);
		comboBoxDisciplina.setBounds(92, 128, 446, 22);
		panelNotasFaltas.add(comboBoxDisciplina);
		
		JLabel lblNewLabel_13 = new JLabel("Semestre");
		lblNewLabel_13.setBounds(20, 193, 62, 14);
		panelNotasFaltas.add(lblNewLabel_13);
		
		String[] semestre = {
			    "","2020-1", "2020-2", "2021-1", "2021-2", "2022-1", "2022-2", "2023-1", "2023-2", "2024-1", "2024-2",
			    "2025-1", "2025-2"
			};
		
		JComboBox comboBoxSemestre = new JComboBox<>(semestre);
		comboBoxSemestre.setBounds(92, 189, 109, 22);
		panelNotasFaltas.add(comboBoxSemestre);
		
		JLabel lblNewLabel_14 = new JLabel("Nota");
		lblNewLabel_14.setBounds(228, 193, 34, 14);
		panelNotasFaltas.add(lblNewLabel_14);
		
		String[] nota = {
			    "", "0,0", "0,5", "1,0", "1,5", "2,0", "2,5", "3,0", "3,5", "4,0", "4,5",
			    "5,0", "5,5", "6,0", "6,5", "7,0", "7,5", "8,0", "8,5", "9,0", "9,5", "10,0"
			};

		JComboBox comboBoxNota = new JComboBox<>(nota);
		comboBoxNota.setBounds(269, 189, 74, 22);
		panelNotasFaltas.add(comboBoxNota);
		
		JLabel lblNewLabel_15 = new JLabel("Faltas");
		lblNewLabel_15.setBounds(388, 193, 39, 14);
		panelNotasFaltas.add(lblNewLabel_15);
		
		textField_10 = new JTextField();
		textField_10.setBounds(434, 190, 104, 20);
		panelNotasFaltas.add(textField_10);
		textField_10.setColumns(10);
		
		// Botão Salvar
		JButton btnSalvarNotas = new JButton("");
		btnSalvarNotas.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // ação de salvar
		    }
		});
		btnSalvarNotas.setIcon(redimensionarIcone("/imagens/salvararquivo.png", 32, 32));
		btnSalvarNotas.setBounds(30, 236, 89, 62);
		panelNotasFaltas.add(btnSalvarNotas);

		// Botão Atualizar
		JButton btnAtualizarNotas = new JButton("");
		btnAtualizarNotas.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // ação de atualizar
		    }
		});
		btnAtualizarNotas.setIcon(redimensionarIcone("/imagens/setas-circulares.png", 32, 32));
		btnAtualizarNotas.setBounds(139, 236, 89, 62);
		panelNotasFaltas.add(btnAtualizarNotas);

		// Botão Listar
		JButton btnListarNotas = new JButton("");
		btnListarNotas.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // ação de listar
		    }
		});
		btnListarNotas.setIcon(redimensionarIcone("/imagens/lupa.png", 32, 32));
		btnListarNotas.setBounds(245, 236, 89, 62);
		panelNotasFaltas.add(btnListarNotas);

		// Botão Excluir
		JButton btnExcluirNotas = new JButton("");
		btnExcluirNotas.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // ação de excluir
		    }
		});
		btnExcluirNotas.setIcon(redimensionarIcone("/imagens/lixo.png", 32, 32));
		btnExcluirNotas.setBounds(349, 236, 89, 62);
		panelNotasFaltas.add(btnExcluirNotas);

		// Botão Sair
		JButton btnSairNotas = new JButton("");
		btnSairNotas.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // ação de sair
		    }
		});
		btnSairNotas.setIcon(redimensionarIcone("/imagens/saida.png", 32, 32));
		btnSairNotas.setBounds(452, 236, 89, 62);
		panelNotasFaltas.add(btnSairNotas);

		
		//Tela Boletim
		JPanel panelBoletim = new JPanel();
		tabbedPane.addTab("Boletim", null, panelBoletim, null);
		panelBoletim.setLayout(null);
		
		JLabel lblNewLabel_16 = new JLabel("Nome");
		lblNewLabel_16.setBounds(20, 2, 35, 14);
		panelBoletim.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("RGM");
		lblNewLabel_17.setBounds(351, 2, 46, 14);
		panelBoletim.add(lblNewLabel_17);
		
		nomeB = new JTextField();
		nomeB.setEditable(false);
		nomeB.setBounds(20, 21, 319, 20);
		panelBoletim.add(nomeB);
		nomeB.setColumns(10);
		
		JLabel lblNewLabel_18 = new JLabel("Semestre");
		lblNewLabel_18.setBounds(20, 47, 57, 14);
		panelBoletim.add(lblNewLabel_18);
		
		semB = new JTextField();
		semB.setEditable(false);
		semB.setBounds(20, 64, 95, 20);
		panelBoletim.add(semB);
		semB.setColumns(10);
		
		JLabel lblNewLabel_19 = new JLabel("Curso");
		lblNewLabel_19.setBounds(129, 47, 35, 14);
		panelBoletim.add(lblNewLabel_19);
		
		curB = new JTextField();
		curB.setEditable(false);
		curB.setBounds(129, 64, 210, 20);
		panelBoletim.add(curB);
		curB.setColumns(10);
		
		Bol_table = new JTable();
		Bol_table.setBounds(10, 101, 552, 226);
		panelBoletim.add(Bol_table);
		
		// Criando o modelo ( colunas ) da tabela
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Disciplina");
		modelo.addColumn("Nota");
		modelo.addColumn("Faltas");
		
		// Atribuindo o modelo a tabela
		Bol_table.setModel(modelo);
		
		/* Adicionando as linhas
		modelo.addRow(new Object[] {"Disciplinas", "Notas", "Faltas"});
		for(int i = 0; i <disciplina.length; i++) {
			modelo.addRow(new Object[] {disciplina[i],nota[i], " "});
			}
		modelo.addRow(nota);*/
		
		JButton btnNewButton = new JButton("Gerar PDF");
		btnNewButton.setBounds(467, 63, 95, 23);
		panelBoletim.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Pesquisar");
		btnNewButton_1.setBounds(351, 63, 95, 23);
		panelBoletim.add(btnNewButton_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(351, 20, 210, 22);
		panelBoletim.add(comboBox_1);
		
		
		

		
	}
}
