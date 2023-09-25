package com.bubblebear.backendProject.entity;
<<<<<<< HEAD
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
=======

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
>>>>>>> 89c095fbc5cd92b3619526fec35f5aefd29a9726
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//@AllArgsConstructor
//@NoArgsConstructor
@Entity
<<<<<<< HEAD
@Data
//@Table(name="users")
public class User {
	@Id
	@Column(name="user_id")
	private long id;
=======
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
>>>>>>> 89c095fbc5cd92b3619526fec35f5aefd29a9726

	
	//@OneToMany(mapperdBy = "users")  @JsonIgnoreProperties("users");

}
