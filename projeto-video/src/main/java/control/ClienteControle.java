package control;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import model.Cliente;

public class ClienteControle {
	private EntityManager em;
	
	public ClienteControle() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica");
		em = emf.createEntityManager();
	}
	
	public void inserir(Cliente objeto) {
		try {
            em.getTransaction().begin();
            em.persist(objeto);
            em.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
         }

	}
	public void alterar(Cliente objeto) {
		 try {
	            em.getTransaction().begin();
	            em.merge(objeto);
	            em.getTransaction().commit();
	         } catch (Exception ex) {
	            ex.printStackTrace();
	            em.getTransaction().rollback();
	         }

	}
	public void excluir(Cliente objeto) {
		try {
            em.getTransaction().begin();
            em.remove(objeto);
            em.getTransaction().commit();
         } catch (Exception ex) {
            //ex.printStackTrace();
        	System.out.println("Não foi possível excluir.");
            em.getTransaction().rollback();
         }

	}
	public void excluirPorId(Integer id) {
		try {
            Cliente objeto = buscarPorId(id);
            excluir(objeto);
         } catch (Exception ex) {
        	System.out.println("Não foi possível excluir.");
         }

	}
	public Cliente buscarPorId(Integer id) {
		return em.find(Cliente.class, id);	
	}
	public List<Cliente> buscarTodos() {
		String nomeClasse = Cliente.class.getName();
		return em.createQuery("FROM " + nomeClasse).getResultList();

	}

	
}
