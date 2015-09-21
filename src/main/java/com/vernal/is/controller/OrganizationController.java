/**
 * 
 */
package com.vernal.is.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vernal.is.model.Organization;
import com.vernal.is.service.OrganizationService;
import com.vernal.is.util.CommonConstants;
import com.vernal.is.util.MessageUtils;

/**
 * @author Vignesh
 *
 */
@Controller
@RequestMapping("/organization")
public class OrganizationController extends BaseController{
	

	@Resource
	private BaseController baseController;
	
	@Resource
	private OrganizationService organizationService;
	
	@RequestMapping(value = "/organization",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createOrganization(HttpSession session)  throws Exception {
		Object result=null;
		try{
			String orgId ="ff22113c-4636-11e5-a151-feff819cd234";
			result=organizationService.createOrganization(orgId,session);
		}catch(Exception ex){
			ex.printStackTrace();
			return new ResponseEntity<>(baseController.setResponse(MessageUtils.getMessage("error.getting.creatingorganization"),HttpStatus.INTERNAL_SERVER_ERROR.toString()),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(result,HttpStatus.OK);
	}

	@RequestMapping(value = "/relatedOrganization/{orgId}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getRelatedOrganizations(@PathVariable(value = "orgId")String organizationId,
			@RequestParam(value = "relationshipType", required=false)String relationshipType,HttpSession session) throws IOException {
		List<Organization> organizationList = null;
		 Map<String, String> queryString = new TreeMap<String, String>();
		 boolean includeCommunication=true;
		try{
			if(relationshipType !=null && !relationshipType.isEmpty()){
				queryString.put(CommonConstants.RELATIONSHIP_TYPE, relationshipType);
			}
			organizationList = organizationService.getRelatedOrganizations(queryString,includeCommunication,organizationId,session,locale);
		}catch(Exception ex){
			return new ResponseEntity<>(setCustomExceptionHandler(ex, MessageUtils.getMessage("error.getting.realted.organization")),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Organization>>(organizationList,HttpStatus.OK);
	}
	
	 /**
		 * Getting Organization Details By Id
		 * @param organizationId -String- Id of organization
		 * @param session - HttpSession variable
		 * @return organization details
		 * @throws Exception
		 */
		@RequestMapping(value = "/organization/{orgId}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<?> getOrganizationDetailsById(@PathVariable(value = "orgId")String organizationId,HttpSession session) throws Exception {
			Organization organization=new Organization();
			Map<String, String> queryString = new TreeMap<String, String>();
			try	{
				organization =organizationService.getOrganizationDetails(queryString,session, locale, organizationId);
			}catch(Exception ex){
				return new ResponseEntity<>(baseController.setResponse(MessageUtils.getMessage("error.getting.organizationdetails"),HttpStatus.INTERNAL_SERVER_ERROR.toString()),HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<Organization>(organization,HttpStatus.OK);
		}
}
