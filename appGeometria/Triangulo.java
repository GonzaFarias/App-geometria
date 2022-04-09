package appGeometria;

public class Triangulo extends Figura {

	private Punto vertice1;
	private Punto vertice2;
	private Punto vertice3;

	public Triangulo(Punto vertice1, Punto vertice2, Punto vertice3) throws Exception {

		if ((vertice1.getX() == vertice2.getX() && vertice1.getY() == vertice2.getY())
				|| (vertice2.getX() == vertice3.getX() && vertice2.getY() == vertice3.getY())
				|| (vertice1.getX() == vertice3.getX() && vertice1.getY() == vertice3.getY()))
			throw new PuntosIgualesException("Los puntos de un triangulo no pueden ser el mismo");

		this.vertice1 = vertice1;
		this.vertice2 = vertice2;
		this.vertice3 = vertice3;

	}

	@Override
	public String toString() {
		return "Triangulo [vertice1=" + vertice1 + ", vertice2=" + vertice2 + ", vertice3=" + vertice3 + ", Area= "
				+ calcularArea() + "]";
	}

	@Override
	public double calcularArea() {
		try {
			Segmento seg1 = new Segmento(getVertice1(), getVertice2());

			Segmento seg2 = new Segmento(getVertice2(), getVertice3());

			return seg1.longitudSegmento() * seg2.longitudSegmento() / 2;
		} catch (Exception e) {

			System.err.println("Los extremos de un segmento no pueden ser el mismo punto");
		}
		return 0;
	}

	public void desplazarPuntoA(Punto a) {

		setVertice1(a);
	}

	public void desplazarPuntoB(Punto a) {

		setVertice2(a);

	}

	public void desplazarPuntoC(Punto a) {

		setVertice3(a);

	}

	@Override
	public void desplazarFiguraAmbosEjes(double d) {

		this.vertice1.setX(vertice1.getX() + d);
		this.vertice1.setY(vertice1.getY() + d);
		this.vertice2.setX(vertice2.getX() + d);
		this.vertice2.setY(vertice2.getY() + d);
		this.vertice3.setX(vertice3.getX() + d);
		this.vertice3.setY(vertice3.getY() + d);
	}

	@Override
	public void desplazarFiguraEnX(double d) {

		this.vertice1.setX(vertice1.getX() + d);
		this.vertice2.setX(vertice2.getX() + d);
		this.vertice3.setX(vertice3.getX() + d);
	}

	@Override
	public void desplazarFiguraEnY(double d) {

		this.vertice1.setY(vertice1.getY() + d);
		this.vertice2.setY(vertice2.getY() + d);
		this.vertice3.setY(vertice3.getY() + d);
	}

	public boolean esParaleloAUnEje() throws Exception {

		Segmento seg1 = new Segmento(this.vertice1, this.vertice2);
		Segmento seg2 = new Segmento(this.vertice2, this.vertice3);
		Segmento seg3 = new Segmento(this.vertice3, this.vertice1);

		return seg1.paraleloEjeX() || seg1.paraleloEjeY() || seg2.paraleloEjeX() || seg2.paraleloEjeY()
				|| seg3.paraleloEjeX() || seg3.paraleloEjeY();
	}

	public Punto getVertice1() {
		return vertice1;
	}

	public void setVertice1(Punto vertice1) {
		this.vertice1 = vertice1;
	}

	public Punto getVertice2() {
		return vertice2;
	}

	public void setVertice2(Punto vertice2) {
		this.vertice2 = vertice2;
	}

	public Punto getVertice3() {
		return vertice3;
	}

	public void setVertice3(Punto vertice3) {
		this.vertice3 = vertice3;
	}

}
