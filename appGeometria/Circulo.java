package appGeometria;

public class Circulo extends Figura {

	private Punto centro;
	private double radio;

	public Circulo(double radio, Punto p) throws InvalidRadioException {

		if (radio <= 0)
			throw new InvalidRadioException("Un circulo no puede tener un radio igual a 0 o negativo");
		this.centro = p;
		this.radio = radio;

	}

	@Override
	public String toString() {
		return "Circulo [centro=" + centro + ", radio=" + radio + ", Area= " + calcularArea() + "]";
	}

	@Override
	public double calcularArea() {
		return Math.PI * (Math.pow(this.radio, 2));
	}

	public void desplazarPuntoCirculo(Punto a) {

		setCentro(a);
	}

	@Override
	public void desplazarFiguraAmbosEjes(double d) {

		this.centro.setX(this.centro.getX() + d);
		this.centro.setY(this.centro.getY() + d);
	}

	@Override
	public void desplazarFiguraEnX(double d) {
		this.centro.setX(this.centro.getX() + d);
	}

	@Override
	public void desplazarFiguraEnY(double d) {
		this.centro.setY(this.centro.getY() + d);
	}

	public Punto getCentro() {
		return centro;
	}

	public void setCentro(Punto centro) {
		this.centro = centro;
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

}
