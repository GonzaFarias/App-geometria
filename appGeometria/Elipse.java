package appGeometria;

public class Elipse extends Figura{

	private Punto punto;
	private double radioA;
	private double radioB;
	
	public Elipse( double radioA,double radioB,Punto punto) {
		
		this.punto=punto;
		this.radioA=radioA;
		this.radioB=radioB;		
	}
	
	@Override
	public String toString() {
		return "Elipse [punto=" + punto + ", radioA=" + radioA + ", radioB=" + radioB + ", Area= "+calcularArea() + "]";
	}

	@Override
	public double calcularArea() {
		return Math.PI * this.radioA * this.radioB;
	}
	
	public void desplazarPuntoElipse(Punto a) {
		 setPunto(a);
	}
	
	@Override
	public void desplazarFiguraAmbosEjes(double d) {
		
		 this.punto.setX(this.punto.getX()+d);
		  this.punto.setY(this.punto.getY()+d);
	}

	@Override
	public void desplazarFiguraEnX(double d) {
		
		 this.punto.setX(this.punto.getX()+d);
	}

	@Override
	public void desplazarFiguraEnY(double d) {

		  this.punto.setY(this.punto.getY()+d);
	}

	public Punto getPunto() {
		return punto;
	}

	public void setPunto(Punto punto) {
		this.punto = punto;
	}

	public double getRadioA() {
		return radioA;
	}

	public void setRadioA(double radioA) {
		this.radioA = radioA;
	}

	public double getRadioB() {
		return radioB;
	}

	public void setRadioB(double radioB) {
		this.radioB = radioB;
	}


	
	
}
