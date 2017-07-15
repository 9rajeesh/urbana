package org.urbana.java.squarewave.generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TestControl {

	static Map<Long,String> aMap = new LinkedHashMap<Long,String>();
	
	


public static void main(String[] args){
	
	List p1 = new ArrayList();
	
	
	double t =20.0;
	double p = 4.0;
	
	
	for(int time=0; time<2048;time++){
		
	String a = append(Integer.toBinaryString(time),10);
	
	//System.out.println("A is:"+a);
	
	int a0 = new Integer(toInt(a.charAt(0)));
	int a1 = new Integer(toInt(a.charAt(1)));
	int a2 = new Integer(toInt(a.charAt(2)));
	int a3 = new Integer(toInt(a.charAt(3)));
	
	int a4 = new Integer(toInt(a.charAt(4)));
	int a5 = new Integer(toInt(a.charAt(5)));
	int a6 = new Integer(toInt(a.charAt(6)));
	int a7 = new Integer(toInt(a.charAt(7)));
	
	int a8 = new Integer(toInt(a.charAt(8)));
	
	int a9 = new Integer(toInt(a.charAt(9)));
	
	int a10 = new Integer(toInt(a.charAt(10)));
	
	String a102 = ""+a0+a1+a2+a3+a4+a5+a6+a7+a8;
	if(!p1.contains(a102)){
		long value1 = a0*a1*a2 + a1*a4 + a2*a5 + a0*a3 + a0*a7*a8+a6*a4 +a8*a2 +a4*a5 +a7*a1*a6 + a9*a10;
	System.out.println("value is:"+value1*value1 + " At "+""+a102);
	p1.add(a102);
	
	  }
	}
	
	aMap.forEach((k,v) ->System.out.println(k));
	int size = aMap.size();
	System.out.println("Size is:"+size);
	

	
}

	
	
	private static String toInt(char charAt) {
	
		if(charAt=='0'){
			return "0";
		}
		
		if(charAt=='1'){
			return "1";
		}
		
	return null;
}



	private static String append(String binaryString, int i) {
	
		while(binaryString.length()<=i){
			binaryString = "0"+binaryString;
			
		}
		
		
	return binaryString;
}



	public static long squareWave(double period, double time){
		
		double a = time/period;
		
		int aInt = (int) (time/period);
		
		if(a-aInt<=0.5){
		return 0;
		}
		
		else{
	return 1;
		}
	}
	
	
	
	
}
