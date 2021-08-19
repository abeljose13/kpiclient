package com.agavide.kpiclient.enums;

/**
 * 
 * @author <a href="mailto:abeljose13@gmail.com">Avelardo Gavide</a>
 *
 */
public enum SexEnum {

	F("F"),
	M("M");
	
	private String value;
	
	private SexEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
