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

public class consumidor implements Runnable
{
        private final static Random generador = new Random();
        private final Bufer ubicacionCompartida; // referencia al objeto compartido
        // constructor
        public consumidor( Bufer compartido )
        {
            ubicacionCompartida = compartido;
        } // fin del constructor de Consumidor
        // lee el valor de ubicacionCompartida 10 veces y suma los valores
        public void run()
        {
         int zona = 0;
            // permanece inactivo de 0 a 3 segundos, lee un valor del búfer y lo agrega asuma
            try
            {
            Thread.sleep( generador.nextInt( 3000 ) );
            zona = ubicacionCompartida.obtener();
            System.out.printf( "t\t\t%2d\n", zona );
            } // fin de try
            // si las líneas 26 o 27 se interrumpen, imprime el rastreo de la pila
            catch ( InterruptedException excepcion )
            {
            excepcion.printStackTrace();
            } // fin de catch

            System.out.printf( "\n%s %d\n%s\n","Consumidor leyo valores, el total es", zona, "Terminando Consumidor" );
        } // fin del método run
} // fin de la clase Consumidor
