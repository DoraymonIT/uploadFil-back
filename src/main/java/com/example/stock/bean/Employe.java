package com.example.stock.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Employe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String fullName;
private String email;
private String gender;
private Integer cin;
private Integer doti;
private Integer enfants;
private String adresse;
private String pays;//ville
private String situationFamiliale;
@Temporal(TemporalType.DATE)
private Date dateDeNaissance;
private String lieuDeNaissance;
private Integer tel;
@ManyToOne
private Employe sup;
@ManyToOne
private Fonction fonction;
@ManyToOne
private Departement dep;
@Temporal(TemporalType.DATE)
private Date dateEntree;
@Temporal(TemporalType.DATE)
private Date dateSortie;
@JsonProperty(access = Access.WRITE_ONLY)
@ManyToOne()
private GradeEmploye dernierGrade;
private Integer compteBancaireRib;
@JsonProperty(access = Access.WRITE_ONLY)
@ManyToOne
private NoteGeneralDeAnnee dernierNote;
@Temporal(TemporalType.DATE)
private Date dateProchainEvaluation;
@Temporal(TemporalType.DATE)
private Date dateDeProchainNote;
@Temporal(TemporalType.DATE)
private Date dateAvancementPrevue;
private Integer soldeRestantesCongéExceptionnel;


public NoteGeneralDeAnnee getDernierNote() {
	return dernierNote;
}
public void setDernierNote(NoteGeneralDeAnnee dernierNote) {
	this.dernierNote = dernierNote;
}
public Date getDateProchainEvaluation() {
	return dateProchainEvaluation;
}
public void setDateProchainEvaluation(Date dateProchainEvaluation) {
	this.dateProchainEvaluation = dateProchainEvaluation;
}
public Date getDateDeProchainNote() {
	return dateDeProchainNote;
}
public void setDateDeProchainNote(Date dateDeProchainNote) {
	this.dateDeProchainNote = dateDeProchainNote;
}
public Date getDateAvancementPrevue() {
	return dateAvancementPrevue;
}
public void setDateAvancementPrevue(Date dateAvancementPrevue) {
	this.dateAvancementPrevue = dateAvancementPrevue;
}

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Employe() {
	super();
	// TODO Auto-generated constructor stub
}
public String getFullName() {
	return fullName;
}
public void setFullName(String fullName) {
	this.fullName = fullName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public Integer getCin() {
	return cin;
}
public void setCin(Integer cin) {
	this.cin = cin;
}

public Integer getEnfants() {
	return enfants;
}
public void setEnfants(Integer enfants) {
	this.enfants = enfants;
}
public String getAdresse() {
	return adresse;
}
public void setAdresse(String adresse) {
	this.adresse = adresse;
}
public String getPays() {
	return pays;
}
public void setPays(String pays) {
	this.pays = pays;
}
public Date getDateDeNaissance() {
	return dateDeNaissance;
}
public void setDateDeNaissance(Date dateDeNaissance) {
	this.dateDeNaissance = dateDeNaissance;
}
public Integer getTel() {
	return tel;
}
public void setTel(Integer tel) {
	this.tel = tel;
}
public Employe getSup() {
	return sup;
}
public void setSup(Employe sup) {
	this.sup = sup;
}
public Departement getDep() {
	return dep;
}
public void setDep(Departement dep) {
	this.dep = dep;
}
public Date getDateEntree() {
	return dateEntree;
}
public void setDateEntree(Date dateEntree) {
	this.dateEntree = dateEntree;
}
public Date getDateSortie() {
	return dateSortie;
}
public void setDateSortie(Date dateSortie) {
	this.dateSortie = dateSortie;
}

public Integer getDoti() {
	return doti;
}
public void setDoti(Integer doti) {
	this.doti = doti;
}
public String getLieuDeNaissance() {
	return lieuDeNaissance;
}
public void setLieuDeNaissance(String lieuDeNaissance) {
	this.lieuDeNaissance = lieuDeNaissance;
}

public String getSituationFamiliale() {
	return situationFamiliale;
}
public void setSituationFamiliale(String situationFamiliale) {
	this.situationFamiliale = situationFamiliale;
}
public Integer getCompteBancaireRib() {
	return compteBancaireRib;
}
public void setCompteBancaireRib(Integer compteBancaireRib) {
	this.compteBancaireRib = compteBancaireRib;
}
public Integer getSoldeRestantesCongéExceptionnel() {
	return soldeRestantesCongéExceptionnel;
}
public void setSoldeRestantesCongéExceptionnel(Integer soldeRestantesCongéExceptionnel) {
	this.soldeRestantesCongéExceptionnel = soldeRestantesCongéExceptionnel;
}
public GradeEmploye getDernierGrade() {
	return dernierGrade;
}
public void setDernierGrade(GradeEmploye dernierGrade) {
	this.dernierGrade = dernierGrade;
}
public Fonction getFonction() {
	return fonction;
}
public void setFonction(Fonction fonction) {
	this.fonction = fonction;
}
public Employe(Long id, String fullName, String email, String gender, Integer cin, Integer doti, Integer enfants,
		String adresse, String pays, String situationFamiliale, Date dateDeNaissance, String lieuDeNaissance,
		Integer tel, Employe sup, Fonction fonction, Departement dep, Date dateEntree, Date dateSortie,
		GradeEmploye dernierGrade, Integer compteBancaireRib, NoteGeneralDeAnnee dernierNote,
		Date dateProchainEvaluation, Date dateDeProchainNote, Date dateAvancementPrevue,
		Integer soldeRestantesCongéExceptionnel) {
	super();
	this.id = id;
	this.fullName = fullName;
	this.email = email;
	this.gender = gender;
	this.cin = cin;
	this.doti = doti;
	this.enfants = enfants;
	this.adresse = adresse;
	this.pays = pays;
	this.situationFamiliale = situationFamiliale;
	this.dateDeNaissance = dateDeNaissance;
	this.lieuDeNaissance = lieuDeNaissance;
	this.tel = tel;
	this.sup = sup;
	this.fonction = fonction;
	this.dep = dep;
	this.dateEntree = dateEntree;
	this.dateSortie = dateSortie;
	this.dernierGrade = dernierGrade;
	this.compteBancaireRib = compteBancaireRib;
	this.dernierNote = dernierNote;
	this.dateProchainEvaluation = dateProchainEvaluation;
	this.dateDeProchainNote = dateDeProchainNote;
	this.dateAvancementPrevue = dateAvancementPrevue;
	this.soldeRestantesCongéExceptionnel = soldeRestantesCongéExceptionnel;
}
@Override
public String toString() {
	return "Employe [id=" + id + ", fullName=" + fullName + ", email=" + email + ", gender=" + gender + ", cin=" + cin
			+ ", doti=" + doti + ", enfants=" + enfants + ", adresse=" + adresse + ", pays=" + pays
			+ ", situationFamiliale=" + situationFamiliale + ", dateDeNaissance=" + dateDeNaissance
			+ ", lieuDeNaissance=" + lieuDeNaissance + ", tel=" + tel + ", sup=" + sup + ", fonction=" + fonction
			+ ", dep=" + dep + ", dateEntree=" + dateEntree + ", dateSortie=" + dateSortie + ", dernierGrade="
			+ dernierGrade + ", compteBancaireRib=" + compteBancaireRib + ", dernierNote=" + dernierNote
			+ ", dateProchainEvaluation=" + dateProchainEvaluation + ", dateDeProchainNote=" + dateDeProchainNote
			+ ", dateAvancementPrevue=" + dateAvancementPrevue + ", soldeRestantesCongéExceptionnel="
			+ soldeRestantesCongéExceptionnel + "]";
}






}
