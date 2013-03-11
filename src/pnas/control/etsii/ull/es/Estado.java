package pnas.control.etsii.ull.es;

public class Estado {
	
	static final int ALTURA_DESEADA = 20;
	static final int LIMITE_INF = -25;
	static final int LIMITE_SUP = 100;
	
	private double alturaAgua;
	private double error;
	private double apertura;
	
	public Estado(double altura) {
		setAlturaAgua(altura);
	}
	
	public void actualizarError() {
		setError(ALTURA_DESEADA - getAlturaAgua());
	}
	
	public void actualizarApertura() {
		
		double sumatorioDividendo = 0;
		double sumatorioDivisor = 0;
		double verdadXi;
		
		for (int i = LIMITE_INF; i < LIMITE_SUP; i++) {
			verdadXi = Verdad.verdadX(getError(), i);
			sumatorioDividendo += i * verdadXi;
			sumatorioDivisor += verdadXi;
		}
		
		// NO SE SI HAY QUE IGUALAR O APLICAR EL PORCENTAJE
		setApertura(sumatorioDividendo / sumatorioDivisor);
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
