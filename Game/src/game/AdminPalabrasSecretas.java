package Game;

import java.util.ArrayList;

public class AdminPalabrasSecretas {
    static ArrayList<String> palabrasSecretas;
    
     public static void agregarPalabra(String palabraSecreta) {
        palabrasSecretas.add(palabraSecreta);
    }
    
    public static ArrayList getpalabrasSecretas(){
        return palabrasSecretas;
    }
    
    public AdminPalabrasSecretas(){
        palabrasSecretas=new ArrayList<>();
        palabrasSecretas.add("PAYASO");
        palabrasSecretas.add("MORTAL");
        palabrasSecretas.add("CALLE");
        palabrasSecretas.add("ALIEN");
        palabrasSecretas.add("OSCURIDAD");
    }

   
}
