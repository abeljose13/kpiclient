package com.agavide.kpiclient.app.handler;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 
 * @author <a href="mailto:abeljose13@gmail.com">Avelardo Gavide</a>
 *
 */
@Data
@AllArgsConstructor
public class ApiError {

	@JsonProperty
    private HttpStatus status;
	
	@JsonProperty
    private String code;

    @JsonProperty
    private String message;
}
