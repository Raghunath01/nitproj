package com.tekleads.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekleads.entity.ContactDtlsEntity;
import com.tekleads.model.Contact;
import com.tekleads.repo.ContactDtlsRepository;
import com.tekleads.repo.ContactDtlsRepository.CreationDate;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDtlsRepository contactRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(ContactServiceImpl.class);

	
	@Override
	public boolean saveContact(Contact contact) {
		logger.debug("Contact object {}. ",contact);
		ContactDtlsEntity entity = new ContactDtlsEntity();
		BeanUtils.copyProperties(contact, entity);
		entity.setActiveSw('Y');
		if( contact.getContactId()!=null ) {
			int id = contact.getContactId();
			CreationDate creationDate = contactRepo.findByContactId(id);
			logger.info("****************************************");
			logger.info("Modified Date {}.",creationDate.getDateModified());
			logger.info("****************************************");
			entity.setDateCreated(creationDate.getDateModified());
		}
		ContactDtlsEntity savedEntity = contactRepo.save(entity);
		return savedEntity.getContactId() != null;
	}

	@Override
	public List<Contact> getAllContacts() {
		//List<ContactDtlsEntity> findAll = contactRepo.findAll();//-------fetch all records
		List<ContactDtlsEntity> entityList = contactRepo.findByActiveSw('Y');//-----fetch only active records [activeSw = Y]
		List<Contact> contacts = new ArrayList<>();
		for(ContactDtlsEntity entity : entityList) {
			Contact contact = new Contact();
			BeanUtils.copyProperties(entity, contact);
			contacts.add(contact);
		}
		return contacts;
	}

	@Override
	public boolean removeContactById(Integer contactId) {
		//contactRepo.deleteById(contactId);//-----Hard DELETE
		contactRepo.updateActiveSwById('N', contactId);
		return true;
	}

	@Override
	public Contact getOneContactById(Integer contactId) {
		Optional<ContactDtlsEntity> opt = contactRepo.findById(contactId);
		if(opt.isPresent()) {
			ContactDtlsEntity dtlsEntity = opt.get();
			Contact contact = new Contact();
			BeanUtils.copyProperties(dtlsEntity, contact);
			return contact;
		}
		return null;
	}

	@Override
	public boolean updateContact(Contact contact) {
		ContactDtlsEntity entity = new ContactDtlsEntity();
		BeanUtils.copyProperties(contact, entity);
		ContactDtlsEntity savedEntity = contactRepo.save(entity);
		return savedEntity.getContactId() != null;
	}

}
