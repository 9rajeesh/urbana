package org.urbana.java.term.algebra;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.urbana.java.taylor.expansion.TaylorSeries;
import org.urbana.java.taylor.expansion.Term;

public class TermAlgebra {

	private double h;
	
	
	public double getHValue(){
		
	return 0.0;
	}
	
	
	public List<Term> performTermAlgerba(Term term){
        
		Map<Term,List<Term>>  termMap  = new HashMap<Term,List<Term>> ();
		
		Term termSine = new Term();
		termSine.setSine(new BigDecimal(1));
		termSine.setNpower(0);
		termSine.setPipower(0);
		termSine.setXpower(0);
		termSine.setLpower(0);
		
		List<Term> terms = addL(TaylorSeries.differentiateToNthDerievative(termSine,n),i);
		
		
		Term termCosine = new Term();
		termCosine.setCosine(new BigDecimal(1));
		termCosine.setNpower(0);
		termCosine.setPipower(0);
		termCosine.setXpower(0);
		termCosine.setLpower(0);
		
		terms = addL(TaylorSeries.differentiateToNthDerievative(termCosine,n),i);
				
		termMap.put(termSine, terms);
		termMap.put(termCosine, terms);
		
		
		
		
	return new ArrayList();
	}
	
	public List<Term> multiplyAndMerge(List<Term> termList1,List<Term> termList2){
		
		
	return new ArrayList();
	}
		
		
		
	
	
	
	
	
	
	
	
	
	
}
