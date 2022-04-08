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
		return "createObject";
	}
	
	@RequestMapping("/saveaddition")
	public String SaveAddition(ObjectModel newObject, Model model)
	{
		database.createObject(newObject);
		return "redirect:/";
	}
	
	/* ===== READ ===== */
	@RequestMapping(value = "", method = RequestMethod.GET)
	@GetMapping("/")
	public String HomePage(Model model)
	{
		model.addAttribute("objects", database.readObjects());		
		return "readObjects";
	}
	
	/* ===== UPDATE ===== */
	@PostMapping("/modify")
	public String ModificationPage(ObjectModel object, Model model)
	{
		model.addAttribute("object", object);
		return "updateObject";
	}
	
	@RequestMapping("/saveupdate")
	public String SaveUpdate(ObjectModel newObject, Model model)
	{
		database.updateObject(newObject);
		return "redirect:/";
	}
	
	/* ===== DELETE ===== */
	@PostMapping("/remove")
	public String RemovePage(ObjectModel om, Model model)
	{
		model.addAttribute("object", om);		
		return "deleteObject";
	}
	
	@RequestMapping("/savedelete")
	public String SaveDelete(ObjectModel om, Model model)
	{
		database.deleteObject(om);
		return "redirect:/";
	}
	
	/* ===== TEST ==== */
	@GetMapping("/test")
	public String Test(Model model)
	{
		return "testPage";
	}
}