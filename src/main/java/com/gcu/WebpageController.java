/* Created by Rhese Soemo */
/* For CST-323 Cloud Computing */
/* On 1/7/2021 */
/* This is my own work */

package com.gcu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//framework
@Controller
@RequestMapping("")
public class WebpageController
{
	@Autowired
	private DatabaseInterface database;
	
	/* ===== CREATE ===== */
	@GetMapping("/add")
	public String AdditionPage(Model model)
	{
		System.out.println("[System | Webpage Controller] Addition page called by a client\n");		
		return "createObject";
	}
	
	@RequestMapping("/saveaddition")
	public String SaveAddition(ObjectModel newObject, Model model)
	{
		System.out.println("[System | Webpage Controller] A client is saving a new object");
		System.out.println("          " + newObject.toString() + "\n");
		database.createObject(newObject);
		return "redirect:/";
	}
	
	/* ===== READ ===== */
	@RequestMapping(value = "", method = RequestMethod.GET)
	@GetMapping("/")
	public String HomePage(Model model)
	{
		System.out.println("[System | Webpage Controller] Home page called by a client\n");
		model.addAttribute("objects", database.readObjects());		
		return "readObjects";
	}
	
	/* ===== UPDATE ===== */
	@PostMapping("/modify")
	public String ModificationPage(ObjectModel object, Model model)
	{
		System.out.println("[System | Webpage Controller] Modification page called by a client");
		System.out.println("          " + object.toString() + "\n");
		model.addAttribute("object", object);
		return "updateObject";
	}
	
	@RequestMapping("/saveupdate")
	public String SaveUpdate(ObjectModel newObject, Model model)
	{
		System.out.println("[System | Webpage Controller] A client is updating an object");
		System.out.println("          " + newObject.toString() + "\n");
		database.updateObject(newObject);
		return "redirect:/";
	}
	
	/* ===== DELETE ===== */
	@PostMapping("/remove")
	public String RemovePage(ObjectModel om, Model model)
	{
		System.out.println("[System | Webpage Controller] Remove page called by a client");
		System.out.println("          " + om.toString() + "\n");
		model.addAttribute("object", om);		
		return "deleteObject";
	}
	
	@RequestMapping("/savedelete")
	public String SaveDelete(ObjectModel om, Model model)
	{
		System.out.println("[System | Webpage Controller] A client is deleting an object");
		System.out.println("          " + om.toString() + "\n");
		database.deleteObject(om);
		return "redirect:/";
	}
	
	/* ===== TEST ==== */
	@GetMapping("/test")
	public String Test(Model model)
	{
		System.out.println("[System | Webpage Controller] A client is running the test page");
		return "testPage";
	}
}