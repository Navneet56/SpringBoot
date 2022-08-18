package com.zee.zee5app.dto;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
//@Table(name="user_table")

public class User {
	@Id
	//@GeneratedValue(strategy =GenerationType.AUTO )
	@GenericGenerator(name="userIdGenerator",strategy="com.zee.zee5app.utils.UserIdGenerator")
	@GeneratedValue(generator = "userIdGenerator")
	private String UserId;
	@Size(max=50)
	@NotNull
	private String firstName;
	@Size(max=50)
	@NotNull
	private String username;
	@NotNull
	private String password;
	@Size(max=50)
	@NotNull
	private String lastName;
	@Size(max=50)
	@Email
	private String email;
	//@Temporal(TemporalType.DATE)
	@Column(columnDefinition = "DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
	private LocalDate doj;
	//@Temporal(TemporalType.DATE)
	@Column(columnDefinition = "DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
	private LocalDate dob;
	private boolean isActive;
	

}
