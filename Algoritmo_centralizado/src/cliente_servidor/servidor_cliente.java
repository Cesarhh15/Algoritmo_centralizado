
package cliente_servidor;

import compartir.Bufer;
import compartir.BuferSincronizado;
import compartir.Productor;
import compartir.consumidor;
import compartir.estado;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static ventana.Ventana.jLabel2;
import static ventana.Ventana.jTextArea1;




/**
 *
 * @author csa
 */
public class servidor_cliente {
    DatagramSocket socket;
     boolean  estado=false,t=true;
     DatagramPacket paqueteRecibir1;
     DatagramPacket paqueteRecibir2;
     int aux=1,aux1=1;
    
  public  servidor_cliente() throws UnknownHostException{
            try // crea objeto DatagramSocket para enviar y recibir paquetes
                {
                    socket = new DatagramSocket( 5000 );
                     
                } // fin de try
                catch ( SocketException excepcionSocket )
                {
                        excepcionSocket.printStackTrace();
                        System.exit( 1 );
                }
    }
  


public void esperarPaquetes() throws InterruptedException
{
    Bufer ubicacionCompartida = new BuferSincronizado();
  ArrayList<String> datoscliente = new ArrayList<String>();
    
Thread w=new Thread(){
    public void run(){
        while ( t )
            {
                System.out.println("sirve el servidor");
                try // recibe el paquete, muestra su contenido, devuelve una copia al cliente
                {
                    byte datos[] = new byte[ 100 ]; // establece un paquete
                    DatagramPacket paqueteRecibir =
                            new DatagramPacket( datos, datos.length );
                    socket.receive( paqueteRecibir ); // espera a recibir el paquete
                    paqueteRecibir1=paqueteRecibir;
                    ExecutorService aplicacion = Executors.newCachedThreadPool();
                   
            
                    // muestra la información del paquete recibido
                    // crea nueva reserva con dos subprocesos
                    //  ExecutorService aplicacion = Executors.newCachedThreadPool();
                    if( (estado==false)){
                        estado es=new estado();
                   es.setVisible(true);
                      System.out.printf( "%-40s%s\t\t%s\n%-40s%s\n\n", "Operacion",
                            "Bufer", "Ocupado", "---------", "------\t\t--------" );
                    //estado=true;
                   // estado= ubicacionCompartida.establecer(1);
                      aplicacion.execute( new Productor( ubicacionCompartida ) );
                    paqueteRecibir2=paqueteRecibir;
                    datoscliente.add(0,paqueteRecibir2.getAddress()+"");
                    datoscliente.add(1,paqueteRecibir2.getPort()+"");
                            jTextArea1.append( "Paquete recibido:" +
                                    "\nDe host: " + paqueteRecibir2.getAddress() +
                                    "\nContiene: " + new String( paqueteRecibir2.getData(),
                                            0, paqueteRecibir2.getLength() )+"\n\n" );
                       
                     String mensajeEv1 = "Estas_en_zona_critica";
                     byte datosEv1[] = mensajeEv1.getBytes(); // convierte en bytes                    
                    InetAddress DireccionIP = paqueteRecibir2.getAddress();
                    int puerto = paqueteRecibir2.getPort();

                    DatagramPacket enviarPaquete = new DatagramPacket(datosEv1, datosEv1.length, DireccionIP, puerto);
                    enviarPaqueteAlCliente(enviarPaquete);
                   Thread hiloaux=new Thread(){
                       public void run(){
                           try {
                               int l=20;
                              // ubicacionCompartida.obtener();
                               while(l>=0){
                                   estado=true;
                               jLabel2.setText(l+"");
                               
                               Thread.sleep(1000);
                               l--;
                               
                           }
                               aplicacion.execute( new consumidor( ubicacionCompartida ) );
                           
                           
                           
                            jTextArea1.setText("Se liberó zona Critica");
                            
                             String mensajeE = "Saliste de zona_critica";
                            
                            byte datosE[] = mensajeE.getBytes(); // convierte en bytes 
                             String ip1=datoscliente.get(0);
                            ip1=ip1.replace("/","");
                             
                              int puerto1 = Integer.parseInt(datoscliente.get(1));

                    DatagramPacket enviarPaquete3 = new DatagramPacket(datosE, datosE.length, InetAddress.getByName(ip1), puerto1);
                    enviarPaqueteAlCliente(enviarPaquete3);
                           datoscliente.clear();
                           
                            aplicacion.shutdown(); // termina la aplicación cuando se completan las tareas
                            estado=false;
                           } catch (InterruptedException ex) {
                               Logger.getLogger(servidor_cliente.class.getName()).log(Level.SEVERE, null, ex);
                           } catch (UnknownHostException ex) {
                               Logger.getLogger(servidor_cliente.class.getName()).log(Level.SEVERE, null, ex);
                           } catch (IOException ex) {
                               Logger.getLogger(servidor_cliente.class.getName()).log(Level.SEVERE, null, ex);
                           }
                       }
                   };
                   hiloaux.start();
                            
                     }else if(estado==true){
                jTextArea1.append("Zona ocupada");
                 String mensajeEv2 = "Zona_critica ocupada";
                     byte datosEv2[] = mensajeEv2.getBytes(); // convierte en bytes                    
                    InetAddress DireccionIP2 = paqueteRecibir1.getAddress();
                    int puerto2 = paqueteRecibir1.getPort();

                    DatagramPacket enviarPaquete2 = new DatagramPacket(datosEv2, datosEv2.length, DireccionIP2, puerto2);
                    enviarPaqueteAlCliente(enviarPaquete2);
            }
                      
               /*    
                    if(datoscliente.size()==0 ||datoscliente.get(0)=="vacio" ){
                      
                    datoscliente.add(0,paqueteRecibir.getAddress()+"");
                    
                   
                    }else{
                        String ipaux=paqueteRecibir.getAddress()+"";
                         
                        if(ipaux.equalsIgnoreCase(datoscliente.get(0))){
                            String ip1=datoscliente.get(0);
                            ip1=ip1.replace("/","");
                            
                            
                            String mensajeE = "Saliste de zona_critica";
                             JOptionPane.showMessageDialog(null,mensajeE);
                     byte datosE[] = mensajeE.getBytes(); // convierte en bytes                    
                    
                    int puerto = 5000;

                    DatagramPacket enviarPaquete = new DatagramPacket(datosE, datosE.length, InetAddress.getByName(ip1), puerto);
                    enviarPaqueteAlCliente(enviarPaquete);
                            
                            datoscliente.add(0,"vacio");
                           paqueteRecibir=null;
                            //ubicacionCompartida.obtener();
                            aplicacion.execute( new consumidor( ubicacionCompartida ) );
                            aplicacion.shutdown(); // termina la aplicación cuando se completan las tareas
                            aux=1;
                            aux1=1;
                           // estado=false;
                            jTextArea1.setText("Se liberó zona Critica");
                           
                        }
                    
                    }*/
                    
                    
            
                 
                   
                } // fin de try
                catch ( IOException excepcionES )
                {
                    
                    excepcionES.printStackTrace();
                } // fin de catch
                
            } // fin de while
        t=true;
    }
};
w.start();
} //

private void enviarPaqueteAlCliente( DatagramPacket paqueteRecibir )
throws IOException
{

// crea paquete para enviar
DatagramPacket paqueteEnviar = new DatagramPacket(
paqueteRecibir.getData(), paqueteRecibir.getLength(),
paqueteRecibir.getAddress(), paqueteRecibir.getPort() );
socket.send( paqueteEnviar ); // envía paquete al cliente
//JOptionPane.showMessageDialog(null, "se envio mensaje");
}
        
    

}
