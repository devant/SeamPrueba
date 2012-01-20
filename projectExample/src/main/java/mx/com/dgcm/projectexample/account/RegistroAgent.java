/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.dgcm.projectexample.account;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import mx.com.dgcm.projectexample.domain.Direccion;
import mx.com.dgcm.projectexample.domain.Usuario;
import mx.com.dgcm.projectexample.security.Autenticated;

/**
 *
 * @author Erika morales
 */
@Stateful
@Named
@ConversationScoped
public class RegistroAgent {
    private Direccion direccion;
    
    @Inject @Autenticated
    private Usuario usuario;
    
    @Inject
    @CurrentAddress
    private Event<Direccion> loginEventSrc;
    
    @Inject
    private Conversation convertation;
    
    @Produces
    @Named
    public Direccion getDireccion() {
        return direccion;
    }

    /*Lo usamos cómo constructor... 
     * Pero le ponemos la anotación para 
     * que se inyecte lo que necesitamos
     */
    @PostConstruct
    public void init(){
        if(convertation.isTransient()){ //NO está iniciada la conversación
            System.out.println("INICIANDO CONVERSACION");
            convertation.begin();
            System.out.println(convertation.getId());
        }
        this.direccion = new Direccion();
        direccion.setUsuario(usuario);
    }
    
    public String closeConversation(){
        convertation.end();
        return "index";
    }
    
    public String siguiente(){
        return "pagina3";
    }
    
    public String confirmar(){
        System.out.println("confirmacion de datos");
        loginEventSrc.fire(direccion);
        System.out.println("redireccionando");
        return "pagina5";
    }
    
}
