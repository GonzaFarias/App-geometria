package appGeometria;

import java.util.Comparator;

public class OrdenarFiguras implements Comparator<Figura> {

	@Override
	public int compare(Figura o1, Figura o2) {

		if (o1.calcularArea() > o2.calcularArea()) {
			return -1;
		} else if (o1.calcularArea() > o2.calcularArea()) {
			return 0;
		} else
			return 1;
	}

}
