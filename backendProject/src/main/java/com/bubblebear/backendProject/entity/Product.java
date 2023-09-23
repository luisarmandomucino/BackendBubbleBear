package com.bubblebear.backendProject.entity;

import java.util.Locale.Category;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private long id;
	
	@Column(name = "name", nullable = false, length=100)
	private String name;
	
	@Column(name = "price", nullable = false)
	private long price;
	
	@Column(name = "size", nullable = false, length=45)
	private String size;
	
	@Column(name = "stock", nullable = false)
	private long stock;
	
	@Column(name = "hide", nullable = false)
	private long hide;
	
	@Column(name = "description", nullable = false, length=300)
	private String description;
	
	@Column(name = "product_photo", nullable = false, length=65535)
	private String photo;
	
	@Column(name = "fk_categories_id", nullable = false)
	private long categoryId;
	
	@Column(name = "flavor", nullable = false, length=45)
	private String flavor;
	
	/*@ManyToOne
	@JsonIgnoreProperties("products")
	private Category category;*/
}
