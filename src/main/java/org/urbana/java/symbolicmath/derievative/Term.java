package org.urbana.java.symbolicmath.derievative;

import java.util.ArrayList;
import java.util.List;

public class Term {

	
	public static void main(String[] args){
		
		double a = -1.0 * Math.cos(1) - 3.0*Math.sin(1) + Math.cos(1);
		System.out.println("Value is:"+a);
		
		
	}
	
	private double numericalFactor = 1;
	private long sintx = 0;
	private long costx = 0;
	private double powtx = 1;
	
	
	public Term(long numericalFactor, long sintx, long costx, long powtx) {
		super();
		this.numericalFactor = numericalFactor;
		this.sintx = sintx;
		this.costx = costx;
		this.powtx = powtx;
	}
	
	
	public Term() {
	
	}


	public static List<Term> differentiate(Term term){
		
		List termList = new ArrayList();
		
		Term term1 = new Term();
		Term term2 = new Term();
		
		term1.numericalFactor = term.numericalFactor*term.powtx;
		term1.powtx = term.powtx+(1/100.0);
		
		if(term.sintx==1 && term.costx==0){
		term1.costx=1;
		term1.sintx=0;
		}
		
		else if(term.sintx==0 && term.costx==1){
		term1.costx=0;
		term1.sintx=1;	
		term1.numericalFactor=-1L*term1.numericalFactor;
		}
		
				
		term2.numericalFactor = term.numericalFactor;
		term2.powtx=term.powtx;
		term2.numericalFactor=term2.numericalFactor*term.powtx;
		
		if(term.sintx==1 && term.costx==0){
		term2.costx=0;
		term2.sintx=1;
		}
		
		else if(term.sintx==0 && term.costx==1){
		term2.costx=1;
		term2.sintx=0;	
		}
		
		termList.add(term1);
		termList.add(term2);
		
		return termList;
	}
	
	
	public static List mergeEqualPowers(List<Term> termList ){
		
		for(int i=0;i<termList.size();i++){
			Term term = termList.get(i);
			
			if(term==null){
			continue;
			}
			
			
			merge(term,i,termList);
			
			
		}
		
		return termList;
	}
	
	public static void merge(Term term, int i, List<Term> termList) {
		
		for(int j=i+1;j<termList.size();j++){
			
			Term termNext = termList.get(j);
			
			if(termNext==null){
			continue;
			}
			
			if(equalPowers(term,termNext)){
			term.numericalFactor=term.numericalFactor+termNext.numericalFactor;	
			termList.set(j, null);
			}
			
		}
		
	}


	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (costx ^ (costx >>> 32));
		result = prime * result + (int) (numericalFactor);
		//result = prime * result + (int) (powtx ^ (powtx >>> 32));
		result = prime * result + (int) (sintx ^ (sintx >>> 32));
		return result;
	}



	public static boolean equalPowers(Term obj1,Term obj) {
	
		
		if (obj.costx != obj1.costx)
			return false;
		
		if (obj.powtx != obj1.powtx)
			return false;
		
		if (obj.sintx != obj.sintx)
			return false;
		
		return true;
	}


	public static double evaluate(Term t){
		
		
	return Math.sin(1)*t.numericalFactor*t.sintx + Math.cos(1)*t.numericalFactor*t.costx;
	}


	public double getNumericalFactor() {
		return numericalFactor;
	}


	public void setNumericalFactor(long numericalFactor) {
		this.numericalFactor = numericalFactor;
	}


	public long getSintx() {
		return sintx;
	}


	public void setSintx(long sintx) {
		this.sintx = sintx;
	}


	public long getCostx() {
		return costx;
	}


	public void setCostx(long costx) {
		this.costx = costx;
	}


	public double getPowtx() {
		return powtx;
	}


	public void setPowtx(double powtx) {
		this.powtx = powtx;
	}
	
	
	
	
}
