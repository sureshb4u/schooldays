/**
 * 
 */
package com.vernal.is.service;

import java.io.IOException;
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
import com.vernal.is.dto.OrganizationDTO;
import com.vernal.is.model.Organization;
import com.vernal.is.translator.OrganizationTranslator;
import com.vernal.is.util.CommonConstants;

/**
 * @author bashelu
 *
 */
@Component
public class OrganizationService extends BaseService{
	
	@Resource
	OrganizationTranslator organizationTranslator;
	
	
	 public Object createOrganization(String startOrgId,HttpSession session) throws IOException {
		Organization organization = organizationTranslator.convertOrganization();
		OrganizationDTO organizationDTO = organizationTranslator.translateToOrganizationDTO(organization, startOrgId);
		String postString = gson.toJson(organizationDTO);
		try {
			HttpEntity<String> entity = preparePost(postString,session);
			ResponseEntity<Object> response = restTemplate.exchange(
					getAPIBaseURL() + CommonConstants.ORGANIZATION_BASE_URL,
							 HttpMethod.POST, entity,Object.class);
			return response.getStatusCode();
		}catch (IOException e) {
			throw e;
		} catch (JsonSyntaxException e) {
			throw e;
		} catch (HttpClientErrorException e) {
			throw e;
		}
	}
	 
	 
	 public List<Organization> getRelatedOrganizations(Map<String, String> queryString,boolean includeCommunication,
				String orgId, HttpSession session, String locale) throws IOException {
		List<Organization> organizationList = null;
		List<OrganizationDTO> organizationDTOList = null;
		String parameterList=null;
		try {
			HttpEntity<String> requestEntity = prepareGet(session); 
			parameterList=translateQueryParams(queryString);
			ResponseEntity<Object> response =
							restTemplate.exchange(getAPIBaseURL() 
							+ CommonConstants.ORGANIZATIONS_BASE_URL+ CommonConstants.SLASH+ orgId +
							CommonConstants.RELATIONSHIPS_BASE_URL +"?"+parameterList.toString(),							
							HttpMethod.GET,requestEntity, Object.class);
		    organizationDTOList = organizationTranslator.translateToOrganizationDTOList(response.getBody());
			organizationList = organizationTranslator.translateToRelatedOrganizationsList(organizationDTOList,includeCommunication,locale);
			return organizationList;
		}catch (IOException e) {
			throw e;
		}catch (JsonSyntaxException e) {
			throw e;
		}catch (HttpClientErrorException e) {
			throw e;
		}
	}
	 
	 public Organization getOrganizationDetails(Map<String, String> queryString,
				HttpSession session, String locale,String organizationId) throws Exception {
			Organization organization=null;
			OrganizationDTO organizationDTO=null;
			String parameterList=null;
			try
			{
					HttpEntity<String> requestEntity = prepareGet(session); 
					parameterList=translateSplitParams(queryString);
					ResponseEntity<Object> response =
								restTemplate.exchange("http://10.213.50.68:9000"
								+ CommonConstants.ORGANIZATION_BASE_URL+CommonConstants.SLASH+organizationId
								+"?"+parameterList.toString(),HttpMethod.GET,requestEntity, Object.class);
					organizationDTO = organizationTranslator.convertOrganizationDTO(response.getBody());
					organization = organizationTranslator.translateToOrganization(organizationDTO,true,locale);
					return organization;
			}catch (Exception e) {
				throw e;
			}
			
		}
	
}
