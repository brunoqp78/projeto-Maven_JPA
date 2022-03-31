package control;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import model.Remedio;

public class RemedioControle {
	private EntityManager em;
	
	public RemedioControle() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica");
		em = emf.createEntityManager();
	}
	
	public void inserir(Remedio objeto) {
		try {
            em.getTransaction().begin();
            em.persist(objeto);
            em.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
         }
	}
	public void alterar(Remedio objeto) {
		 try {
	            em.getTransaction().begin();
	            em.merge(objeto);
	            em.getTransaction().commit();
	         } catch (Exception ex) {
	            ex.printStackTrace();
	            em.getTransaction().rollback();
	         }

	}
	public void excluir(Remedio objeto) {
		try {
            em.getTransaction().begin();
            em.remove(objeto);
            em.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
         }

	}
	public void excluirPorId(Integer id) {
		try {
            Remedio objeto = buscarPorId(id);
            excluir(objeto);
         } catch (Exception ex) {
            ex.printStackTrace();
         }

	}
	
	public Remedio buscarPorId(Integer id) {
		return em.find(Remedio.class, id);	
	}
	
	public List<Remedio> buscarTodos() {
		String nomeClasse = Remedio.class.getName();
		return em.createQuery("FROM " + nomeClasse).getResultList();
	}
	

}
