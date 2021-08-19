package com.agavide.kpiclient.app.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agavide.kpiclient.app.api.ClientApi;
import com.agavide.kpiclient.app.api.ClientApiResponse;
import com.agavide.kpiclient.app.api.KpiClientResponse;
import com.agavide.kpiclient.domain.service.ClientService;
import com.agavide.kpiclient.exception.AppException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 
 * @author <a href="mailto:abeljose13@gmail.com">Avelardo Gavide</a>
 *
 */
@RestController
@RequestMapping("/api/client")
@Tag(name = "Client Controller", description = "Client KPI services.")
public class ClientController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	private ClientService clientService;
	
	
	@Operation(description = "Create new Client", operationId = "client.create")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Client created.", 
    				content = @Content(schema = @Schema(implementation = ClientApi.class)))
	})
	@PostMapping(produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@Parameter(description = "Client data to be create", required = true)
			@RequestBody ClientApi clientApi) throws AppException {
		
		log.info("Creating a new Client");
		
		clientApi = clientService.create(clientApi);
		
		return new ResponseEntity<ClientApi>(clientApi, HttpStatus.OK);
	}
	
	@Operation(description = "Get all Kpi's", operationId = "meetup.getkpis")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Kpi's showed.", 
    				content = @Content(schema = @Schema(implementation = KpiClientResponse.class)))
	})
	@GetMapping(path = "/kpi", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> getKpis() throws AppException {
		
		log.info("Getting Client Kpi's");
		
		KpiClientResponse response = clientService.getKpis();
		
		return new ResponseEntity<KpiClientResponse>(response, HttpStatus.OK);
	}
	
	@Operation(description = "Get all Clients", operationId = "meetup.showall")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Clients showed.", 
    				content = @Content(schema = @Schema(implementation = ClientApiResponse.class)))
	})
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> showAll() throws AppException {
		
		log.info("Getting all Clients");
		
		List<ClientApiResponse> response = clientService.getAll();
		
		return new ResponseEntity<List<ClientApiResponse>>(response, HttpStatus.OK);
	}
}
