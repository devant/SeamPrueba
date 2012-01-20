/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.dgcm.projectexample.security;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import mx.com.dgcm.projectexample.domain.Usuario;

/**
 *
 * @author Erika morales
 */
@Stateful //guarda estado
@Named //acceder desde EL
@SessionScoped //contexto
public class LoginAgent {
    private Usuario usuario = new Usuario();

    @Produces          
    @Named
    @Autenticated
    public Usuario getUsuario() {
        return usuario;
    }
    
    @PostConstruct
    public void init(){
        this.usuario.setIntereses(new ArrayList<String>());
    }
    
    public String looging(){
        
        return "otraPagina";
    }
}
