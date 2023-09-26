package com.bubblebear.backendProject.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="orders")


public class Orders {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer order_id;
	private Date purchase_date;
	private int total_amount;
	private int fk_user_id;
	
	

	
	
	
}
