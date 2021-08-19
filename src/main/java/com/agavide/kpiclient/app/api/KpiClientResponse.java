package com.agavide.kpiclient.app.api;

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
@Schema(description = "KPI Client response.")
@Data
public class KpiClientResponse {
	
	@JsonProperty(value = "averageAge", required = false)
	@Schema(description = "Clients age average.", required = false)
	private Double averageAge = 0.0;
	
	@JsonProperty(value = "ageStandardDeviation", required = false)
	@Schema(description = "Clients age standard deviation.", required = false)
	private Double ageStandardDeviation = 0.0;

}
