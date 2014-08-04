package org.librairiejpa.dal;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the auteur database table.
 * 
 */
@Entity
@NamedQuery(name="Auteur.findAll", query="SELECT a FROM Auteur a")
public class Auteur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="auteur_id")
	private Integer auteurId;

	@Column(name="auteur_nom")
	private String auteurNom;

	@Column(name="auteur_prenom")
	private String auteurPrenom;

	//bi-directional many-to-one association to Livreauteur
	@OneToMany(mappedBy="auteur")
	private List<Livreauteur> livreauteurs;

	public Auteur() {
	}

	public Integer getAuteurId() {
		return this.auteurId;
	}

	public void setAuteurId(Integer auteurId) {
		this.auteurId = auteurId;
	}

	public String getAuteurNom() {
		return this.auteurNom;
	}

	public void setAuteurNom(String auteurNom) {
		this.auteurNom = auteurNom;
	}

	public String getAuteurPrenom() {
		return this.auteurPrenom;
	}

	public void setAuteurPrenom(String auteurPrenom) {
		this.auteurPrenom = auteurPrenom;
	}

	public List<Livreauteur> getLivreauteurs() {
		return this.livreauteurs;
	}

	public void setLivreauteurs(List<Livreauteur> livreauteurs) {
		this.livreauteurs = livreauteurs;
	}

	public Livreauteur addLivreauteur(Livreauteur livreauteur) {
		getLivreauteurs().add(livreauteur);
		livreauteur.setAuteur(this);

		return livreauteur;
	}

	public Livreauteur removeLivreauteur(Livreauteur livreauteur) {
		getLivreauteurs().remove(livreauteur);
		livreauteur.setAuteur(null);

		return livreauteur;
	}

}