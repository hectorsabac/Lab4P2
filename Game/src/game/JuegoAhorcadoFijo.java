package AhorcadosJuego;

import javax.swing.JOptionPane;


public class JuegoAhorcadoFijo extends JuegoAhorcadoBase {
    
    public JuegoAhorcadoFijo(String palabrasecreta) {
        this.palabrasecreta = palabrasecreta.toUpperCase();
        inicializarPalabraSecreta();
        intentos = 6;
    }
    
    public void actualizarPalabraActual(char letra) {
        char[] palabrareemplazar = palabraactual.toCharArray();
        if (verificarLetra(letra)) {
            for (int i = 0; i < palabrasecreta.length(); i++) {
                if (palabrasecreta.charAt(i) == letra) {
                    palabrareemplazar[i] = letra;
                }
            }
            palabraactual = new String(palabrareemplazar);
        } else {
            intentos--;
        }
    }
    
    public boolean verificarLetra(char letra) {
        for (char letraverificar : palabrasecreta.toCharArray()) {
            if (letraverificar == letra) {
                return true;
            }
        }
        return false;
    }
    
    public void inicializarPalabraSecreta() {
        palabraactual = "";
        for (int i = 0; i < palabrasecreta.length(); i++) {
            palabraactual += "_";
        }
    }
    
    public boolean hasGanado() {
        return palabraactual.equalsIgnoreCase(palabrasecreta);
    }
    
    public void jugar() {
        while (intentos > 0) {
            StringBuilder palabraMutilada = new StringBuilder();
            for (int i = 0; i < palabraactual.length(); i++) {
                palabraMutilada.append(palabraactual.charAt(i)).append(" ");
            }
            String prueba;
            do {
                prueba = JOptionPane.showInputDialog(null, "Ingrese la letra que intenta adivinar\nPista: " + palabraMutilada + "\nIntentos restantes: " + intentos, "Ahorcado Fijo", JOptionPane.INFORMATION_MESSAGE);
            } while (prueba == null || prueba.isEmpty());
            prueba = prueba.toUpperCase();
            char letra = prueba.charAt(0);
            actualizarPalabraActual(letra);
            if (hasGanado()) {
                JOptionPane.showMessageDialog(null,"Victoria!");
                intentos = 0;
            } else if (intentos == 0) {
                JOptionPane.showMessageDialog(null,"Perdio");
            }
        }
    }
}
