package org.urbana.java.criteria.generator;

import java.math.BigDecimal;

public class LogarithmHelper {

	static int SIZE=10;
	
	public static void main(String[] args){
		
		BigDecimal b = new BigDecimal("0.000001");
		Double s = getMantisaa(b);
		Double log = getLogarithm(b);
		System.out.println(" Value:"+log);
		
		
	}
	
	public static double getLogarithm(BigDecimal b){
		
		return getExponent(b)+log(getMantisaa(b));
	}
	
	public static BigDecimal getBigDecimal(double d,double exp){
		
		return getExponent(b)+log(getMantisaa(b));
	}
	
    
	
	private static Double log(double mantisaa) {
		
		return Math.log10(mantisaa);
	}

	private static Double getExponent(BigDecimal b){
		
		String s = b.toEngineeringString();
		
		if(s.contains(".")){
		s=s.substring(0,s.indexOf("."));
		}
		
	    return new Double((s.length()-1+0.0));
	}
	
    private static Double getMantisaa(BigDecimal b){
    	String s = b.toEngineeringString();
    	System.out.println(" Value:"+s);
        s = s.replaceAll("\\.", "");
    	
    	if(s.length()>SIZE){
    	s=s.substring(0,SIZE);
    	}
    	
    	int l = 0;
    	if(s.length()>=SIZE){
    		l=SIZE;
    	}
    	else{
    		l=s.length();
    	}
    	
    	s =s.substring(0,1)+"."+s.substring(1,l);
	   return Double.valueOf(s);
	}
	
	
	
	
}
