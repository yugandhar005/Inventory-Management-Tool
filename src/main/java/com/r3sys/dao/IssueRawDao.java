package com.r3sys.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.r3sys.model.IssueRaw;

@Component
public class IssueRawDao {
@Autowired
	private HibernateTemplate hibernateTemplate;
	// inserting the data
	@Transactional //for making transaction with database like insert, delete, update
	public int insert(IssueRaw issueRaw) {
	// insert
	Integer i = (Integer) this.hibernateTemplate.save(issueRaw);
	return i;
	}
	// get the single data(object)
	public IssueRaw getIssueRaw(int issueRawId) {
	IssueRaw issueRaw = this.hibernateTemplate.get(IssueRaw.class, issueRawId);
	return issueRaw;
	}
	
	public IssueRaw getid(int id) {
		IssueRaw issueRaw = this.hibernateTemplate.get(IssueRaw.class, id);
		return issueRaw;
		}

	public List<IssueRaw> getAllIssueRaw() {
	List<IssueRaw> issueRaws = this.hibernateTemplate.loadAll(IssueRaw.class);
	return issueRaws;
	}
	// deleting the data
	@Transactional //for making transaction with database like insert, delete, update
	public void deleteissueRaw(int issueRawId) {
	IssueRaw issueRaw = this.hibernateTemplate.get(IssueRaw.class, issueRawId);
	this.hibernateTemplate.delete(issueRaw);
	}
	// updating data...
	@Transactional //for making transaction with database like insert, delete, update
	public void updateQuantity(IssueRaw issueRaw) {
	this.hibernateTemplate.update(issueRaw);
	}
	public HibernateTemplate getHibernateTemplate() {
	return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	this.hibernateTemplate = hibernateTemplate;
	}
	
}
