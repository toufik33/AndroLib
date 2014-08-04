package org.librairiejpa.dal;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the livreauteur database table.
 * 
 */
@Entity
@NamedQuery(name="Livreauteur.findAll", query="SELECT l FROM Livreauteur l")
public class Livreauteur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="livreauteur_id")
	private Integer livreauteurId;

	//bi-directional many-to-one association to Auteur
	@ManyToOne
	@JoinColumn(name="livreauteur_auteur_id")
	private Auteur auteur;

	//bi-directional many-to-one association to Livre
	@ManyToOne
	@JoinColumn(name="livreauteur_livre_id")
	private Livre livre;

	public Livreauteur() {
	}

	public Integer getLivreauteurId() {
		return this.livreauteurId;
	}

	public void setLivreauteurId(Integer livreauteurId) {
		this.livreauteurId = livreauteurId;
	}

	public Auteur getAuteur() {
		return this.auteur;
	}

	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}

	public Livre getLivre() {
		return this.livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

}