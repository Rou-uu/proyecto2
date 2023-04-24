
package mx.unam.ciencias.edd.proyecto2;
import mx.unam.ciencias.edd.*;

public class SVGCreator {

	static SVGShorts wa = new SVGShorts();

	public SVGCreator() {}

	public static String aboToSVG(Lista<Integer> elems) {
		ArbolBinarioOrdenado<Integer> arbol = new ArbolBinarioOrdenado<Integer>(elems);
		return "";
	}

	public static String abcToSVG(Lista<Integer> elems) {
		ArbolBinarioCompleto<Integer> arbol = new ArbolBinarioCompleto<Integer>(elems);
		return "";

	}

	public static String abrToSVG(Lista<Integer> elems) {
		ArbolRojinegro<Integer> arbol = new ArbolRojinegro<Integer>(elems);
		return "";

	}

	public static String avlToSVG(Lista<Integer> elems) {
		ArbolAVL<Integer> arbol = new ArbolAVL<Integer>(elems);
		return "";
	}

	public static String listaToSVG(Lista<Integer> elems) {
		IteradorLista<Integer> i = (IteradorLista<Integer>) elems.iteradorLista();
		int a = elems.getElementos();
		String s = "";

		s += wa.startSVG(90 * a + 60, 40);
		int x = 10;

		while (i.hasNext()) {
			Integer elem = i.next();
			s += wa.drawRectangle(x, 10, 50, 20, "black", elem);
			if (i.hasNext())
				s += wa.drawListaArrow(x + 60, 20, x + 70, 20);
			x += 80;
		}

		s += wa.finishSVG();
		System.out.println(s);
		return s;
	}

	public static String colaToSVG(Lista<Integer> elems) {
		Cola<Integer> cola = new Cola<>();
		IteradorLista<Integer> i = (IteradorLista<Integer>) elems.iteradorLista();
		int a = 0;
		String s = "";

		while (i.hasNext()) {
			cola.mete(i.next());
			a++;
		} s += wa.startSVG(80 * a + 50, 40);

		int x = 10;

		while(!cola.esVacia()) {
			Integer elem = cola.saca();
			s += wa.drawRectangle(x, 10, 50, 20, "black", elem);
			s += wa.drawColaArrow(x + 50, 20, x + 70, 20);
			x += 80;
		}

		s += wa.finishSVG();
		System.out.println(s);
		return s;
	}

	public static String pilaToSVG(Lista<Integer> elems) {
		Pila<Integer> pila = new Pila<>();
		IteradorLista<Integer> i = (IteradorLista<Integer>) elems.iteradorLista();
		int a = 0;
		String s = "";

		while (i.hasNext()) {
			pila.mete(i.next());
			a++;
		} s += wa.startSVG(70, 50 * a + 30);

		int x = 10;

		while (!pila.esVacia()) {
			Integer elem = pila.saca();
			s += wa.drawRectangle(10, x, 50, 20, "black", elem);
			s += wa.drawPilaArrow(35, x + 20, 35, x + 40);
			x += 50;

		}

		s += wa.finishSVG();
		System.out.println(s);
		return s;
	}

	public static String graphToSVG(Lista<Integer> elems, Grafica<Integer> graph) {
		return "";
	}
}