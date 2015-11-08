/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializacion;

import java.io.Serializable;

/**
 *
 * @author csa
 */
public class serializacion implements Serializable {
    private String mensaje;
    private int bandera;
    
    public serializacion(String mensaje1,int bandera1){
        mensaje=mensaje1;
        bandera=bandera1;
        
    }
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getBandera() {
        return bandera;
    }

    public void setBandera(int bandera) {
        this.bandera = bandera;
    }
    
    
    
    
}
