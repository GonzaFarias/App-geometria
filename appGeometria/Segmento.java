package appGeometria;

public class Segmento {

	Punto a;
	Punto b;

	public Segmento(Punto a, Punto b) throws InvalidSegmentoException {

		if (a.getX() == b.getX() && a.getY() == b.getY())
			throw new InvalidSegmentoException("Los extremos de un segmento no pueden ser el mismo punto");

		this.a = a;
		this.b = b;
	}

	@Override
	public String toString() {
		return "Segmento [a=" + a + ", b=" + b + ", Longitud= " + longitudSegmento() + "]";
	}

	public double longitudSegmento() {

		return Math.sqrt((Math.pow(this.a.getX() - this.b.getX(), 2) + Math.pow(this.a.getY() - this.b.getY(), 2)));
	}

	public boolean paraleloEjeX() {
		return this.a.getY() == this.b.getY();
	}

	public boolean paraleloEjeY() {
		return this.a.getX() == this.b.getX();
	}

	public boolean segmentosParalelos(Segmento a, Segmento b) {
		double pendienteA = 0;
		double pendienteB = 0;
		pendienteA = (a.getB().getY() - a.getA().getY()) / (a.getB().getX() - a.getA().getX());
		pendienteB = (b.getB().getY() - b.getA().getY()) / (b.getB().getX() - b.getA().getX());
		if (pendienteB < 0)
			pendienteB = pendienteB * -1;
		if (pendienteA < 0)
			pendienteA = pendienteA * -1;

		if (pendienteA == pendienteB) {
			return (a.getB().getY() != b.getA().getY()) && (a.getA().getY() != b.getA().getY())
					&& (a.getB().getY() != b.getB().getY()) && (a.getA().getY() != b.getB().getY())
					|| (a.getB().getX() != b.getA().getX()) && (a.getA().getX() != b.getA().getX())
							&& (a.getB().getX() != b.getB().getX()) && (a.getA().getX() != b.getB().getX());
		}
		return false;
	}

	public void desplazarPuntoA(Punto a) {

		setA(a);
	}

	public void desplazarPuntoB(Punto a) {

		setB(a);
	}

	public void desplazarSegmentoEjeY(double d) {

		this.a.setY(a.getY() + d);
		this.b.setY(a.getY() + d);
	}

	public void desplazarSegmentoEjeX(double d) {

		this.a.setX(this.a.getX() + d);
		this.b.setX(this.b.getX() + d);
	}

	public void desplazarSegmentoAmbosEjes(double d) {

		this.a.setX(this.a.getX() + d);
		this.a.setY(this.a.getY() + d);
		this.b.setX(this.b.getX() + d);
		this.b.setY(this.b.getY() + d);
	}

	public Punto getA() {
		return a;
	}

	public void setA(Punto a) {
		this.a = a;
	}

	public Punto getB() {
		return b;
	}

	public void setB(Punto b) {
		this.b = b;
	}

}
