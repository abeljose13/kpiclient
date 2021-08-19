package com.agavide.kpiclient.domain.service;

import java.util.List;

import com.agavide.kpiclient.app.api.ClientApi;
import com.agavide.kpiclient.app.api.ClientApiResponse;
import com.agavide.kpiclient.app.api.KpiClientResponse;
import com.agavide.kpiclient.exception.AppException;

/**
 * 
 * @author <a href="mailto:abeljose13@gmail.com">Avelardo Gavide</a>
 *
 */
public interface ClientService {

	/**
	 * Create a new Client
	 * 
	 * @param clientApi
	 * @return New {@link ClientApi} object
	 * @throws AppException
	 */
	public ClientApi create(ClientApi clientApi) throws AppException;
	
	/**
	 * Get KPI's values
	 * 
	 * @return A {@link KpiClientResponse} object
	 * @throws AppException
	 */
	public KpiClientResponse getKpis() throws AppException;
	
	/**
	 * Get all Clients
	 * 
	 * @return A {@link ClientApiResponse} object list
	 * @throws AppException
	 */
	public List<ClientApiResponse> getAll() throws AppException;
}
