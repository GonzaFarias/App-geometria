package appGeometria;

public class Cuadrado extends Figura {

	private double lado;
	private Punto punto;

	public Cuadrado(double lado, Punto puntoInfIz) throws InvalidCuadradoException {

		if (lado <= 0)
			throw new InvalidCuadradoException("Un cuadrado no puede tener un lado igual a 0 o negativo");

		this.punto = puntoInfIz;
		this.lado = lado;
	}

	@Override
	public String toString() {
		return "Cuadrado [lado=" + lado + ", punto=" + punto + ", Area= " + calcularArea() + "]";
	}

	@Override
	public double calcularArea() {

		return Math.pow(this.lado, 2);
	}

	public void desplazarPuntoCuadrado(Punto a) {

		setPunto(a);
	}

	@Override
	public void desplazarFiguraAmbosEjes(double d) {

		this.punto.setX(this.punto.getX() + d);
		this.punto.setY(this.punto.getY() + d);
	}

	@Override
	public void desplazarFiguraEnX(double d) {

		this.punto.setX(this.punto.getX() + d);
	}

	@Override
	public void desplazarFiguraEnY(double d) {

		this.punto.setY(this.punto.getY() + d);
	}

	public double getLado() {
		return this.lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

	public Punto getPunto() {
		return punto;
	}

	public void setPunto(Punto punto) {
		this.punto = punto;
	}

}
