package br.senai.sp.jandira.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSlider;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import br.senai.sp.jandira.model.Aluno;
import br.senai.sp.jandira.model.Periodo;
import br.senai.sp.jandira.repository.AlunoRepository;

public class FrameCadastroAlunos extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	
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
		
		textField = new JTextField();
		textField.setBounds(67, 33, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("name");
		lblName.setBounds(10, 64, 51, 14);
		contentPane.add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(67, 61, 86, 20);
		contentPane.add(textField_1);
		
		JLabel lblPeriodo = new JLabel("periodo");
		lblPeriodo.setBounds(10, 89, 51, 14);
		contentPane.add(lblPeriodo);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBounds(64, 128, 89, 23);
		contentPane.add(btnNewButton);
		
		AlunoRepository turmas = new AlunoRepository(3);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Aluno aluno = new Aluno();
				aluno.setMatricula(lblNewLabel.getText());
				aluno.setNome(lblName.getText());
				turmas.gravar(aluno, posicao);
				
				posicao++;
				
			}
		});
		
		

		
		JLabel lblListaDeAlunos = new JLabel("Lista De Alunos :");
		lblListaDeAlunos.setBounds(229, 36, 108, 14);
		contentPane.add(lblListaDeAlunos);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(229, 64, 195, 187);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		//adicionar o nome do aluno na lista
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		list.setBounds(229, 63, 195, 187);
		contentPane.add(list);
		
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
		
		JButton btnNewButton_1 = new JButton("Exibir Alunos");
		btnNewButton_1.setBounds(64, 174, 89, 23);
		contentPane.add(btnNewButton_1);
		contentPane.setVisible(true);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for (Aluno aluno : turmas.listarTodos()) {
					System.out.println(aluno.getMatricula());
					System.out.println(aluno.getNome());
					System.out.println(aluno.getPeriodo());
				}
				
				
			}
		});
		
	}
}
