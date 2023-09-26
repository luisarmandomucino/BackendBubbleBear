package com.bubblebear.backendProject.entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
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
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	
	@Column(name = "user_id")
	private Long id;
	
	@Column(name = "fullname", nullable = false, length = 150)
	private String fullname;
	
	@Column(name = "email", nullable = false, length =150, unique = true)
	private String email;
	
	@Column(name = "password", nullable = false, length = 200)
	private String password;
	
	@Column(name = "birthday" )
	private Date birthday;
	
	@Column(name = "phone_number")
	private String phone_number;
	
	@Column(name = "role")
	private Boolean role;
	

	public User(String fullname, String email, String password, 
			Date birthday, String phone_number, Boolean role) {
		this.fullname = fullname;
		this.email = email;
		this.password = password;
		this.birthday = birthday;
		this.phone_number = phone_number;
		this.role = role;
	}

	/*
	@OneToMany(mapperdBy = "user")  
	@JsonIgnoreProperties("user")
	private List<Orders> orders = new ArrayList<>(); */

}
