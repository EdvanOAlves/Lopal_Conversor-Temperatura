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
	public double converterParaKelvin(){
		double kelvin = celsius + 273.15;
		return kelvin;
	}
	
	public double converterParaFahreinheit() {
		//A fazer isso
		double fahreinheit = celsius * 1.8 + 32;
		return fahreinheit;
		
	}

}
