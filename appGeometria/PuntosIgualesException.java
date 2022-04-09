package appGeometria;

	/*
	 * PuntosIgualesException se lanza cuando una figura tiene un punto igual a otro
	 * en este caso no se podrian unir los puntos ya que serian el mismo, impidiendo
	 * graficar la figura.
	 */

	@SuppressWarnings("serial")
	public class PuntosIgualesException extends RuntimeException {

		public PuntosIgualesException(String s) {
			super(s);
		}

	}


