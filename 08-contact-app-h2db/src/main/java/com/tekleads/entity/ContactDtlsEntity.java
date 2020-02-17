package com.tekleads.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CONTACT_DTLS")
//@EntityListeners(AuditingEntityListener.class)
public class ContactDtlsEntity {
	@Id
	@GeneratedValue
	@Column(name = "CONTACT_ID")
	private Integer contactId;
	@Column(name = "CONTACT_NAME")
	private String contactName;
	@Column(name = "CONTACT_NUM")
	private Long contactNum;
	@Column(name = "CONTACT_MAIL")
	private String contactMail;
	@Column(name = "ACTIVE_SW")
	private Character activeSw;
	
//	@CreatedDate
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;
	
//	@LastModifiedDate
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
//	private LocalDateTime dateModified;
	private Date dateModified;
	
	/*
	 * @CreatedBy private String createdBy;
	 * 
	 * @LastModifiedBy private String modifiedBy;
	 */}
