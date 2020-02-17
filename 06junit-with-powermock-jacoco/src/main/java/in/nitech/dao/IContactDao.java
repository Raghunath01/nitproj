package in.nitech.dao;

import java.util.List;

import in.nitech.model.Contact;

public interface IContactDao {
	public Long findContactNumByName(String name);
	public List<Contact> findAll(); 
}
