package appGeometria;

/***
 * InvalidSegmentoException se lanza cuando los extremos del segmento 
 * son el mismo punto, en ese caso no es un segmento e intentar verificar que 
 * dos segmentos sean paralelos provocara una division por cero. 
 *
 */

@SuppressWarnings("serial")
public class InvalidSegmentoException extends RuntimeException {

	public InvalidSegmentoException(String s) {
		super(s);
	}

}
