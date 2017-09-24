package org.urbana.java.criteria.generator;

import java.util.ArrayList;
import java.util.List;

public class Expression {

	
	private List<String> varList = new ArrayList<String>();

	
	
	public List<String> getVarList() {
		return varList;
	}

	public void setVarList(List<String> varList) {
		this.varList = varList;
	}

	private Double value;

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
	
	
	
	
}
