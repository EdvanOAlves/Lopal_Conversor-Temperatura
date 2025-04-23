package br.dev.edvan.temperatura.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.dev.edvan.temperatura.model.Temperatura;

public class TelaConversor {
	//Declarando elementos a serem utilizados na interface gráfica
	
	//Elementos de comunicação com o usuário e entrada
	private JLabel labelCelsius;
	private JTextField textCelsius;
	
	//Botões
	private JButton buttonKelvin;
	private JButton buttonFahreinheit;
	
	//Outputs
	private JLabel labelResultado;
	private JTextArea labelMensagemErro;
	public void criarTelaConversor(String tituloDaTela) {//criando a tela
		//Iniciando 
		JFrame tela = new JFrame();
		tela.setTitle(tituloDaTela);
		tela.setSize(500, 420);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);

		//Configurando botões, campos de entrada e labels
		labelCelsius = new JLabel();
		labelCelsius.setText("Temperatura em graus celsius:");
		labelCelsius.setBounds(40, 30, 240, 25);
		labelCelsius.setFont(new Font ("Arial", 0, 14));
		
		textCelsius = new JTextField();
		textCelsius.setBounds(40, 60, 420, 30);
		
		buttonFahreinheit= new JButton();
		buttonFahreinheit.setText("FAHREINHEIT");
		buttonFahreinheit.setBounds(40, 100, 200, 25);
		
		buttonKelvin = new JButton();
		buttonKelvin.setText("KELVIN");
		buttonKelvin.setBounds(260, 100, 200, 25);
		
		labelResultado = new JLabel();
//		labelResultado.setText("78,8 FAHREINHEIT ");
		labelResultado.setFont(new Font ("Arial", 1, 18));
		labelResultado.setBounds(175, 150, 200, 40);
		
		labelMensagemErro = new JTextArea();
//		labelMensagemErro.setText("Caso o valor fornecido pelo usuário esteja incorreto,\n a mensagem de erro deverá aparecer aqui");
		labelMensagemErro.setBounds(75, 200, 350, 80);
		labelMensagemErro.setForeground(Color.red);
		labelMensagemErro.setBackground(null);
	
		Container container = tela.getContentPane(); //Pegando o local para adicionar o conteudo ao JFrame
		
		buttonFahreinheit.addActionListener(new ActionListener() { //Funcionamento do botão limpar
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputCelsius = textCelsius.getText();				
				Temperatura temperatura = new Temperatura();
				temperatura.setCelsius(Double.parseDouble(inputCelsius)); //convertendo para double
				
				double temperaturaFahreinheit = temperatura.converterParaFahreinheit();
				labelResultado.setText(Double.toString(temperaturaFahreinheit) + " FAHREINHEIT");
				labelResultado.setBounds(165, 150, 200, 40);
				textCelsius.requestFocus();
				
			}
		});
		
		buttonKelvin.addActionListener(new ActionListener() { //Funcionamento do botão limpar
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputCelsius = textCelsius.getText();				
				Temperatura temperatura = new Temperatura();
				temperatura.setCelsius(Double.parseDouble(inputCelsius)); //convertendo para double
				
				
				double temperaturaKelvin = temperatura.converterParaKelvin();
				labelResultado.setText(Double.toString(temperaturaKelvin) + " KELVIN");
				labelResultado.setBounds(180, 150, 200, 40);
				textCelsius.requestFocus();
				
			}
		});
		
		container.add(labelCelsius);
		container.add(textCelsius);
		container.add(buttonFahreinheit);
		container.add(buttonKelvin);
		container.add(labelResultado);
		container.add(labelMensagemErro);
		
		
		tela.setVisible(true);
		
	}


}
