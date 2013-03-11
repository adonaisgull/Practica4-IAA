package pnas.control.etsii.ull.es;

import java.util.*;

public class Verdad {
	
	static final int EN_A = -15;
	static final int EN_B = -10;
	static final int EN_C = 0;
	
	static final int EP_A = 0;
	static final int EP_B = 10;
	static final int EP_C = 15;
	
	static final int EC_A = -5;
	static final int EC_B = 0;
	static final int EC_C = 5;
	
	static final int APA_A = 0;
	static final int APA_B = 50;
	
	static final int APC_A = -25;
	static final int APC_B = 0;
	static final int APC_C = 25;
	
	static public double errorNegativo(double x) {
		
		if (x >= EN_A && x <= EN_B)
			return 1;
		if (x > EN_B && x <= EN_C)
			return (-x / 10.0);
		
		return 0;
	}
	
	static public double errorPositivo(double x) {
		
		if (x >= EP_A && x <= EP_B)
			return (x / 10.0);
		if (x > EP_B && x <= EP_C)
			return 1;
		return 0;
	}
	
	static public double errorCero(double x) {
		if (x >= EC_A && x <= EC_B)
			return ((5.0 + x) / 5.0);
		if (x > EC_B && x <= EC_C)
			return ((5.0 - x) / 5.0);
		
		return 0;
	}
	
	static public double aperturaAbrir(double x) {
		
		if (x >= APA_A && x <= APA_B)
			return (x / 10.0);
		if (x > APA_B)
			return 1;
		
		return 0;
	}
	
	static public double aperturaCerrar(double x) {
		
		if (x >= APC_A && x <= APC_B)
			return ((25.0 + x) / 25.0);
		if (x > APC_B && x <= APC_C)
			return ((25.0 - x) / 25.0);
		
		return 0;
	}
	
	static public double verdadRegla1(double error, double x) {
		
		double verdadError = errorNegativo(error);
		double verdadApertura = aperturaCerrar(x);
		
		if (verdadError < verdadApertura)
			return verdadError;
		
		return verdadApertura;
	}
	
	static public double verdadRegla2(double error, double x) {
		
		double verdadError = errorCero(error);
		double verdadApertura = aperturaCerrar(x);
		
		if (verdadError < verdadApertura)	// devolvemos el minimo
			return verdadError;
		
		return verdadApertura;
	}
	
	static public double verdadRegla3(double error, double x) {
		
		double verdadError = errorPositivo(error);
		double verdadApertura = aperturaAbrir(x);
		
		if (verdadError < verdadApertura)	// devolvemos el minimo
			return verdadError;
		
		return verdadApertura;
	}
	
	static public double verdadX(double error, double x) {
		
		ArrayList<Double> gradosVerdad = new ArrayList<Double>();
		gradosVerdad.add(verdadRegla1(error, x));
		gradosVerdad.add(verdadRegla2(error, x));
		gradosVerdad.add(verdadRegla3(error, x));
		
		Collections.sort(gradosVerdad);
		
		return gradosVerdad.get(0);		// devolvemos el maximo
	}
}
