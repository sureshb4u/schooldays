package com.vernal.is.model;

import java.util.List;

/**
 * Model Class for PagePermission
 * User: Suganyadevi.P
 * Date: 05/29/2015
 */
public class PagePermission {
	private String menuTitle;
	private List<String> viewby;
	private String style;
	private String menuItemDisplay;
	private String url;
	
	public String getMenuTitle() {
		return menuTitle;
	}
	public void setMenuTitle(String menuTitle) {
		this.menuTitle = menuTitle;
	}
	public String getMenuItemDisplay() {
		return menuItemDisplay;
	}
	public void setMenuItemDisplay(String menuItemDisplay) {
		this.menuItemDisplay = menuItemDisplay;
	}
	public List<String> getViewby() {
		return viewby;
	}
	public void setViewby(List<String> viewby) {
		this.viewby = viewby;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}