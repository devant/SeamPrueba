/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.dgcm.projectexample.account;

import java.io.Serializable;
import javax.ejb.Stateful;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import mx.com.dgcm.projectexample.domain.Direccion;
import mx.com.dgcm.projectexample.security.Autenticated;

/**
 *
 * @author Erika morales
 */
@Stateful
@ConversationScoped
public class DireccionUsuario implements Serializable {        
    
    private Direccion direccionUsuario;

    @Produces
    @CurrentAddress
    @Named
    public Direccion getDireccionUsuario() {
        return direccionUsuario;
    }
    
    public void onLogin(@Observes @CurrentAddress Direccion direccion) {        
        direccionUsuario = direccion;
        System.out.println(direccionUsuario);
    }

   
        
}
