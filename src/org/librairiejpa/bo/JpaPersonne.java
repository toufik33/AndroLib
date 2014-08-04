package org.librairiejpa.bo;

import javax.persistence.Column;

public class JpaPersonne {
	//private Integer personneId;
	private String personneNom;
	private String personnePrenom;
	private String personneTel;
	private String personneEmail;
	private String personneAdresse;
	private String personneAdresse1;
	private Integer personneCp;
	private String personneVille;
	//
	
	public String getPersonneNom() {
		return personneNom;
	}

	public void setPersonneNom(String personneNom) {
		this.personneNom = personneNom;
	}

	public String getPersonnePrenom() {
		return personnePrenom;
	}

	public void setPersonnePrenom(String personnePrenom) {
		this.personnePrenom = personnePrenom;
	}

	public String getPersonneTel() {
		return personneTel;
	}

	public void setPersonneTel(String personneTel) {
		this.personneTel = personneTel;
	}

	public String getPersonneEmail() {
		return personneEmail;
	}

	public void setPersonneEmail(String personneEmail) {
		this.personneEmail = personneEmail;
	}

	public String getPersonneAdresse() {
		return personneAdresse;
	}

	public void setPersonneAdresse(String personneAdresse) {
		this.personneAdresse = personneAdresse;
	}

	public String getPersonneAdresse1() {
		return personneAdresse1;
	}

	public void setPersonneAdresse1(String personneAdresse1) {
		this.personneAdresse1 = personneAdresse1;
	}

	public Integer getPersonneCp() {
		return personneCp;
	}

	public void setPersonneCp(Integer personneCp) {
		this.personneCp = personneCp;
	}

	public String getPersonneVille() {
		return personneVille;
	}

	public void setPersonneVille(String personneVille) {
		this.personneVille = personneVille;
	}
	//
	
	public JpaPersonne(String personneNom, String personnePrenom,
			String personneTel, String personneEmail, String personneAdresse,
			String personneAdresse1,Integer Cp, String personneVille) {
		this.personneNom = personneNom;
		this.personnePrenom = personnePrenom;
		this.personneTel = personneTel;
		this.personneEmail = personneEmail;
		this.personneAdresse = personneAdresse;
		this.personneAdresse1 = personneAdresse1;
		this.personneCp = Cp;
		this.personneVille = personneVille;
	}

	

}
