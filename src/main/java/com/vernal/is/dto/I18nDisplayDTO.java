package com.vernal.is.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * I18n translation string DTO
 * User : Suganyadevi.P
 * Date : 04/28/2015
 */
@JsonInclude(value = Include.NON_EMPTY)
public class I18nDisplayDTO{

    public I18nDisplayDTO() {}

    @JsonCreator
    public I18nDisplayDTO(@JsonProperty("displays") Map<String, String> displays) {
        setDisplays(displays, null);
    }

    private Map<String, String> displays;

    @JsonValue
    public Map<String, String> getDisplays() {
        return displays;
    }

    public void setDisplays(Map<String, String> displays, String locale) {
        this.displays = displays;
    }
}
