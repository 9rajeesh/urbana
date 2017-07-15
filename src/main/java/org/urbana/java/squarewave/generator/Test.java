package org.urbana.java.squarewave.generator;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Test {

	static Map<Long,String> aMap = new LinkedHashMap<Long,String>();
	
	
	public static void main(String[] args){
		
		
		
		double t =20.0;
		double p = 4.0;
		
		
		for(double time=0.0; time<2048*21; time=time+0.25){
			//System.out.println("In loop");
		long a0 = squareWave(2.0,time);
		long a1 = squareWave(3.0,time);
		long a2 = squareWave(5.0,time);
		long a3 = squareWave(7.0,time);
		long a4 = squareWave(11.0,time);
		
		long a5 = squareWave(13.0,time);
		long a6 = squareWave(17.0,time);
		long a7 = squareWave(23.0,time);
		long a8 = squareWave(29.0,time);
		long a9 = squareWave(31.0,time);
		long a10 = squareWave(37.0,time);
		long a11 = squareWave(41.0,time);
		
		long a12 = squareWave(43.0,time);
		
		//long a13 = squareWave(47.0,time);
		
		//long a14 = squareWave(53.0,time);
		
		//long a15 = squareWave(59.0,time);
		
		//long a16 = squareWave(53.0,time);
	   //  System.out.println(""+a0+a1+a2+a3+a4+a5+a6+a7+a8+a9+a10+a11+a12+a13+a14+a15);
		
		long value = a0*1 + a1*2 +a2*4 + a3*8+ a4*16
				+a5*32+a6*64
		        + a7*128 + a8*256 +a9*512+a10*1024
				+a11*2048
				+a12*4096;
				//+a13*8192+ a14*8192*2 + a15*8192*4;
				//a16*8192*8;
		aMap.put( value,"true");
		
		
		
		}
		
		aMap.forEach((k,v) ->System.out.println(k));
		int size = aMap.size();
		System.out.println("Size is:"+size);
		

		
	}


public static void main1(String[] args){
	
	
	
	double t =20.0;
	double p = 4.0;
	
	
	for(double time=0.0; time<2048*12*257321.0; time=time+0.25){
		//System.out.println("In loop");
	long a0 = squareWave(257321.0,time);
	long a1 = squareWave(257339.0,time);
	long a2 = squareWave(257351.0,time);
	long a3 = squareWave(257353.0,time);
	long a4 = squareWave(257371.0,time);
	long a5 = squareWave(257381.0,time);
	long a6 = squareWave(257399.0,time);
	long a7 = squareWave(257401.0,time);
	long a8 = squareWave(257407.0,time);
	long a9 = squareWave(257407.0,time);
	long a10 = squareWave(257443.0,time);
	
	long a11 = squareWave(257447.0,time);
	
	//long a12 = squareWave(101489.0,time);
	
	//long a13 = squareWave(101501.0,time);
	//
	//long a14 = squareWave(101503.0,time);
	
	//long a15 = squareWave(101513.0,time);
	
	//long a16 = squareWave(53.0,time);
   //  System.out.println(""+a0+a1+a2+a3+a4+a5+a6+a7+a8+a9+a10+a11+a12+a13+a14+a15);
	
	long value = a0*1 + a1*2 +a2*4 + a3*8+ a4*16
			+ a5*32
			+ a6*64
			+ a7*128 + a8*256 +a9*512+a10*1024
			+a11*2048;
			//+a12*4096 +a13*8192+ a14*8192*2 + a15*8192*4;
			//a16*8192*8;
	aMap.put( value,"true");
	
	
	
	}
	
	aMap.forEach((k,v) ->System.out.println(k));
	int size = aMap.size();
	System.out.println("Size is:"+size);
	

	
}

	public static void main5(String[] args){
		
	
		
		double t =20.0;
		double p = 4.0;
		
		
		for(double time=0.0; time<1024*1024*4; time=time+0.25){
			//System.out.println("In loop");
		long a0 = squareWave(2.0,time);
		long a1 = squareWave(3.0,time);
		long a2 = squareWave(5.0,time);
		long a3 = squareWave(7.0,time);
		long a4 = squareWave(11.0,time);
		
		long a5 = squareWave(13.0,time);
		long a6 = squareWave(17.0,time);
		long a7 = squareWave(19.0,time);
		long a8 = squareWave(23.0,time);
		long a9 = squareWave(29.0,time);
		long a10 = squareWave(31.0,time);
		
		long a11 = squareWave(37.0,time);
		
		long a12 = squareWave(41.0,time);
		
		long a13 = squareWave(43.0,time);
		
		long a14 = squareWave(47.0,time);
		
		long a15 = squareWave(51.0,time);
		
		long a16 = squareWave(53.0,time);
		//System.out.println(a0);
		
		long value = a0*1 + a1*2 +a2*4 + a3*8+ a4*16+ a5*32+ a6*64+ a7*128 + a8*256 +a9*512+a10*1024+a11*2048
				+a12*4096 +a13*8192+ a14*8192*2 + a15*8192*4+ a16*8192*8;
		aMap.put( value,"true");
		
		
		
		}
		
		aMap.forEach((k,v) ->System.out.println(k));
		int size = aMap.size();
		System.out.println("Size is:"+size);
		
	
		
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
