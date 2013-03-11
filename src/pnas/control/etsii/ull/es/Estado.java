package pnas.control.etsii.ull.es;

public class Estado {
	
	static final int ALTURA_DESEADA = 20;
	
	private double alturaAgua;
	private double error;
	private double apertura;
	
	public Estado(double altura) {
		setAlturaAgua(altura);
		
	}
	
	public void actualizarError() {
		setError(ALTURA_DESEADA - getAlturaAgua());
	}
	
	double getAlturaAgua() {
		return alturaAgua;
	}
	
	double getError() {
		return error;
	}
	
	double getApertura() {
		return apertura;
	}
	
	void setAlturaAgua(double altura) {
		alturaAgua = altura;
	}
	
	void setError(double err) {
		error = err;
	}
	
	void setApertura(double apert) {
		apertura = apert;
	}
}
