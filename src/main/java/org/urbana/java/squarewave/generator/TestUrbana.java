package org.urbana.java.squarewave.generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TestUrbana {

	static Map<Long,String> aMap = new LinkedHashMap<Long,String>();
	
	


public static void main(String[] args){
	
	List p1 = new ArrayList();
	
	
	double t =20.0;
	double p = 4.0;
	
	
	for(double time=0.0; time<1024*1024; time=time+1){
		//System.out.println("In loop");
	long a0 = squareWave(2.0*10,time);
	long a1 = squareWave(3.0*10,time);
	long a2 = squareWave(5.0*10,time);
	long a3 = squareWave(7.0*10,time);
	long a4 = squareWave(11.0*10,time);
	
	long a5 = squareWave(13.0*10,time);
	long a6 = squareWave(17.0*10,time);
	long a7 = squareWave(19.0*10,time);
	long a8 = squareWave(23.0*10,time);
	long a9 = squareWave(29*10,time);
	long a10 = squareWave(31.0*10,time);
	
	long a11 = squareWave(37.0*10,time);
	
	long a12 = squareWave(41.0*10,time);
	
	//long a13 = squareWave(193.0,time);
	
	//long a14 = squareWave(197.0,time);
	
	//long a15 = squareWave(199.0,time);
	
	//long a16 = squareWave(53.0,time);
    // System.out.println(""+a0+a1+a2+a3+a4+a5+a6+a7+a8+a9+a10+a11+a12+a13+a14+a15);
	
	///long value = a0*1 + a1*2 +a2*4 + a3*8+ a4*16+ a5*32+ a6*64+ a7*128 + a8*256 +a9*512+a10*1024+a11*2048
	///		+a12*4096 +a13*8192+ a14*8192*2 + a15*8192*4;
			//a16*8192*8;
	//aMap.put( value,"true");
	
	String a102 = ""+a0+a1+a2+a3+a4+a5+a6+a7+a8+a9+a10+a11+a12;
	if(!p1.contains(a102)){
	long value1 = a0*a1*a2 + a1*a4 + a2*a5 + a0*a3 + a0*a7*a8+a6*a4 +a8*a2 +a4*a5 +a7*a1*a6 + a9*a10+a11*a12+a12*a6*a5+a5*a2*a11+a11*a4+a8*a10;
	//System.out.println("value is:"+value1*value1 + " At "+""+a102);
	
	//System.out.println(value1*value1);
	print(Math.abs(value1));
	p1.add(a102);
	
	//long b1 = (long) p1.get(p1.size()-1);
	//long b2 = (long) p1.get(p1.size()-2);
	//long b3 = (long) p1.get(p1.size()-3);
	
	//if(b2<b1 && b2>b3){
	
	// }
	}
	}
	
	//aMap.forEach((k,v) ->System.out.println(k));
	int size = aMap.size();
	System.out.println("Size is:"+size);
	

	
 }
	


	
	
	private static void print(long abs) {
	
		
		
		for(int i=0;i<abs*abs;i++){
			
			System.out.print("*");
		}
		System.out.println(abs);
		
	
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
