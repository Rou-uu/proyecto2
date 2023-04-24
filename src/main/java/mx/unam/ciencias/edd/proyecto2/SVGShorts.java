
package mx.unam.ciencias.edd.proyecto2;
import mx.unam.ciencias.edd.*;

public class SVGShorts {

	public SVGShorts() {}

	public static String startSVG(int w, int h) {
		return "<svg width='" + w + "' height='" + h + "'>\n<g>\n";
	}

	public static String drawCircle(int cx, int cy, int r, String strokeColor, String fillColor, Integer element) {
		String s = "";
		s += "<circle cx='" + cx + "' cy='" + cy + "' r='" + r + "' stroke='" + strokeColor + "' strocke-width='3' fill='" + fillColor + "' />\n";
		s += "<text fill='black' fort-family='sans-sherif' font-size='20' x='" + (cx + 20) + "' y=" + (cy+17) + "' text-anchor='middle'>" + element + "</text>\n";
		return s;
	}

	public static String drawRectangle(int cx, int cy, int w, int h, String strokeColor, Integer element) {
		String s = "";
		s += "<rect x='" + cx + "' y='" + cy + "' width='" + w + "' height='" + h +"' fill='none' stroke-width='3' stroke='black' />\n";
		s += "<text fill='black' fort-family='sans-sherif' font-size='20' x='" + (cx + 25) + "' y='" + (cy + 17) + "' text-anchor='middle'>" + element + "</text>\n";
		return s;
	}

	public static String drawLine(int x, int y, int x2, int y2) {
		String s = "";
		return s += "<line x1='" + x + "' y1='" + y + "' x2='" + x2 + "' y2='" + y2 + "' stroke='black' stroke-width='3' />\n";
	}

	public static String drawListaArrow(int x, int y, int x2, int y2) {
		String s = "";
		s += drawLine(x, y, x2, y2);

		s += drawLine(x, y, x, y-5);
		s += drawLine(x, y-5, x-10, y);
		s += drawLine(x-10, y, x, y+5);
		s += drawLine(x, y+5, x, y);

		s += drawLine(x2, y2, x2, y2-5);
		s += drawLine(x2, y2-5, x2+10, y2);
		s += drawLine(x2+10, y2, x2, y2+5);
		s += drawLine(x2, y2+5, x2, y2);
		return s;
	}

	public static String drawColaArrow(int x, int y, int x2, int y2) {
		String s = "";
		s += drawLine(x, y, x2, y2);
		s += drawLine(x2, y2, x2, y2-5);
		s += drawLine(x2, y2-5, x2+10, y2);
		s += drawLine(x2+10, y2, x2, y2+5);
		s += drawLine(x2, y2+5, x2, y2);
		return s;
	}

	public static String drawPilaArrow(int x, int y, int x2, int y2) {
		String s = "";
		s += drawLine(x, y, x2, y2);
		s += drawLine(x2, y2, x2-5, y2);
		s += drawLine(x2-5, y2, x2, y2 + 10);
		s += drawLine(x2, y2+10, x2 + 5, y2);
		s += drawLine(x2 + 5, y2, x2, y2);
		return s;
	}

	public String drawVerticeArbol(double x, double y, double radius,String text, String vertexColor, boolean isAVL, String balanceHeight) {
        String circulo = "<circle " + "cx='"+ x + "' cy='" + y + "' r='" + radius + "' fill='" + vertexColor + "' stroke='black' stroke-width='3'/>\n";

        String textColor = vertexColor.equals("white") ? "black" : "white";

        String texto = "<text x='" + x + "' y='" + (y + 4) + "' fill='" + textColor + "' font-family='sans-sherif' font-size='16' text-anchor='middle'>" + text + "</text>\n";

        String balanceAVL = "<text " + "x='" + (x+35) + "' y='" + (y-15) + "' fill='blue' font-family='sans-sheriff' font-size='12' text-anchor='middle'>" + balanceHeight + "</text>\n";

        return circulo + texto + (isAVL ? balanceAVL : "");
    }

	public static String finishSVG() {
		String s = "";
		s += "</g>\n</svg>";
		return s;
	}
}