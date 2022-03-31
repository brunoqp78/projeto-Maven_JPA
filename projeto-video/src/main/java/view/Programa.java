package view;



import java.awt.Desktop;
import java.io.File;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.adobe.acrobat.Viewer;

import model.Autor;

public class Programa {
	
		/**
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		
		Autor obj1 = new Autor(null, "Bruno Queiroz", "Brasileira");
		Autor obj2 = new Autor(null, "Danilo", "Japones");
		Autor obj3 = new Autor(null, "Fernando", "Argentino");
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(obj1);
		em.persist(obj2);
		em.persist(obj3);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
