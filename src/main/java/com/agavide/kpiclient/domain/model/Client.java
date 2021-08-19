package com.agavide.kpiclient.domain.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.agavide.kpiclient.enums.SexEnum;

import lombok.Data;

/**
 * 
 * @author <a href="mailto:abeljose13@gmail.com">Avelardo Gavide</a>
 *
 */
@Entity
@Table(name = "client")
@Data
public class Client {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "first_name", length = 30, nullable = false)
    private String firstName;
	
	@Column(name = "last_name", length = 30, nullable = false)
    private String lastName;
	
	@Column(name = "age", nullable = true)
    private Integer age;
	
	@Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "sex", length = 1, nullable = false)
    private SexEnum sex;
	
}
