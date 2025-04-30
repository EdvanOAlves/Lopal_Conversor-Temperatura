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

import br.dev.edvan.temperatura.model.TratamentoDeInput;
import br.dev.edvan.temperatura.model.Temperatura;

public class TelaConversor {
	// Declarando elementos a serem utilizados na interface gráfica

	// Elementos de comunicação com o usuário e entrada
	private JLabel labelCelsius;
	private JTextField textCelsius;

	// Botões
	private JButton buttonKelvin;
	private JButton buttonFahreinheit;

	// Outputs
	private JLabel labelResultado;
	private JTextArea labelMensagemErro;

	public void criarTelaConversor(String tituloDaTela) {// criando a tela
		// Iniciando
		JFrame tela = new JFrame();
		tela.setTitle(tituloDaTela);
		tela.setSize(500, 420);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);

		// Configurando botões, campos de entrada e labels
		labelCelsius = new JLabel();
		labelCelsius.setText("Temperatura em graus celsius:");
		labelCelsius.setBounds(40, 30, 240, 25);
		labelCelsius.setFont(new Font("Arial", 0, 14));

		textCelsius = new JTextField();
		textCelsius.setBounds(40, 60, 420, 30);

		buttonFahreinheit = new JButton();
		buttonFahreinheit.setText("FAHREINHEIT");
		buttonFahreinheit.setBounds(40, 100, 200, 25);

		buttonKelvin = new JButton();
		buttonKelvin.setText("KELVIN");
		buttonKelvin.setBounds(260, 100, 200, 25);

		labelResultado = new JLabel();
		labelResultado.setFont(new Font("Arial", 1, 18));
		labelResultado.setBounds(175, 120, 200, 40);

		labelMensagemErro = new JTextArea();
		labelMensagemErro.setBounds(75, 200, 350, 80);
		labelMensagemErro.setForeground(Color.red);
		labelMensagemErro.setBackground(null);

		Container container = tela.getContentPane(); // Pegando o local para adicionar o conteudo ao JFrame

		buttonFahreinheit.addActionListener(new ActionListener() { // Funcionamento do botão limpar

			@Override
			public void actionPerformed(ActionEvent e) {
				String inputCelsius = textCelsius.getText(); 	//Coletando input e guardando na variável

				inputCelsius = TratamentoDeInput.tratarInput(inputCelsius); 	// Tratamento do input
				String errorMessage = TratamentoDeInput.verificarErros(inputCelsius);	//Enviando input para verificar por erros e receber uma mensagem (Se necessário)
																				// 
				if (errorMessage.equals("none")) { 	//Se estiver tudo certo, procedimento normal
					Temperatura temperatura = new Temperatura();
					temperatura.setCelsius(Double.parseDouble(inputCelsius)); //convertendo para double

					double temperaturaFahreinheit = temperatura.converterParaFahreinheit();
					labelResultado.setText(Double.toString(temperaturaFahreinheit) + " FAHREINHEIT");
					textCelsius.requestFocus();
				} else {	//Em caso de erro, a mensagem de erro é exibida
					labelResultado.setText("");
					labelMensagemErro.setText(errorMessage);
				}

			}
		});

		buttonKelvin.addActionListener(new ActionListener() { 	//Funcionamento do botão limpar

			@Override
			public void actionPerformed(ActionEvent e) {
				String inputCelsius = textCelsius.getText(); 	//Coletando input e guardando na variável

				inputCelsius = TratamentoDeInput.tratarInput(inputCelsius); 	//Tratamento do input
				String errorMessage = TratamentoDeInput.verificarErros(inputCelsius);	//Enviando input para verificar por erros e receber uma mensagem (Se necessário)

				if (errorMessage.equals("none")) { 	//Se estiver tudo certo, procedimento normal
				Temperatura temperatura = new Temperatura();
				temperatura.setCelsius(Double.parseDouble(inputCelsius)); // convertendo para double

				double temperaturaKelvin = temperatura.converterParaKelvin();
				labelResultado.setText(Double.toString(temperaturaKelvin) + " KELVIN");
				textCelsius.requestFocus();
				}
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
