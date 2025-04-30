package br.dev.edvan.temperatura.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private JLabel labelMensagemErro;

	public void criarTelaConversor(String tituloDaTela) {// criando a tela
		// Iniciando
		JFrame tela = new JFrame();
		tela.setTitle(tituloDaTela);
		tela.setSize(500, 300);
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

		labelMensagemErro = new JLabel();
		labelMensagemErro.setBounds(110, 150, 350, 80);
		labelMensagemErro.setForeground(Color.red);
		labelMensagemErro.setBackground(null);

		// Pegando o local para adicionar o conteudo ao JFrame
		Container container = tela.getContentPane();

		buttonFahreinheit.addActionListener(new ActionListener() { // Funcionamento do botão limpar

			@Override
			public void actionPerformed(ActionEvent e) {
				// Coletando input
				String inputCelsius = textCelsius.getText();

				// Tratamento de input e diagnóstico de erros
				inputCelsius = TratamentoDeInput.tratarInput(inputCelsius);
				String errorMessage = TratamentoDeInput.verificarErros(inputCelsius);
				//
				if (errorMessage.equals("none")) { // Se estiver tudo certo, procedimento normal

					// instanciando objeto com a temperatura
					Temperatura temperatura = new Temperatura();
					temperatura.setCelsius(Double.parseDouble(inputCelsius));

					// conversão e formatação do resultado
					double temperaturaFahreinheit = temperatura.converterParaFahreinheit();
					String resultado = String.format("%.2f", temperaturaFahreinheit);
					labelResultado.setText(resultado + " FAHREINHEIT");
					labelResultado.setBounds(155, 120, 200, 40);
					labelMensagemErro.setText("");
					textCelsius.requestFocus();
				} else { // Em caso de erro, a mensagem de erro é exibida
					labelResultado.setText("");
					labelMensagemErro.setText(errorMessage);
				}

			}
		});

		buttonKelvin.addActionListener(new ActionListener() { // Funcionamento do botão limpar

			@Override
			public void actionPerformed(ActionEvent e) {
				// Coletando input
				String inputCelsius = textCelsius.getText();

				// Tratamento de input e diagnóstico de erros
				inputCelsius = TratamentoDeInput.tratarInput(inputCelsius);
				String errorMessage = TratamentoDeInput.verificarErros(inputCelsius);

				if (errorMessage.equals("none")) { // Se estiver tudo certo, procedimento normal
					
					// instanciando objeto com a temperatura
					Temperatura temperatura = new Temperatura();
					temperatura.setCelsius(Double.parseDouble(inputCelsius)); 
					
					// conversão e formatação do resultado
					double temperaturaKelvin = temperatura.converterParaKelvin();
					String resultado = String.format("%.2f", temperaturaKelvin);
					labelResultado.setText(resultado + " KELVIN");
					labelResultado.setBounds(190, 120, 200, 40);
					textCelsius.requestFocus();
					labelMensagemErro.setText("");
				} else { // Em caso de erro, a mensagem de erro é exibida
					labelResultado.setText("");
					labelMensagemErro.setText(errorMessage);
				}
			}
		});

		//adicionando elementos na tela
		container.add(labelCelsius);
		container.add(textCelsius);
		container.add(buttonFahreinheit);
		container.add(buttonKelvin);
		container.add(labelResultado);
		container.add(labelMensagemErro);

		//ligando a visualização
		tela.setVisible(true);

	}

}
