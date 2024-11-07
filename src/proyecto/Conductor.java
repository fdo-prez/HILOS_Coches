/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author totit
 */
public class Conductor implements Runnable{
   
   /*Creamos los cuatro semáforos,que representan los coches, con un solo acceso, que 
    serán los conductores que pueden acceder a la vez al coche
    */
    static Semaphore Seat= new Semaphore(1);
    static Semaphore Ford= new Semaphore(1);
    static Semaphore Bmw= new Semaphore(1);
    static Semaphore Audi = new Semaphore(1);
   
    //Creamos el array que contendrá los semaforos, es decir, los coches
    static Semaphore [] coches={Seat,Ford,Bmw,Audi};
    
    //Creamos un array que tendrá el nombre de cada coche
    String [] nombreCoches={"Seat","Ford","Bmw","Audi"};
   
    
    //Con una variable aleatoria de tamaño 4, haremos que el cliente acceda a un coche aleatorio
    int Aleatorio=(int)(Math.random()*4);

    public Conductor () {
    }
      
    
    @Override
    public void run() {
        try {
            //Creamos una variable de tipo semaforo para guardar un coche aleatorio
            Semaphore coche=coches[Aleatorio];
           
            //El coche queda bloqueado por un cliente
            coche.acquire();
            System.out.println("El cliente "+ Thread.currentThread().getName()+" va a coger el coche: "+ nombreCoches[Aleatorio]);
           
            //Tiempo que tarda el cliente en acceder al coche
            Thread.sleep(2000);
            
            System.out.println(Thread.currentThread().getName()+" está conduciendo");
            //Tiempo que conduce el cliente
            Thread.sleep(5000);
            
            System.out.println(Thread.currentThread().getName()+" ha soltado el coche: "+nombreCoches[Aleatorio]);
           //El cliente suelta el coche, liberandolo para otro cliente
            coche.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Conductor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
