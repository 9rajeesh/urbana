package org.urbana.java.taylor.expansion;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaylorSeries {
	
	static boolean caching = false;
	
   
    public static boolean isCaching() {
		return caching;
	}

	public static void setCaching(boolean caching) {
		TaylorSeries.caching = caching;
	}

	//	Double h = 0.5;
	static Map<Integer,List<Term>> cachedListMap = new HashMap<Integer,List<Term>>();
	
	
	public static List<Term> expandTerm(Term term,int n,BigDecimal h){
		
		List<Term> taylorExpansion = new ArrayList<Term>();
		taylorExpansion.add(term);
		for(int i =1;i<=n;i++){
			List<Term>  termList = differentiateToNthDerievative(term,i);
			termList=scaleAllTerm(termList,h,i);
			taylorExpansion.addAll(termList);	
			}
		return taylorExpansion;
	}
	
	public static List<Term> expandTermUsingCache(Term term,int n,Double h){
		
		List<Term> taylorExpansion = new ArrayList<Term>();
		
		for(int i =1;i<=n;i++){
			List<Term>  termList = differentiateToNthDerievative(term,i);
			termList=scaleAllTerm(termList,new BigDecimal(h),i);
			taylorExpansion.addAll(termList);	
			}
		return taylorExpansion;
	}
		
	private static List<Term> scaleAllTerm(List<Term> differentiateToNthDerievative,BigDecimal h2, int i) {
		
		
		BigDecimal scaleFactor = power(h2, i).divide(factorial(i),Term.precision, RoundingMode.CEILING);

		for (Term term : differentiateToNthDerievative) {
			
			if (term.getCosine() != null) {
			term.setCosine(term.getCosine().multiply(scaleFactor));
			}

			else if (term.getSine() != null) {
			term.setSine(term.getSine().multiply(scaleFactor));
			}

		}
     return differentiateToNthDerievative;
	}

	private static BigDecimal factorial(int n) {
		BigDecimal a = new BigDecimal(1.0);
		
		for (int i = 1; i <= n; i++) {
		a = a.multiply(new BigDecimal(i));
		}
		return a;
	}

	public static  BigDecimal power(Double h2, int n) {

		BigDecimal a = new BigDecimal(1.0);
		for (int i = 0; i < n; i++) {
		a = a.multiply(new BigDecimal(h2));
		}
		return a;
	}
	
	public static  BigDecimal power(BigDecimal h2, int n) {

		BigDecimal a = new BigDecimal(1);
		for (int i = 0; i < n; i++) {
		a = a.multiply(h2);
		}
		return a;
	}

	public static List<Term> differentiateToNthDerievative(Term term, int n) {

		List<Term> termList = new ArrayList<Term>();
		List<Term> termListp = new ArrayList<Term>();
		termList.add(term);
		int index = 0;
		
		if(caching && cachedListMap.get(n-1)!=null){
			termList = cachedListMap.get(n-1);
			index = n-1;
		}

		for (int i = index; i < n; i++) {
			termListp = new ArrayList<Term>();
			for (Term termV : termList) {
				Terms terms = termV.differentiate(termV);
				termListp.add(terms.getTerm1());
				termListp.add(terms.getTerm2());
			}
			
			
			termList = compressList(termListp);
		}
		cachedListMap.put(n,termList);
		return termList;
	}

	public static List<Term> compressList(List<Term> termList) {

		for (Term term : termList) {
			getMatchingTermsAndMergeAndNullifyMergedTerms(term, termList);
		}

		return removeNulls(termList);
	}

	private static List<Term> removeNulls(List<Term> termList) {
		termList.removeIf(term -> term == null);
		return termList;
	}

	private static void getMatchingTermsAndMergeAndNullifyMergedTerms(Term term, List<Term> termList) {

		for (int i=0;i<termList.size();i++) {

			Term termV =termList.get(i); 
			if (term != termV &&term!=null && termV != null) {

				if ((term.getSine()==null && termV.getSine() ==null) ||  (term.getCosine()==null && termV.getCosine()==null)) {
					
						if (term.getNpower().equals(termV.getNpower())) {
							if (term.getPipower().equals(termV.getPipower())) {
								if (term.getXpower().equals(termV.getXpower())) {
									if (term.getLpower().equals(termV.getLpower())) {

										if (term.getCosine() != null) {
										term.setCosine(termV.getCosine().add(term.getCosine()));
										}

										else if (term.getSine() != null) {
										term.setSine(termV.getSine().add(term.getSine()));
										}
										termList.set(i, null);
									}
								}
							}
						
					}
				}
			}
		}
	}
}
