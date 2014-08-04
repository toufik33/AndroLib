package org.librairiejpa.tools;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



public class BDDTools {

	

	private static  EntityManagerFactory emf;
	public EntityManagerFactory getEmf() {
		return emf;
	}

	public EntityManager getEm() {
		return em;
	}

	public EntityTransaction getTransac() {
		return transac;
	}

	private static  EntityManager em;
	private  static EntityTransaction transac;
  private static BDDTools bddtools ;
	
	
	private BDDTools() {
		emf = Persistence.createEntityManagerFactory("librairiejpa");
		em = emf.createEntityManager();
		transac = em.getTransaction();
	}
	
//	public static Utilisateur getUtilisateur (String sql)
//	{
//		getInstance();
//		
//		Query query = (Query) em.createQuery(sql);
//		Utilisateur user = (Utilisateur) ((javax.persistence.Query) query).getSingleResult();
//		
//		return user;
//	}

	

	public static  BDDTools getInstance()
	{
		if (bddtools == null)
		{
			bddtools = new BDDTools();
		}
		return bddtools;
	}
	
	


	public static void closeConnection() {
		em.close();
		emf.close();
		bddtools = null;
	}
}

