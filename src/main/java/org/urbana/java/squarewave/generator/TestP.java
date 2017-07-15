package org.urbana.java.squarewave.generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TestP {

	static Map<Long,String> aMap = new LinkedHashMap<Long,String>();
	static List<Double> periodList = new ArrayList<Double>();
	
	public static void main1(String[] args){
		
		Boolean a = null;
		
		
		double time =20.0;
		double p = 4.0;
		
		preparePeriodList(2.0,3.0,5.0,7.0,11.0,13.0,17.0,23.0,29.0,31.0,37.0,41.0);
		
		for(Double period:periodList){
			period = period-1.0;
		 
		  for(double t=period;t<period+2;t=t+0.25){	
			
		time =t;
			
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
		long a10 =squareWave(37.0,time);
		//long a11 = squareWave(41.0,time);
		
		//long a12 = squareWave(43.0,time);
		
		//long a13 = squareWave(47.0,time);
		
		//long a14 = squareWave(53.0,time);
		
		//long a15 = squareWave(59.0,time);
		
		//long a16 = squareWave(53.0,time);
	   //  System.out.println(""+a0+a1+a2+a3+a4+a5+a6+a7+a8+a9+a10+a11+a12+a13+a14+a15);
		
		long value = a0*1 + a1*2 +a2*4 + a3*8+ a4*16
				+a5*32+a6*64
		        + a7*128 + a8*256 +a9*512+a10*1024;
				//+a11*2048;
				//+a12*4096 +a13*8192+ a14*8192*2 + a15*8192*4;
				//a16*8192*8;
		aMap.put( value,"true");
		
		
		  }
		}
		
		aMap.forEach((k,v) ->System.out.println(k));
		int size = aMap.size();
		System.out.println("Size is:"+size);
		

		
	}


  private static void preparePeriodList(double... periodArray) {
   
	 for(Double period: periodArray) {
	  double t = 1;
  
         while(period*t<4096*16777259.0*8){
	   
	       double pp = period*t;
	      
	       if(!periodList.contains(pp)){
	    	   periodList.add(pp) ;
	       }
	       
	       t=t+1.0; 
         }
	
	 }
		
	}
  
  
  public static void main(String[] args){
		
		
		double time =20.0;
		double p = 4.0;
		
		preparePeriodList(16777259.0,
				16777289.0,
				16777291.0,
				16777331.0,
				16777333.0,
				16777337,
				16777381,
				16777421,
				16777441,
				16777447,
				16777469,
				16777499
				);
				
		
		for(Double period:periodList){
			period = period-1.0;
		 
		  for(double t=period;t<period+2;t=t+0.25){	
			
		time =t;
			//System.out.println("In loop");
		long a0 = squareWave(16777259.0,time);
		long a1 = squareWave(16777289.0,time);
		long a2 = squareWave(16777291.0,time);
		long a3 = squareWave(16777331.0,time);
		long a4 = squareWave(16777333.0,time);
		long a5 = squareWave(16777337,time);
		long a6 = squareWave(16777381,time);
		long a7 = squareWave(16777421,time);
		long a8 = squareWave(16777441,time);
		long a9 = squareWave(16777447,time);
		long a10 = squareWave(16777469,time);
		long a11 = squareWave(16777499.0,time);
		
		//
		//long a14 = squareWave(101503.0,time);
		
		//long a15 = squareWave(101513.0,time);
		
		//long a16 = squareWave(53.0,time);
	   //  System.out.println(""+a0+a1+a2+a3+a4+a5+a6+a7+a8+a9+a10+a11+a12+a13+a14+a15);
		
		long value = a0*1 + a1*2 +a2*4 + a3*8+ a4*16
				+ a5*32
				+ a6*64
				+ a7*128 + a8*256 +a9*512
		       + a10*1024
				+a11*2048;
				//+a12*4096;
				//+a13*8192+ a14*8192*2 + a15*8192*4;
				//a16*8192*8;
		aMap.put( value,"true");
		
		
		
		 }
		}
		
		aMap.forEach((k,v) ->System.out.println(k));
		int size = aMap.size();
		System.out.println("Size is:"+size);
		

		
	}


public static void main2(String[] args){
	
		
	double time =20.0;
	double p = 4.0;
	
	preparePeriodList(477881.0,477899.0,477913.0,477941.0,477947.0,477973.0,477977.0,477991.0,478001.0,478039.0,478063.0,478067.0,478069.0);
	
	for(Double period:periodList){
		period = period-1.0;
	 
	  for(double t=period;t<period+2;t=t+0.25){	
		
	time =t;
		//System.out.println("In loop");
	long a0 = squareWave(477881.0,time);
	long a1 = squareWave(477899.0,time);
	long a2 = squareWave(477913.0,time);
	long a3 = squareWave(477941.0,time);
	long a4 = squareWave(477947.0,time);
	long a5 = squareWave(477973.0,time);
	long a6 = squareWave(477977.0,time);
	long a7 = squareWave(477991.0,time);
	long a8 = squareWave(478001.0,time);
	long a9 = squareWave(478039.0,time);
	long a10 = squareWave(478063.0,time);
	
	long a11 = squareWave(478067.0,time);
	
	long a12 = squareWave(478069.0,time);
	
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
			+a11*2048
			+a12*4096;
			//+a13*8192+ a14*8192*2 + a15*8192*4;
			//a16*8192*8;
	aMap.put( value,"true");
	
	
	
	 }
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
