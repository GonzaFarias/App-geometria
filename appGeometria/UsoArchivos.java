package appGeometria;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

public class UsoArchivos {

	private Elipse elipse;
	private Cuadrado cuadrado;
	private Triangulo triangulo;
	private Circulo circulo;
	private Rectangulo rectangulo;

	// Listas para cada Figura y Segmento.

	private LinkedList<Figura> cuadrados;
	private LinkedList<Segmento> segmentos;
	private LinkedList<Figura> elipses;
	private LinkedList<Figura> circulos;
	private LinkedList<Figura> triangulos;
	private LinkedList<Figura> rectangulos;
	private LinkedList<Triangulo> triangulos2;

	public UsoArchivos() {

		elipses = new LinkedList<Figura>();
		segmentos = new LinkedList<Segmento>();
		cuadrados = new LinkedList<Figura>();
		circulos = new LinkedList<Figura>();
		triangulos = new LinkedList<Figura>();
		rectangulos = new LinkedList<Figura>();
		triangulos2 = new LinkedList<Triangulo>();

	}

	// Metodo para obtener las figuras del archivo

	public LinkedList<Figura> leerArchivo(String archivo) throws Exception {

		LinkedList<Figura> figuras = new LinkedList<Figura>();
		Scanner sc = new Scanner(new File(archivo));
		sc.useLocale(Locale.ENGLISH);
		String[] arrFiguras;
		Segmento segmento;
		double m; // Aqui defini solo 6 variables para declarar menos,
		double n; // en lugar muchas para cada figura.
		double v;
		double k;
		double j;
		double h;

		while (sc.hasNext()) {

			// Lectura de cada tipo de figura y segmento.

			try {
				arrFiguras = sc.nextLine().split(",");
				if ("CIRCULO".equals(arrFiguras[0])) {
					m = Double.parseDouble(arrFiguras[1]);
					n = Double.parseDouble(arrFiguras[2]);
					v = Double.parseDouble(arrFiguras[3]);
					circulo = new Circulo(m, new Punto(n, v));
					figuras.add(circulo);
					circulos.add(circulo);
				} else if ("ELIPSE".equals(arrFiguras[0])) {
					m = Double.parseDouble(arrFiguras[1]);
					n = Double.parseDouble(arrFiguras[2]);
					v = Double.parseDouble(arrFiguras[3]);
					k = Double.parseDouble(arrFiguras[4]);
					elipse = new Elipse(m, n, new Punto(v, k));
					figuras.add(elipse);
					elipses.add(elipse);
				} else if ("SEGMENTO".equals(arrFiguras[0])) {
					m = Double.parseDouble(arrFiguras[1]);
					n = Double.parseDouble(arrFiguras[2]);
					v = Double.parseDouble(arrFiguras[3]);
					k = Double.parseDouble(arrFiguras[4]);
					try {
						segmento = new Segmento(new Punto(m, n), new Punto(v, k));
						this.segmentos.add(segmento);
					} catch (InvalidSegmentoException a) {
						System.err.println(a.getMessage());
					}
				} else if ("CUADRADO".equals(arrFiguras[0])) {
					m = Double.parseDouble(arrFiguras[1]);
					n = Double.parseDouble(arrFiguras[2]);
					v = Double.parseDouble(arrFiguras[3]);
					cuadrado = new Cuadrado(m, new Punto(n, v));
					figuras.add(cuadrado);
					cuadrados.add(cuadrado);
				} else if ("RECTANGULO".equals(arrFiguras[0])) {
					m = Double.parseDouble(arrFiguras[1]);
					n = Double.parseDouble(arrFiguras[2]);
					v = Double.parseDouble(arrFiguras[3]);
					k = Double.parseDouble(arrFiguras[4]);
					try {
						rectangulo = new Rectangulo(new Punto(m, n), new Punto(v, k));
						figuras.add(rectangulo);
						rectangulos.add(rectangulo);
					} catch (PuntosIgualesException a) {
						System.err.println(a.getMessage());
					}
				} else if ("TRIANGULO".equals(arrFiguras[0])) {
					m = Double.parseDouble(arrFiguras[1]);
					n = Double.parseDouble(arrFiguras[2]);
					v = Double.parseDouble(arrFiguras[3]);
					k = Double.parseDouble(arrFiguras[4]);
					j = Double.parseDouble(arrFiguras[5]);
					h = Double.parseDouble(arrFiguras[6]);
					try {
						triangulo = new Triangulo(new Punto(m, n), new Punto(v, k), new Punto(j, h));
						figuras.add(triangulo);
						triangulos.add(triangulo);
						triangulos2.add(triangulo);
					} catch (PuntosIgualesException a) {
						System.err.println(a.getMessage());
					}
				}
			} catch (ArrayIndexOutOfBoundsException a) {
				System.err.println("        Error: La cantidad de parametros dados no coinciden con los de la figura");
			}
		}
		sc.close();

		return figuras;
	}

	// Escritura de las figuras en archivo figuras.out ordenadas por area de mayor a
	// menor.

	public void escribirFiguras() throws IOException {

		FileWriter arch = new FileWriter(new File("src/archivosFiguras/figuras.out"));
		PrintWriter salida = new PrintWriter(arch);

		UsoArchivos l = new UsoArchivos();

		this.circulos = l.ordenarFiguras(circulos); // Antes de escribir el archivo se ordenan las figuras con el metodo
													// ordenarFiguras.
		this.elipses = l.ordenarFiguras(elipses);
		this.triangulos = l.ordenarFiguras(triangulos);
		this.rectangulos = l.ordenarFiguras(rectangulos);
		this.cuadrados = l.ordenarFiguras(cuadrados);

		salida.println("Círculos");			
		salida.println(this.circulos);
		salida.println("Elipses");
		salida.println(this.elipses);
		salida.println("Triángulos");
		salida.println(this.triangulos);
		salida.println("Rectángulos");
		salida.println(this.rectangulos);
		salida.println("Cuadrados");
		salida.println(this.cuadrados);

		salida.close();
	}

	// Escritura en archivo paralelos.out de segmentos paralelos a un eje y
	// triangulos con lados paralelos a algun eje.

	public void escribirParalelos() throws Exception {

		ArrayList<Segmento> segmentosParalelos = new ArrayList<Segmento>();
		ArrayList<Triangulo> triangulosParalelos = new ArrayList<Triangulo>();

		for (Segmento a : this.segmentos) {
			if (a.paraleloEjeY() || a.paraleloEjeX())
				segmentosParalelos.add(a);
		}

		for (Triangulo a : this.triangulos2) {
			if (a.esParaleloAUnEje())
				triangulosParalelos.add(a);
		}

		FileWriter arch = new FileWriter(new File("src/archivosFiguras/paralelos.out"));
		PrintWriter salida = new PrintWriter(arch);

		salida.println("Segmentos paralelos a alguno de los ejes: ");
		salida.println(segmentosParalelos);
		salida.println("Triangulos con algun lado paralelo a un eje: ");
		salida.println(triangulosParalelos);

		salida.close();
	}

	// Escritura de la/s figura/s de mayor tamaño por area y segmento/s más largo/s.

	public void escribirGrandotes(LinkedList<Figura> a) throws Exception {

		ArrayList<Figura> figurasGrandes = new ArrayList<Figura>();
		ArrayList<Segmento> segmentosLargos = new ArrayList<Segmento>();

		int flag = 0;
		int flag2 = 0;

		if (!a.isEmpty()) { //Se comprueba que la lista no esté vacia.
			for (Figura f : a) {

				if (flag == 0) {
					figurasGrandes.add(f);
					flag = 1;
				} else if (f.calcularArea() > figurasGrandes.get(0).calcularArea()) {
					figurasGrandes.clear();
					figurasGrandes.add(f);
				} else if (f.calcularArea() == figurasGrandes.get(0).calcularArea()) {
					figurasGrandes.add(f);
				}
			}
		}
		for (Segmento s : this.segmentos) {

			if (flag2 == 0) {
				segmentosLargos.add(s);
				flag2 = 1;
			} else if (s.longitudSegmento() > segmentosLargos.get(0).longitudSegmento()) {
				segmentosLargos.clear();
				segmentosLargos.add(s);
			} else if (s.longitudSegmento() == segmentosLargos.get(0).longitudSegmento()) {
				segmentosLargos.add(s);
			}
		}

		FileWriter arch = new FileWriter(new File("src/archivosFiguras/grandotes.out"));
		PrintWriter salida = new PrintWriter(arch);

		salida.println("Figura/s más grande/s");
		salida.println(figurasGrandes);
		salida.println("Segmento/s más largo/s");
		salida.print(segmentosLargos);

		salida.close();
	}

	// Metodo en el cual se ordenan las figuras usando una clase en la que se aplica
	// comparator.

	public LinkedList<Figura> ordenarFiguras(LinkedList<Figura> x) {

		Collections.sort(x, new OrdenarFiguras());

		return x;
	}
}
