package appGeometria;


public abstract class Figura {

	public Figura() {
		
	}
	
	public abstract double calcularArea(); //Para calcular area de las figuras.
		
	public abstract void desplazarFiguraAmbosEjes(double d); //Se utiliza para mover la figura en diagonal sin perder su forma.
	
	public abstract void desplazarFiguraEnX(double d); //Se utiliza para mover la figura en el eje X sin perder su forma.
	
	public abstract void desplazarFiguraEnY(double d); //Se utiliza para mover la figura en el eje Y sin perder su forma.
	
	

	

	
	
}
