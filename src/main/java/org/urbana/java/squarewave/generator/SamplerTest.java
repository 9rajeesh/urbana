package org.urbana.java.squarewave.generator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SamplerTest {

	static Map<Integer,Double> pMap = new HashMap<Integer,Double>();
	static long count=0;
	
	public static void main(String[] args){
		
		List p = new ArrayList();
		Long lastentered = 1L;
		Long current = 0L;
		
		for(Long i=0L;i<333000;i++){
		
		BigDecimal time = new BigDecimal(generateRandom().toString()).multiply(new BigDecimal("1048576")).multiply(new BigDecimal("3.141592653589793"))
				 ;
		
		String a = "";
		
		for(int k=0;k<40;k++){
				//26214.4
		String a0 = squareWave(new BigDecimal("26214.4").add(new BigDecimal(k)),time);
		a= a+a0;
		}
		
		
		//System.out.println("Time is: "+time + "Value is"+a);
		
		if(!p.contains(a)){
		p.add(a);
		//System.out.println("Probability at n:"+p.size() + " Value is:"+1/(i-lastentered+0.0));
		
		pMap.put(p.size(),1/(i-lastentered+0.0));
		lastentered = i;
		}
	    count++;
	    if(count==1000){
		System.out.println(" Size is: "+p.size());
		count=0;
		}
		}
		/*
		cacluateAverage(500,20);
		cacluateAverage(1000,20);
		cacluateAverage(1500,20);
		cacluateAverage(2000,20);
		cacluateAverage(2500,20);
		cacluateAverage(3000,20);
		cacluateAverage(3500,20);
		cacluateAverage(4000,20);
		cacluateAverage(4500,20);
		cacluateAverage(5000,20);
		cacluateAverage(5500,20);
		cacluateAverage(6000,20);
		
		cacluateAverage(6500,20);
		cacluateAverage(7000,20);
		cacluateAverage(7500,20);
		cacluateAverage(8000,20);
		cacluateAverage(8500,20);
		cacluateAverage(9000,20);
		cacluateAverage(9500,20);
		cacluateAverage(10000,20);
		
		cacluateAverage(11000,20);
		cacluateAverage(12000,20);
		cacluateAverage(13000,20);
		cacluateAverage(14000,20);
		cacluateAverage(15000,20);
		cacluateAverage(16000,20);
		cacluateAverage(17000,20);
		cacluateAverage(18000,20);
		cacluateAverage(19000,20);
		cacluateAverage(20000,20);
		*/
		
		System.out.println("Total Size is: "+p.size());
	}
	
    private static Double cacluateAverage(int i, int j) {
		Double sum=0.0;
		for(int k=i,l=0;l<j;l++,k++){
			
			Double v  = pMap.get(k);
			sum= sum+v;
		}
		
		Double avg = (sum/j);
		Double log  = Math.log(avg)/Math.log(2);
		System.out.println("Avg at:"+i+ " is:"+avg +  " Log is:"+log);
		return avg;
	}

	private static BigInteger generateRandom() {
	
    	String a = "";
    	
    	for(int i=0;i<20;i++){
    		double p = Math.random();
    		
    		int n =0;
    		
    		if(p<0.5){
    		n=0;
    		}
    		else if(p>0.5){
    		n=1;
    		}
    		
    		
    		
    		a =a +n;
    		//System.out.println("a is:"+a);
    		//break;
    	}
    	BigInteger a1 = new BigInteger(a, 2);
    
    	return  a1;
	}

	public static String squareWave(BigDecimal period, BigDecimal time){
		
    	BigDecimal a = time.divide(period,25,RoundingMode.HALF_UP);
		
    	BigDecimal aInt = stripDecimal(a);
		
    	BigDecimal v = a.subtract(aInt);
    	
		if(Math.abs(v.doubleValue())<=0.5){
		return "0";
		}
		
		else{
	    return "1";
		}
	}

	private static BigDecimal stripDecimal(BigDecimal divide) {
		
		String a = divide.toPlainString();
		if(a.contains(".")){
			a=a.substring(0,a.indexOf("."));
		}
		
		
		BigDecimal a1 = new BigDecimal(a);
		return a1;
	}
	
	
	
	
	
}
