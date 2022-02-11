package com.example.happyhealth2.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "training_center")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class TrainingCenter 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "center_id" , nullable = false)
	private Long centerId;
	
	@Column(name = "center_name", nullable = false, length=40)
	private String centerName;
	
	@Column(name = "center_code", nullable = false,length = 12)
	@Size(min=12,max=12)
	private String centerCode;
	
	//One to One mapping with address
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address", referencedColumnName = "address_id")
	public Address address;
	
	@Column(name="student_capacity",nullable=false)
	private Long studentCapacity;
	
	@ElementCollection
	@CollectionTable(name = "courses", joinColumns = @JoinColumn(name = "center_id"))
	@Column(name="courses_offered",nullable=false)
	private List<String> coursesOffered;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_on", columnDefinition= "TIMESTAMP WITH TIME ZONE")
	private Date createdOn;

	@Column(name = "contact_email", nullable = true)
	private String contactEmail;
	
	@Column(name = "contact_phone", nullable = false, unique=true)
	private String contactPhone;
}
