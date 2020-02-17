package com.tekleads.service;

import java.util.List;

import com.tekleads.model.Contact;

public interface ContactService {
	
	public boolean saveContact(Contact c);
	public List<Contact> getAllContacts();
	public boolean removeContactById(Integer contactId);
	public Contact getOneContactById(Integer contactId);
	public boolean updateContact(Contact c);
	
}
