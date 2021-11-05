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
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import br.senai.sp.jandira.model.Periodo;

public class FrameCadastroAlunos extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("matricula");
		lblNewLabel.setBounds(20, 35, 47, 17);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(67, 33, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("name");
		lblName.setBounds(20, 64, 41, 14);
		contentPane.add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(67, 61, 86, 20);
		contentPane.add(textField_1);
		
		JLabel lblPeriodo = new JLabel("periodo");
		lblPeriodo.setBounds(20, 89, 41, 14);
		contentPane.add(lblPeriodo);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBounds(64, 128, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblListaDeAlunos = new JLabel("Lista De Alunos :");
		lblListaDeAlunos.setBounds(251, 36, 86, 14);
		contentPane.add(lblListaDeAlunos);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(229, 64, 195, 187);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		list.setBounds(229, 63, 195, 187);
		contentPane.add(list);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Periodo.values()));
		comboBox.setBounds(67, 85, 86, 22);
		contentPane.add(comboBox);
		contentPane.setVisible(true);
	}
}
