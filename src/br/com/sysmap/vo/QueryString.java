package br.com.sysmap.vo;

import java.io.Serializable;

public class QueryString implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5584442415144617550L;

	private String name;
	
	private Boolean required;
	
	public QueryString() {
		//Default Constructor
	}
	
	public QueryString(String name){
		this.name = name;
		this.required = new Boolean(false);
	}
	
	public QueryString(String name, Boolean required){
		this.name = name;
		this.required = required;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Boolean getRequired() {
		return required;
	}
	
	public void setRequired(Boolean required) {
		this.required = required;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((required == null) ? 0 : required.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QueryString other = (QueryString) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (required == null) {
			if (other.required != null)
				return false;
		} else if (!required.equals(other.required))
			return false;
		return true;
	}
	
	
	
}