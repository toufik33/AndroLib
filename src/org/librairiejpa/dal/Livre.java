package org.librairiejpa.dal;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the livre database table.
 * 
 */
@Entity
@NamedQuery(name="Livre.findAll", query="SELECT l FROM Livre l")
public class Livre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="livre_id")
	private Integer livreId;

	@Column(name="livre_couverture")
	private String livreCouverture;

	@Temporal(TemporalType.DATE)
	@Column(name="livre_date")
	private Date livreDate;

	@Column(name="livre_format")
	private String livreFormat;

	@Column(name="\"livre_ISBN\"")
	private String livre_ISBN;

	@Column(name="livre_latitude")
	private String livreLatitude;

	@Column(name="livre_longitude")
	private String livreLongitude;

	@Column(name="livre_resume")
	private String livreResume;

	@Column(name="livre_titre")
	private String livreTitre;

	//bi-directional many-to-one association to Commande
	@OneToMany(mappedBy="livre")
	private List<Commande> commandes;

	//bi-directional many-to-one association to Collection
	@ManyToOne
	@JoinColumn(name="livre_collection")
	private Collection collection;

	//bi-directional many-to-one association to Media
	@ManyToOne
	@JoinColumn(name="livre_media")
	private Media media;

	//bi-directional many-to-one association to Theme
	@ManyToOne
	@JoinColumn(name="livre_theme")
	private Theme theme;

	//bi-directional many-to-one association to Type
	@ManyToOne
	@JoinColumn(name="livre_type")
	private Type type;

	//bi-directional many-to-one association to Livreauteur
	@OneToMany(mappedBy="livre")
	private List<Livreauteur> livreauteurs;

	public Livre() {
	}

	public Integer getLivreId() {
		return this.livreId;
	}

	public void setLivreId(Integer livreId) {
		this.livreId = livreId;
	}

	public String getLivreCouverture() {
		return this.livreCouverture;
	}

	public void setLivreCouverture(String livreCouverture) {
		this.livreCouverture = livreCouverture;
	}

	public Date getLivreDate() {
		return this.livreDate;
	}

	public void setLivreDate(Date livreDate) {
		this.livreDate = livreDate;
	}

	public String getLivreFormat() {
		return this.livreFormat;
	}

	public void setLivreFormat(String livreFormat) {
		this.livreFormat = livreFormat;
	}

	public String getLivre_ISBN() {
		return this.livre_ISBN;
	}

	public void setLivre_ISBN(String livre_ISBN) {
		this.livre_ISBN = livre_ISBN;
	}

	public String getLivreLatitude() {
		return this.livreLatitude;
	}

	public void setLivreLatitude(String livreLatitude) {
		this.livreLatitude = livreLatitude;
	}

	public String getLivreLongitude() {
		return this.livreLongitude;
	}

	public void setLivreLongitude(String livreLongitude) {
		this.livreLongitude = livreLongitude;
	}

	public String getLivreResume() {
		return this.livreResume;
	}

	public void setLivreResume(String livreResume) {
		this.livreResume = livreResume;
	}

	public String getLivreTitre() {
		return this.livreTitre;
	}

	public void setLivreTitre(String livreTitre) {
		this.livreTitre = livreTitre;
	}

	public List<Commande> getCommandes() {
		return this.commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public Commande addCommande(Commande commande) {
		getCommandes().add(commande);
		commande.setLivre(this);

		return commande;
	}

	public Commande removeCommande(Commande commande) {
		getCommandes().remove(commande);
		commande.setLivre(null);

		return commande;
	}

	public Collection getCollection() {
		return this.collection;
	}

	public void setCollection(Collection collection) {
		this.collection = collection;
	}

	public Media getMedia() {
		return this.media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	public Theme getTheme() {
		return this.theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public List<Livreauteur> getLivreauteurs() {
		return this.livreauteurs;
	}

	public void setLivreauteurs(List<Livreauteur> livreauteurs) {
		this.livreauteurs = livreauteurs;
	}

	public Livreauteur addLivreauteur(Livreauteur livreauteur) {
		getLivreauteurs().add(livreauteur);
		livreauteur.setLivre(this);

		return livreauteur;
	}

	public Livreauteur removeLivreauteur(Livreauteur livreauteur) {
		getLivreauteurs().remove(livreauteur);
		livreauteur.setLivre(null);

		return livreauteur;
	}

}