package AhorcadosJuego;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

public class JuegoAhorcadoAzar extends JuegoAhorcadoBase {

    ArrayList<String> palabrasPosibles = new ArrayList<>();
    
    public JuegoAhorcadoAzar(ArrayList<String> palabrasSecretas) {
        palabrasPosibles = palabrasSecretas;
        seleccionarPalabraAzar();
        inicializarPalabraSecreta();
        intentos = 6;
    }

    private void seleccionarPalabraAzar() {
        Random r = new Random();
        int indice = r.nextInt(palabrasPosibles.size());
        palabraSecreta = palabrasPosibles.get(indice).toUpperCase();
    }

    public void actualizarPalabraActual(char letra) {
        char[] palabraReemplazar = palabraActual.toCharArray();
        if (verificarLetra(letra)) {
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra) {
                    palabraReemplazar[i] = letra;
                }
            }
            palabraActual = new String(palabraReemplazar);
        } else {
            intentos -= 1;
        }
    }

    public boolean verificarLetra(char letra) {
        for (char letraverificar : palabraSecreta.toCharArray()) {
            if (letraverificar == letra) {
                return true;
            }
        }
        return false;
    }

    public void inicializarPalabraSecreta() {
        palabraActual = "";
        for (int i = 0; i < palabraSecreta.length(); i++) {
            palabraActual += "_";
        }
    }

    public boolean hasGanado() {
        return palabraActual.equals(palabraSecreta);
    }

    public void jugar() {
        while (intentos > 0) {
            StringBuilder palabradeshebrada = new StringBuilder();
            for (int i = 0; i < palabraActual.length(); i++) {
                palabradeshebrada.append(palabraActual.charAt(i)).append(" ");
            }
            String prueba;
            do {
                prueba = JOptionPane.showInputDialog(null, "Ingrese una letra\nPista: " + palabradeshebrada + "\nIntentos restantes: " + intentos, "Ahorcado Azar", JOptionPane.INFORMATION_MESSAGE);
            } while (prueba == null || prueba.isEmpty());
            prueba = prueba.toUpperCase();
            char letra = prueba.charAt(0);
            actualizarPalabraActual(letra);
            if (hasGanado() && intentos > 0) {
                JOptionPane.showMessageDialog(null, "Victoria!");
                intentos = 0;
            } else if (intentos == 0) {
                JOptionPane.showMessageDialog(null, "Perdio");
            }
        }
    }
}
