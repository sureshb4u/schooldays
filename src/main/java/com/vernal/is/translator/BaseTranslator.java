package com.vernal.is.translator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vernal.is.dto.DomainReferenceDTO;
import com.vernal.is.dto.I18nDisplayDTO;
import com.vernal.is.dto.OrganizationDTO;
import com.vernal.is.model.RoleMenu;
import com.vernal.is.service.BaseService;
import com.vernal.is.util.CommonConstants;
import com.vernal.is.util.CommonUtil;


@Component
public class BaseTranslator {
	
	public static final Gson gson = new GsonBuilder().setDateFormat(CommonConstants.ISO_DATE_FORMAT).create();
	
	@Resource
	public BaseService baseService;
	
	@Resource
	CommonUtil commonUtil;
	
	/**
	 * Get Organization id from Session 
	 * @param session
	 * @return {@link String}
	 * @throws Exception
	 */
	public String getOrganizationId(HttpSession session){
		String organizationId = null;
		if(session.getAttribute(CommonConstants.SESSION_ORG_ID) != null)
			organizationId = session.getAttribute(CommonConstants.SESSION_ORG_ID).toString();
		return organizationId;
	}
	
	/**
	 * Translate to Domain reference DTO
	 * @param key the String value of key.
	 * @return {@link DomainReferenceDTO}
	 */
	public DomainReferenceDTO translateToDomainReferenceDTO(String key) {
		DomainReferenceDTO domainReferenceDTO = new DomainReferenceDTO();
		if(key != null && !key.isEmpty()){
		domainReferenceDTO.setKey(key);
		}
		return domainReferenceDTO;
	}
	
	/**
	 * Translate to I18nDisplayDTO
	 * @param value the String value of value.
	 * @param locale the Locale of URI.
	 * @return {@link I18nDisplayDTO}
	 */
	public I18nDisplayDTO translateToI18nDisplayDTO(String value, String locale) {
		Map<String, String> map = new HashMap<String, String>();
		I18nDisplayDTO i18nDisplayDTO = new I18nDisplayDTO();
		map.put(locale, value);
		i18nDisplayDTO.setDisplays(map, locale);
		return i18nDisplayDTO;
	}
	
	/**
	 * Translate to I18nStringMap
	 * @param value the String value of value.
	 * @param locale the Locale of URI.
	 * @return Map<String, String>
	 */
	public Map<String, String> translateToI18nStringMap(String value, String locale) {
		Map<String, String> map = new HashMap<String, String>();
		map.put(locale, value);
		return map;
	}
	
	/**
	 * Translate to Currency Map.
	 * @param code the String value of code.
	 * @param price the String value of price.
	 * @return Map<String, String>.
	 */
	public Map<String, String> translateToCurrencyMap(String code, String price) {
		Map<String, String> map = new HashMap<String, String>();
		map.put(code, price);
		return map;
	}
	
	/**
	 * Translate Object to Json.
	 * @param obj a Object.
	 * @return String.
	 */
	public String translateObjectToJson(Object obj) {
		return gson.toJson(obj);
	}
	
	/**
	 * converts object to OrganizationDTO
	 * @param object
	 * @return
	 */
	public OrganizationDTO convertOrganizationDTO(Object object) {
		Type listType = new TypeToken<OrganizationDTO>() {}.getType();
		OrganizationDTO organizationDTO = gson.fromJson(translateObjectToJson(object), listType);
		return organizationDTO;
	}
	
	 /**Translate to RoleMenu.
	 * @param object The Object.
	 * @return menuOptions {@link RoleMenu}
	 */
	public RoleMenu convertRoleMenu(Object object) {
		RoleMenu menuOptions = gson.fromJson(object.toString(), RoleMenu.class);
		return menuOptions;
	}
 }
