/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agendadormtt.VO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mlopes
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByUsuariosId", query = "SELECT u FROM Usuarios u WHERE u.usuariosId = :usuariosId"),
    @NamedQuery(name = "Usuarios.findByUsuariosNome", query = "SELECT u FROM Usuarios u WHERE u.usuariosNome = :usuariosNome"),
    @NamedQuery(name = "Usuarios.findByUsuariosMail", query = "SELECT u FROM Usuarios u WHERE u.usuariosMail = :usuariosMail"),
    @NamedQuery(name = "Usuarios.findByUsuariosPassword", query = "SELECT u FROM Usuarios u WHERE u.usuariosPassword = :usuariosPassword")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usuarios_id")
    private Integer usuariosId;
    
    @Basic(optional = false)
    @Column(name = "usuarios_nome")
    private String usuariosNome;
    
    @Basic(optional = false)
    @Column(name = "usuarios_mail")
    private String usuariosMail;
    
    @Basic(optional = false)
    @Column(name = "usuarios_password")
    private String usuariosPassword;

    public Usuarios() {
    }

    public Usuarios(Integer usuariosId) {
        this.usuariosId = usuariosId;
    }

    public Usuarios(Integer usuariosId, String usuariosNome, String usuariosMail, String usuariosPassword) {
        this.usuariosId = usuariosId;
        this.usuariosNome = usuariosNome;
        this.usuariosMail = usuariosMail;
        this.usuariosPassword = usuariosPassword;
    }

    public Integer getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(Integer usuariosId) {
        this.usuariosId = usuariosId;
    }

    public String getUsuariosNome() {
        return usuariosNome;
    }

    public void setUsuariosNome(String usuariosNome) {
        this.usuariosNome = usuariosNome;
    }

    public String getUsuariosMail() {
        return usuariosMail;
    }

    public void setUsuariosMail(String usuariosMail) {
        this.usuariosMail = usuariosMail;
    }

    public String getUsuariosPassword() {
        return usuariosPassword;
    }

    public void setUsuariosPassword(String usuariosPassword) {
        this.usuariosPassword = usuariosPassword;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuariosId != null ? usuariosId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.usuariosId == null && other.usuariosId != null) || (this.usuariosId != null && !this.usuariosId.equals(other.usuariosId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.agendadormtt.VO.Usuarios[ usuariosId=" + usuariosId + " ]";
    }
    
}
