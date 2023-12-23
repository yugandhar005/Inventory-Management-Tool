package com.r3sys.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.r3sys.model.IssueProcessed;
@Component
public class IssueProcessedDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	// inserting the data
	@Transactional //for making transaction with database like insert, delete, update
	public int insert(IssueProcessed issueProcessed) {
	// insert
	Integer i = (Integer) this.hibernateTemplate.save(issueProcessed);
	return i;
	}
	// get the single data(object)
	public IssueProcessed getIssueProcessed(int issueProcessedId) {
	IssueProcessed issueProcessed = this.hibernateTemplate.get(IssueProcessed.class, issueProcessedId);
	return issueProcessed;
	}
	
	public IssueProcessed getid(int id) {
		IssueProcessed issueProcessed = this.hibernateTemplate.get(IssueProcessed.class, id);
		return issueProcessed;
		}

	public List<IssueProcessed> getAllIssueProcessed() {
	List<IssueProcessed> issueProcesseds = this.hibernateTemplate.loadAll(IssueProcessed.class);
	return issueProcesseds;
	}
	// deleting the data
	@Transactional //for making transaction with database like insert, delete, update
	public void deleteissueProcessed(int issueProcessedId) {
	IssueProcessed issueProcessed = this.hibernateTemplate.get(IssueProcessed.class, issueProcessedId);
	this.hibernateTemplate.delete(issueProcessed);
	}
	// updating data...
	@Transactional //for making transaction with database like insert, delete, update
	public void updateQuantity(IssueProcessed issueProcessed) {
	this.hibernateTemplate.update(issueProcessed);
	}
	public HibernateTemplate getHibernateTemplate() {
	return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	this.hibernateTemplate = hibernateTemplate;
	}
	
}
