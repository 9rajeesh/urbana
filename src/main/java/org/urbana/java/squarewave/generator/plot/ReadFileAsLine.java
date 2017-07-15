package org.urbana.java.squarewave.generator.plot;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReadFileAsLine {

	
	public static int[] readFile(int size,int offset){
		///1789116
		List aList = new ArrayList();
		int[] ar = new int[size];
		int i = 0;
		try{
			  // Open the file that is the first 
			  // command line parameter
			  FileInputStream fstream = new FileInputStream("D:\\data.txt");
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  //Read File Line By Line
			  int j=0;
			  while ((strLine = br.readLine()) != null && j<size)   {
			  // Print the content on the console
				  if(i>=offset && !aList.contains(strLine)){
				  ar[j] = Integer.parseInt (strLine);
				  aList.add(strLine);
				  
				  j++;
				  }
				  i++;
			  }
			  //Close the input stream
			  in.close();
			    }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
		
		
		return ar;
	}
	
	
	
	
	
	
	
}
