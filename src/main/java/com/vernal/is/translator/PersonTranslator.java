/**
 * 
 */
package com.vernal.is.translator;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.gson.reflect.TypeToken;
import com.vernal.is.dto.AddressDTO;
import com.vernal.is.dto.DomainReferenceDTO;
import com.vernal.is.dto.EmailAddressDTO;
import com.vernal.is.dto.PersonAddressDTO;
import com.vernal.is.dto.PersonDTO;
import com.vernal.is.dto.PersonEmailAddressDTO;
import com.vernal.is.dto.PersonPhoneDTO;
import com.vernal.is.dto.PhoneNumberDTO;
import com.vernal.is.model.Address;
import com.vernal.is.model.Alias;
import com.vernal.is.model.Asset;
import com.vernal.is.model.DropDownValue;
import com.vernal.is.model.EmailAddress;
import com.vernal.is.model.Person;
import com.vernal.is.model.PhoneNumber;

/**
 * @author bashelu
 *
 */
@Component
public class PersonTranslator extends BaseTranslator {

	private static final Logger LOGGER = LoggerFactory.getLogger(PersonTranslator.class);

	/**
	 * translate Person to PersonDTO
	 * @param person
	 * @param locale
	 * @return
	 */
	public PersonDTO translateToPersonDTO(Person person, String locale) {
		LOGGER.debug("translate Person to PersonDTO");
			PersonDTO personDTO= new PersonDTO();
			if(person.getFirstName()!=null){
				personDTO.setFirstName(person.getFirstName());
			}
			if(person.getLastName()!=null){
				personDTO.setLastName(person.getLastName());
			}
			if(person.getDateOfBirth()!=null){
				personDTO.setDateOfBirth(person.getDateOfBirth());
			}
			if(person.getType()!=null){
				DomainReferenceDTO typedomainReferenceDTO=new DomainReferenceDTO();
				typedomainReferenceDTO.setKey(person.getType().toUpperCase());
				personDTO.setType(typedomainReferenceDTO);
			}
			if(person.getGender()!=null){
				DomainReferenceDTO gender =new DomainReferenceDTO();
				gender.setKey(person.getGender().toUpperCase());
				personDTO.setGender(gender);
			}
			if(person.getAddresses() != null){
			List<Address> addressList = person.getAddresses();
			List<PersonAddressDTO> personAddressDTOs = translateToPersonAddressDTOs(addressList);
			if(personAddressDTOs != null && !personAddressDTOs.isEmpty()){
				personDTO.setAddresses(personAddressDTOs);
			}
		}
		if(person.getEmailAddresses()!=null){
			List<EmailAddress> emailAddressList= person.getEmailAddresses();
			List<PersonEmailAddressDTO> personEmailAddressDTOs= tranlsateToPersonEmailAddressDTOs(emailAddressList);
			if(personEmailAddressDTOs!=null && !personEmailAddressDTOs.isEmpty()){
				personDTO.setEmailAddresses(personEmailAddressDTOs);
			}
		}
		if(person.getPhoneNumbers()!=null){
			List<PhoneNumber> phoneNumberList=person.getPhoneNumbers();
			List<PersonPhoneDTO> personPhoneDTOs= translateToPersonPhoneDTOs(phoneNumberList);
			if(personPhoneDTOs!=null && !personPhoneDTOs.isEmpty()){
				personDTO.setPhoneNumbers(personPhoneDTOs);
			}
		}
		return personDTO;
	}
	/**
	 * translate List of Address model to PersonAddressDTO List
	 * @param addressList
	 * @return
	 */
	private List<PersonAddressDTO> translateToPersonAddressDTOs(List<Address> addressList) {
		LOGGER.debug("translate Address to PersonAddressDTO");
		List<PersonAddressDTO> personAddressDTOs = null;
		personAddressDTOs = new ArrayList<PersonAddressDTO>();
		for(Address address:addressList){
			PersonAddressDTO addressDTO = translateToPersonAddressDTO(address);
			if(addressDTO.getLine1() != null){
				personAddressDTOs.add(addressDTO);
			}
		}
		return personAddressDTOs;
	}
	/**
	 * translate Address to PersonAddressDTO
	 * @param addresses
	 * @return
	 */
	public PersonAddressDTO translateToPersonAddressDTO(Address addresses)  {
		LOGGER.debug("translate Address to PersonAddressDTO");
		PersonAddressDTO addressDTO = new PersonAddressDTO();
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
			addresses.setType("WORK");
		}
		if(addresses.getType() != null && !addresses.getType().isEmpty()){
			addressDTO.setType(translateToDomainReferenceDTO(addresses.getType()));
		} 
		return addressDTO;
	}
	/**
	 * translate EmailAddress to PersonEmailAddressDTO
	 * @param emailAddressList
	 * @return
	 */
	private List<PersonEmailAddressDTO> tranlsateToPersonEmailAddressDTOs(List<EmailAddress> emailAddressList) {
		LOGGER.debug("translate EmailAddress to PersonEmailAddressDTO");
		 List<PersonEmailAddressDTO> personEmailAddressDTOs=new ArrayList<PersonEmailAddressDTO>();
		for(EmailAddress emailAddress : emailAddressList){
			PersonEmailAddressDTO personEmailAddressDTO  = translateToEmailAddressDTO(emailAddress);
			personEmailAddressDTOs.add(personEmailAddressDTO);
		}
		
		return personEmailAddressDTOs;
	}
	/**
	 * translate EmailAddress to PersonEmailAddressDTO
	 * @param emailAddress
	 * @return
	 */
	public PersonEmailAddressDTO translateToEmailAddressDTO(EmailAddress emailAddress) {
		LOGGER.debug("translate EmailAddress to PersonEmailAddressDTO");
		PersonEmailAddressDTO personEmailAddressDTO=new PersonEmailAddressDTO();
		if(emailAddress.getId()!=null && !emailAddress.getId().isEmpty()){
			personEmailAddressDTO.setId(UUID.fromString(emailAddress.getId()));
		}
		if(emailAddress.getEmailId() !=null && !emailAddress.getEmailId().isEmpty()){
			personEmailAddressDTO.setEmailAddress(emailAddress.getEmailId());
		}
		if(emailAddress.getType()!=null){
			personEmailAddressDTO.setType(translateToDomainReferenceDTO(emailAddress.getType()));
		}
		if(emailAddress.getStatus()!=null){
			personEmailAddressDTO.setStatus(translateToDomainReferenceDTO(emailAddress.getStatus()));
		}
		return personEmailAddressDTO;
	}
	/**
	 * translate PhoneNumber List to List of PersonPhoneDTO
	 * @param phoneNumberList
	 * @return
	 */
	private List<PersonPhoneDTO> translateToPersonPhoneDTOs(List<PhoneNumber> phoneNumberList) {
		LOGGER.debug("translate PhoneNumber List to List of PersonPhoneDTO");
		List<PersonPhoneDTO> personPhoneDTOs= new ArrayList<PersonPhoneDTO>();
		for(PhoneNumber phoneNumber:phoneNumberList){
			PersonPhoneDTO organizationPhoneDTO = translateToPhoneDTO(phoneNumber);
			personPhoneDTOs.add(organizationPhoneDTO);
		}
		return personPhoneDTOs;
	}
	/**
	 * translate PhoneNumber to PersonPhoneDTO
	 * @param phoneNumber
	 * @return
	 */
	public PersonPhoneDTO translateToPhoneDTO(PhoneNumber phoneNumber) {
		LOGGER.debug("translate PhoneNumber to PersonPhoneDTO");
		PersonPhoneDTO personPhoneDTO=new PersonPhoneDTO();
		if(phoneNumber.getId()!=null && !phoneNumber.getId().isEmpty()){
			personPhoneDTO.setId(UUID.fromString(phoneNumber.getId()));
		}
		if(phoneNumber.getPhoneNo()!=null && !phoneNumber.getPhoneNo().isEmpty()){
			personPhoneDTO.setPhoneNumber(phoneNumber.getPhoneNo());
		}
		if(phoneNumber.getStatus()!=null){
			personPhoneDTO.setStatus(translateToDomainReferenceDTO(phoneNumber.getStatus()));
		}
		if(phoneNumber.getType()!=null){
			personPhoneDTO.setType(translateToDomainReferenceDTO(phoneNumber.getType()));
		}
		return personPhoneDTO;
	}
	
	
	/**
	 * Translating List of AddressDTO to Address List
	 * @param addresseDTOList
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	public List<Address> translateToAddresses(List<AddressDTO> addresseDTOList,String locale){
		LOGGER.debug("translate AddressDTO List to List of Address Model");
		List<Address> addressesList = null;
		if(addresseDTOList != null && !addresseDTOList.isEmpty()){
			addressesList = new ArrayList<Address>();
			for(AddressDTO personAddressDTO : addresseDTOList){
				Address address = new Address();
				address = translateToAddress(personAddressDTO, locale);
				addressesList.add(address);
			}
		}
		return addressesList;
	}

	/**
	 * Translate addressDTO to Address Model
	 * @param addressDTO
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	public Address translateToAddress(AddressDTO addressDTO, String locale){
		LOGGER.debug("translate addressDTO to Address Model");
		Address address = new Address(); 
		if(addressDTO.getId() != null){
			address.setId(addressDTO.getId().toString());
		}else{
			address.setId("");
		}
		if(addressDTO.getLine1() != null){
			address.setLine1(addressDTO.getLine1());
		}else{
			address.setLine1("");
		}
		if(addressDTO.getLine2() != null){
			address.setLine2(addressDTO.getLine2());
		}else{
			address.setLine2("");
		}
		if(addressDTO.getCity() != null){
			address.setCity(addressDTO.getCity());
		}else{
			address.setCity("");
		}
		if(addressDTO.getState() != null){
			address.setState(addressDTO.getState().toString());
		}else{
			address.setState("");
		}
		if(addressDTO.getType() != null){
			address.setType(addressDTO.getType().getKey().toString());
		}else{
			address.setType("");
		}
		address.setZipcode(addressDTO.getZipcode());
		if(addressDTO.getCountry() != null){
			address.setCountry(commonUtil.getLocaleValue(addressDTO.getCountry().getDisplays(), locale));
		}else{
			address.setCountry("");
		}
		DropDownValue stateDropDownValue = null;
		if(addressDTO.getState() != null){
			stateDropDownValue = new DropDownValue();
			stateDropDownValue.setKey(addressDTO.getState().getKey().toString());
			stateDropDownValue.setValue(commonUtil.getLocaleValue(addressDTO.getState().getDisplays(), locale));
			address.setAddress_state(stateDropDownValue);
			address.setState(addressDTO.getState().getKey());
		} else{
			stateDropDownValue = new DropDownValue();
			stateDropDownValue.setValue("");
			address.setAddress_state(stateDropDownValue);
		}
		DropDownValue countryDropDownValue = null;
		if(addressDTO.getCountry() != null){
			countryDropDownValue = new DropDownValue();
			countryDropDownValue.setKey(addressDTO.getCountry().getKey().toString());
			countryDropDownValue.setValue(commonUtil.getLocaleValue(addressDTO.getCountry().getDisplays(), locale));
			address.setAddress_country(countryDropDownValue);
			address.setCountry(addressDTO.getCountry().getKey());
		} else{
			countryDropDownValue = new DropDownValue();
			countryDropDownValue.setValue("");
			address.setAddress_country(countryDropDownValue);
		}
		return address;
	}
	
	/**
	 * Stubbed data for Person model
	 * @return
	 */
	public Person convertToPerson(){
		
		Person person = new Person();
		person.setFirstName("Peter");
		person.setLastName("Dlnklage");
		person.setDesignation("Art Director");
		person.setDateOfBirth("07/10/2015");
		person.setType("PERSON");
		person.setGender("MALE");

		List<Address> addressList = new ArrayList<Address>();
		Address address = new Address();
		address.setLine1("316 e");
		address.setLine2("108th street");
		address.setCity("ManHattan");
		address.setState(null);
		address.setCountry("NY");
		address.setZipcode("10016");
		addressList.add(address);
		person.setAddresses(addressList);
		
		List<EmailAddress> emailAddresses = new ArrayList<EmailAddress>();
		EmailAddress emailAddress = new EmailAddress();
		emailAddress.setEmailId("jon.snow@gmail.com");
		emailAddress.setStatus("VERIFIED");
		emailAddress.setType("PERSONAL");
		emailAddresses.add(emailAddress);
		person.setEmailAddresses(emailAddresses);
		
		List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();
		PhoneNumber phoneNumber = new PhoneNumber();
		phoneNumber.setPhoneNo("732.343.2823");
		phoneNumber.setStatus("VERIFIED");
		phoneNumber.setType("PERSONAL");
		phoneNumbers.add(phoneNumber);
		person.setPhoneNumbers(phoneNumbers);
		
		List<Alias> aliasList = new ArrayList<Alias>();
		Alias alias = null;
		alias = new Alias();
		alias.setEntityId(UUID.fromString("ff22113c-4636-11e5-a151-feff819cdc9f"));
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
		
		alias = new Alias();
		alias.setEntityId(UUID.fromString("ff22113c-4636-11e5-a151-feff819cdc34"));
		DropDownValue entityType2 = new DropDownValue();
		entityType2.setKey("Twitter");
		entityType2.setValue("twitter");
		alias.setEntityType(entityType2);
		aliasList.add(alias);
		person.setAlias(aliasList);
		return person;
	}
	
	/**
	 * translate PerEmailAddressDTOsonDTO to EmailAddress
	 * @param personEmailAddressDTO
	 * @return
	 * @throws Exception
	 */
	public EmailAddress translateToEmailAddress(EmailAddressDTO personEmailAddressDTO){
		LOGGER.debug("translate PerEmailAddressDTOsonDTO to EmailAddress Model");
		EmailAddress emailAddress = new EmailAddress();
		if(personEmailAddressDTO.getId()!=null){
			emailAddress.setId(personEmailAddressDTO.getId().toString());
		}
		if(personEmailAddressDTO.getEmailAddress()!=null && !personEmailAddressDTO.getEmailAddress().isEmpty()){
			emailAddress.setEmailId(personEmailAddressDTO.getEmailAddress());
		}
		if(personEmailAddressDTO.getStatus() != null){
			emailAddress.setStatus(personEmailAddressDTO.getStatus().getKey());
		}
		if(personEmailAddressDTO.getType() != null){
			emailAddress.setType(personEmailAddressDTO.getType().getKey());
		}
		return emailAddress;
	}
	
	/**
	 * translate PhoneNumberDTO to PhoneNumber
	 * @param personPhoneDTO
	 * @return
	 * @throws Exception
	 */
	public PhoneNumber translateToPhoneNumber(PhoneNumberDTO PhoneDTO) {
		LOGGER.debug("translate PhoneNumberDTO to PhoneNumber");
		PhoneNumber phoneNumber = new PhoneNumber();
		if(PhoneDTO.getId()!=null){
			phoneNumber.setId(PhoneDTO.getId().toString());
		}
		if(PhoneDTO.getPhoneNumber()!=null && !PhoneDTO.getPhoneNumber().isEmpty()){
			phoneNumber.setPhoneNo(PhoneDTO.getPhoneNumber());
		}
		if(PhoneDTO.getStatus()!=null){
			phoneNumber.setStatus(PhoneDTO.getStatus().getKey());
		}
		if(PhoneDTO.getType()!=null){
			phoneNumber.setType(PhoneDTO.getType().getKey());
		}
		return phoneNumber;
	}
	
	
	/**
	 * translate PersonDTO to Person Model
	 * @param personDTO 
	 * @return
	 * @throws Exception
	 */
	public Person translateToPerson(PersonDTO personDTO){
		LOGGER.debug("translate PersonDTO to Person Model");
			Person person = new Person();
			if(personDTO.getId()!=null)	{
				person.setId(personDTO.getId());
			}
			if(personDTO.getFirstName()!=null && !personDTO.getFirstName().isEmpty()){
				person.setFirstName(personDTO.getFirstName());
			}
			if(personDTO.getLastName()!=null && !personDTO.getLastName().isEmpty()){
				person.setLastName(personDTO.getLastName());
			}
			if(personDTO.getDateOfBirth()!=null && !personDTO.getDateOfBirth().isEmpty()){
				person.setDateOfBirth(personDTO.getDateOfBirth());
			}
			if(personDTO.getGender() != null){
				person.setGender(personDTO.getGender().getKey());
			}
			if(personDTO.getOrgId()!=null){
			person.setOrgId(personDTO.getOrgId());
			}
			if(personDTO.getType() != null){
				person.setType(personDTO.getType().getKey());
			}
		return person;
	}
	
	/**
	 * translating json response to PersonDTOList
	 * @param object
	 * @return
	 */
	public List<PersonDTO> translateToPersonDTOList(Object object) {
		LOGGER.debug("translating json response to PersonDTOList");
		Type listType = new TypeToken<List<PersonDTO>>() {}.getType();
		List<PersonDTO> personDTOList = gson.fromJson(translateObjectToJson(object), listType);
		return personDTOList;
	}
	
	public List<Person> translateToPersonsList(List<PersonDTO> personDTOList) {
		LOGGER.debug("translate PersonDTOList to PersonList");
		List<Person> personList = null;
		if(personDTOList != null && !personDTOList.isEmpty()){
			personList = new ArrayList<Person>();
			for(PersonDTO personDTO : personDTOList){
				Person person = new Person();
				person = translateToPerson(personDTO);
				personList.add(person);
			}
		}
		
		return personList;
	}
}
