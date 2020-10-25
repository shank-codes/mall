package com.internshipproject.dlithe.mall;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
//import javax.validation.Valid;


@Controller
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	List<Product> temp;
	static List<Product> temp2=new ArrayList<Product>();
	
	HttpSession session;
	
	@RequestMapping("/")
	public ModelAndView begin()
	{
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/log",method=RequestMethod.POST)
	public ModelAndView let(@RequestParam("user") String user, @RequestParam("pass") String pass, HttpServletRequest request)
	{
		if(user.equalsIgnoreCase("mall")&&pass.equalsIgnoreCase("mall"))
		{
			session=request.getSession();     
			session.setAttribute("authorised", user);
			temp2=new ArrayList<Product>();                //important
			return new ModelAndView("home");
		}
		else {return new ModelAndView("index").addObject("msg", "Unauthorised login");}
	}
	
	@RequestMapping(value="/back")
	public ModelAndView again()
	{
		if(session.getAttribute("authorised")!=null)
		{
			temp2=new ArrayList<Product>();        //important
			return new ModelAndView("home"); }
		else {return new ModelAndView("index");}
	}

	
	@RequestMapping("/add")
	public ModelAndView askToAdd()
	{
		if(session.getAttribute("authorised")!=null)
		return new ModelAndView("import");
		else {return new ModelAndView("index");}
		
	}
	
	@RequestMapping(value="/newstock",method=RequestMethod.POST)
	public ModelAndView addSubmit(Product pro, BindingResult bind)
	{
		if(session.getAttribute("authorised")!=null)
		{
			ModelAndView mod=new ModelAndView("import");
			pro.setTotal(pro.getPpp()*pro.getQuantity());
			if(bind.hasErrors()) {return mod;}   //?
			if(service.newadd(pro)!=null)
			{
				mod.addObject("msg", "Product "+pro.getPname()+" has added in stock");
			}
			else {mod.addObject("msg", "Product "+pro.getPname()+" has not added in stock");}
			return mod;
		}
		else {return new ModelAndView("index");}
		
	}
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView traverse()
	{
		if(session.getAttribute("authorised")!=null)
		{
			temp=service.every();
			return new ModelAndView("show").addObject("all", temp);
		}
		else {return new ModelAndView("index");}
		
	}
	@RequestMapping(value="/editable",method=RequestMethod.GET)
	public ModelAndView editRequest(@RequestParam("id") int id)
	{
		if(session.getAttribute("authorised")!=null)
		{
		
			Product p=service.single(id);
			return new ModelAndView("edit").addObject("one", p);
		}
		
		else {return new ModelAndView("index");}
	}
	
	@RequestMapping(value="/change",method=RequestMethod.POST)
	public ModelAndView editResponse(Product product)
	{
		if(session.getAttribute("authorised")!=null)
		{
		    product.setTotal(product.getPpp()*product.getQuantity());
			service.alter(product);
			return traverse().addObject("msg", product.getPname()+" has updated");
		}
		else {return new ModelAndView("index");}
	}
	
	@RequestMapping(value="/deletable",method=RequestMethod.GET)
	public ModelAndView deleteRequest(@RequestParam("id") int id)
	{
		if(session.getAttribute("authorised")!=null)
		{
		
			Product temp=service.single(id);
			String hold=service.remove(temp);
			return traverse().addObject("msg",hold+" has deleted");
		}
		else {return new ModelAndView("index");}
		
	}
	@RequestMapping(value="/bill1",method=RequestMethod.GET)
	public ModelAndView billRequest1()
	{
		if(session.getAttribute("authorised")!=null)
		return new ModelAndView("billpage");
		else {return new ModelAndView("index");}
	}
	@RequestMapping(value="/bill2",method=RequestMethod.POST)
	public ModelAndView billRequest2(Product product)
	{
		Product pro=service.single(product.getPid());
		temp=service.every();
		if(temp.contains(pro)) {
			if(pro.getQuantity()>=product.getQuantity()) {
				
			product.setPname(pro.getPname());
			product.setPpp(pro.getPpp());
			product.setTotal(product.getPpp() * product.getQuantity());
		temp2.add(product);
		pro.setQuantity(pro.getQuantity()-product.getQuantity());
		pro.setTotal(pro.getQuantity() * pro.getPpp());
		service.alter(pro);
		//System.out.println(temp2);
		return new ModelAndView("billpage");
		}
			else {
				return new ModelAndView("billpage").addObject("msg","Only "+pro.getQuantity()+" units of  "+pro.getPname()+" is available in stock");
			}
	}
		else {
			return new ModelAndView("billpage").addObject("msg","Invalid product id: "+product.getPid());
		}
	}
	
	@RequestMapping(value="/finalbill",method=RequestMethod.GET)
	public ModelAndView finalBillRequest()
	{
		
		
		return new ModelAndView("finalbill").addObject("one",temp2);
		
	}
	@RequestMapping(value="/newbill",method=RequestMethod.GET)
	public ModelAndView newbillRequest()
	{
		temp2=new ArrayList<Product>();
		//System.out.println(temp2);
		return new ModelAndView("billpage");
		
	}
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public ModelAndView out()
	{
		session.removeAttribute("authorised");
		session.setAttribute("authorised", null);
		return new ModelAndView("index").addObject("msg", "Logged out successfully");
	}

}
