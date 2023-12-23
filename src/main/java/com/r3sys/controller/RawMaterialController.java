package com.r3sys.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.r3sys.dao.IssueRawDao;
import com.r3sys.dao.RawMaterialDao;
import com.r3sys.model.IssueRaw;
import com.r3sys.model.RawMaterial;


@Controller
public class RawMaterialController {

	
	@RequestMapping("/Addraw")
	public String addRawMaterial()
	{
	return "addraw";
	}
	@RequestMapping("/addraw")
	public String addrawmaterial(@ModelAttribute RawMaterial rawMaterial, HttpServletRequest request)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		RawMaterialDao rawMaterialDao = (RawMaterialDao) context.getBean("rawMaterialDao", RawMaterialDao.class);
		int i = rawMaterialDao.insert(rawMaterial);
		if(i>0)
		{
	        return "dashboard";
		}
	else
    	{
		return "";
    	}
		
	}
	@RequestMapping("/ViewRaw")
	public String viewRawMaterial(Model m)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		RawMaterialDao rawMaterialDao = (RawMaterialDao) context.getBean("rawMaterialDao", RawMaterialDao.class);
	  List<RawMaterial> rawMaterial = rawMaterialDao.getAllRawmaterial();
	  m.addAttribute("rawMaterial",rawMaterial);
	return "viewraw";
	}
@RequestMapping(path="/deleteRaw/{rmId}",method=RequestMethod.GET)
public RedirectView deleteRawMaterial(@PathVariable("rmId") int rmId,HttpServletRequest request)
{
	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	RawMaterialDao rawMaterialDao = (RawMaterialDao) context.getBean("rawMaterialDao", RawMaterialDao.class);
	rawMaterialDao.deleterawmaterial(rmId);
	RedirectView  redirectView = new RedirectView();
	redirectView.setUrl(request.getContextPath()+"/ViewRaw");
	return redirectView;
}
@RequestMapping(value="/update",method=RequestMethod.GET)
public String updateRawMaterial(@RequestParam int id,Model m)
{
	m.addAttribute("id",id);
	return "updateraw";
}

@RequestMapping("/updateRawMaterial")
public RedirectView updateRawMat(HttpServletRequest request)
{
	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	RawMaterialDao rawMaterialDao = (RawMaterialDao) context.getBean("rawMaterialDao", RawMaterialDao.class);
	int quantity=Integer.parseInt(request.getParameter("quantity"));
	int id=Integer.parseInt(request.getParameter("id"));
	
	RawMaterial rawmaterial = rawMaterialDao.getid(id);
	rawmaterial.setQuantity(rawmaterial.getQuantity()+quantity);
	rawMaterialDao.updateQuantity(rawmaterial);
	
	RedirectView rv=new RedirectView();
	rv.setUrl(request.getContextPath()+"/ViewRaw");
	return rv;
    }
@RequestMapping(value="/issueR",method=RequestMethod.GET)
public String issuepage(@RequestParam int id,String name, Model m)
{
	m.addAttribute("id", id);
	m.addAttribute("name",name);
	System.out.println(id);
	System.out.println(name);
	return "issueR";
}

@RequestMapping("/issueR")
public RedirectView issueRaw(@ModelAttribute  IssueRaw issueRaw, HttpServletRequest request)
{
	ApplicationContext c=new ClassPathXmlApplicationContext("config.xml");
	 RawMaterialDao rawMaterialDao=(RawMaterialDao) c.getBean("rawMaterialDao");
	IssueRawDao issueRawDao= (IssueRawDao) c.getBean("issueRawDao");
	
	int new_quantity=Integer.parseInt(request.getParameter("quantity"));
	int id=Integer.parseInt(request.getParameter("pid"));
	
	RawMaterial issueraw = rawMaterialDao.getid(id);
	if(issueraw.getQuantity()>=new_quantity)
	{
	issueraw.setQuantity(issueraw.getQuantity()-new_quantity);
	rawMaterialDao.updateQuantity(issueraw);
	issueRawDao.insert(issueRaw);
	RedirectView redirectView =new RedirectView();
	redirectView.setUrl(request.getContextPath()+"/viewlogs");
	return redirectView;
	
}
	else{
	RedirectView redirectView = new RedirectView();
	redirectView.setUrl(request.getContextPath()+"/issueR");
	return redirectView;
}
}
@RequestMapping("/viewlogs")
public String viewrawlogpage(Model m)
{
	ApplicationContext context =new ClassPathXmlApplicationContext("config.xml");
	IssueRawDao issueRawDao = (IssueRawDao) context.getBean("issueRawDao");
	List<IssueRaw> issueRaw = issueRawDao.getAllIssueRaw();
	m.addAttribute("issueRaw", issueRaw);
	return "viewlogsraw";
}
@RequestMapping("/unavailraw")
public String unavailraw(Model m)
{
	ApplicationContext context =new ClassPathXmlApplicationContext("config.xml");
	RawMaterialDao rawMaterialDao = (RawMaterialDao) context.getBean("rawMaterialDao");
	List<RawMaterial> rawMaterial = rawMaterialDao.getAllRawmaterial();
	m.addAttribute("rawMaterial", rawMaterial);
	return "viewunavailraw";
}
}