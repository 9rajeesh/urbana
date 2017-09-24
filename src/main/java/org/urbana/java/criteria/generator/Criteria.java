package org.urbana.java.criteria.generator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.urbana.java.taylor.expansion.Term;

public class Criteria {
	
	private List<Expression> expList = new ArrayList<Expression>();
	private Double value;
	
	public List<Expression> getExpList() {
		return expList;
	}
	public void setExpList(List<Expression> expList) {
		this.expList = expList;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}

	public static void main(String[] args){
		
		BigDecimal a = Criteria.inverse(new BigDecimal("0.12456"));
		System.out.println("Value is:"+a);
		
	}
	
	private static BigDecimal inverse(BigDecimal value1) {
		BigDecimal value = null;
		int power = 0;
		String a = value1.toPlainString();
		String b = "";
		
		if(!a.contains(".")){
		b  = a.substring(0,1) + "." + a.substring(1);
		power = a.length()-1;
		}
		else{
		power = a.indexOf(".")-1;
		a =a.replaceAll("\\.", "");
		b = a.substring(0,1) + "." + a.substring(1);
		}
		
		value = new BigDecimal(b);
		value = new BigDecimal("1").divide(value,Term.precision,RoundingMode.CEILING);
		
		String p = value.toPlainString()+"E"+(power*-1);
		value = new BigDecimal(p);
		
		return value;
	}
	
}
