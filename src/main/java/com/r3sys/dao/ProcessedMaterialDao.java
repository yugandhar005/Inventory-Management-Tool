package com.r3sys.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.r3sys.model.ProcessedMaterial;


@Component
public class ProcessedMaterialDao {
@Autowired
	private HibernateTemplate hibernateTemplate;
	// inserting the data
	@Transactional //for making transaction with database like insert, delete, update
	public int insert(ProcessedMaterial processedmaterial) {
	// insert
	Integer i = (Integer) this.hibernateTemplate.save(processedmaterial);
	return i;
	}
	// get the single data(object)
	public ProcessedMaterial getProcessedMaterial(int processedmaterialId) {
	ProcessedMaterial processedmaterial = this.hibernateTemplate.get(ProcessedMaterial.class, processedmaterialId);
	return processedmaterial;
	}
	
	public ProcessedMaterial getid(int id) {
		ProcessedMaterial processedmaterial = this.hibernateTemplate.get(ProcessedMaterial.class, id);
		return processedmaterial;
		}

	public List<ProcessedMaterial> getAllProcessedmaterial() {
	List<ProcessedMaterial> processedmaterials = this.hibernateTemplate.loadAll(ProcessedMaterial.class);
	return processedmaterials;
	}
	// deleting the data
	@Transactional //for making transaction with database like insert, delete, update
	public void deleteprocessedmaterial(int processedmaterialId) {
	ProcessedMaterial processedmaterial = this.hibernateTemplate.get(ProcessedMaterial.class, processedmaterialId);
	this.hibernateTemplate.delete(processedmaterial);
	}
	// updating data...
	@Transactional //for making transaction with database like insert, delete, update
	public void updateQuantity(ProcessedMaterial processedmaterial) {
	this.hibernateTemplate.update(processedmaterial);
	}
	public HibernateTemplate getHibernateTemplate() {
	return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	this.hibernateTemplate = hibernateTemplate;
	}
	
}
