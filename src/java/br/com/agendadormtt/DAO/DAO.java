
package br.com.agendadormtt.DAO;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.jpa.internal.EntityManagerImpl;

/**
 *
 * @author mlopes
 */
public class DAO {
    
    private EntityManagerFactory emf;
    
    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    
    public DAO (){
        emf = Persistence.createEntityManagerFactory("AgendadorMTTPU");
    }
    
    public Session getSession(){
        
        if (getEntityManager().getDelegate() instanceof EntityManagerImpl) {
            
            EntityManagerImpl entityManagerImpl = (EntityManagerImpl) getEntityManager().getDelegate();
            return entityManagerImpl.getSession();
                
	} else {
            
            return (Session) getEntityManager().getDelegate();
	
        }
        
    }
    
}
