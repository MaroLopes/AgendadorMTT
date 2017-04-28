package br.com.agendadormtt.DAO;

import br.com.agendadormtt.VO.Usuarios;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author mlopes
 */
public class UsuariosDAO extends DAO {
    
    public void salvar(Usuarios usuario){
        EntityManager em = getEntityManager();
        
        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERRO",  e.getMessage()));
            em.getTransaction().rollback();
            em.close();
        }
        
    }
    
    public Usuarios getByUsuario(int idUsuario){
        EntityManager em = getEntityManager();
        
        return em.find(Usuarios.class, idUsuario);
        
    }
    
    public void update(Usuarios usuario){
        EntityManager em = getEntityManager();
        
        try {
            
            em.getTransaction().begin();
            Usuarios u = em.find(Usuarios.class, usuario.getUsuariosId());
            
            u.setUsuariosNome(usuario.getUsuariosNome());
            u.setUsuariosMail(usuario.getUsuariosMail());
            u.setUsuariosPassword(usuario.getUsuariosPassword());
            
            em.getTransaction().commit();
            
        } catch (Exception e) {
            em.getTransaction().rollback();
            em.close();
        }
    }
    
    public void delete(Usuarios usuario){
        EntityManager em = getEntityManager();
        
        try {
            
            em.getTransaction().begin();
            Usuarios u = em.find(Usuarios.class, usuario.getUsuariosId());
            
            em.remove(u);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            em.getTransaction().rollback();
            em.close();
        }
    }
    
    public List<Usuarios> GetALL(){
        EntityManager em = getEntityManager();
        List<Usuarios> lista = null;
        
        try {
            
            Query q =  em.createQuery("select object (u) from Usuarios as u");
            lista = q.getResultList();
            
        } catch (Exception e) {
            em.close();
        }
        return lista;
    }
    
}
