package mx.unam.ciencias.edd.proyecto2;

public enum Estructuras {
	LISTA, PILA, COLA, COMPLETO, ORDENADO, ROJI, AVL, GRAFICA, NADA;

	public static Estructuras asignar(String s) {
		switch (s) {
			case "Lista":
				return LISTA;

			case "Pila":
				return PILA;

			case "Cola":
				return COLA;

			case "ArbolBinarioCompleto":
				return COMPLETO;

			case "ArbolBinarioOrdenado":
				return ORDENADO;

			case "ArbolRojinegro":
				return ROJI;

			case "ArbolAVL":
				return AVL;

			case "Grafica":
				return GRAFICA;

			default:
				return NADA;
		}
	}
}