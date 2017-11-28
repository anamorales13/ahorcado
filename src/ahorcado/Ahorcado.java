
package ahorcado;

import static ahorcado.Jugador.jugadores;
import java.util.Scanner;


public class Ahorcado {
    
       final static int puntuacion=5;
       public static String palabra;
       //final static int numeroErrores=6;
   
    public static void main(String[] args) {

        //Scanner sn = new Scanner(System.in);
        Jugador j= new Jugador();
        char abecedario[]=generarLetras();
        boolean letrasRepetida[]= new boolean[26];
        int turno=0;
        int numeroErrores=6;
        int puntos=0;
        int numeroRemplazos=0;
        
        
        j.pedirNombre();
        
        
        
       while(!finPartida(j.getPuntos(),puntuacion)){
           j.pedirPalabra();
           
           for(int i=0; i<10; i++){
               System.out.println("");
           }
           
          //palabra con guiones:
          palabra=secreto(j.getPalabraElegida());
          
         while(!PalabraCorrecta(j.getPalabraElegida(),palabra)&& numeroErrores>0){
             
           Mostrar(palabra);
           MostrarLetrasRepetidas(abecedario,letrasRepetida);
           
           j.pedirLetra();
         //  if(j.getPalabraUsuario().length()==1){
               if(Character.isAlphabetic(j.getPalabraUsuario().charAt(0))){
           
            if(caracterIntroducido(letrasRepetida,j.getPalabraUsuario().charAt(0))){
              System.out.println("El caracter ya esta introducido");
            }      
            else if(numremplazos(j.getPalabraElegida(),j.getPalabraUsuario().charAt(0))>0){
              palabra=remplazos(j.getPalabraElegida(),palabra, j.getPalabraUsuario().charAt(0));
            }
            else{
              numeroErrores--;
              System.out.println("Te quedan: "+ numeroErrores+ " intentos");
          }
      //   }  
          actualizarInsertados(letrasRepetida,j.getPalabraUsuario().charAt(0));
            }
       // }//else if(!PalabraCorrecta(j.getPalabraElegida(),j.getPalabraUsuario())){
          // numeroErrores--;
          //     System.out.println("Error, no es la palabra correcta");
      // }
         
      } 
        
         if(numeroErrores>0){            
         j.setPuntos(++puntos,turno);   
         }
         
         mostrarPuntuacion(j.getJugadores(), j.getPuntos());
         turno=cambiarTurno(turno,jugadores.length-1);
         numeroErrores=6;
       
       
        
         j.setTurno(turno);
    }
      
    }
    
    public static char[] generarLetras(){
        char[] caracteres=new char[26];
       // for(int i=0,j=97; i<caracteres.length; i++,j++){
      for(int i=0; i<26; i++){
       caracteres[i]=(char)('a'+i);
            
        }
        return caracteres;
    }
    
    //PARA VER SI CONTINUAMOS O NO LA PARTIDA.
    
    public static boolean finPartida(int puntos[], int puntuacion){
        for(int i=0;i<puntos.length; i++){
            if(puntos[i]>=puntuacion){
                return true;
            }
        }
        return false;
    }
               
    public static String secreto(String cadena){
        String palabra="";
        for(int i=0;i<cadena.length(); i++){
          //  System.out.println("*");
          palabra+="*";
        }
        return palabra;
    }
    
    public static void Mostrar(String cadena){
        
        for(int i=0;i<cadena.length(); i++){
           System.out.print(cadena.charAt(i)+ " ");
           
        }
        System.out.println("");
    }
    
    public static void MostrarLetrasRepetidas(char[] ab,boolean letras[]){
        System.out.println(" --- REPETIDAS ---");
        for(int i=0; i<letras.length; i++){
            if(letras[i]){
                System.out.print(ab[i]);
                System.out.print(" ");
            }
        }
        System.out.println("");
    }
    
    
    //palabra: palabraElegida
    //juego: palabra escrita por el usuario.
    public static boolean PalabraCorrecta(String palabra, String juego ){
        
        return palabra.equals(juego);
        
    }
    
    
    public static int numremplazos(String p, char caracter){
        int remplazos=0;
        char ca;
        for(int i=0; i<p.length(); i++){
            ca=p.charAt(i);
            
            if(ca==caracter){
            remplazos++;
             }
        }
       return remplazos; 
    }
    
    
    
     public static String remplazos(String original, String r, char caracter){
       String cadenaRemplazo="";
        char ca;
        for(int i=0; i<original.length(); i++){
            ca=original.charAt(i);
            
            if(ca==caracter){
            cadenaRemplazo+=caracter;
             }
            else{
                cadenaRemplazo+=r.charAt(i);
            }
        }
       return cadenaRemplazo; 
    }
     
     public static boolean caracterIntroducido(boolean[] insertados,char caracter){
         return insertados[caracter-'a'];
     }
    
     public static void actualizarInsertados(boolean[] insertados, char caracter){
          insertados[caracter-'a']=true;
     }
    
     public static int cambiarTurno(int turnoActual, int turno){
         if(turnoActual==turno){
             return 0;
         }else{
             return ++turnoActual;
         }
     }

public static void mostrarPuntuacion(String[]jugadores, int[] puntos){
    for(int i=0; i<jugadores.length; i++){
        System.out.print(jugadores[i]+ ":  "+ puntos[i]+ " puntos ");
    }
    System.out.println("");
}



}
