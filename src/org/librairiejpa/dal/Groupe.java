package org.librairiejpa.dal;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the groupe database table.
 * 
 */
@Entity
@NamedQuery(name="Groupe.findAll", query="SELECT g FROM Groupe g")
public class Groupe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="groupe_id")
	private Integer groupeId;

	@Column(name="groupe_nom")
	private String groupeNom;

	//bi-directional many-to-one association to Role
	@OneToMany(mappedBy="groupe")
	private List<Role> roles;

	public Groupe() {
	}

	public Integer getGroupeId() {
		return this.groupeId;
	}

	public void setGroupeId(Integer groupeId) {
		this.groupeId = groupeId;
	}

	public String getGroupeNom() {
		return this.groupeNom;
	}

	public void setGroupeNom(String groupeNom) {
		this.groupeNom = groupeNom;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Role addRole(Role role) {
		getRoles().add(role);
		role.setGroupe(this);

		return role;
	}

	public Role removeRole(Role role) {
		getRoles().remove(role);
		role.setGroupe(null);

		return role;
	}

}