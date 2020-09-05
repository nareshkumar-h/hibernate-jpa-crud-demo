package com.charityapp.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Sequence or AUTO_INCREMENT
	private Integer id;

	private String name;

	private String email;

	private String password;

	@Convert(converter = GenderConverter.class)
	//@Enumerated(EnumType.STRING)
	private Gender gender;

	private Boolean active;

	@Column(name = "created_date")
	private LocalDateTime createdDate;

	@Column(name = "modified_date")
	private LocalDateTime modifiedDate;

	@PrePersist
	protected void onCreate() {
		createdDate = LocalDateTime.now();
		modifiedDate = LocalDateTime.now();
	}

	@PreUpdate
	protected void onUpdate() {
		modifiedDate = LocalDateTime.now();
	}
}
