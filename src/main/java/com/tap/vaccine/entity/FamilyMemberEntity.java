package com.tap.vaccine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="family_members")
public class FamilyMemberEntity {
	
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="DATE_OF_BIRTH")
	private String dateOfBirth;
	
	@Column(name="ID_PROOF")
	private String idProof;
	
	@Column(name="ID_PROOF_NO")
	private String idProofNo;
	
	@Column(name="MOBILE_NUMBER")
	private long mobileNumber;
	
	@Column(name="VACCINE_TYPE")
	private String vaccineType;
	
	@Column(name="DOSE")
	private String dose;

	public FamilyMemberEntity() {
		
	}

	public FamilyMemberEntity(String name, String gender, String dateOfBirth, String idProof, String idProofNo,
			long mobileNumber, String vaccineType, String dose) {
		this.name = name;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.idProof = idProof;
		this.idProofNo = idProofNo;
		this.mobileNumber = mobileNumber;
		this.vaccineType = vaccineType;
		this.dose = dose;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getIdProof() {
		return idProof;
	}

	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}

	public String getIdProofNo() {
		return idProofNo;
	}

	public void setIdProofNo(String idProofNo) {
		this.idProofNo = idProofNo;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getVaccineType() {
		return vaccineType;
	}

	public void setVaccineType(String vaccineType) {
		this.vaccineType = vaccineType;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}
	
	
	
	

}
