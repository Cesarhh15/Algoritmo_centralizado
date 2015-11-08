
package cliente_servidor;

import java.awt.Color;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static ventana.Ventana.jTextArea1;
import static ventana.Ventana.zona_buton;


/**
 *
 * @author csa
 */
public class cliente_servidor {
   private DatagramSocket socket;

    public cliente_servidor() throws SocketException{
        socket = new DatagramSocket();
    }

  public cliente_servidor(String ip){
      

      try // crea objeto DatagramSocket para enviar y recibir paquetes
{
socket = new DatagramSocket();
} // fin de try
catch ( SocketException excepcionSocket )
{
System.exit( 1 );
} // fin de catch
      try // crea y envía un paquete
{
    
// obtiene mensaje del campo de texto
String mensaje = "zona_critica";

byte datos[] = mensaje.getBytes(); // convierte en bytes
// crea objeto sendPacket
DatagramPacket paqueteEnviar = new DatagramPacket( datos,datos.length, InetAddress.getByName(ip), 5000 );
socket.send( paqueteEnviar ); // envía el paquete
jTextArea1.setText("peticion al coordinador");
System.out.println("se envio al servidor");
//jLabel1.setText( "Paquete enviado\n" );

} // fin de try
catch ( IOException excepcionES )

{
    System.out.println("problemas al enviar al cliente");

excepcionES.printStackTrace();
} // fin de catch


  }

public void esperarPaquetes()
{
   Thread f=new Thread(){
       public void run(){
        while ( true )
        {
                try // recibe el paquete, muestra su contenido, devuelve una copia al cliente
                {
                byte datos[] = new byte[ 100 ]; // establece un paquete
                DatagramPacket paqueteRecibir =new DatagramPacket( datos, datos.length );
                socket.receive( paqueteRecibir ); // espera a recibir el paquete
                // muestra la información del paquete recibido
                System.out.println("recibio del servidor");
                  jTextArea1.setText( "Paquete recibido:" +
                "\nDe host: " + paqueteRecibir.getAddress() +
                "\nContiene:\n\t" + new String( paqueteRecibir.getData(),
                0, paqueteRecibir.getLength() ) );
                  String mensaje=new String( paqueteRecibir.getData(), 0, paqueteRecibir.getLength() );
                  if(mensaje.equalsIgnoreCase("Estas_en_zona_critica")){
                    zona_buton.setBackground(Color.GREEN);
                  }
                  if(mensaje.equalsIgnoreCase("Zona_critica ocupada")){
                     
                      Thread.sleep(10000);
                        String mensajeEv2 = "zona_critica";
                     byte datosEv2[] = mensajeEv2.getBytes(); // convierte en bytes                    
                    InetAddress DireccionIP2 = paqueteRecibir.getAddress();
                    int puerto2 = paqueteRecibir.getPort();

                    DatagramPacket enviarPaquete2 = new DatagramPacket(datosEv2, datosEv2.length, DireccionIP2, puerto2);
                      enviarPaqueteAlCliente( enviarPaquete2 );
                  }
		if(mensaje.equalsIgnoreCase("Saliste de zona_critica")){
                    zona_buton.setBackground(Color.RED);
		break;
		}
					
                //enviarPaqueteAlCliente( paqueteRecibir ); // envía el paquete al cliente
                } // fin de try
                catch ( IOException excepcionES )
                {
               
                excepcionES.printStackTrace();
                } catch (InterruptedException ex) {
                Logger.getLogger(cliente_servidor.class.getName()).log(Level.SEVERE, null, ex);
            } // fin de catch
        } // fin de while
   }
           };
   f.start();
} //

public void salir_zona(String ip) throws IOException{
 
            String mensaje = "salir_zona_critica";

byte datos[] = mensaje.getBytes(); // convierte en bytes
// crea objeto sendPacket

DatagramPacket paqueteEnviar = null;
            
                paqueteEnviar = new DatagramPacket( datos,datos.length, InetAddress.getByName(ip), 5000 );
         
                        socket.send( paqueteEnviar ); // envía el paquete
                        jTextArea1.setText(mensaje);
System.out.println("se envio al servidor");
                   
}
private void enviarPaqueteAlCliente( DatagramPacket paqueteRecibir )
throws IOException
{

// crea paquete para enviar
DatagramPacket paqueteEnviar = new DatagramPacket(
paqueteRecibir.getData(), paqueteRecibir.getLength(),
paqueteRecibir.getAddress(), paqueteRecibir.getPort() );
socket.send( paqueteEnviar ); // envía paquete al cliente
jTextArea1.setText("peticion al servidor");

}
    

}   


