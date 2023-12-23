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

import com.r3sys.dao.IssueProcessedDao;
import com.r3sys.dao.ProcessedMaterialDao;
import com.r3sys.dao.ProcessedMaterialDao;
import com.r3sys.model.IssueProcessed;
import com.r3sys.model.ProcessedMaterial;
import com.r3sys.model.ProcessedMaterial;

@Controller
public class ProcessedMaterialController {

	@RequestMapping("/Addprocessed")
	public String addProcessedMaterial()
	{
	return "addprocessed";
	}
	@RequestMapping("/addprocessed")
	public String addprocessedmaterial(@ModelAttribute ProcessedMaterial processedMaterial, HttpServletRequest request)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		ProcessedMaterialDao processedMaterialDao = (ProcessedMaterialDao) context.getBean("processedMaterialDao", ProcessedMaterialDao.class);
		int i = processedMaterialDao.insert(processedMaterial);
		if(i>0)
		{
	        return "dashboard";
		}
	else
    	{
		return "";
    	}
		
	}
	@RequestMapping("/ViewProcessed")
	public String viewProcessedMaterial(Model m)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		ProcessedMaterialDao processedMaterialDao = (ProcessedMaterialDao) context.getBean("processedMaterialDao", ProcessedMaterialDao.class);
	  List<ProcessedMaterial> processedMaterial = processedMaterialDao.getAllProcessedmaterial();
	  m.addAttribute("processedMaterial",processedMaterial);
	return "viewprocessed";
	}
@RequestMapping(path="/deleteProcessed/{pmId}",method=RequestMethod.GET)
public RedirectView deleteProcessedMaterial(@PathVariable("pmId") int pmId,HttpServletRequest request)
{
	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	ProcessedMaterialDao processedMaterialDao = (ProcessedMaterialDao) context.getBean("processedMaterialDao", ProcessedMaterialDao.class);
	processedMaterialDao.deleteprocessedmaterial(pmId);
	RedirectView  redirectView = new RedirectView();
	redirectView.setUrl(request.getContextPath()+"/ViewProcessed");
	return redirectView;
}
@RequestMapping(value="/updatepro",method=RequestMethod.GET)
public String updateProcessedMaterial(@RequestParam int id,Model m)
{
	m.addAttribute("id",id);
	return "updatepro";
}

@RequestMapping("/updateProcessedMaterial")
public RedirectView updateProcessedMat(HttpServletRequest request)
{
	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	ProcessedMaterialDao processedMaterialDao = (ProcessedMaterialDao) context.getBean("processedMaterialDao", ProcessedMaterialDao.class);
	int quantity=Integer.parseInt(request.getParameter("quantity"));
	int id=Integer.parseInt(request.getParameter("id"));
	
	ProcessedMaterial processedmaterial = processedMaterialDao.getid(id);
	processedmaterial.setQuantity(processedmaterial.getQuantity()+quantity);
	processedMaterialDao.updateQuantity(processedmaterial);
	
	RedirectView rv=new RedirectView();
	rv.setUrl(request.getContextPath()+"/ViewProcessed");
	return rv;
    }
@RequestMapping(value="/issuepro",method=RequestMethod.GET)
public String issuepage(@RequestParam int id,String name, Model m)
{
	m.addAttribute("id", id);
	m.addAttribute("name",name);
	System.out.println(id);
	System.out.println(name);
	return "issuepro";
}

@RequestMapping("/issuepro")
public RedirectView issueRaw(@ModelAttribute  IssueProcessed issueProcessed, HttpServletRequest request)
{
	ApplicationContext c=new ClassPathXmlApplicationContext("config.xml");
	ProcessedMaterialDao processedMaterialDao=(ProcessedMaterialDao) c.getBean("processedMaterialDao");
	IssueProcessedDao issueProcessedDao= (IssueProcessedDao) c.getBean("issueProcessedDao");
	
	int new_quantity=Integer.parseInt(request.getParameter("quantity"));
	int id=Integer.parseInt(request.getParameter("pid"));
	
	ProcessedMaterial issueprocessed=processedMaterialDao.getid(id); 
	if(issueprocessed.getQuantity()>=new_quantity) 
	{
	issueprocessed.setQuantity(issueprocessed.getQuantity()-new_quantity);
	processedMaterialDao.updateQuantity(issueprocessed);
	issueProcessedDao.insert(issueProcessed);
	RedirectView redirectView =new RedirectView();
	redirectView.setUrl(request.getContextPath()+"/Viewlog");
	return redirectView;
	
} 
	else{
	RedirectView redirectView = new RedirectView();
	redirectView.setUrl(request.getContextPath()+"/issuepro");
	return redirectView;
}
}
@RequestMapping("/Viewlog")
public String viewrawlogpage(Model m)
{
	ApplicationContext context =new ClassPathXmlApplicationContext("config.xml");
	IssueProcessedDao issueProcessedDao = (IssueProcessedDao) context.getBean("issueProcessedDao");
	List<IssueProcessed> issueProcessed = issueProcessedDao.getAllIssueProcessed();
	m.addAttribute("issueProcessed", issueProcessed);
	return "viewlogspro";
}
@RequestMapping("/unavailpro")
public String unavailpro(Model m)
{
	ApplicationContext context =new ClassPathXmlApplicationContext("config.xml");
	ProcessedMaterialDao processedMaterialDao = (ProcessedMaterialDao) context.getBean("processedMaterialDao");
	List<ProcessedMaterial> processedMaterial = processedMaterialDao.getAllProcessedmaterial();
	m.addAttribute("processedMaterial", processedMaterial);
	return "viewunavailpro";
}
}

