package com.agavide.kpiclient.util;

import java.time.LocalDate;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.agavide.kpiclient.app.api.ClientApiResponse;
import com.agavide.kpiclient.domain.model.Client;
import com.agavide.kpiclient.enums.SexEnum;

@Component
public class KpiCalculation {
	
	  private static Integer femaleLifeExpectancy;
	  
	  private static Integer maleLifeExpectancy;
	 
	  @Value("${kipclient.lifeexpectancy.female}")
	  public void setFemaleLifeExpectancy(Integer value) {
		  this.femaleLifeExpectancy = value;
	  }
	  
	  @Value("${kipclient.lifeexpectancy.male}")
	  public void setMaleLifeExpectancy(Integer value) {
		  this.maleLifeExpectancy = value;
	  }
	
	/**
	 * Calculates the average age
	 * 
	 * @param clients
	 * @return A {@link OptionalDouble} object
	 */
	public static OptionalDouble ageAverage(List<Client> clients) {
		
		OptionalDouble average = clients.stream()
				.mapToInt((x) -> x.getAge())
				.average();
		
		return average;
	}
	
	/**
	 * Calculate standard deviation of ages
	 * 
	 * @param clients
	 * @return A {@link Double} object
	 */
	public static Double ageStandardDeviation(List<Client> clients) {
		
		double sum = 0.0, standardDeviation = 0.0;
		
		sum = clients.stream()
				.mapToInt((x) -> x.getAge())
				.sum();
		
		Double media = sum/clients.size();
		
		standardDeviation = clients.stream()
				.mapToDouble((x) -> Math.pow(x.getAge() - media, 2))
				.sum();
		
		return Math.sqrt(standardDeviation/clients.size());
	}
	
	/**
	 * Calculate life expectancy
	 * 
	 * @param clientApiResponse
	 * @return A LocalDate
	 */
	public static LocalDate getLifeExpectancy(ClientApiResponse client) {
		
		LocalDate response = null;
		Integer hopeLife = null;
		
		if (client.getSex().equals(SexEnum.F)) {
			
			hopeLife = femaleLifeExpectancy - client.getAge();
							
		} else if (client.getSex().equals(SexEnum.M)) {
		
			hopeLife = maleLifeExpectancy - client.getAge();
		}
		
		Random randon = new Random();
		Integer randomDays = randon.nextInt(90);
		
		response = LocalDate.now().plusYears(hopeLife).plusDays(randomDays.longValue());
		
		return response;
	}

}
