import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String palabraSecreta = "inteligente";
        int maximo = 3;
        int intentos = 0;
        boolean adivinada = false;

        char[] letrasAdivinadas = new char[palabraSecreta.length()];

        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
        }
        System.out.println(letrasAdivinadas);

        while (!adivinada && intentos < maximo) {
            System.out.println("Palabra: " + String.valueOf(letrasAdivinadas) + " " +
            palabraSecreta.length() + " letras");
            System.out.println("Introduce letra: ");
            char letra = Character.toLowerCase(scanner.next().charAt(0));

            boolean letraCorrecta = false;

            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra) {
                    letraCorrecta = true;
                    letrasAdivinadas[i] = letra;
                }
            }
            if (!letraCorrecta) {
                intentos++;
                System.out.println("Incorrecta. Te quedan " + (maximo - intentos) + " intentos");
            }
            if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
                adivinada = true;
                System.out.println("Lo hiciste! Palabra secreta: " + palabraSecreta);
            }
        }
        if (!adivinada) {
            System.out.println("Sin más intentos disponibles... Game Over");
        }
        scanner.close();
    }
}