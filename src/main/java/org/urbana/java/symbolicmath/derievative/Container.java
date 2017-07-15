package org.urbana.java.symbolicmath.derievative;

import java.util.ArrayList;
import java.util.List;

public class Container {

	
	
	public static void main(String[] args){
		
		
	Term term = new Term();
	
	term.setNumericalFactor(1);	
	term.setCostx(1);	
	term.setSintx(0);
	term.setPowtx(1/100.0);
	
	List<Term> f = Term.differentiate(term);
	
	List<Term> f2 = new ArrayList<Term>();
	
	for(Term term1:f){
	f2.addAll(Term.differentiate(term1));
	}
	
	
	List<Term> f3 = Term.mergeEqualPowers(f2);
	
	List<Term> f4 = clearNulls(f3);
	printTermList(f4);
	
	
	double sum = 0;
	for(Term term1:f4){
	
		if(term1==null){
			continue;
		}
		
		
	sum = sum  + Term.evaluate(term1);
	}
	
	printTermList(f4);
	
	System.out.println("Sum is:"+sum);
	
	
	
	List p = f4;
	for(int i=0;i<650;i++){
	p = diff(p,i+3);
	}
	
	/*
   List<Term> h2 = new ArrayList<Term>();
	
	for(Term term1:f4){
	h2.addAll(Term.differentiate(term1));
	}
	
  List<Term> h3 = Term.mergeEqualPowers(h2);
	
	List<Term> h4 = clearNulls(h3);
	
	double sum1 = 0;
	for(Term term1:h4){
	sum1 = sum1  + Term.evaluate(term1);
	}
	
	printTermList(h4);
	System.out.println("Sum1 is:"+sum1);
	*/
	
	
	}
	
	
	public static List diff(List<Term> list,int i){
		
		System.out.println("New derievative");
		 List<Term> h2 = new ArrayList<Term>();
			
			for(Term term1:list){
			h2.addAll(Term.differentiate(term1));
			}
			
		  List<Term> h3 = Term.mergeEqualPowers(h2);
			
			List<Term> h4 = clearNulls(h3);
			
			double sum1 = 0;
			for(Term term1:h4){
			sum1 = sum1  + Term.evaluate(term1);
			}
			
			printTermList(h4);
			System.out.println("Sum1 is:"+sum1);
			
		
		return h2;
		
	}

	public static void printTermList(List<Term> f4) {
	
		for(Term term1:f4){
			
			if(term1==null){
				continue;
			}
			
			if(term1.getSintx()==0 && term1.getCostx()==1){
			System.out.println(term1.getNumericalFactor()+"*"+"t^"+term1.getPowtx()+"*"+"costx");
			}
			
			else if(term1.getSintx()==1 && term1.getCostx()==0){
			System.out.println(term1.getNumericalFactor()+"*"+"t^"+term1.getPowtx()+"*"+"sintx");	
			}
			
		}
			
	}

	private static List<Term> clearNulls(List<Term> f3) {
		
		for(int i=0;i<f3.size();i++){
			if(f3.get(i)==null){
			f3.remove(i);
			}
		}
		
		return f3;
	}
	
	
	
	
	
	
	
	
}
