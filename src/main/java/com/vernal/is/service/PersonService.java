/**
 * 
 */
package com.vernal.is.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import com.google.gson.JsonSyntaxException;
import com.vernal.is.dto.PersonDTO;
import com.vernal.is.model.EvaluationStatus;
import com.vernal.is.model.Person;
import com.vernal.is.model.PersonList;
import com.vernal.is.model.WorkerProfile;
import com.vernal.is.translator.PersonTranslator;
import com.vernal.is.util.CommonConstants;

/**
 * @author bashelu
 *
 */
@Component
public class PersonService extends BaseService {

	@Resource
	PersonTranslator personTranslator;
	
			
	public Object createPerson(String locale) throws Exception {
		Person person = personTranslator.convertToPerson();
		PersonDTO personDTO= personTranslator.translateToPersonDTO(person,locale);
		String postString = gson.toJson(personDTO);
		try{
			/*HttpEntity<String> entity = preparePost(postString,session);
			ResponseEntity<Object> response = restTemplate.exchange(
					getAPIBaseURL() + CommonConstants.ORGANIZATIONS_BASE_URL+CommonConstants.SLASH+ orgId+
					CommonConstants.PERSONS_BASE_URL,HttpMethod.POST, entity,Object.class);
			return response.getBody();*/
			
			return postString;
		}catch (Exception exception) {
			throw exception;
		}
	}
	
	public Object getPerson(String locale) throws Exception {
		Person person = personTranslator.convertToPerson();
		//PersonDTO personDTO= personTranslator.translateToPersonDTO(person,locale);
		//String postString = gson.toJson(personDTO);
		try{
			/*HttpEntity<String> entity = preparePost(postString,session);
			ResponseEntity<Object> response = restTemplate.exchange(
					getAPIBaseURL() + CommonConstants.ORGANIZATIONS_BASE_URL+CommonConstants.SLASH+ orgId+
					CommonConstants.PERSONS_BASE_URL,HttpMethod.POST, entity,Object.class);
			return response.getBody();*/
			
			return person;
		}catch (Exception exception) {
			throw exception;
		}
	}
	
	public WorkerProfile getPersonProfile() throws IOException {
		File file = new File("worker-profile.json");
		InputStream inputStream = null;
		WorkerProfile workerProfile = null;
		if (!file.exists()) {
			/* if not exists, reading file from appln file path */
			inputStream = this
					.getClass()
					.getClassLoader()
					.getResourceAsStream(
							"com/vernal/is/properties/worker-profile.json");
		} else {
			/* file exists, reading file */
			try {
				inputStream = new FileInputStream("worker-profile.json");
			} catch (FileNotFoundException exception) {
				// LOGGER.error("Error getting getApiConfig:",
				// exception.getMessage());
				throw exception;
			}
		}
		workerProfile = gson.fromJson(
				commonUtil.getStringFromInputStream(inputStream),
				WorkerProfile.class);
		return workerProfile;
	}
	
	public EvaluationStatus getEvaluationStatus() throws IOException {
		File file = new File("evaluation-status.json");
		InputStream inputStream = null;
		EvaluationStatus evaluationStatus = null;
		if (!file.exists()) {
			/* if not exists, reading file from appln file path */
			inputStream = this
					.getClass()
					.getClassLoader()
					.getResourceAsStream(
							"com/vernal/is/properties/evaluation-status.json");
		} else {
			/* file exists, reading file */
			try {
				inputStream = new FileInputStream("evaluation-status.json");
			} catch (FileNotFoundException exception) {
				// LOGGER.error("Error getting getApiConfig:",
				// exception.getMessage());
				throw exception;
			}
		}
		evaluationStatus = gson.fromJson(
				commonUtil.getStringFromInputStream(inputStream),
				EvaluationStatus.class);
		return evaluationStatus;
	}
	
	public PersonList getPersonList() throws IOException {
		File file = new File("person-list.json");
		InputStream inputStream = null;
		PersonList personList = null;
		if (!file.exists()) {
			/* if not exists, reading file from appln file path */
			inputStream = this
					.getClass()
					.getClassLoader()
					.getResourceAsStream(
							"com/vernal/is/properties/person-list.json");
		} else {
			/* file exists, reading file */
			try {
				inputStream = new FileInputStream("person-list.json");
			} catch (FileNotFoundException exception) {
				// LOGGER.error("Error getting getApiConfig:",
				// exception.getMessage());
				throw exception;
			}
		}
		personList = gson.fromJson(
				commonUtil.getStringFromInputStream(inputStream),
				PersonList.class);
		return personList;
	}

	public List<Person> getPersonsByOrgIdAndRoleType(String organizationId,	String roleType, Map<String, String> queryString, HttpSession session) throws IOException {
		 List<Person> personList = null;
		 List<PersonDTO> personDTOList = null;	
		 String parametersList=null;
		try {
				parametersList = translateSplitParams(queryString);
				HttpEntity<String> requestEntity = prepareGet(session); 
				ResponseEntity<Object> response =
								restTemplate.exchange("http://10.213.50.68:9000"  
								+ CommonConstants.ORGANIZATION_BASE_URL+ CommonConstants.SLASH+organizationId + 
								CommonConstants.PERSONS_BASE_URL +CommonConstants.ROLE_BASE_URL +"?"+parametersList.toString(),							
								HttpMethod.GET,requestEntity, Object.class);
				personDTOList = personTranslator.translateToPersonDTOList(response.getBody());
				personList = personTranslator.translateToPersonsList(personDTOList);
				return personList;
		}catch (IOException e) {
			throw e;
		} catch (JsonSyntaxException e) {
			throw e;
		} catch (HttpClientErrorException e) {
			throw e;
		}
	}
}
