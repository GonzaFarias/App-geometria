package appGeometria;

import java.util.LinkedList;

public class AppGeometria {

	public static void main(String[] args) throws Exception {
		
		LinkedList<Figura> a = new LinkedList<Figura>();
		UsoArchivos b = new UsoArchivos();
		a = b.leerArchivo("src/archivosFiguras/input.in");
		b.escribirFiguras();
		b.escribirGrandotes(a);
		b.escribirParalelos();
		Segmento s = new Segmento(new Punto(7,8),new Punto(7,7));
		if(s.segmentosParalelos(new Segmento(new Punto(5,8),new Punto(5,2)),new Segmento(new Punto(7,8),new Punto(7,2))))
			System.out.println("Son segmentos paralelos");
	}
}
