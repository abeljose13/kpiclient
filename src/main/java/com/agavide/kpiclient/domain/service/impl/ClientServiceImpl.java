package com.agavide.kpiclient.domain.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.OptionalDouble;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agavide.kpiclient.app.api.ClientApi;
import com.agavide.kpiclient.app.api.ClientApiResponse;
import com.agavide.kpiclient.app.api.KpiClientResponse;
import com.agavide.kpiclient.domain.model.Client;
import com.agavide.kpiclient.domain.repository.ClientRepository;
import com.agavide.kpiclient.domain.service.ClientService;
import com.agavide.kpiclient.exception.AppException;
import com.agavide.kpiclient.util.KpiCalculation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author <a href="mailto:abeljose13@gmail.com">Avelardo Gavide</a>
 *
 */
@Service
public class ClientServiceImpl implements ClientService {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private ObjectMapper mapper;
	
	
	@Override
	public ClientApi create(ClientApi clientApi) throws AppException {
		
		Client client = mapper.convertValue(clientApi, Client.class);
		
		client = clientRepository.saveAndFlush(client);
		log.info("New Client created with ID: "+client.getId());
		
		return mapper.convertValue(client, ClientApi.class);
	}


	@Override
	public KpiClientResponse getKpis() throws AppException {
		
		KpiClientResponse response = new KpiClientResponse();
		
		List<Client> clients = clientRepository.findAll();
		
		if (!clients.isEmpty()) {
		
			OptionalDouble ageAverage = KpiCalculation.ageAverage(clients);
			
			if (ageAverage.isPresent()) {
				response.setAverageAge(ageAverage.getAsDouble());
			}
			
			Double standardDeviation = KpiCalculation.ageStandardDeviation(clients);
			
			if (standardDeviation != null) {
				response.setAgeStandardDeviation(standardDeviation);
			}
		} else {
			log.error("No data to calculate");
			throw new AppException("No data to calculate", "NO_DATA");
		}
		
		return response;
	}


	@Override
	public List<ClientApiResponse> getAll() throws AppException {
		
		List<ClientApiResponse> result = null;
		
		List<Client> clients = clientRepository.findAll();
		
		try {
			String jsonArray = mapper.writeValueAsString(clients);
		
			result = mapper.readValue(
					jsonArray, mapper.getTypeFactory()
					.constructCollectionType(List.class, ClientApiResponse.class));
			
			result.stream()
					.forEach(c -> c.setProbableDateOfDeath(KpiCalculation.getLifeExpectancy(c)));
			
		} catch (JsonParseException e) {
			throw new AppException("Json Parse Exception", "", e.getCause());
			
		} catch (JsonMappingException e) {
			throw new AppException("Json Mapping Exception", "", e.getCause());
			
		} catch (IOException e) {
			throw new AppException("IO Exception", "", e.getCause());
		}
		
		return result;
	}

}
