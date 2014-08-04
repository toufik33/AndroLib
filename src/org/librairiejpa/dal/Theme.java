package org.librairiejpa.dal;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the theme database table.
 * 
 */
@Entity
@NamedQuery(name="Theme.findAll", query="SELECT t FROM Theme t")
public class Theme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="theme_id")
	private Integer themeId;

	@Column(name="theme_nom")
	private String themeNom;

	//bi-directional many-to-one association to Livre
	@OneToMany(mappedBy="theme")
	private List<Livre> livres;

	public Theme() {
	}

	public Integer getThemeId() {
		return this.themeId;
	}

	public void setThemeId(Integer themeId) {
		this.themeId = themeId;
	}

	public String getThemeNom() {
		return this.themeNom;
	}

	public void setThemeNom(String themeNom) {
		this.themeNom = themeNom;
	}

	public List<Livre> getLivres() {
		return this.livres;
	}

	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}

	public Livre addLivre(Livre livre) {
		getLivres().add(livre);
		livre.setTheme(this);

		return livre;
	}

	public Livre removeLivre(Livre livre) {
		getLivres().remove(livre);
		livre.setTheme(null);

		return livre;
	}

}