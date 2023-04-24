
package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.*;
import java.io.*;

public class Main {
	static Lista<Integer> elementos = new Lista<Integer>();
	static Estructuras e;

	public static void main(String [] args) {
		try {
			readFiles(args, args.length != 0);
		} catch (FileNotFoundException e) {
			System.out.println("No se encontro el archivo");
			System.exit(-1);
		} catch (IOException e) {}

		String s = "";
		SVGCreator wa = new SVGCreator();

		switch (e) {
			case LISTA:
				wa.listaToSVG(elementos);
				break;

			case ROJI:
				wa.abrToSVG(elementos);
				break;

			case COLA:
				wa.colaToSVG(elementos);
				break;

			case PILA:
				wa.pilaToSVG(elementos);
				break;

			case ORDENADO:
				wa.aboToSVG(elementos);
				break;

			case COMPLETO:
				wa.abcToSVG(elementos);
				break;

			case AVL:
				wa.avlToSVG(elementos);
				break;

			case GRAFICA:
		}
	}

	private static void readFiles(String[] a, boolean type)
		throws FileNotFoundException, IOException {

		BufferedReader br;
		boolean gotClass = false;

		String temp = null;
		int recorrido = 0;

		if (type)
			br = new BufferedReader(new FileReader(a[0]));
		
		else
			br = new BufferedReader(new InputStreamReader(System.in));

		String cas = "";
		while ((temp = br.readLine()) != null) {
			temp = temp.trim();

			if (!gotClass) {
				cas = getFirstWord(temp);

				if (cas.charAt(0) != '#') {
					e = Estructuras.asignar(cas);
					if (e == Estructuras.NADA) {
						System.out.println("No se encontro estructura valida, revise el archivo");
						System.exit(-1);
					}
					temp = temp.replace(cas, "");
					gotClass = true;
				}
				
			}

			if (gotClass) {
				String element = "";

				for (int x = 0; x < temp.length(); x++) {
					if (temp.charAt(x) == '#') {
						break;
					}

					else if (Character.isDigit(temp.charAt(x))) {
						element += temp.charAt(x);
					}
					
					else if (temp.charAt(x) == ' ') {
						elementos.agregaFinal(Integer.parseInt(element));
						element = "";
					}

					else {
						System.out.println("Se encontro un caracter que no es entero en el archivo de texto.");
						System.exit(-1);
					}
				}

				if (!element.equals("")) {
					elementos.agregaFinal(Integer.parseInt(element));
				}
			}
		}
	}

	private static String getFirstWord(String s) {
		int index = s.indexOf(" ");
		String firstWord = index == -1 ? s : s.substring(0, index);
		return firstWord;
	}
}