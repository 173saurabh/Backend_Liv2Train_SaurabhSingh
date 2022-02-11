package com.example.happyhealth2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Address 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "address_id" , nullable = false)
	private Long addressId;
	
	@Column(name="detailed_address",nullable=false)
	public String detailedAddress;
	
	@Column(name="city",nullable=false)
	public String city;
	
	@Column(name="state",nullable=false)
	public String state;
	
	@Column(name="pincode",nullable=false)
	public Long pincode;
	
	//One to One mapping with training center
	 @OneToOne(mappedBy = "address")
	 private TrainingCenter trainingCenter;
}
