/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compartir;

import static compartir.estado.zona_area;
import java.awt.Color;
import static ventana.Ventana.zona_buton;

/**
 *
 * @author csa
 */
public class BuferSincronizado implements Bufer
{
        private int bufer = -1; // compartido por los subprocesos productor y consumidor
        private boolean ocupado = false; // indica si el búfer está ocupado o no
        // coloca el valor en el búfer
        public synchronized boolean establecer( int valor ) throws InterruptedException
        {
            // mientras no haya ubicaciones vacías, coloca el subproceso en espera
            while ( ocupado )
            {
                // imprime información del subproceso e información del búfer, después espera
                System.out.println( "Productor trata de escribir." );
                mostrarEstado( "Bufer lleno. Productor espera." );
                wait();
                
            } // fin de while
            bufer = valor; // establece el nuevo valor del búfer
            // indica que el productor no puede almacenar otro valor
            // hasta que el consumidor obtenga el valor actual del búfer
            ocupado = true;
            mostrarEstado( "Productor escribe " + bufer );
            notifyAll(); // indica al (los) subproceso(s) en espera que entren al estado runnable
            return ocupado;
        } // fin del método establecer; libera el bloqueo sobre BuferSincronizado
        // devuelve el valor del búfer
        public synchronized int obtener() throws InterruptedException
        {
            // mientras no haya datos para leer, coloca el subproceso en el estado en espera
            while ( !ocupado )
            {
                // imprime la información del subproceso y la información del búfer, después espera
                System.out.println( "Consumidor trata de leer." );
                mostrarEstado( "Bufer vacio. Consumidor espera." );
                wait();
            } // fin de while
        // indica que el productor puede almacenar otro valor
        // debido a que el consumidor acaba de obtener el valor del búfer
        ocupado = false;
        mostrarEstado( "Consumidor lee " + bufer );
        notifyAll(); // indica al (los) subproceso(s) en espera que entren al estado runnable
        return bufer;
        } // fin del método obtener; libera el bloqueo sobre BuferSincronizado
        // muestra la operación actual y el estado del búfer
        public void mostrarEstado( String operacion )
        {
            Thread o=new Thread(){
                public void run(){
                    zona_area.append( operacion+"\t"+bufer+"\t"+ocupado+"\n");
                     System.out.printf( "%s\t\t%d\t\t%b\n\n", operacion, bufer, ocupado);
                    Thread l=new Thread(){
                        public void run(){
                     if(ocupado==true){
                     zona_buton.setBackground(Color.GREEN);
                     }
                     if(ocupado==false){
                         zona_buton.setBackground(Color.RED);
                     }
                    }};l.start();
            }
            };
            o.start();
        } // fin del método mostrarEstado
public boolean estado_zona(){
    return ocupado;
}

} // fin de la clase BuferSincronizado