package in.nitech.service;

import java.util.List;

import in.nitech.model.Contact;

public interface IContactService {
	public Long findContactNumByName(String name);
	public List<Contact> findAll(); 
}
