package org.urbana.java.squarewave.generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TestUrbana {

	static Map<Long,String> aMap = new HashMap<Long,String>();
	static List<Long> aList = new ArrayList<Long>();
	static List<Double> periodList = new ArrayList<Double>();
	
	public static void main1(String[] args){
				
		double time =20.0;
		double p = 4.0;
		
		preparePeriodList(2.0,3.0,5.0,7.0,11.0,13.0,17.0,23.0,29.0,31.0,37.0,41.0,43.0,47.0,53.0,59.0);
		
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
		long a10 = squareWave(37.0,time);
		long a11 = squareWave(41.0,time);
		
		long a12 = squareWave(43.0,time);
		
	    long a13 = squareWave(47.0,time);
		
		long a14 = squareWave(53.0,time);
		
		long a15 = squareWave(59.0,time);
		
		//long a16 = squareWave(53.0,time);
	   //  System.out.println(""+a0+a1+a2+a3+a4+a5+a6+a7+a8+a9+a10+a11+a12+a13+a14+a15);
		
		long value = a0*1 + a1*2 +a2*4 + a3*8+ a4*16
				+a5*32+a6*64
		        + a7*128 + a8*256 +a9*512+a10*1024
				+a11*2048
				+a12*4096
				+a13*8192
			+ a14*8192*2
			+ a15*8192*4;
				//a16*8192*8;
		aMap.put( value,"true");
		
		
		  }
		}
		
		aMap.forEach((k,v) ->System.out.println(k));
		int size = aMap.size();
		System.out.println("Size is:"+size);
		

		
	}


	private static void preparePeriodList(double... periodArray) {

		for (Double period : periodArray) {

			double h = 1;
			double t = 1.0;

			while (t < 65536.0*16*4) {
				t = (period / 2) * h;

				if (!periodList.contains(t)) {
					periodList.add(t);
				}

				h = h + 1.0;
			}
		}
	}
  
  
  	public static void main(String[] args) {
		
		
		double time =20.0;
		double p = 4.0;
		//521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 
		
		//double[] a = new double[]{727.0, 733.0, 739.0, 743.0, 751.0, 757.0, 761.0, 769.0, 773.0, 787.0, 797.0, 809.0, 811.0, 821.0, 823.0, 827.0};
		
		double[] a = new double[]{ 
				
				////1024.0,1025.05,1026.10,1027.15,1028.20,
				//1029.25,1030.30,1031.35,1032.40,1033.45,
				///1034.50,1035.55,1036.60,1037.65,1038.70,1039.75,1040.80,1041.85,1042.90,1043.95
				
				//256,257,258,259,260, 261,262,263,264,265, 266,267,268,269,270, 271
				//512/2,514,516,518,520, 522,524,526,528,530, 532,534,536,538,540, 542,544,546
				
				//1024/3,1025,1026,1027,1028, 1029,1030,1031,1032,1033, 1034,1035,1036,1037,1038, 1039,1040,1041,1042,1043
				
				2048/4,1025,1026,1027,1028, 1029,1030,1031,1032,1033, 1034,1035,1036,1037,1038, 1039,1040,1041,1042,1043, 1,1
				//1024.0,1024.1,1024.2,1024.3,1024.4,
				//1024.5,1024.6,1024.7,1024.8,1024.9,
				//1025.0,1025.1,1025.2,1025.3,1025.4,1025.5,1025.6,1025.7,1025.8,1025.9
				};
		
		for(int i=1;i<a.length;i++){
			a[i] = a[0]+(i*1);
		}
		
		
		preparePeriodList(a);
				
				
		for(Double period:periodList){
			period = period-1.0;
		 
		  for(double t=period;t<period+2;t=t+0.5){	
			
		time =t;
			//System.out.println("In loop");
		long a0 = squareWave(a[0],time);
		long a1 = squareWave(a[1],time);
		long a2 = squareWave(a[2],time);
		long a3 = squareWave(a[3],time);
		long a4 = squareWave(a[4],time);
		long a5 = squareWave(a[5],time);
		long a6 = squareWave(a[6],time);
		long a7 = squareWave(a[7],time);
		long a8 = squareWave(a[8],time);
		long a9 = squareWave(a[9],time);
		long a10= squareWave(a[10],time);
		long a11= squareWave(a[11],time);
		long a12= squareWave(a[12],time);
	    long a13 = squareWave(a[13],time);
		long a14 = squareWave(a[14],time);
		long a15 = squareWave(a[15],time);
	    long a16 = squareWave(a[16],time);
		long a17 = squareWave(a[17],time);
		
		long a18 = squareWave(a[18],time);
		long a19 = squareWave(a[19],time);
		//
		long a20 = squareWave(a[20],time);
		long a21 = squareWave(a[21],time);
	   //  System.out.println(""+a0+a1+a2+a3+a4+a5+a6+a7+a8+a9+a10+a11+a12+a13+a14+a15);
		
		long value = a0*1 + a1*2 +a2*4 + a3*8+ a4*16
				+ a5*32
				+ a6*64
				+ a7*128 
				+ a8*256 +a9*512
		        + a10*1024
			    + a11*2048
				+ a12*4096
			    + a13*8192
				+ a14*8192*2
				+ a15*8192*4
				+a16*8192*8
		        + a17*8192*16
		        +a18*8192*32
		        +a19*8192*64
		        +a20*8192*128
                +a21*8192*256;
		
		///aMap.put( value,"true");
		//System.out.println("Value:"+value);
		if(!aList.contains(value)){
		aList.add(value);
		  }
		 }
		}
		
		//aList.forEach((value) ->System.out.println(value));
		int size = aList.size();
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
	///aMap.put( value,"true");
	aList.add(value);
	
	
	 }
	}
	
	aList.forEach((v) ->System.out.println(v));
	int size = aList.size();
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
		
		aMap.forEach((k,v) ->{
			
			if(k.equals("A")){
				
			  }
		     }
         );
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
