package br.com.prog2.trabalho.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.prog2.trabalho.controller.ClienteController;
import br.com.prog2.trabalho.negocio.Cliente;
import br.com.prog2.trabalho.util.Util;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFormattedTextField;

public class FrmCliente extends JFrame {
	private void pesquisar(){
		List<Cliente> listaCli = new ArrayList<>();
		ClienteController cc = new ClienteController();
		listaCli = cc.listarTodos();
		DefaultTableModel tbm = (DefaultTableModel)tblConsulta.getModel();
		for(int i = tbm.getRowCount()-1; i >= 0; i--){
			tbm.removeRow(i);
		}
		int i = 0;
		for(Cliente cli : listaCli){
			tbm.addRow(new String[1]);
			tblConsulta.setValueAt(cli.getCodCliente(), i, 0);
			tblConsulta.setValueAt(cli.getNomeCliente(), i, 1);
			tblConsulta.setValueAt(cli.getRgCliente(), i, 2);
			tblConsulta.setValueAt(cli.getEnderecoCliente(), i, 3);
			tblConsulta.setValueAt(cli.getBairroCliente(), i, 4);
			tblConsulta.setValueAt(cli.getCidadeCliente(), i, 5);
			tblConsulta.setValueAt(cli.getEstadoCliente(), i, 6);
			tblConsulta.setValueAt(cli.getCepCliente(), i, 7);
			tblConsulta.setValueAt(cli.getNascimentoCliente(), i, 8);
			i++;
		}
	}
	private MaskFormatter mascaraData = null;
	private JFormattedTextField txtNascimento;
	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTextField txtRG;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private JTextField txtCEP;
	private JLabel lblMensagem;
	private JTable tblConsulta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCliente frame = new FrmCliente();
					frame.setTitle("Cadastro de Clientes");
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
	public FrmCliente() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 613);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_2 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
						.addComponent(panel_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		tblConsulta = new JTable();
		tblConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Integer linha = tblConsulta.getSelectedRow();
				String cod = tblConsulta.getValueAt(linha, 0).toString();
				String nome = tblConsulta.getValueAt(linha, 1).toString();
				String rg = tblConsulta.getValueAt(linha, 2).toString();
				String endereco = tblConsulta.getValueAt(linha, 3).toString();
				String bairro = tblConsulta.getValueAt(linha, 4).toString();
				String cidade = tblConsulta.getValueAt(linha, 5).toString();
				String estado = tblConsulta.getValueAt(linha, 6).toString();
				String cep = tblConsulta.getValueAt(linha, 7).toString();
				String nascimento = tblConsulta.getValueAt(linha, 8).toString();
				DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate localDate = LocalDate.parse(nascimento, dateTimeFormatter);
				nascimento = Util.formatarDataDeLocalDateParaGui(localDate);
				txtCodigo.setText(cod);
				txtNome.setText(nome);
				txtRG.setText(rg);
				txtEndereco.setText(endereco);
				txtBairro.setText(bairro);
				txtCidade.setText(cidade);
				txtEstado.setText(estado);
				txtCEP.setText(cep);
				txtNascimento.setText(nascimento);
			}
		});
		tblConsulta.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nome", "RG", "Endere\u00E7o", "Bairro", "Cidade", "Estado", "CEP", "Nascimento"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblConsulta.getColumnModel().getColumn(0).setResizable(false);
		tblConsulta.getColumnModel().getColumn(1).setResizable(false);
		tblConsulta.getColumnModel().getColumn(2).setResizable(false);
		tblConsulta.getColumnModel().getColumn(3).setResizable(false);
		tblConsulta.getColumnModel().getColumn(4).setResizable(false);
		tblConsulta.getColumnModel().getColumn(5).setResizable(false);
		tblConsulta.getColumnModel().getColumn(6).setResizable(false);
		tblConsulta.getColumnModel().getColumn(7).setResizable(false);
		tblConsulta.getColumnModel().getColumn(8).setResizable(false);
		scrollPane.setViewportView(tblConsulta);
		panel_2.setLayout(gl_panel_2);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente cli = new Cliente();
				ClienteController cc = new ClienteController();
				cli.setCodCliente(txtCodigo.getText());
				cli.setNomeCliente(txtNome.getText());
				cli.setRgCliente(txtRG.getText());
				cli.setEnderecoCliente(txtEndereco.getText());
				cli.setBairroCliente(txtBairro.getText());
				cli.setCidadeCliente(txtCidade.getText());
				cli.setEstadoCliente(txtEstado.getText());
				cli.setCepCliente(txtCEP.getText());
				int[] dataFormatada = Util.formatarDataDeGuiParaLocalDate(txtNascimento.getText());
				cli.setNascimentoCliente(LocalDate.of(dataFormatada[2], dataFormatada[1], dataFormatada[0]));
				Cliente c = new Cliente();
				c.setCodCliente(cli.getCodCliente());
				c = cc.pesquisarPorCod(c.getCodCliente());
				if(c != null) {
					txtCodigo.setText(c.getCodCliente());
					txtNome.setText(c.getNomeCliente());
					txtRG.setText(c.getRgCliente());
					txtEndereco.setText(c.getEnderecoCliente());
					txtBairro.setText(c.getBairroCliente());
					txtCidade.setText(c.getCidadeCliente());
					txtEstado.setText(c.getEstadoCliente());
					txtCEP.setText(c.getCepCliente());
					LocalDate nascimento = c.getNascimentoCliente();
					String nascimento2;
					nascimento2 = Util.formatarDataDeLocalDateParaGui(nascimento);
					txtNascimento.setText(nascimento2);
					JOptionPane.showMessageDialog(null, "Cliente com este Codigo ja existente, preenchendo...");
					pesquisar();
				}
				else {
				lblMensagem.setText(cc.inserir(cli));
				pesquisar();
				}
			}
		});
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente cli = new Cliente();
				ClienteController cc = new ClienteController();
				cli.setCodCliente(txtCodigo.getText());
				cli.setNomeCliente(txtNome.getText());
				cli.setRgCliente(txtRG.getText());
				cli.setEnderecoCliente(txtEndereco.getText());
				cli.setBairroCliente(txtBairro.getText());
				cli.setCidadeCliente(txtCidade.getText());
				cli.setEstadoCliente(txtEstado.getText());
				cli.setCepCliente(txtCEP.getText());
				int[] dataFormatada = Util.formatarDataDeGuiParaLocalDate(txtNascimento.getText());
				cli.setNascimentoCliente(LocalDate.of(dataFormatada[2], dataFormatada[1], dataFormatada[0]));
				lblMensagem.setText(cc.alterar(cli));
				pesquisar();
			}
		});
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente cli = new Cliente();
				ClienteController cc = new ClienteController();
				cli.setCodCliente(txtCodigo.getText());
				Object[] opcoes = { "Sim", "Nao" };
				int i = JOptionPane.showOptionDialog(null, "Deseja excluir esse cliente: "+txtNome.getText()+"?", "Exclusao", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[1]);
				if(JOptionPane.YES_OPTION == i){
					lblMensagem.setText(cc.excluir(cli));
					pesquisar();
					}
			}
		});
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pesquisar();
			}
		});
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnLimpa = new JButton("Limpar");
		btnLimpa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCodigo.setText("");
				txtNome.setText("");
				txtRG.setText("");
				txtBairro.setText("");
				txtCidade.setText("");
				txtEstado.setText("");
				txtCEP.setText("");
				txtEndereco.setText("");
				txtNascimento.setText("");
				DefaultTableModel tbm =
				(DefaultTableModel)tblConsulta.getModel();
				for(int i = tbm.getRowCount()-1; i >= 0; i--){
				tbm.removeRow(i);
				}
			}
		});
		
		JButton btnSair = new JButton("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FrmCliente.this.dispose();
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(46)
					.addComponent(btnInserir)
					.addGap(18)
					.addComponent(btnAlterar)
					.addGap(18)
					.addComponent(btnExcluir)
					.addGap(18)
					.addComponent(btnPesquisar)
					.addPreferredGap(ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
					.addComponent(btnLimpa)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSair)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSair)
						.addComponent(btnLimpa)
						.addComponent(btnPesquisar)
						.addComponent(btnExcluir)
						.addComponent(btnAlterar)
						.addComponent(btnInserir))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		
		JLabel lblNome = new JLabel("Nome");
		
		JLabel lblRg = new JLabel("RG");
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		
		JLabel lblBairro = new JLabel("Bairro");
		
		JLabel lblCidade = new JLabel("Cidade");
		
		JLabel lblEstado = new JLabel("Estado");
		
		JLabel lblCep = new JLabel("CEP");
		
		JLabel lblNascimento = new JLabel("Nascimento");
		
		lblMensagem = new JLabel("Mensagem:");
		lblMensagem.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMensagem.setForeground(Color.BLUE);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		txtRG = new JTextField();
		txtRG.setColumns(10);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		
		txtCEP = new JTextField();
		txtCEP.setColumns(10);
		
		try {
			mascaraData = new MaskFormatter("##/##/####");
			} catch (ParseException e) {
			System.err.println(e.getMessage());
			}
		txtNascimento = new JFormattedTextField(mascaraData);
		
		JLabel lblDdmmaaaa = new JLabel("dd/mm/aaaa");
		lblDdmmaaaa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDdmmaaaa.setForeground(Color.RED);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblCdigo)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNome)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblRg)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtRG, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblBairro)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)))
							.addGap(10)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNascimento)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtNascimento, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblDdmmaaaa))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblCep)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtCEP, GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblEstado)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtEstado, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblCidade)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtCidade, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblEndereo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtEndereco, GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE))
						.addComponent(lblMensagem))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCdigo)
						.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCidade)
						.addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEstado)
						.addComponent(txtEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRg)
						.addComponent(txtRG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCep)
						.addComponent(txtCEP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNascimento)
						.addComponent(lblBairro)
						.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNascimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDdmmaaaa))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEndereo)
						.addComponent(txtEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addComponent(lblMensagem)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
