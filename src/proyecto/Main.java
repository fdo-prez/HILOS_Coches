/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author totit
 */
public class Main {
    public static void main(String[] args) {
      
        //Mediante un mensaje mostramos que se va a realizar un sorteo de preferencia, que se aplicará con el metodo sorteo de la clase Sorteo
        JOptionPane.showMessageDialog(null,"Debido a la gran afluencia, hemos dado a cada cliente un numero aleatorio"
                + " de preferencia, que no establece su turno pero"
                + " si más posibilidades de coger el coche antes" ,"Alerta",2);
        
        
        
        try{
            //instanciamos variables de la clase Conductor, que al implementar Runnable pueden ser usadas por hilos
            
            Conductor javier = new Conductor();
            Conductor pedro = new Conductor();
            Conductor jose = new Conductor();
            Conductor martin = new Conductor();
            Conductor luis = new Conductor();
            Conductor ana = new Conductor();
            Conductor maria = new Conductor();
            Conductor alex = new Conductor();
            Conductor nuria = new Conductor();

            
            
            
            //instanciamos los hilos, que serán los conductores, pasandole por contructor la variable de la clase Conductor
            
            Thread Javier = new Thread(javier, "Javier");
            Thread Pedro = new Thread(pedro, "Pedro");
            Thread Jose = new Thread(jose, "Jose");
            Thread Martin = new Thread(martin, "Martin");
            Thread Luis = new Thread(luis, "Luis");
            Thread Ana = new Thread(ana, "Ana");
            Thread Maria = new Thread(maria, "Maria");
            Thread Alex = new Thread(alex, "Alex");
            Thread Nuria = new Thread(nuria, "Nuria");
            
            /* Creamos un array de hilos, para darles a todos una preferencia aleatoria
            metiante el método sorteo, en vez de usar un Thread.setPriority uno por uno,
            simplificando el código
            */
            
            Thread[] conductores = {Javier, Pedro, Jose, Martin, Luis, Ana, Maria, Alex, Nuria};
            for (int i = 0; i < conductores.length; i++) {
                Sorteo.sorteo(conductores[i]);
            }
            
            
            //Iniciamos los hilos con una preferencia aleatoria
            Javier.start();
            Pedro.start();
            Jose.start();
            Martin.start();
            Luis.start();
            Ana.start();
            Maria.start();
            Alex.start();
            Nuria.start();

          
        } catch (Exception io) {
            
            //Si ha habido un error, se imprimirá en rojo el mensaje
            System.err.println("Ha habido un problema en el concesionario");
            io.printStackTrace();
        }
  
    }
}
