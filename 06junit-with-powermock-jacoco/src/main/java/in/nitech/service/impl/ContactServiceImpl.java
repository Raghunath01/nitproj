package in.nitech.service.impl;

import java.util.List;

import in.nitech.dao.IContactDao;
import in.nitech.exception.DataNotFoundException;
import in.nitech.model.Contact;
import in.nitech.service.IContactService;

public class ContactServiceImpl implements IContactService{

	private IContactDao dao;
	
	public void setDao(IContactDao dao) {
		this.dao = dao;
	}
	
	@Override
	public Long findContactNumByName(String name) {
		 Long num = dao.findContactNumByName(name);
		 if(num==null) {
			 throw new DataNotFoundException("Name is not Available");
		 }
		return num;
	}

	@Override
	public List<Contact> findAll() {
		List<Contact> contacts = dao.findAll();
		if(contacts == null || contacts.isEmpty()) {
			throw new DataNotFoundException("No Contacts available");
		}
		return contacts;
	}
	
}
