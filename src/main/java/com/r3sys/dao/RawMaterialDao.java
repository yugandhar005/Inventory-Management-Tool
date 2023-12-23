package com.r3sys.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.r3sys.model.RawMaterial;

@Component
public class RawMaterialDao {
@Autowired
	private HibernateTemplate hibernateTemplate;
	// inserting the data
	@Transactional //for making transaction with database like insert, delete, update
	public int insert(RawMaterial rawmaterial) {
	// insert
	Integer i = (Integer) this.hibernateTemplate.save(rawmaterial);
	return i;
	}
	// get the single data(object)
	public RawMaterial getRawMaterial(int rawmaterialId) {
	RawMaterial rawmaterial = this.hibernateTemplate.get(RawMaterial.class, rawmaterialId);
	return rawmaterial;
	}
	
	public RawMaterial getid(int id) {
		RawMaterial rawmaterial = this.hibernateTemplate.get(RawMaterial.class, id);
		return rawmaterial;
		}

	public List<RawMaterial> getAllRawmaterial() {
	List<RawMaterial> rawmaterials = this.hibernateTemplate.loadAll(RawMaterial.class);
	return rawmaterials;
	}
	// deleting the data
	@Transactional //for making transaction with database like insert, delete, update
	public void deleterawmaterial(int rawmaterialId) {
	RawMaterial rawmaterial = this.hibernateTemplate.get(RawMaterial.class, rawmaterialId);
	this.hibernateTemplate.delete(rawmaterial);
	}
	// updating data...
	@Transactional //for making transaction with database like insert, delete, update
	public void updateQuantity(RawMaterial rawmaterial) {
	this.hibernateTemplate.update(rawmaterial);
	}
	public HibernateTemplate getHibernateTemplate() {
	return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	this.hibernateTemplate = hibernateTemplate;
	}
	
}
