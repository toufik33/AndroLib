package org.librairiejpa.bo;

import java.util.List;

import javax.persistence.TypedQuery;

import org.librairiejpa.dal.Personne;
import org.librairiejpa.dal.Utilisateur;
import org.librairiejpa.tools.BDDTools;

public class JpaUtilisateur {

	private BDDTools bddtools;

	// private String sqlGetUser = "";
	// private String sqlGetAllUser = "select u from Utilisateur";

	private String utilisateurLogin;
	
	private String utilisateurPwd;

	private JpaPersonne jpaPersonne;

	public JpaUtilisateur(){
		bddtools = BDDTools.getInstance();
	}
	
	
	public JpaUtilisateur(String utilisateurLogin, String utilisateurPwd, JpaPersonne jpaPersonne) {
		this();
		this.utilisateurLogin = utilisateurLogin;
		this.utilisateurPwd = utilisateurPwd;
		this.jpaPersonne = jpaPersonne;
		
	}

	





//	public User() {
//		bddtools = BDDTools.getInstance();
//
//	}

	public void savePersonneAndUser() {
		bddtools = BDDTools.getInstance();
		bddtools.getTransac().begin();
		
		//
		Personne personne = new Personne();
		personne.setPersonneNom(jpaPersonne.getPersonneNom());
		personne.setPersonnePrenom(jpaPersonne.getPersonnePrenom());
		personne.setPersonneAdresse(jpaPersonne.getPersonneAdresse());
		personne.setPersonneAdresse1(jpaPersonne.getPersonneAdresse1());
		personne.setPersonneCp(jpaPersonne.getPersonneCp());
		personne.setPersonneEmail(jpaPersonne.getPersonneEmail());
		personne.setPersonneTel(jpaPersonne.getPersonneTel());
		personne.setPersonneVille(jpaPersonne.getPersonneVille());
		
		bddtools.getEm().persist(personne);
		
		
		Utilisateur utilisateur = new Utilisateur();

		utilisateur.setUtilisateurLogin(this.utilisateurLogin);
		utilisateur.setUtilisateurPwd(this.utilisateurPwd);
		utilisateur.setPersonne(personne);
		
		bddtools.getEm().persist(utilisateur);
		bddtools.getTransac().commit();
		
		bddtools.closeConnection();

	}
	public void saveUserOnly() {
		bddtools = BDDTools.getInstance();
		bddtools.getTransac().begin();

		Utilisateur utilisateur = new Utilisateur();

		utilisateur.setUtilisateurLogin(this.utilisateurLogin);
		utilisateur.setUtilisateurPwd(this.utilisateurPwd);
	
		bddtools.getEm().persist(utilisateur);
		bddtools.getTransac().commit();
		
		bddtools.closeConnection();

	}
	public List<Utilisateur> getAllUtilisateur() {

		TypedQuery<Utilisateur> query = bddtools.getEm().createNamedQuery(
				"Utilisateur.findAll", Utilisateur.class);

		List<Utilisateur> utilisateur = query.getResultList();

		return utilisateur;

	}
	
	public Utilisateur getUserByLogin (String login, String pwd)
	{
		bddtools = BDDTools.getInstance();
		Utilisateur util = (Utilisateur)bddtools.getEm().createQuery("select u from Utilisateur u where u.utilisateurLogin='"
				+ login + "' AND u.utilisateurPwd='" + pwd + "'").getSingleResult();
		
		bddtools.closeConnection();
		 return util;
	}

}
