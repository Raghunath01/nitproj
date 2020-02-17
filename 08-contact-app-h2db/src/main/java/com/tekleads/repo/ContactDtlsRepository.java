package com.tekleads.repo;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.tekleads.entity.ContactDtlsEntity;

public interface ContactDtlsRepository extends JpaRepository<ContactDtlsEntity, Integer>{

	List<ContactDtlsEntity> findByActiveSw(Character activeSw);
	
	@Modifying 
	@Transactional
	@Query("update ContactDtlsEntity set activeSw = :activeSw where contactId= :contactId")
	void updateActiveSwById(Character activeSw, Integer contactId);
	
	interface CreationDate{
		Date getDateModified();
	}
	
	CreationDate findByContactId(Integer contactId);
	
}
