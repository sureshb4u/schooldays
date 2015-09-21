/**
 * 
 */
package com.vernal.is.translator;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.gson.reflect.TypeToken;
import com.vernal.is.dto.DomainReferenceDTO;
import com.vernal.is.dto.EmailAddressDTO;
import com.vernal.is.dto.OrganizationAddressDTO;
import com.vernal.is.dto.OrganizationDTO;
import com.vernal.is.dto.OrganizationEmailAddressDTO;
import com.vernal.is.dto.OrganizationPhoneDTO;
import com.vernal.is.dto.PhoneNumberDTO;
import com.vernal.is.dto.RelatedOrganizationDTO;
import com.vernal.is.model.Address;
import com.vernal.is.model.Alias;
import com.vernal.is.model.DropDownValue;
import com.vernal.is.model.EmailAddress;
import com.vernal.is.model.Organization;
import com.vernal.is.model.PhoneNumber;

/**
 * @author bashelu
 *
 */
@Component
public class OrganizationTranslator  extends BaseTranslator{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationTranslator.class);
	
	@Resource
	PersonTranslator personTranslator;
	
	
	public OrganizationDTO translateToOrganizationDTO(Organization organization, String startOrgId) {
		OrganizationDTO organizationDTO = new OrganizationDTO();
		
		organizationDTO = translateToRelatedOrgDTO(organization, organizationDTO, startOrgId);
		if(organization.getId() != null){
			organizationDTO.setId(UUID.fromString(organization.getId()));
		}
		if(organization.getMnemonic() != null){
			organizationDTO.setMnemonic(organization.getMnemonic());
		}
		if(organization.getOrgName() != null){
			organizationDTO.setOrgName(organization.getOrgName());
		}
		if(organization.getOrgType() != null){
			organizationDTO.setOrgType(translateToDomainReferenceDTO(organization.getOrgType().toUpperCase()));
		}
		if(organization.getAddresses() != null && !organization.getAddresses().isEmpty()){
			List<Address> addressList = organization.getAddresses();
			List<OrganizationAddressDTO> orgAddressDTOs = translateToAddressDTOs(addressList);
			if(orgAddressDTOs != null && !orgAddressDTOs.isEmpty()){
				organizationDTO.setAddresses(orgAddressDTOs);
			}
		}
		if(organization.getEmailAddresses()!=null && !organization.getEmailAddresses().isEmpty()){
			List<EmailAddress> emailAddressList= organization.getEmailAddresses();
			List<OrganizationEmailAddressDTO> orgEmailAddressDTOs= tranlsateToEmailAddressDTOs(emailAddressList);
			if(orgEmailAddressDTOs!=null && !orgEmailAddressDTOs.isEmpty()){
				organizationDTO.setEmailAddresses(orgEmailAddressDTOs);
			}
		}
		if(organization.getPhoneNumbers()!=null && !organization.getPhoneNumbers().isEmpty()){
			List<PhoneNumber> phoneNumberList=organization.getPhoneNumbers();
			List<OrganizationPhoneDTO> orgPhoneDTOs= translateToPhoneDTOs(phoneNumberList);
			if(orgPhoneDTOs!=null && !orgPhoneDTOs.isEmpty()){
				organizationDTO.setPhones(orgPhoneDTOs);
			}
		}
		
		return organizationDTO;
	}
	
	public OrganizationDTO translateToRelatedOrgDTO(Organization organization, OrganizationDTO organizationDTO, String startOrgId) {
		if(organization.getRelationships() != null){
			List<DomainReferenceDTO> domainReferenceDTO = new ArrayList<DomainReferenceDTO>();
			for(DropDownValue dropDownValue : organization.getRelationships()){
				DomainReferenceDTO relationship = new DomainReferenceDTO();
				relationship.setKey(dropDownValue.getKey().toUpperCase());
				domainReferenceDTO.add(relationship);
			}
			organizationDTO.setRelationships(domainReferenceDTO);
		}
		if(organization.getRelationshipType() != null && !organization.getRelationshipType().isEmpty()){
			organizationDTO.setRelationshipType(translateToRelatedOrgDTOs(organization.getRelationshipType(), startOrgId, organization));
		}
		return organizationDTO;
	}

	
	 public List<RelatedOrganizationDTO> translateToRelatedOrgDTOs(String relationshipTypes, String startOrgId, Organization organization) {
			
			List<String> items = Arrays.asList(relationshipTypes.split("\\s*,\\s*"));
			List<RelatedOrganizationDTO> relatedOrganizationDTOList = new ArrayList<RelatedOrganizationDTO>();
			RelatedOrganizationDTO relatedOrganizationDTO = null;
			for(String relation : items){
				relatedOrganizationDTO = new RelatedOrganizationDTO();
				relatedOrganizationDTO.setRelationshipType(translateToDomainReferenceDTO(relation));
				relatedOrganizationDTO.setStartOrganizationId(startOrgId);
				relatedOrganizationDTO.setEndOrganizationId(organization.getId());
				relatedOrganizationDTOList.add(relatedOrganizationDTO);
			}
			return relatedOrganizationDTOList;
		}
	 
     /**
	 * translates Address List to OrganizationAddressDTO List
	 * @param addressesList
	 * @return
	 */
	public List<OrganizationAddressDTO> translateToAddressDTOs(List<Address> addressesList) {
			List<OrganizationAddressDTO> organizationAddressDTOs = null;
			if(addressesList!=null && !addressesList.isEmpty()){
				organizationAddressDTOs = new ArrayList<OrganizationAddressDTO>();
				for(Address address:addressesList){
					OrganizationAddressDTO addressDTO = translateToAddressDTO(address);
					if(addressDTO.getLine1() != null){
						organizationAddressDTOs.add(addressDTO);
					}
				}
			}
			return organizationAddressDTOs;
		}

		/**
		 * translates Address to OrganizationAddressDTO
		 * @param addresses
		 * @return
		 */
		public OrganizationAddressDTO translateToAddressDTO(Address addresses)  {
			OrganizationAddressDTO addressDTO = new OrganizationAddressDTO();
			if(addresses.getId() != null && !addresses.getId().isEmpty()){
				addressDTO.setId(UUID.fromString(addresses.getId()));
			}
			if(addresses.getLine1() != null && !addresses.getLine1().isEmpty()){
				addressDTO.setLine1(addresses.getLine1());
			} 
			if(addresses.getLine2() != null && !addresses.getLine2().isEmpty()){
				addressDTO.setLine2(addresses.getLine2());
			} 
			if(addresses.getCity() != null && !addresses.getCity().isEmpty()){
				addressDTO.setCity(addresses.getCity());
			} 
			if(addresses.getCountry() != null && !addresses.getCountry().isEmpty()){
				addressDTO.setCountry(translateToDomainReferenceDTO(addresses.getCountry()));
			} 
			if(addresses.getState() != null){
				addressDTO.setState(translateToDomainReferenceDTO(addresses.getState()));
			} 
			if(addresses.getZipcode() != null && !addresses.getZipcode().isEmpty()){
				addressDTO.setZipcode(addresses.getZipcode());
			} 
			if(addresses.getLine1() != null && !addresses.getLine1().isEmpty()){
				addressDTO.setType(translateToDomainReferenceDTO(addresses.getType()));
			}
			return addressDTO;
		}
		
		/**
		 * translates EmailAddress List to OrganizationEmailAddressDTO List
		 * @param emailAddressList
		 * @return
		 */
		private List<OrganizationEmailAddressDTO> tranlsateToEmailAddressDTOs(List<EmailAddress> emailAddressList) {
			List<OrganizationEmailAddressDTO> organizationEmailAddressDTOs=null;
			if(emailAddressList !=null && !emailAddressList.isEmpty()){
				organizationEmailAddressDTOs=new ArrayList<OrganizationEmailAddressDTO>();
				for(EmailAddress emailAddress : emailAddressList){
					OrganizationEmailAddressDTO organizationEmailAddressDTO  = translateToEmailAddressDTO(emailAddress);
					organizationEmailAddressDTOs.add(organizationEmailAddressDTO);
				}
			}
			return organizationEmailAddressDTOs;
		}
		
		/**
		 * translates EmailAddress to OrganizationEmailAddressDTO
		 * @param emailAddress
		 * @return
		 */
		public OrganizationEmailAddressDTO translateToEmailAddressDTO(EmailAddress emailAddress) {
			OrganizationEmailAddressDTO organizationEmailAddressDTO=new OrganizationEmailAddressDTO();
			if(emailAddress.getId()!=null && !emailAddress.getId().isEmpty()){
				organizationEmailAddressDTO.setId(UUID.fromString(emailAddress.getId()));
			}
			if(emailAddress.getEmailId() !=null && !emailAddress.getEmailId().isEmpty()){
				organizationEmailAddressDTO.setEmailAddress(emailAddress.getEmailId());
			}
			if(emailAddress.getType()!=null && !emailAddress.getType().isEmpty() ){
				organizationEmailAddressDTO.setType(translateToDomainReferenceDTO(emailAddress.getType()));
			}
			if(emailAddress.getStatus()!=null && !emailAddress.getStatus().isEmpty()){
				organizationEmailAddressDTO.setStatus(translateToDomainReferenceDTO(emailAddress.getStatus()));
			}
			return organizationEmailAddressDTO;
		}
		
		/**
		 *  translates PhoneNumberList to OrganizationPhoneDTO List
		 * @param phoneNumberList
		 * @return
		 */
		private List<OrganizationPhoneDTO> translateToPhoneDTOs(List<PhoneNumber> phoneNumberList) {
			List<OrganizationPhoneDTO> organizationPhoneDTOs = null;
			if(phoneNumberList!=null && !phoneNumberList.isEmpty()){
				organizationPhoneDTOs= new ArrayList<OrganizationPhoneDTO>();
				for(PhoneNumber phoneNumber:phoneNumberList){
					OrganizationPhoneDTO organizationPhoneDTO = translateToPhoneDTO(phoneNumber);
					organizationPhoneDTOs.add(organizationPhoneDTO);
				}
			}	
			return organizationPhoneDTOs;
		}
		
		/**
		 * translates PhoneNumber to OrganizationPhoneDTO
		 * @param phoneNumber
		 * @return
		 */
		public OrganizationPhoneDTO translateToPhoneDTO(PhoneNumber phoneNumber) {
			OrganizationPhoneDTO organizationPhoneDTO=new OrganizationPhoneDTO();
			if(phoneNumber.getId()!=null && !phoneNumber.getId().isEmpty()){
				organizationPhoneDTO.setId(UUID.fromString(phoneNumber.getId()));
			}
			if(phoneNumber.getPhoneNo()!=null && !phoneNumber.getPhoneNo().isEmpty()){
				organizationPhoneDTO.setPhoneNumber(phoneNumber.getPhoneNo());
			}
			if(phoneNumber.getStatus()!=null && !phoneNumber.getStatus().isEmpty()){
				organizationPhoneDTO.setStatus(translateToDomainReferenceDTO(phoneNumber.getStatus()));
			}
			if(phoneNumber.getType()!=null && !phoneNumber.getType().isEmpty()){
				organizationPhoneDTO.setType(translateToDomainReferenceDTO(phoneNumber.getType()));
			}
			return organizationPhoneDTO;
		}
		
		public Organization convertOrganization(){
			Organization  organization = new Organization();
			organization.setId("ff22113c-4636-11e5-a151-feff812456");
			organization.setOrgName("ald");
			organization.setMnemonic("ooo");
			List<Address> addressList = new ArrayList<Address>();
			Address address = new Address();
			address.setLine1("fgdfgfd");
			address.setLine2("dfgdfg");
			address.setCity("mdu");
			address.setState("TAMILNADU");
			address.setCountry("INDIA");
			address.setZipcode("123");
			addressList.add(address);
			organization.setAddresses(addressList);
			
			List<EmailAddress> emailAddresses = new ArrayList<EmailAddress>();
			EmailAddress emailAddress = new EmailAddress();
			emailAddress.setEmailId("vernail@gmail.com");
			emailAddress.setStatus("VERIFIED");
			emailAddress.setType("PERSONAL");
			emailAddresses.add(emailAddress);
			organization.setEmailAddresses(emailAddresses);
			
			List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();
			PhoneNumber phoneNumber = new PhoneNumber();
			phoneNumber.setPhoneNo("123456");
			phoneNumber.setStatus("VERIFIED");
			phoneNumber.setType("PERSONAL");
			phoneNumbers.add(phoneNumber);
			organization.setPhoneNumbers(phoneNumbers);
			
			List<Alias> aliasList = new ArrayList<Alias>();
			Alias alias = null;
			alias = new Alias();
			alias.setEntityId(UUID.fromString("ff22113c-4636-11e5-a151-feff819cd23f"));
			DropDownValue entityType = new DropDownValue();
			entityType.setKey("www.jonsnow.com");
			entityType.setValue("www.jonsnow.com");
			alias.setEntityType(entityType);
			aliasList.add(alias);
			
			alias = new Alias();
			alias.setEntityId(UUID.fromString("ff22113c-4636-11e5-a151-feff819cdc34"));
			DropDownValue entityType1 = new DropDownValue();
			entityType1.setKey("Linked In");
			entityType1.setValue("linked in");
			alias.setEntityType(entityType1);
			aliasList.add(alias);	
			organization.setAlias(aliasList);
		return organization;
	}
	
	/**
	 * translate json response to organizationDTO
	 * @param object
	 * @return
	 */
	public List<OrganizationDTO> translateToOrganizationDTOList(Object object) {
		Type listType = new TypeToken<List<OrganizationDTO>>() {}.getType();
		List<OrganizationDTO> organizationDTOList = gson.fromJson(translateObjectToJson(object), listType);
		return organizationDTOList;
	}
	
	/**
	 * translate to organizationDTO to Organization to get Related Organization
	 * @param organizationDTOList
	 * @param includeCommunication
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	public List<Organization> translateToRelatedOrganizationsList(List<OrganizationDTO> organizationDTOList,boolean includeCommunication,String locale){
		LOGGER.debug("translating to OrganizationDTO List to Organization List");
		List<Organization> organizationList=new ArrayList<Organization>();
		for(OrganizationDTO organizationDTO:organizationDTOList){
		Organization organization = new Organization();
		if(organizationDTO.getId() != null){
			organization.setId(organizationDTO.getId().toString());
		}
		if(organizationDTO.getOrgName()!=null && !organizationDTO.getOrgName().isEmpty()){
		organization.setOrgName(organizationDTO.getOrgName());
		}
		if(organizationDTO.getMnemonic()!=null && !organizationDTO.getMnemonic().isEmpty()){
		organization.setMnemonic(organizationDTO.getMnemonic());
		}
		if(organizationDTO.getOrgType()!=null){
			organization.setOrgType(organizationDTO.getOrgType().getKey());
		}
		if(organizationDTO.getRelationships()!=null && !organizationDTO.getRelationships().isEmpty()){
			organization.setRelationships(translateToRelationship(organizationDTO.getRelationships(),locale));
		}
		if(includeCommunication){
			if(organizationDTO.getAddresses()!=null && !organizationDTO.getAddresses().isEmpty()){
				organization.setAddresses(translateToOrganizationAddresses(organizationDTO.getAddresses(), locale));
			}
			if(organizationDTO.getEmailAddresses()!=null && !organizationDTO.getEmailAddresses().isEmpty())	{
				organization.setEmailAddresses(translateToOrganizationEmailAddresses(organizationDTO.getEmailAddresses()));
			}
			if(organizationDTO.getPhones()!=null && !organizationDTO.getPhones().isEmpty()){
				organization.setPhoneNumbers(translateToOrganizationPhoneNumbers(organizationDTO.getPhones()));
			}
		}
	 organizationList.add(organization);
	 }
	return organizationList;
	}
	
	
	/**
	 * translate list of OrganizationAddressDTO to OrganizationAddress
	 * @param personAddresseDTOList
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private List<Address> translateToOrganizationAddresses(List<OrganizationAddressDTO> organizationAddressDTOList,String locale) {
		LOGGER.debug("Translating OrganizationAddressDTOList to AddressList");
		List<Address> addressesList = null;
		if(organizationAddressDTOList != null && !organizationAddressDTOList.isEmpty()){
			addressesList = new ArrayList<Address>();
			for(OrganizationAddressDTO orgAddressDTO : organizationAddressDTOList){
				Address address = new Address();
				address = personTranslator.translateToAddress(orgAddressDTO, locale);
				addressesList.add(address);
			}
		}
		else
		{
			addressesList = new ArrayList<Address>();
		}
		return addressesList;
	}
	/**
	 * translate list of OrganizationEmailAddressDTO to list of EmailAddress Model
	 * @param personEmailAddresseDTOList
	 * @return
	 * @throws Exception
	 */
	private List<EmailAddress> translateToOrganizationEmailAddresses(List<OrganizationEmailAddressDTO> orgEmailAddresseDTOList){
		LOGGER.debug("Translating OrganizationEmailAddressDTOList to EmailAddressList");
		List<EmailAddress> emailAddressesList = null;
		if(orgEmailAddresseDTOList != null && !orgEmailAddresseDTOList.isEmpty()){
			emailAddressesList = new ArrayList<EmailAddress>();
			for(OrganizationEmailAddressDTO orgEmailAddressDTO : orgEmailAddresseDTOList){
				EmailAddress emailAddress = new EmailAddress();
				emailAddress = personTranslator.translateToEmailAddress(orgEmailAddressDTO);
				emailAddressesList.add(emailAddress);
			}
		}
		
		return emailAddressesList;
	}

	/**
	 * translate list of OrganizationPhoneNumberDTO to list of PhoneNumber Model
	 * @param personPhoneDTOList
	 * @return
	 * @throws Exception
	 */
	private List<PhoneNumber> translateToOrganizationPhoneNumbers(List<OrganizationPhoneDTO> orgPhoneDTOList) {
		LOGGER.debug("Translating list of OrganizationPhoneNumberDTO to list of PhoneNumber Model");
		List<PhoneNumber> phoneNumberList = null;
		if(orgPhoneDTOList != null && !orgPhoneDTOList.isEmpty()){
			phoneNumberList = new ArrayList<PhoneNumber>();
			for(OrganizationPhoneDTO orgPhoneDTO : orgPhoneDTOList){
				PhoneNumber phoneNumber = new PhoneNumber();
				phoneNumber = personTranslator.translateToPhoneNumber(orgPhoneDTO);
				phoneNumberList.add(phoneNumber);
			}
		}
		return phoneNumberList;
	}
	
	
	/**
	 * translate to Relationship list to list of Relationship Model
	 * @param relationshipList
	 * @param locale
	 * @return
	 */
	private List<DropDownValue> translateToRelationship(List<DomainReferenceDTO> relationshipList,String locale){
		LOGGER.debug("Translate relationship list to Relationship model");
		List<DropDownValue> dropDownValues =new ArrayList<DropDownValue>();
		if(relationshipList !=null && !relationshipList.isEmpty()){
			DropDownValue dropDownValue=null;
			for(DomainReferenceDTO relationDomainReferenceDTO : relationshipList){
				dropDownValue =new DropDownValue();
				dropDownValue.setKey(relationDomainReferenceDTO.getKey());
				dropDownValue.setValue(commonUtil.getLocaleValue(relationDomainReferenceDTO.getDisplays(),locale));
				dropDownValues.add(dropDownValue);
			}
		}
		return dropDownValues;
	}
	
	public Organization translateToOrganization(OrganizationDTO organizationDTO,boolean includeCommunication,String locale) throws Exception{
		LOGGER.debug("Translating OrganizationDTO to Organization");
		Organization organization = new Organization();
		if(organizationDTO.getId() != null){
			organization.setId(organizationDTO.getId().toString());
		}
		if(organizationDTO.getOrgName()!=null && !organizationDTO.getOrgName().isEmpty()){
		organization.setOrgName(organizationDTO.getOrgName());
		}
		if(organizationDTO.getMnemonic()!=null && !organizationDTO.getMnemonic().isEmpty()){
		organization.setMnemonic(organizationDTO.getMnemonic());
		}
		if(organizationDTO.getOrgType()!=null){
			organization.setOrgType(organizationDTO.getOrgType().getKey());
		}
		if(includeCommunication){
			if(organizationDTO.getAddresses()!=null && !organizationDTO.getAddresses().isEmpty()){
				organization.setAddresses(translateToOrganizationAddresses(organizationDTO.getAddresses(), locale));
			}
			if(organizationDTO.getEmailAddresses()!=null && !organizationDTO.getEmailAddresses().isEmpty())	{
				organization.setEmailAddresses(translateToOrganizationEmailAddresses(organizationDTO.getEmailAddresses()));
			}
			if(organizationDTO.getPhones()!=null && !organizationDTO.getPhones().isEmpty()){
				organization.setPhoneNumbers(translateToOrganizationPhoneNumbers(organizationDTO.getPhones()));
			}
	  }
	 return organization;
	}
}
