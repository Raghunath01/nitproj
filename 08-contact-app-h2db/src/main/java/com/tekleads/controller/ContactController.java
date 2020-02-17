package com.tekleads.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tekleads.model.Contact;
import com.tekleads.service.ContactService;

@Controller
public class ContactController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());//getClass() = ContactController.class
	
	@Autowired
	private ContactService contactService;
	
	@RequestMapping("/contactPage")
	public String init(Model model) {
		logger.debug("init method started");
		model.addAttribute("contact", new Contact());
		logger.debug("init method ended");
		return "contact";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String handleSubmitButton(@ModelAttribute("contact")Contact contact, Model model) {
		logger.debug("handleSubmitButton method started");
		boolean flag = contactService.saveContact(contact);
		if(flag) {
			model.addAttribute("message", "Contact Saved Successfuly...");
		}else {
			logger.error("contact not saved");
			model.addAttribute("message", "Contact Not Saved..");
		}
		logger.debug("handleSubmitButton method ended");
		return "redirect:/contactPage";
	}
	
	@RequestMapping("/allContacts")
	public String handleViewAllContactsHyperLink(Model model) {
		logger.debug("handleViewAllContactsHyperLink method started");
		List<Contact> contacts = contactService.getAllContacts();
		model.addAttribute("contacts", contacts);
		logger.debug("handleViewAllContactsHyperLink method ended");
		return "viewContacts";
	}
	
	@RequestMapping("/edit")
	public String handleEditLink(HttpServletRequest req, Model model) {
		logger.debug("handleEditLink method started");
		Integer id = Integer.parseInt(req.getParameter("id"));
		Contact contact = contactService.getOneContactById(id);
		model = (Model) req.getAttribute("model");
		model.addAttribute("contact", contact);
		logger.debug("handleEditLink method ended");
		return "contact";
	}
	
	@RequestMapping("/delete")
	public String handleDeleteLink(@RequestParam Integer id, Model model, RedirectAttributes redirectAttributes) {
		logger.debug("handleDeleteLink method started");
		String msg = null;
		boolean status = contactService.removeContactById(id);
		if(status) {
			msg="Contact Deleted(Soft)";
		}else {
			logger.error("error while deleting record[May be Contact not available in DB Table]");
			msg="Contact Not Available";
		}
		/*
		 * model.addAttribute("msg", msg); handleViewAllContactsHyperLink(model); return "viewContacts";
		 */
		redirectAttributes.addFlashAttribute("msg", msg);
		logger.debug("handleDeleteLink method ended");
		return "redirect:/allContacts";
	}
	
}
