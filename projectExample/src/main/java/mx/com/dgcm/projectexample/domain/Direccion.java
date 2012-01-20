/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.dgcm.projectexample.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Erika morales
 */
@Entity
public class Direccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
   
    private String calle;
    private String numero;
    private String ciudad;
    private Usuario usuario;

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Direccion other = (Direccion) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.calle == null) ? (other.calle != null) : !this.calle.equals(other.calle)) {
            return false;
        }
        if ((this.numero == null) ? (other.numero != null) : !this.numero.equals(other.numero)) {
            return false;
        }
        if ((this.ciudad == null) ? (other.ciudad != null) : !this.ciudad.equals(other.ciudad)) {
            return false;
        }
        if (this.usuario != other.usuario && (this.usuario == null || !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 59 * hash + (this.calle != null ? this.calle.hashCode() : 0);
        hash = 59 * hash + (this.numero != null ? this.numero.hashCode() : 0);
        hash = 59 * hash + (this.ciudad != null ? this.ciudad.hashCode() : 0);
        hash = 59 * hash + (this.usuario != null ? this.usuario.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Direccion{" + "id=" + id + ", calle=" + calle + ", numero=" + numero + ", ciudad=" + ciudad + ", usuario=" + usuario + '}';
    }
    
}
