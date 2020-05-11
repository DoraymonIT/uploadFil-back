package com.example.stock.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.Dao.GradeEmployeDao;
import com.example.stock.bean.GradeEmploye;
import com.example.stock.service.facade.GradeEmployeService;

@Service
public class GradeEmployeServiceImpl implements GradeEmployeService {
@Autowired
private GradeEmployeDao gradeDao;


@Override
public int save(GradeEmploye grade) {
	if(findByid(grade.getId())!= null) {
return -1;
}else {
	gradeDao.save(grade);
		return 1;
}
	}

@Override
public GradeEmploye findByid(Long id) {
	if (gradeDao.findById(id).isPresent()) {
		return gradeDao.findById(id).get();
	} else
		return null;
}

@Override
public int deleteById(Long id) {
	gradeDao.deleteById(id);
	if (findByid(id) == null) {
		return 1;
	} else
		return -1;
}


@Override
public List<GradeEmploye> findAll() {
	return gradeDao.findAll();
}


@Override
public List<GradeEmploye> findByDoti(Integer doti) {
	return gradeDao.findByDoti(doti);
}

@Override
public List<GradeEmploye> findByDateDeAffectation(Date dateAfectation) {
	return gradeDao.findByDateDeAffectation(dateAfectation);
}

@Override
public List<GradeEmploye> findByEtat(String etat) {
	return gradeDao.findByEtat(etat);
}
@Override
public List<GradeEmploye> findGradeNonTraite() {
	return gradeDao.findByEtat("en traitement");
}
}
