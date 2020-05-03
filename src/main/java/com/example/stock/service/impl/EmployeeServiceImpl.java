package com.example.stock.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.Dao.EmployeDao;
import com.example.stock.Utilis.DateUlils;
import com.example.stock.bean.Employe;
import com.example.stock.bean.Notification;
import com.example.stock.bean.NotificationEmploye;
import com.example.stock.bean.SalaireEmploye;
import com.example.stock.service.facade.EmployeService;
import com.example.stock.service.facade.GradeEmployeService;
import com.example.stock.service.facade.NotificationEmployeService;
import com.example.stock.service.facade.SalaireEmployeService;

@Service
public class EmployeeServiceImpl implements EmployeService {
@Autowired
private EmployeDao employeDao;
@Autowired
private SalaireEmployeService salaireEmployeService;
@Autowired
private GradeEmployeService gradeEmployeService;
@Autowired
private NotificationEmployeService notificationEmployeService;


@Override
public List<Employe> findAll() {
	return employeDao.findAll();
}

@Override
public int save(Employe employe) {
	if(findByid(employe.getId())!= null) {
return -1;
}else {
	/* khas ikon date de sortie =null
	khas ikon date entrée ! = null
			khas ikon ga3 les champs 3amrin le nom et email ghadi iverifia forme dialhoom
			khas ikon cin ma kayenex 3and chi wajed akher
			khas ikon doti ma kayenex 3and chi wahed akher
			khas ikon age <30*/
	//ghadi ncree grade dil dak employe ou ndiro dik grade hi dernier grade
	//ghadi ncree solde employe net en fonction de  grade khasna ncriw fonction returni salaire net en fonction de grade
	// ghadi nzido les salaire akherin
	// ghadi ncriw solde congé 
   // ghadi ndiro date de prochaine evalution , note,
		employeDao.save(employe);
		return 1;
}
	}

@Override
public Employe findByid(Long id) {
	if (employeDao.findById(id).isPresent()) {
		return employeDao.findById(id).get();
	} else
		return null;
}

@Override
public int deleteById(Long id) {
	employeDao.deleteById(id);
	if (findByid(id) == null) {
		return 1;
	} else
		return -1;
}

@Override
public int nombreDesEmployes() {
	return findAll().size();
}

@Override
public int nombreDesEmployesParDepartements(String nomDepartement) {
	List<Employe> employes = findAll();
	List<Employe> resultat = new ArrayList<Employe>();
	employes.forEach(e->{
		if(e.getDep().getNom().equals(nomDepartement))
			resultat.add(e);
	});
	return resultat.size();
}
@Override
public int nombreDesEmployesParAnneeDeEntré(Integer annee) {
	List<Employe> employes = findAll();
	List<Employe> resultat = new ArrayList<Employe>();
	employes.forEach(e->{
		if(DateUlils.getYear(e.getDateEntree()) == annee)
			resultat.add(e);
	});
	return resultat.size();
}
@Override
public List<Employe> EmployesParAnneeDeEntré(Integer annee) {
	List<Employe> employes = findAll();
	List<Employe> resultat = new ArrayList<Employe>();
	employes.forEach(e->{
		if(DateUlils.getYear(e.getDateEntree()) == annee)
			resultat.add(e);
	});
	return resultat;
}
@Override
public Double MoyenDeSalaireParAnnee(int annee) {
	Double  SomMontant = 0.0;
	List<Employe> resultat = new ArrayList<Employe>();
	List<Employe> employes = new ArrayList<Employe>();
	for (int i = 2010; i < annee; i++) {
		Integer ans = Integer.valueOf(i);
			employes.addAll(EmployesParAnneeDeEntré(ans));
		}
for (Employe employe : employes) {
SalaireEmploye salaireEmploye=salaireEmployeService.findByid(employe.getId());
	SomMontant += salaireEmploye.getSalaireNet();
}
	return SomMontant/resultat.size();
}

@Override
public Employe findByCin(Integer cin) {
	return employeDao.findByCin(cin);
}

@Override
public Employe findByDoti(Integer doti) {
	return employeDao.findByDoti(doti);
}

@Override
public Employe findByEmail(String email) {
	return employeDao.findByEmail(email);
}


@Override
public List<Employe> findBySupId(Long id) {
	return employeDao.findBySupId(id);
}

@Override
public List<Employe> findByDateAvancementPrevue(Date dateAvancementPrevue) {
	return employeDao.findByDateAvancementPrevue(dateAvancementPrevue);
}

@Override
public List<Employe> findByDateDeProchainNote(Date dateDeProchainNote) {
	return employeDao.findByDateDeProchainNote(dateDeProchainNote);
}

@Override
public List<Employe> findByDateProchainEvaluation(Date dateProchainEvaluation) {
	return employeDao.findByDateProchainEvaluation(dateProchainEvaluation);
}
@Override
public List<Employe> findLesEmployeAyantEvaluationAujourdHui(){
Date dateAujourdHui= new Date();
List<Employe> employes = findAll();
Notification notification = new Notification("evaluation est ahjourd'ui");
List<Employe> resultat = new ArrayList<Employe>();
for (Employe employe : employes) {
	if(employe.getDateProchainEvaluation()== dateAujourdHui) {
		resultat.add(employe);
		NotificationEmploye notificationEmploye = new NotificationEmploye();
		notificationEmploye.setDateDeNotification(dateAujourdHui);
		notificationEmploye.setEmploye(employe);
		notificationEmploye.setNotification(notification);
		notificationEmploye.setLibelle("non lus");
	}
}
return resultat;
}
@Override
public List<Employe> findLesEmployeAyantAvancementAujourdHui(){
Date dateAujourdHui= new Date();
List<Employe> employes = findAll();
Notification notification = new Notification("avancement est Anjourd'hui");
List<Employe> resultat = new ArrayList<Employe>();
for (Employe employe : employes) {
	if(employe.getDateAvancementPrevue()== dateAujourdHui) {
		resultat.add(employe);
		NotificationEmploye notificationEmploye = new NotificationEmploye();
		notificationEmploye.setDateDeNotification(dateAujourdHui);
		notificationEmploye.setEmploye(employe);
		notificationEmploye.setNotification(notification);
		notificationEmploye.setLibelle("non lus");
		//cree rapport de Evaluation
		//enregistrer les notes generale  et calculer la moyen et la mention
		//enregistrer cree nouveau grade sitier ce grade comme dernier grade en employe et dans rapport
		//enregistrer les punition dans rapport
		//enregistrer les prix dans rapport
		//enregistrer les formation dans rapport
	}
}
return resultat;
}
@Override
public List<Employe> findLesEmployeAyantLaNoteGeneraleAujourdHui(){
Date dateAujourdHui= new Date();
List<Employe> employes = findAll();
Notification notification = new Notification("note générale est aujourd'hui");
List<Employe> resultat = new ArrayList<Employe>();
for (Employe employe : employes) {
	if(employe.getDateDeProchainNote()== dateAujourdHui) {
		resultat.add(employe);
		NotificationEmploye notificationEmploye = new NotificationEmploye();
		notificationEmploye.setDateDeNotification(dateAujourdHui);
		notificationEmploye.setEmploye(employe);
		notificationEmploye.setNotification(notification);
		notificationEmploye.setLibelle("non lus");
	}
}
return resultat;
}

@Override
public List<Employe> findBySoldeRestantesCongéExceptionnel(Integer soldeRestantesCongéExceptionnel) {
	return employeDao.findBySoldeRestantesCongéExceptionnel(soldeRestantesCongéExceptionnel);
}
}