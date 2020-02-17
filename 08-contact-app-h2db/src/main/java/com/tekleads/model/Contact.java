package com.tekleads.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
	private Integer contactId;
	private String contactName;
	private String contactMail;
	private Long contactNum;
	private Character activeSw;
}
