package control;

import java.util.List;
import model.Veterinario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class VeterinarioControle {
	private EntityManager em;
	
	public VeterinarioControle() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica");
		em = emf.createEntityManager();
	}

	public void inserir(Veterinario objeto) {
		try {
            em.getTransaction().begin();
            em.persist(objeto);
            em.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
         }
	}
	
	public void alterar(Veterinario objeto) {
		 try {
	            em.getTransaction().begin();
	            em.merge(objeto);
	            em.getTransaction().commit();
	         } catch (Exception ex) {
	            ex.printStackTrace();
	            em.getTransaction().rollback();
	         }
	}
	public void excluir(Veterinario objeto) {
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
            Veterinario objeto = buscarPorId(id);
            excluir(objeto);
         } catch (Exception ex) {
            ex.printStackTrace();
         }

	}
	public Veterinario buscarPorId(Integer id) {
		return em.find(Veterinario.class, id);		
	}
	public List<Veterinario> buscarTodos(){ 
		String nomeClasse = Veterinario.class.getName();
		return em.createQuery("FROM " + nomeClasse).getResultList();

	}
	
}
