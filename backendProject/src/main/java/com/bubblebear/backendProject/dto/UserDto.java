package com.bubblebear.backendProject.dto;

import java.util.Date;

import com.bubblebear.backendProject.entity.limits.UserFieldLimits;

import jakarta.validation.constraints.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto implements UserFieldLimits {
	
	private long id;
	
	@NotEmpty(message = "Fullname should not be null or empty")
	@Size(min= FULLNAME_MIN_LENGTH, max= FULLNAME_MAX_LENGTH, 
			message = "Fullname must be between " + FULLNAME_MIN_LENGTH + " and "+ FULLNAME_MAX_LENGTH + " characters")
	private String fullname; 
	
	@NotEmpty(message = "E-mail should not be null or empty")
	@Email(message = "Email address should be valid", regexp="^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,10}")
	@Size(min= EMAIL_MIN_LENGTH, max= EMAIL_MAX_LENGTH, 
			message = "E-mail must be between " + EMAIL_MIN_LENGTH + " and "+ EMAIL_MAX_LENGTH + " characters")
	private String email; 
	
	@Past( message = "Birthdate must be in the past.")
	private Date birthday; 
	
	@NotEmpty(message = "Phone Number should not be null or empty")
	@Pattern(message = "Phone number must be a 10-digit number", regexp = "\\d{10}")
	@Size(min= PHONE_NUMBER_MIN_LENGTH, max=  PHONE_NUMBER_MAX_LENGTH, 
			message = "Phone Number must be between " +  PHONE_NUMBER_MIN_LENGTH + " and "+ PHONE_NUMBER_MAX_LENGTH + " characters")
	private String phone_number;
	
}
	