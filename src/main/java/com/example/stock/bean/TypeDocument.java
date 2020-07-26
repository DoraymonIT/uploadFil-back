package com.example.stock.bean;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class TypeDocument {
@Id
@GeneratedValue(strategy =GenerationType.AUTO )
private Long id;
private String libelle;
private String contentType;
@Lob
private byte[] data;




public TypeDocument() {
	super();
	// TODO Auto-generated constructor stub
}



public TypeDocument(Long id, String libelle, String contentType, byte[] data) {
	super();
	this.id = id;
	this.libelle = libelle;
	this.contentType = contentType;
	this.data = data;
}

public TypeDocument( String libelle, String contentType, byte[] data) {
	super();
	this.libelle = libelle;
	this.contentType = contentType;
	this.data = data;
}


public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getLibelle() {
	return libelle;
}
public void setLibelle(String libelle) {
	this.libelle = libelle;
}
public String getContentType() {
	return contentType;
}
public void setContentType(String contentType) {
	this.contentType = contentType;
}
public byte[] getData() {
	return data;
}
public void setData(byte[] data) {
	this.data = data;
}



@Override
public String toString() {
	return "TypeDocument [id=" + id + ", libelle=" + libelle + ", contentType=" + contentType + ", data="
			+ Arrays.toString(data) + "]";
}



@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((contentType == null) ? 0 : contentType.hashCode());
	result = prime * result + Arrays.hashCode(data);
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
	return result;
}



@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	TypeDocument other = (TypeDocument) obj;
	if (contentType == null) {
		if (other.contentType != null)
			return false;
	} else if (!contentType.equals(other.contentType))
		return false;
	if (!Arrays.equals(data, other.data))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (libelle == null) {
		if (other.libelle != null)
			return false;
	} else if (!libelle.equals(other.libelle))
		return false;
	return true;
}



}
