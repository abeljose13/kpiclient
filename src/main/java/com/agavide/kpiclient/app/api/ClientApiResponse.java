package com.agavide.kpiclient.app.api;

import java.time.LocalDate;

import com.agavide.kpiclient.enums.SexEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 
 * @author <a href="mailto:abeljose13@gmail.com">Avelardo Gavide</a>
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "Client API response.")
@Data
public class ClientApiResponse {
	
	@JsonProperty(value = "id")
	@Schema(description = "Client ID.")
	private Long id;
	
	@JsonProperty(value = "firstName", required = true)
	@Schema(description = "Client first name.", required = true)
	private String firstName;
	
	@JsonProperty(value = "lastName", required = true)
	@Schema(description = "Client last name.", required = true)
	private String lastName;

	@JsonProperty(value = "age")
	@Schema(description = "Client age.")
	private Integer age;
	
	@JsonProperty(value = "birthDate", required = true)
	@Schema(description = "Client birth date.", required = true)
	private LocalDate birthDate;
	
	@JsonProperty(value = "sex", required = true)
	@Schema(description = "Client sex.", required = true)
	private SexEnum sex;
	
	@JsonProperty(value = "probableDateOfDeath")
	@Schema(description = "Probable date of death.")
	private LocalDate probableDateOfDeath;
}
