package br.com.agendadormtt.DAO;

import br.com.agendadormtt.VO.Agenda;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author mlopes
 */
public class AgendaDAO extends DAO{
    
    public void salvar(Agenda agenda){
        EntityManager em = getEntityManager();
        
        try {
            em.getTransaction().begin();
            em.persist(agenda);
            em.getTransaction().commit();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERRO",  e.getMessage()));
            em.getTransaction().rollback();
            em.close();
        }
        
    }
    
    public Agenda getByUsuario(int idAgenda){
        EntityManager em = getEntityManager();
        
        return em.find(Agenda.class, idAgenda);
        
    }
    
    public void update(Agenda agenda){
        EntityManager em = getEntityManager();
        
        try {
            
            em.getTransaction().begin();
            Agenda a = em.find(Agenda.class, agenda.getAgendaId());
            
            a.setAgendaCidade(agenda.getAgendaCidade());
            a.setAgendaClienteFinal(agenda.getAgendaClienteFinal());
            a.setAgendaData(agenda.getAgendaData());
            a.setAgendaDescricaoAtividade(agenda.getAgendaDescricaoAtividade());
            a.setAgendaHora(agenda.getAgendaHora());
            a.setAgendaProjetoId(agenda.getAgendaProjetoId());
            a.setAgendaSolicitante(agenda.getAgendaSolicitante());
            a.setAgendaUf(agenda.getAgendaUf());
            
            em.getTransaction().commit();
            
        } catch (Exception e) {
            em.getTransaction().rollback();
            em.close();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERRO",  e.getMessage()));
        }
    }
    
    public void delete(Agenda agenda){
        EntityManager em = getEntityManager();
        
        try {
            
            em.getTransaction().begin();
            Agenda a = em.find(Agenda.class, agenda.getAgendaId());
            
            em.remove(a);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            em.getTransaction().rollback();
            em.close();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERRO",  e.getMessage()));
        }
    }
    
    public List<Agenda> GetALL(){
        EntityManager em = getEntityManager();
        List<Agenda> lista = null;
        
        try {
            
            Query q =  em.createQuery("select object (a) from Agenda as a");
            lista = q.getResultList();
            
        } catch (Exception e) {
            em.close();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERRO",  e.getMessage()));
        }
        return lista;
    }
    
    public List<Agenda> GetData(Date data){
        EntityManager em = getEntityManager();
        List<Agenda> lista = null;
        
        try {
            
            Query q =  em.createQuery("select object (a) from Agenda as a where a.agendaData = :data").setParameter("data", data);
            lista = q.getResultList();
            
        } catch (Exception e) {
            em.close();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERRO",  e.getMessage()));
        }
        
        return lista;
    }
    
}
