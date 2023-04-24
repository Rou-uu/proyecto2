
package mx.unam.ciencias.edd.proyecto2;
import mx.unam.ciencias.edd.*;

public class SVGCreator {

	static SVGShorts wa = new SVGShorts();

	public SVGCreator() {}

	public static String arbolToSVG(Lista<Integer> elems, Estructuras e) {

		ArbolBinario<Integer> arbol = null;
		boolean isAVL = false;
		
		switch (e) {
			case ROJI:
				arbol = new ArbolRojinegro<Integer>(elems);
				break;

			case COMPLETO:
				arbol = new ArbolBinarioCompleto<Integer>(elems);
				break;

			case ORDENADO:
				arbol = new ArbolBinarioOrdenado<Integer>(elems);
				break;

			case AVL:
				arbol = new ArbolAVL<Integer>(elems);
				isAVL = true;
				break;
		}


		String s = "";
		int profundidad = arbol.altura();
		int h = 100 + profundidad * 100;
		int w = (int) (Math.pow(2, profundidad) * 50); //50 es el diametro de los vertices para el arbol

		if (e == Estructuras.ORDENADO) {
			w = arbol.getElementos() * 200 + 100;
			s += wa.startSVG(w * 2, h + 100);
		}

		else 
			s += wa.startSVG(w  + 100, h);

		if (!arbol.esVacia()) {
			s += drawAllLines(arbol.raiz(), (w/2) / 2, w/2, 50);
			s += drawAllVertices(arbol.raiz(), (w/2) / 2, w/2, 50, e);
		}

		s += wa.finishSVG();

		System.out.println(s);

		return s;
	}

	private static String drawAllVertices(VerticeArbolBinario v, double coord, double padreCoord, double y , Estructuras e) {
		String s = "";

		if (v != null) {
			String bna = getBalanceDeAVL(v.toString(), e);
			s += wa.drawVerticeArbol(padreCoord, y, (double) 25, v.get().toString(), colorchis(v, e), bna != null, bna);

			if (v.hayIzquierdo() && v.hayDerecho()) {
				s += drawAllVertices(v.izquierdo(), coord / 2, padreCoord - coord, y + 100, e);
				s += drawAllVertices(v.derecho(), coord / 2, padreCoord + coord, y + 100, e);
			}

			else if (v.hayIzquierdo())
				s += drawAllVertices(v.izquierdo(), coord / 2, padreCoord - coord, y + 100, e);

			else if (v.hayDerecho())
				s += drawAllVertices(v.derecho(), coord / 2, padreCoord + coord, y + 100, e);
		}

		return s;

	}

	private static String drawAllLines(VerticeArbolBinario v, double coord, double padreCoord, double y) {
		String s = "";

		if (v != null) {
			if (v.hayIzquierdo() && v.hayDerecho()) {
				s += wa.drawLine((int) padreCoord, (int) y, (int) (padreCoord - coord), (int) y + 100);
				s += wa.drawLine( (int)padreCoord, (int) y, (int) (padreCoord + coord), (int) y + 100);
				s += drawAllLines(v.izquierdo(), coord/2, padreCoord - coord, y + 100);
				s += drawAllLines(v.derecho(), coord/2, padreCoord + coord, y + 100);
			}

			else if (v.hayIzquierdo()) {
				s += wa.drawLine((int) padreCoord, (int) y, (int) (padreCoord - coord), (int) y + 100);
				s += drawAllLines(v.izquierdo(), coord/2, padreCoord - coord, y + 100);
			}

			else if (v.hayDerecho()) {
				s += wa.drawLine((int) padreCoord, (int) y, (int) (padreCoord + coord), (int) y + 100);
				s += drawAllLines(v.derecho(), coord/2, padreCoord + coord, y + 100);
			}
		}

		return s;
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

	private static String getBalanceDeAVL(String s, Estructuras e) {
		String r = null;

		if (e == Estructuras.AVL) {
			String aux = "";

			for (int i = s.length() - 1; i >= 0; i--) {
				if (s.charAt(i) == ' ') 
					break;
				else
					aux = s.charAt(i) + aux;
			}

			r = aux;
		}

		return r;
	}

	private static String colorchis(VerticeArbolBinario v, Estructuras e) {
		String color = "white";

		if (e == Estructuras.ROJI) {
			if (v.toString().substring(0, 1).equals("N"))
				color = "black";
			else if (v.toString().substring(0, 1).equals("R"))
				color = "red";
		}


		return color;
	}
}