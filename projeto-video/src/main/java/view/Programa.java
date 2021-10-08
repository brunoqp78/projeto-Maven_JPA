package view;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Cliente;
import model.Remedio;
import model.Veterinario;

public class Programa {
	public static void main(String[] args) {
		
		Veterinario v1 = new Veterinario(null, "Bruno", "Clinica");
		Veterinario v2 = new Veterinario(null, "Erica", "Clinica");
		Veterinario v3 = new Veterinario(null, "Jose", "Cirurgião");
		
		Remedio r1 = new Remedio(null, "Ivermectina", "Pfizer", "10/10/2022");
		Remedio r2 = new Remedio(null, "Loleg", "Pfizer", "10/10/2022");
		
		Cliente c1 = new Cliente(null, "Raquel", "000.000.000-00", "Raquel", "4444-4444");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(v1); // chamo o gerenciador de tabelas(em) para fazer o comando insert relacionado ao veterinário presente em v1.
		em.persist(v2); 
		em.persist(v3); 
		
		em.persist(r1);
		em.persist(r2);
		
		em.persist(c1);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
