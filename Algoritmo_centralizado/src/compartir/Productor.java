/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compartir;

/**
 *
 * @author csa
 */
import java.util.Random;
public class Productor implements Runnable{
    
        private final static Random generador = new Random();
        private final Bufer ubicacionCompartida; // referencia al objeto compartido
        // constructor
        public Productor( Bufer compartido )
        {
            ubicacionCompartida = compartido;
        } // fin del constructor de Productor
        // almacena valores del 1 al 10 en ubicacionCompartida
        public void run()
        {
            int zona = 1;
           
            try // permanece inactivo de 0 a 3 segundos, después coloca valor en Bufer
            {
            Thread.sleep( generador.nextInt( 3000 ) ); // periodo de inactividad aleatorio
            ubicacionCompartida.establecer( zona ); // establece el valor en el búfer
            System.out.printf( "\t%2d\n", zona );
            } // fin de try
            // si las líneas 25 o 26 se interrumpen, imprime el rastreo de la pila
            catch ( InterruptedException excepcion )
            {
               
            excepcion.printStackTrace();
            } // fin de catch
        
            System.out.println("Productor termino de producir\nTerminando Productor" );
        } // fin del método run
} // fin de la clase Productor
