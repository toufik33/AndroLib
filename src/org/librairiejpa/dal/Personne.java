package org.librairiejpa.dal;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the personne database table.
 * 
 */
@Entity
@NamedQuery(name="Personne.findAll", query="SELECT p FROM Personne p")
public class Personne implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="personne_id")
	private Integer personneId;

	@Column(name="personne_adresse")
	private String personneAdresse;

	@Column(name="personne_adresse1")
	private String personneAdresse1;

	@Column(name="personne_cp")
	private Integer personneCp;

	@Column(name="personne_email")
	private String personneEmail;

	@Column(name="personne_nom")
	private String personneNom;

	@Column(name="personne_prenom")
	private String personnePrenom;

	@Column(name="personne_tel")
	private String personneTel;

	@Column(name="personne_ville")
	private String personneVille;

	//bi-directional many-to-one association to Commande
	@OneToMany(mappedBy="personne")
	private List<Commande> commandes;

	//bi-directional many-to-one association to Utilisateur
	@OneToMany(mappedBy="personne")
	private List<Utilisateur> utilisateurs;

	public Personne() {
	}

	public Integer getPersonneId() {
		return this.personneId;
	}

	public void setPersonneId(Integer personneId) {
		this.personneId = personneId;
	}

	public String getPersonneAdresse() {
		return this.personneAdresse;
	}

	public void setPersonneAdresse(String personneAdresse) {
		this.personneAdresse = personneAdresse;
	}

	public String getPersonneAdresse1() {
		return this.personneAdresse1;
	}

	public void setPersonneAdresse1(String personneAdresse1) {
		this.personneAdresse1 = personneAdresse1;
	}

	public Integer getPersonneCp() {
		return this.personneCp;
	}

	public void setPersonneCp(Integer personneCp) {
		this.personneCp = personneCp;
	}

	public String getPersonneEmail() {
		return this.personneEmail;
	}

	public void setPersonneEmail(String personneEmail) {
		this.personneEmail = personneEmail;
	}

	public String getPersonneNom() {
		return this.personneNom;
	}

	public void setPersonneNom(String personneNom) {
		this.personneNom = personneNom;
	}

	public String getPersonnePrenom() {
		return this.personnePrenom;
	}

	public void setPersonnePrenom(String personnePrenom) {
		this.personnePrenom = personnePrenom;
	}

	public String getPersonneTel() {
		return this.personneTel;
	}

	public void setPersonneTel(String personneTel) {
		this.personneTel = personneTel;
	}

	public String getPersonneVille() {
		return this.personneVille;
	}

	public void setPersonneVille(String personneVille) {
		this.personneVille = personneVille;
	}

	public List<Commande> getCommandes() {
		return this.commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public Commande addCommande(Commande commande) {
		getCommandes().add(commande);
		commande.setPersonne(this);

		return commande;
	}

	public Commande removeCommande(Commande commande) {
		getCommandes().remove(commande);
		commande.setPersonne(null);

		return commande;
	}

	public List<Utilisateur> getUtilisateurs() {
		return this.utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public Utilisateur addUtilisateur(Utilisateur utilisateur) {
		getUtilisateurs().add(utilisateur);
		utilisateur.setPersonne(this);

		return utilisateur;
	}

	public Utilisateur removeUtilisateur(Utilisateur utilisateur) {
		getUtilisateurs().remove(utilisateur);
		utilisateur.setPersonne(null);

		return utilisateur;
	}

}