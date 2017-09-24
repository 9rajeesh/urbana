package org.urbana.java.criteria.generator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.urbana.java.taylor.expansion.Term;

public class Harmonics {

	
	
 public static List<Term> generateHarmonics(int harmonic, List<Term> baseTerms)	{
	final List<Term> baseTerms1 = ApplyCriteria.mergeLikeTerms(baseTerms);
	List<Term> terms = new ArrayList<Term>();
	

	int power = 0;
	
	//1
	terms.addAll(scale(termPower(baseTerms1,1),1*1.27323));
	
	//3
	terms.addAll(scale(termPower(baseTerms1,1),3*(0.42441)));
	terms.addAll(scale(termPower(baseTerms1,3),-4*0.42441));
	
	
	//5
	terms.addAll(scale(termPower(baseTerms,1),5*0.2546479));
	terms.addAll(scale(termPower(baseTerms,3),-20*0.2546479));
	terms.addAll(scale(termPower(baseTerms,5),16*0.2546479));
	
	//terms = ApplyCriteria.mergeLikeTerms(terms);
	
	return terms;
}


 private static List<Term> scale(List<Term> termPower, double d) {
	 List<Term> terms1 = new ArrayList<Term>();
	 for(Term term:termPower){
		 Term termp = new Term();
		 termp.setXpower(term.getXpower());
		
		 if(term.getSine()!=null){
		 termp.setSine(term.getSine());
		 termp.setSine(term.getSine().multiply(new BigDecimal(d))); 
		 }
		 else if(term.getCosine()!=null){
			 termp.setCosine(term.getCosine());
			 termp.setCosine(term.getCosine().multiply(new BigDecimal(d))); 	 
		 }
		 
		 
		 terms1.add(termp);
	 }
	 
	//termPower.forEach(term-> term.setSine(term.getSine().multiply(new BigDecimal(d))));
	
	return terms1;
 }


 private static List<Term> termPower(List<Term> baseTerms, int power) {
	
	 List<Term> terms = new ArrayList<Term>(baseTerms);
	 List<Term> terms1 = new ArrayList<Term>();
	 int count =0;
	 
	 
	 for(int i=1;i<power;i++){
		 if(count==0){
		 terms1 = ApplyCriteria.multiplyAndMerge(baseTerms, terms);
		 count++;
		 }
		 
		 else{
		 terms1 = ApplyCriteria.multiplyAndMerge(baseTerms, terms1);	 
		 }
	 }
	 
	 if(terms1.isEmpty()){
	 return terms;
     }
	return terms1;
 }

 private static List<Term> getOnlySineTerms(List<Term> baseTerms) {
	
	 List<Term> terms = new ArrayList<Term>();
	 
	 for(Term term:baseTerms){
		 
		 if(term.getSine()!=null){
			 term.setSine(term.getSine().multiply(new BigDecimal("-1")));
			 terms.add(term);
		 }
	 }
	 
	return terms;
 }
	
	
	
	
	
	
	
	
	
}
