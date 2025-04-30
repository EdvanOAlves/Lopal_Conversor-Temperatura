package br.dev.edvan.temperatura.model;

public class Temperatura {
	private double celsius;
	
	//Get e Set da temperatura em Celsius
	public double getCelsius() {
		return celsius;
	}
	
	public void setCelsius(double celsius) {
		this.celsius = celsius;
	}
	
	
	//Conversões
	public double converterParaKelvin(){ //Conversão para Kelvin
		double kelvin = celsius + 273.15;
		return kelvin;
	}
	
	public double converterParaFahreinheit() { //Conversão para Fahreinheit
		double fahreinheit = celsius * 1.8 + 32;
		return fahreinheit;
		
	}

}
