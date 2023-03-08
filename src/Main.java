import java.util.HashMap;
public class Main {
    public static void main(String[] args) {
        String textoPlano = "Este es un mensaje secreto";
        String textoEncriptado = encriptar(textoPlano);
        System.out.println("Texto encriptado: " + textoEncriptado);
    }

    public static String encriptar(String textoPlano) {
        // Creamos un mapa de sustitución
        HashMap<Character, Character> mapaSustitucion = new HashMap<Character, Character>();
        mapaSustitucion.put('a', 'q');
        mapaSustitucion.put('b', 'w');
        mapaSustitucion.put('c', 'e');
        mapaSustitucion.put('d', 'r');
        mapaSustitucion.put('e', 't');
        mapaSustitucion.put('f', 'y');
        mapaSustitucion.put('g', 'u');
        mapaSustitucion.put('h', 'i');
        mapaSustitucion.put('i', 'o');
        mapaSustitucion.put('j', 'p');
        mapaSustitucion.put('k', 'a');
        mapaSustitucion.put('l', 's');
        mapaSustitucion.put('m', 'd');
        mapaSustitucion.put('n', 'f');
        mapaSustitucion.put('o', 'g');
        mapaSustitucion.put('p', 'h');
        mapaSustitucion.put('q', 'j');
        mapaSustitucion.put('r', 'k');
        mapaSustitucion.put('s', 'l');
        mapaSustitucion.put('t', 'z');
        mapaSustitucion.put('u', 'x');
        mapaSustitucion.put('v', 'c');
        mapaSustitucion.put('w', 'v');
        mapaSustitucion.put('x', 'b');
        mapaSustitucion.put('y', 'n');
        mapaSustitucion.put('z', 'm');

        // Convertimos el texto a minúsculas
        textoPlano = textoPlano.toLowerCase();

        // Creamos una cadena para almacenar el texto encriptado
        StringBuilder textoEncriptado = new StringBuilder();

        // Iteramos sobre cada carácter del texto plano y lo sustituimos
        for (int i = 0; i < textoPlano.length(); i++) {
            char caracter = textoPlano.charAt(i);
            if (mapaSustitucion.containsKey(caracter)) {
                textoEncriptado.append(mapaSustitucion.get(caracter));
            } else {
                textoEncriptado.append(caracter);
            }
        }

        return textoEncriptado.toString();
    }
}