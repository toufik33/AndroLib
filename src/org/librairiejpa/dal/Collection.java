package org.librairiejpa.dal;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the collection database table.
 * 
 */
@Entity
@NamedQuery(name="Collection.findAll", query="SELECT c FROM Collection c")
public class Collection implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="collection_id")
	private Integer collectionId;

	@Column(name="collection_nom")
	private String collectionNom;

	//bi-directional many-to-one association to Livre
	@OneToMany(mappedBy="collection")
	private List<Livre> livres;

	public Collection() {
	}

	public Integer getCollectionId() {
		return this.collectionId;
	}

	public void setCollectionId(Integer collectionId) {
		this.collectionId = collectionId;
	}

	public String getCollectionNom() {
		return this.collectionNom;
	}

	public void setCollectionNom(String collectionNom) {
		this.collectionNom = collectionNom;
	}

	public List<Livre> getLivres() {
		return this.livres;
	}

	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}

	public Livre addLivre(Livre livre) {
		getLivres().add(livre);
		livre.setCollection(this);

		return livre;
	}

	public Livre removeLivre(Livre livre) {
		getLivres().remove(livre);
		livre.setCollection(null);

		return livre;
	}

}