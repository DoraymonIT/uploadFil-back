package com.example.stock.service.facade;

import java.util.List;

import com.example.stock.bean.TypeDocument;

public interface TypeDocumentService {
	TypeDocument findByid(Long id);
	TypeDocument findByLibelle(String libelle);
	List<TypeDocument> findAll();
	int save(TypeDocument typeDocument);
	int deleteById(Long id);
}
