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
public class Users {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "fullname", nullable = false, length=100)
	private String fullname;
	
	@Column(name = "email", nullable = false, updatable = false, unique = true)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "birthday" )
	private Date birthday;
	
	@Column(name = "phone_number", nullable = false )
	private String phone_number;
	
	@Column(name = "role")
	private Boolean role;

	public Users(String fullname, String email, String password, Date birthday, String phone_number, Boolean role) {
	    
		this.fullname = fullname;
	    this.email = email;
	    this.password= password;
	    this.birthday= birthday;
	    this.phone_number= phone_number;
	    this.role= role;
	  
	}
	
	
	//@OneToMany(mapperdBy = "users")  @JsonIgnoreProperties("users");

}
