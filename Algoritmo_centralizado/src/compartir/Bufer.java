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
public interface Bufer
{
// coloca valor int value en Bufer
public boolean establecer( int valor ) throws InterruptedException;
// obtiene valor int de Bufer
public int obtener() throws InterruptedException;

} // fin de la interfaz Bufer