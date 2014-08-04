package org.librairiejpa.dal;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the utilisateur database table.
 * 
 */
@Entity
@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u")
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="utilisateur_id")
	private Integer utilisateurId;

	@Column(name="utilisateur_login")
	private String utilisateurLogin;

	@Column(name="utilisateur_pwd")
	private String utilisateurPwd;

	//bi-directional many-to-one association to Role
	@OneToMany(mappedBy="utilisateur")
	private List<Role> roles;

	//bi-directional many-to-one association to Personne
	@ManyToOne
	@JoinColumn(name="utilisateur_personne_id")
	private Personne personne;

	public Utilisateur() {
	}

	public Integer getUtilisateurId() {
		return this.utilisateurId;
	}

	public void setUtilisateurId(Integer utilisateurId) {
		this.utilisateurId = utilisateurId;
	}

	public String getUtilisateurLogin() {
		return this.utilisateurLogin;
	}

	public void setUtilisateurLogin(String utilisateurLogin) {
		this.utilisateurLogin = utilisateurLogin;
	}

	public String getUtilisateurPwd() {
		return this.utilisateurPwd;
	}

	public void setUtilisateurPwd(String utilisateurPwd) {
		this.utilisateurPwd = utilisateurPwd;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Role addRole(Role role) {
		getRoles().add(role);
		role.setUtilisateur(this);

		return role;
	}

	public Role removeRole(Role role) {
		getRoles().remove(role);
		role.setUtilisateur(null);

		return role;
	}

	public Personne getPersonne() {
		return this.personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

}