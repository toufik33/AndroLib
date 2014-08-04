package org.librairiejpa.dal;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the commande database table.
 * 
 */
@Entity
@NamedQuery(name="Commande.findAll", query="SELECT c FROM Commande c")
public class Commande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="commande_id")
	private Integer commandeId;

	//bi-directional many-to-one association to Livre
	@ManyToOne
	@JoinColumn(name="commande_livre_id")
	private Livre livre;

	//bi-directional many-to-one association to Personne
	@ManyToOne
	@JoinColumn(name="commande_personne_id")
	private Personne personne;

	public Commande() {
	}

	public Integer getCommandeId() {
		return this.commandeId;
	}

	public void setCommandeId(Integer commandeId) {
		this.commandeId = commandeId;
	}

	public Livre getLivre() {
		return this.livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	public Personne getPersonne() {
		return this.personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

}