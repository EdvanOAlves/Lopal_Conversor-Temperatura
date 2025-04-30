package br.dev.edvan.temperatura.model;

public class TratamentoDeInput {

	public static String tratarInput(String inputCelsius) { // Tratamento da variável

		if (!(inputCelsius.indexOf(",") == -1)) { // Substituindo virgula por ponto
			inputCelsius = inputCelsius.replace(",", ".");
		}
		if (!(inputCelsius.indexOf(" ") == -1)) { // Removendo espaços em branco
			inputCelsius = inputCelsius.replace(" ", "");
		}
		return inputCelsius;// Após a rotina de tratamento, a variável volta pro seu caminho

	}

	public static String verificarErros(String inputCelsius) { // Verificação de erros
		String mensagemDeErro = "none"; // Por padrão, sem nenhum erro até que se prove o contrário
		String formatacao = "<html><body style=' width: 365px; padding: 70px; text-align:center'>"; //Definindo formatacao da caixa de texto para mensagem de erro

		// Caso 1: Campo vazio
		if (inputCelsius.isEmpty()) {
			mensagemDeErro = formatacao + "Por favor, preencha o campo com uma temperatura em graus Celsius";
			return mensagemDeErro;
		}

		//Caso 2: Input de não-dígito
		if (!inputCelsius.matches("-?[0-9.]+$")){ //verificação de números, símbolo de negativo ao inicio e "." ao longo do número
			mensagemDeErro = formatacao + "Por favor, apenas caracteres válidos (0-9 . , -)";
			return mensagemDeErro;

		}

		// Caso 3: Mais de um ponto
		if (!(inputCelsius.indexOf('.') == -1)){ //Caso exista ponto flutuante
			int numeroDePontos = 0;
			for (int i = 0; i < inputCelsius.length(); i++) { //Verificação do String
				if (inputCelsius.charAt(i) == '.'){ // contagem de pontos
					numeroDePontos++;
				}

				if (numeroDePontos >1){	//Verificação,  se tem mais de um ponto
					mensagemDeErro = formatacao + "Por favor, insira apenas um ponto";
					return  mensagemDeErro;
				}
			}
		}

		// Caso 4: Valor abaixo do possível
		else if (Double.parseDouble(inputCelsius) <= -273.16) {
			mensagemDeErro = formatacao + "Por favor, não insira temperaturas abaixo do zero absoluto (-273.15°C)";
			return mensagemDeErro;
		}

		// Caso final: Se não teve nenhum erro encontrado, retorna o "none"
		return mensagemDeErro;
	}

}
