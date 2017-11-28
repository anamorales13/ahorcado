
package ahorcado;

import static ahorcado.Jugador.jugadores;
import java.util.Scanner;


public class Jugador {
    
    public static String jugadores[]= new String[2];
    public static int puntos[]= new int[2];
    public static int turno=0;
    public static String palabraElegida;
    public static String palabraUsuario;
    
    

public String getPalabraElegida(){ return palabraElegida;}
public int[] getPuntos(){return puntos;}
public void setPuntos(int pun,int turno){puntos[turno]=pun;}
public String getPalabraUsuario(){return palabraUsuario;}
public void setTurno(int t){turno=t;}
public String[] getJugadores(){ return jugadores;}
public void setPalabraElegida(String n){palabraElegida=n;}



    
public static void pedirNombre(){
        Scanner sn = new Scanner(System.in);
        for(int i=0; i<jugadores.length;i++){
        System.out.println("Introduce el nombre del jugador "+ (i+1));
            jugadores[i]=sn.next();
        }
    }

public static void pedirPalabra(){
    Scanner sn = new Scanner (System.in);
    System.out.println("***************************");
    System.out.println("Introduce una palabra: "+ jugadores[turno]);
    palabraElegida=sn.next();
}

public static void pedirLetra(){
    Scanner sn = new Scanner (System.in);
    System.out.println("");
    System.out.println("Escribe una letra, (Escribe solucion si la sabes)");
    palabraUsuario=sn.next();
    
}




}