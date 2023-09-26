package com.bubblebear.backendProject.entity;
<<<<<<< HEAD

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
=======
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
>>>>>>> f792bf81ed1c23a69d8288392f25bab5f7816b15
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
<<<<<<< HEAD
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;
	
	@Column(name = "fullname")
	private String fullname;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "birthday" )
	private Date birthday;
	
	@Column(name = "phone_number")
	private String phone_number;
	
	@Column(name = "role")
	private Boolean role;
=======
	@Id
	@Column(name="user_id")
	private long id;
>>>>>>> f792bf81ed1c23a69d8288392f25bab5f7816b15

	
	//@OneToMany(mapperdBy = "users")  @JsonIgnoreProperties("users");

}
