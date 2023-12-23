package com.r3sys.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController
{

	@RequestMapping("/")
    public String home()
    {
        System.out.println("This is home url..");
        return "login";
    }
    @RequestMapping("/login")
    public String about()
    {
        System.out.println("This is about controller..");
        return "login";
    }
    @RequestMapping(path="/LoginAdmin",method=RequestMethod.POST)
    public String aftrLoginPage(HttpServletRequest request, Model m){
    
    String email = request.getParameter("email");
    String pass = request.getParameter("password");
    if(email.equals("admin@gmail.com") && pass.equals("admin"))
    {
    	m.addAttribute("email", email);
    	return "dashboard";
    }
    else   
    {
    	m.addAttribute("email", email);
    	return "fail";	
    }
    }
}
