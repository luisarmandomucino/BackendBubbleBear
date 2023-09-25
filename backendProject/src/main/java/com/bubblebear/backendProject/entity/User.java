package com.bubblebear.backendProject.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="users")
public class User {
	@Id
	@Column(name="user_id")
	private long id;


}
