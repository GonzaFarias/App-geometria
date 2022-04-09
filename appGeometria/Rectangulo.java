package appGeometria;

public class Rectangulo extends Figura {

	private Punto superiorDerecha;
	private Punto inferiorIzquierda;

	public Rectangulo(Punto inferiorIzquierda, Punto superiorDerecha) throws Exception {

		if (superiorDerecha.getX() == inferiorIzquierda.getX() && superiorDerecha.getY() == inferiorIzquierda.getY())
			throw new PuntosIgualesException("Los puntos de un rectangulo no pueden ser el mismo");

		this.inferiorIzquierda = inferiorIzquierda;
		this.superiorDerecha = superiorDerecha;
	}

	@Override
	public double calcularArea() {

		double base = 0;
		double altura = 0;
		base = Math.sqrt(Math.pow(this.inferiorIzquierda.getX() - this.superiorDerecha.getX(), 2));
		altura = Math.sqrt(Math.pow(this.inferiorIzquierda.getY() - this.superiorDerecha.getY(), 2));

		return base * altura;
	}

	public void desplazarPuntoInferiorIzquierdo(Punto a) {

		setInferiorIzquierda(a);
	}

	public void desplazarPuntoSuperiorDerecho(Punto a) {

		setSuperiorDerecha(a);
	}

	@Override
	public void desplazarFiguraAmbosEjes(double d) {

		this.inferiorIzquierda.setX(this.inferiorIzquierda.getX() + d);
		this.inferiorIzquierda.setY(this.inferiorIzquierda.getY() + d);
		this.superiorDerecha.setX(this.superiorDerecha.getX() + d);
		this.superiorDerecha.setY(this.superiorDerecha.getY() + d);
	}

	@Override
	public void desplazarFiguraEnX(double d) {

		this.superiorDerecha.setX(this.superiorDerecha.getX() + d);
		this.inferiorIzquierda.setX(this.inferiorIzquierda.getX() + d);
	}

	@Override
	public void desplazarFiguraEnY(double d) {

		this.inferiorIzquierda.setY(this.inferiorIzquierda.getY() + d);
		this.superiorDerecha.setY(this.superiorDerecha.getY() + d);
	}

	@Override
	public String toString() {
		return "Rectangulo [superiorDerecha=" + superiorDerecha + ", inferiorIzquierda=" + inferiorIzquierda
				+ ", Area= " + calcularArea() + "]";
	}

	public Punto getSuperiorDerecha() {
		return superiorDerecha;
	}

	public void setSuperiorDerecha(Punto superiorDerecha) {
		this.superiorDerecha = superiorDerecha;
	}

	public Punto getInferiorIzquierda() {
		return inferiorIzquierda;
	}

	public void setInferiorIzquierda(Punto inferiorIzquierda) {
		this.inferiorIzquierda = inferiorIzquierda;
	}

}
