package br.senai.sp.jandira.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JButton;
import javax.swing.JSlider;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import br.senai.sp.jandira.model.Aluno;
import br.senai.sp.jandira.model.Periodo;
import br.senai.sp.jandira.repository.AlunoRepository;
import javax.swing.JScrollPane;

public class FrameCadastroAlunos extends JFrame {

	private JPanel contentPane;
	private JTextField cachinhamatricula;
	private JTextField cachinhaname;
	
	private int posicao = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameCadastroAlunos frame = new FrameCadastroAlunos();
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
	public FrameCadastroAlunos() {
		
		String dias [] = {"segunda", "terça", "quarta", "quinta"};
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("matricula");
		lblNewLabel.setBounds(10, 35, 57, 17);
		contentPane.add(lblNewLabel);
		
		cachinhamatricula = new JTextField();
		cachinhamatricula.setBounds(67, 33, 86, 20);
		contentPane.add(cachinhamatricula);
		cachinhamatricula.setColumns(10);
		
		JLabel lblName = new JLabel("name");
		lblName.setBounds(10, 64, 51, 14);
		contentPane.add(lblName);
		
		cachinhaname = new JTextField();
		cachinhaname.setColumns(10);
		cachinhaname.setBounds(67, 61, 86, 20);
		contentPane.add(cachinhaname);
		
		JLabel lblPeriodo = new JLabel("periodo");
		lblPeriodo.setBounds(10, 89, 51, 14);
		contentPane.add(lblPeriodo);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBounds(64, 128, 89, 23);
		contentPane.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		//para colocar "lista" no combobox usa-se as duas linhas abaixo
		DefaultComboBoxModel<String> modelperiodo = new DefaultComboBoxModel<String>(dias);

		//usei o for para não ter que fazer coisas repetitivas !!
		for(Periodo P : Periodo.values()) {
			modelperiodo.addElement(P.getDescricao());
		}
		comboBox.setModel(modelperiodo);
		comboBox.setBounds(67, 85, 86, 22);
		contentPane.add(comboBox);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(229, 64, 179, 174);
		contentPane.add(scrollPane);

		JList list = new JList();
		DefaultListModel<String> listMod = new DefaultListModel<String>();
		list.setModel(listMod);
		scrollPane.setViewportView(list);
		contentPane.setVisible(true);
		
		AlunoRepository turmas = new AlunoRepository();
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Aluno aluno = new Aluno();
				aluno.setMatricula(cachinhamatricula.getText());
				aluno.setNome(cachinhaname.getText());
				
				
				
				// Definir o horario que o aluno estuda 
				aluno.setPeriodo(determinarPeriodo(comboBox.getSelectedIndex()));
				turmas.gravar(aluno, posicao);
				
				
				posicao++;
				
				// adicionar o aluno a lista
				listMod.addElement(aluno.getNome());
				
				if (posicao == turmas.gettamanho()) {
					btnNewButton.setEnabled(false);
					JOptionPane.showMessageDialog(null, "A turma ja encheu");
					
					
					
				}
				
			}
		});
		
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				Aluno aluno = turmas.listarAluno(list.getSelectedIndex());
				cachinhaname.setText(aluno.getNome());
				cachinhamatricula.setText(aluno.getMatricula());
				
				comboBox.setSelectedIndex(aluno.getPeriodo().ordinal());
				
			}
		});
		
		
		
		

		
		JLabel lblListaDeAlunos = new JLabel("Lista De Alunos :");
		lblListaDeAlunos.setBounds(229, 36, 108, 14);
		contentPane.add(lblListaDeAlunos);
		//adicionar o nome do aluno na lista
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		
		
		
		JButton btnNewButton_1 = new JButton("Exibir Alunos");
		btnNewButton_1.setBounds(64, 174, 89, 23);
		contentPane.add(btnNewButton_1);
				
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for (Aluno aluno : turmas.listarTodos()) {
					System.out.println(aluno.getMatricula());
					System.out.println(aluno.getNome());
					System.out.println(aluno.getPeriodo().getDescricao());
					
				}
				
				
			}
		});
		
		
		
	}
	private Periodo determinarPeriodo (int periodoselecionado) {
		
		if (periodoselecionado == 0 ) {
			return Periodo.MANHA;
		}else if(periodoselecionado == 1 ) {
			return Periodo.TARDE;
		}else {
			return Periodo.NOITE;
		}

	}
}
