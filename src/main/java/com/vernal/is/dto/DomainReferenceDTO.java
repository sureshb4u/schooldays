package com.vernal.is.dto;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value= JsonInclude.Include.NON_EMPTY)
public class DomainReferenceDTO {

    public DomainReferenceDTO(){}
    public DomainReferenceDTO(String key) {
        setKey(key);
    }
    private Map<String,String> displays;
	private String key;
	private String locale;
    //public I18nDisplayDTO displays;

	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
    public Map<String,String> getDisplays() {
        return displays;
    }
    public void setDisplays(Map<String,String> displays) {
        this.displays = displays;
    }
    public void  setDisplay(String display)
    {
        if (getDisplays() != null) {
            throw new IllegalStateException("setDisplays was already called.");
        }
        Map<String,String> displays = new HashMap<String,String>();
        displays.put(locale, display);


       // I18nDisplayDTO i18nDisplayDTO = new I18nDisplayDTO();
       // i18nDisplayDTO.setDisplays(displays, locale);

        this.displays = displays;
    }
}
