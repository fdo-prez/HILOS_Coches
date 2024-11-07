/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author totit
 */
public class Sorteo {
    
    //Con el método que recibe un hilo, cambiaremos su preferencia con un numero aleatorio entre 1 y 10
    
    public static void sorteo(Thread thread){
    
    int Preferencia= (int)(Math.random() * 10) + 1;   
        
    thread.setPriority(Preferencia);
    
        
    }
    
}
