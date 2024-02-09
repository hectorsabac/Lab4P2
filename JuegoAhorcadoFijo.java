package AhorcadosJuego;

import javax.swing.JOptionPane;


public class JuegoAhorcadoFijo extends JuegoAhorcadoBase {
    
    public JuegoAhorcadoFijo(String palabrasecreta) {
        this.palabraSecreta = palabrasecreta.toUpperCase();
        inicializarPalabraSecreta();
        intentos = 6;
    }
    
    @Override
    public void actualizarPalabraActual(char letra) {
        char[] palabraAReemplazar = palabraActual.toCharArray();
        
        if (verificarLetra(letra)) {
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra) {
                    palabraAReemplazar[i] = letra;
                }
            }
            
            palabraActual = new String(palabraAReemplazar);
        } else {
            intentos--;
        }
    }
    
    @Override
    public boolean verificarLetra(char letra) {
        
        for (char letraverificar : palabraSecreta.toCharArray()) {
            if (letraverificar == letra) {
                return true;
            }
        }
        
        return false;
    }
    
    @Override
    public void inicializarPalabraSecreta() {
        palabraActual = "";
        
        for (int i = 0; i < palabraSecreta.length(); i++) {
            palabraActual += "_";
        }
    }
    
    @Override
    public boolean hasGanado() {
        
        return palabraActual.equalsIgnoreCase(palabraSecreta);
        
    }
    
    @Override
    public void jugar() {
        while (intentos > 0) {
            StringBuilder palabraVacia = new StringBuilder();
            
            for (int i = 0; i < palabraActual.length(); i++) {
                palabraVacia.append(palabraActual.charAt(i)).append(" ");
            }
            
            String letra_s;
            
            do {
                letra_s = JOptionPane.showInputDialog(null, "Ingrese la letra que intenta adivinar\nPista: " + palabraVacia + "\nIntentos restantes: " + intentos, "Ahorcado Fijo", JOptionPane.INFORMATION_MESSAGE);
            } while (letra_s == null || letra_s.isEmpty());
            
            letra_s = letra_s.toUpperCase();
            char letra = letra_s.charAt(0);
            actualizarPalabraActual(letra);
            
            if (hasGanado()) {
                JOptionPane.showMessageDialog(null,"Felicidades!\nHas ganado!");
                intentos = 0;
            } else if (intentos == 0) {
                JOptionPane.showMessageDialog(null,"Perdiste :(");
            }
        }
    }
}
