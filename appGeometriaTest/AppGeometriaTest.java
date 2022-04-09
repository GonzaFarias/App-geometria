package appGeometriaTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import appGeometria.Circulo;
import appGeometria.Cuadrado;
import appGeometria.Elipse;
import appGeometria.Figura;
import appGeometria.Punto;
import appGeometria.Rectangulo;
import appGeometria.Segmento;
import appGeometria.Triangulo;
import appGeometria.UsoArchivos;

public class AppGeometriaTest {

	private LinkedList<Figura> a;
	private UsoArchivos b;

	@Before
	public void obtenerFiguras() throws Exception {
		a = new LinkedList<Figura>();
		b = new UsoArchivos();
		a = b.leerArchivo("src/archivosFiguras/input.in");
	}

	@Test
	public void creoListaFigurasTest() {
		assertNotNull(a);
	}

	@Test
	public void escribirFigurasTest() throws IOException {
		b.escribirFiguras();
	}

	@Test
	public void escribirGrandotesTest() throws Exception {

		b.escribirGrandotes(a);
	}

	@Test
	public void escribirParalelosTest() throws Exception {

		b.escribirParalelos();
	}

	@Test
	public void cuadradoTest() {

		Cuadrado cuadrado = new Cuadrado(2.0, new Punto(1.0, 2.1));

		double obtener = 4.00;
		double obtenido = cuadrado.calcularArea();

		assertEquals(obtener, obtenido, 000.1);

		cuadrado.desplazarFiguraAmbosEjes(2.0);

		double obtenidoX = 3;
		double obtenidoY = 4.1;

		assertEquals(cuadrado.getPunto().getY(), obtenidoY, 0.001);
		assertEquals(cuadrado.getPunto().getX(), obtenidoX, 0.001);

		cuadrado.desplazarFiguraEnX(4.0);
		obtenidoX = 7;

		assertEquals(cuadrado.getPunto().getX(), obtenidoX, 0.001);

		cuadrado.desplazarFiguraEnY(2.0);
		obtenidoY = 6.1;

		assertEquals(cuadrado.getPunto().getY(), obtenidoY, 0.001);

		cuadrado.desplazarPuntoCuadrado(new Punto(4.0, 5.0));
		obtenidoX = 4.0;
		obtenidoY = 5.0;

		assertEquals(cuadrado.getPunto().getY(), obtenidoY, 0.001);
		assertEquals(cuadrado.getPunto().getX(), obtenidoX, 0.001);

	}

	@Test(expected = Exception.class)
	public void creoCuadradoLadoNegativoTest() {
		@SuppressWarnings("unused")
		Cuadrado cuadrado = new Cuadrado(-5, new Punto(5, 5));
	}

	@Test
	public void trianguloTest() throws Exception {

		Triangulo triangulo = new Triangulo(new Punto(4.0, 3.0), new Punto(2.0, 5.0), new Punto(3.0, 2.0));

		triangulo.calcularArea();

		Segmento seg1 = new Segmento(triangulo.getVertice1(), triangulo.getVertice2());
		Segmento seg2 = new Segmento(triangulo.getVertice2(), triangulo.getVertice3());

		double obtenidoArea = seg1.longitudSegmento() * seg2.longitudSegmento() / 2;

		assertEquals(obtenidoArea, triangulo.calcularArea(), 0.001);

		triangulo.desplazarPuntoA(new Punto(5.0, 4.0));
		assertEquals(triangulo.getVertice1().getX(), 5.0, 0.001);
		assertEquals(triangulo.getVertice1().getY(), 4.0, 0.001);

		triangulo.desplazarPuntoB(new Punto(3.1, 5.2));
		assertEquals(triangulo.getVertice2().getX(), 3.1, 0.001);
		assertEquals(triangulo.getVertice2().getY(), 5.2, 0.001);

		triangulo.desplazarPuntoC(new Punto(8.0, 9.0));
		assertEquals(triangulo.getVertice3().getX(), 8.0, 0.001);
		assertEquals(triangulo.getVertice3().getY(), 9.0, 0.001);

		triangulo.desplazarFiguraEnX(-1.0);
		double obtenidoX1 = 4.0;
		double obtenidoX2 = 2.1;
		double obtenidoX3 = 7.0;

		assertEquals(triangulo.getVertice1().getX(), obtenidoX1, 0.001);
		assertEquals(triangulo.getVertice2().getX(), obtenidoX2, 0.001);
		assertEquals(triangulo.getVertice3().getX(), obtenidoX3, 0.001);

		triangulo.desplazarFiguraEnY(-1.0);
		double obtenidoY1 = 3.0;
		double obtenidoY2 = 4.2;
		double obtenidoY3 = 8.0;

		assertEquals(triangulo.getVertice1().getY(), obtenidoY1, 0.001);
		assertEquals(triangulo.getVertice2().getY(), obtenidoY2, 0.001);
		assertEquals(triangulo.getVertice3().getY(), obtenidoY3, 0.001);

		triangulo.desplazarFiguraAmbosEjes(6.0);
		obtenidoX1 = 10.0;
		obtenidoX2 = 8.1;
		obtenidoX3 = 13.0;
		obtenidoY1 = 9.0;
		obtenidoY2 = 10.2;
		obtenidoY3 = 14.0;

		assertEquals(triangulo.getVertice1().getX(), obtenidoX1, 0.001);
		assertEquals(triangulo.getVertice2().getX(), obtenidoX2, 0.001);
		assertEquals(triangulo.getVertice3().getX(), obtenidoX3, 0.001);
		assertEquals(triangulo.getVertice1().getY(), obtenidoY1, 0.001);
		assertEquals(triangulo.getVertice2().getY(), obtenidoY2, 0.001);
		assertEquals(triangulo.getVertice3().getY(), obtenidoY3, 0.001);

		Triangulo t = new Triangulo(new Punto(2.0, 8.0), new Punto(2.0, 9.0), new Punto(10.0, 5.0));

		assertTrue(t.esParaleloAUnEje());

	}

	@Test(expected = Exception.class)
	public void creoTrianguloPuntosIgualesTest() throws Exception {
		@SuppressWarnings("unused")
		Triangulo triangulo = new Triangulo(new Punto(4.0, 3.0), new Punto(4.0, 3.0), new Punto(3.0, 2.0));
	}

	@Test
	public void circuloTest() {
		Circulo circulo = new Circulo(2.0, new Punto(3.0, 1.3));

		circulo.calcularArea();

		double obtenido = Math.PI * (Math.pow(2.0, 2));

		assertEquals(obtenido, circulo.calcularArea(), 0.001);

		circulo.desplazarFiguraAmbosEjes(2.0);
		double obtenidoX = 5.0;
		double obtenidoY = 3.3;

		assertEquals(circulo.getCentro().getX(), obtenidoX, 0.001);
		assertEquals(circulo.getCentro().getY(), obtenidoY, 0.001);

		circulo.desplazarPuntoCirculo(new Punto(5.6, 3.1));
		obtenidoX = 5.6;
		obtenidoY = 3.1;

		assertEquals(circulo.getCentro().getX(), obtenidoX, 0.001);
		assertEquals(circulo.getCentro().getY(), obtenidoY, 0.001);

		circulo.desplazarFiguraEnX(-2.0);
		circulo.desplazarFiguraEnY(1.5);

		obtenidoX = 3.6;
		obtenidoY = 4.6;

		assertEquals(circulo.getCentro().getX(), obtenidoX, 0.001);
		assertEquals(circulo.getCentro().getY(), obtenidoY, 0.001);

	}

	@Test(expected = Exception.class)
	public void creoCirculoRadioNegativoTest() {
		@SuppressWarnings("unused")
		Circulo circulo = new Circulo(-5, new Punto(5, 5));
	}

	@Test
	public void segmentoTest() throws Exception {
		Segmento linea = new Segmento(new Punto(4.0, 5.0), new Punto(4.0, 3.0));

		double obtener = Math.sqrt((Math.pow(4.0 - 4.0, 2) + Math.pow(5.0 - 3.0, 2)));
		double obtenido = linea.longitudSegmento();

		assertEquals(obtener, obtenido, 0.001);

		assertTrue(linea.paraleloEjeY());
		assertFalse(linea.paraleloEjeX());

		assertTrue(linea.segmentosParalelos(new Segmento(new Punto(4.0, 5.0), new Punto(4.0, 3.0)),
				new Segmento(new Punto(7.0, 5.0), new Punto(7.0, 3.0))));

		linea.desplazarPuntoA(new Punto(6.0, 7.0));
		assertEquals(linea.getA().getX(), 6, 0.001);
		assertEquals(linea.getA().getY(), 7, 0.001);

		linea.desplazarPuntoB(new Punto(8.0, 9.0));
		assertEquals(linea.getB().getX(), 8, 0.001);
		assertEquals(linea.getB().getY(), 9, 0.001);

		linea.desplazarSegmentoEjeX(4.0);
		double obtenerAX = 10.0;
		double obtenerBX = 12.0;

		assertEquals(linea.getA().getX(), obtenerAX, 0.001);
		assertEquals(linea.getB().getX(), obtenerBX, 0.001);

		linea.desplazarSegmentoEjeY(2.0);
		double obtenerAY = 9.0;
		double obtenerBY = 11.0;

		assertEquals(linea.getA().getY(), obtenerAY, 0.001);
		assertEquals(linea.getB().getY(), obtenerBY, 0.001);

		linea.desplazarSegmentoAmbosEjes(-1.0);
		obtenerAX = 9.0;
		obtenerAY = 8.0;
		obtenerBX = 11.0;
		obtenerBY = 10.0;

		assertEquals(linea.getA().getY(), obtenerAY, 0.001);
		assertEquals(linea.getB().getY(), obtenerBY, 0.001);
		assertEquals(linea.getA().getX(), obtenerAX, 0.001);
		assertEquals(linea.getB().getX(), obtenerBX, 0.001);

	}

	@Test(expected = Exception.class)
	public void creoSegmentoExtremosIgualesTest() {
		@SuppressWarnings("unused")
		Segmento seg = new Segmento(new Punto(4.0, 5.0), new Punto(4.0, 5.0));
	}

	@Test

	public void rectanguloTest() throws Exception {

		Rectangulo rectangulo = new Rectangulo(new Punto(6.0, 5.0), new Punto(4.0, 7.0));

		rectangulo.calcularArea();

		double base = Math.sqrt(Math.pow(6.0 - 4.0, 2));
		double altura = Math.sqrt(Math.pow(5.0 - 7.0, 2));

		double esperado = base * altura;

		assertEquals(rectangulo.calcularArea(), esperado, 0.001);

		rectangulo.desplazarPuntoInferiorIzquierdo(new Punto(4.0, 8.0));

		double obtenidoIX = 4.0;
		double obtenidoIY = 8.0;

		assertEquals(rectangulo.getInferiorIzquierda().getX(), obtenidoIX, 0.001);
		assertEquals(rectangulo.getInferiorIzquierda().getY(), obtenidoIY, 0.001);

		rectangulo.desplazarPuntoSuperiorDerecho(new Punto(2.0, 10.0));

		double obtenidoSX = 2.0;
		double obtenidoSY = 10.0;

		assertEquals(rectangulo.getSuperiorDerecha().getX(), obtenidoSX, 0.001);
		assertEquals(rectangulo.getSuperiorDerecha().getY(), obtenidoSY, 0.001);

		rectangulo.desplazarFiguraAmbosEjes(2.0);

		obtenidoSX = 4.0;
		obtenidoSY = 12.0;
		obtenidoIX = 6.0;
		obtenidoIY = 10.0;

		assertEquals(rectangulo.getInferiorIzquierda().getX(), obtenidoIX, 0.001);
		assertEquals(rectangulo.getInferiorIzquierda().getY(), obtenidoIY, 0.001);
		assertEquals(rectangulo.getSuperiorDerecha().getX(), obtenidoSX, 0.001);
		assertEquals(rectangulo.getSuperiorDerecha().getY(), obtenidoSY, 0.001);

		rectangulo.desplazarFiguraEnX(-1.0);

		obtenidoSX = 3.0;
		obtenidoIX = 5.0;

		assertEquals(rectangulo.getSuperiorDerecha().getX(), obtenidoSX, 0.001);
		assertEquals(rectangulo.getInferiorIzquierda().getX(), obtenidoIX, 0.001);

		rectangulo.desplazarFiguraEnY(-1.0);

		obtenidoSY = 11.0;
		obtenidoIY = 9.0;

		assertEquals(rectangulo.getSuperiorDerecha().getY(), obtenidoSY, 0.001);
		assertEquals(rectangulo.getInferiorIzquierda().getY(), obtenidoIY, 0.001);
	}

	@Test(expected = Exception.class)
	public void creoRectanguloPuntosIgualesTest() throws Exception {
		@SuppressWarnings("unused")
		Rectangulo rectangulo = new Rectangulo(new Punto(5.0, 5.0), new Punto(5.0, 5.0));
	}

	@Test
	public void creoElipseTest() {

		Elipse e = new Elipse(5, 8, new Punto(2, 9));

		double obtenido = e.calcularArea();

		double esperado = 125.663;

		assertEquals(obtenido, esperado, 0.001);

		e.desplazarFiguraAmbosEjes(2.0);
		double esperadoX = 4.0;
		double esperadoY = 11.0;

		assertEquals(e.getPunto().getX(), esperadoX, 0.001);
		assertEquals(e.getPunto().getY(), esperadoY, 0.001);

		e.desplazarPuntoElipse(new Punto(5.6, 3.1));

		esperadoX = 5.6;
		esperadoY = 3.1;

		assertEquals(e.getPunto().getX(), esperadoX, 0.001);
		assertEquals(e.getPunto().getY(), esperadoY, 0.001);

		e.desplazarFiguraEnX(-2.0);
		e.desplazarFiguraEnY(1.5);

		esperadoX = 3.6;
		esperadoY = 4.6;

		assertEquals(esperadoX, e.getPunto().getX(), 0.001);
		assertEquals(esperadoY, e.getPunto().getY(), 0.001);

	}

}
