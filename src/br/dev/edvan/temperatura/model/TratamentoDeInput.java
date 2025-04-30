package br.dev.edvan.temperatura.model;

public class TratamentoDeInput {
	/*
	 * Olá, não sei se essa anotação vai ficar aqui, só preciso esclarecer:
	 * Eu sei que essa solução foge do diagrama de classe, eu só
	 * notei que não foram abordados os métodos try catch em aula (que eu já sabia
	 * usar), então decidi pegar pra fazer o tratamento dos inputs e capturar o
	 * máximo de erros manualmente em uma classe só por prática mesmo, obrigado pela
	 * atenção :)
	 * 
	 */

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

		// Caso 1: Campo vazio
		if (inputCelsius.isEmpty()) { 
			mensagemDeErro = "Por favor, preencha o campo com uma temperatura em graus Celcius";
			return mensagemDeErro;
		}
		
		//Caso 2: Input de não-dígito
		if (!inputCelsius.matches("-?[0-9.]+$")){ //verificação de números, símbolo de negativo ao inicio e "." ao longo do número
			mensagemDeErro = "Por favor, apenas caracteres válidos (0-9, . e -)";
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
					mensagemDeErro = "Por favor, insira apenas um ponto";
					return  mensagemDeErro;
				}
			}
		}
		
		// Caso 4: Valor abaixo do possível
		else if (Double.parseDouble(inputCelsius) <= -273.16) { 
			mensagemDeErro = "Por favor, não insira temperaturas abaixo do zero absoluto (-273.15°C)";
			return mensagemDeErro;
		}
		
		// Caso final: Se não teve nenhum erro encontrado, retorna o "none"
		return mensagemDeErro;
	}

}
