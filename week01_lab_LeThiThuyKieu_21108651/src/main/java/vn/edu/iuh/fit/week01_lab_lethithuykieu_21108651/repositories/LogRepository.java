package vn.edu.iuh.fit.week01_lab_lethithuykieu_21108651.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.week01_lab_lethithuykieu_21108651.entities.Log;

public class LogRepository {
    private EntityManagerFactory emf;
    public LogRepository(){
        this.emf = Persistence.createEntityManagerFactory("JPA_MARIADB");
    }
    public boolean addLog(Log log){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(log);
            em.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public Log findLogById(String logId){
        EntityManager em = emf.createEntityManager();
        return em.find(Log.class, logId);
    }
    public boolean updateLog(Log log){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(log);
            em.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean deleteLog(String logId){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            Log log = em.find(Log.class, logId);
            if(log != null){
                em.remove(log);
                em.getTransaction().commit();
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
