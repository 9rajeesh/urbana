package org.urbana.java.criteria.generator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.urbana.java.taylor.expansion.TaylorSeries;
import org.urbana.java.taylor.expansion.Term;

public class ApplyCriteria {

	Criteria criteria;
	static int max = 0;
	static List<Term> listOfTerms = new ArrayList<Term>();
		
	public static List<Term> scale(List<Term> termList){
		 termList.stream().forEach( term ->{
			
			 BigDecimal value = term.getSine();
			
			 if(value==null){
			 value = term.getCosine();
			 }
			 
			BigDecimal a = new BigDecimal(1)
					       .subtract(value)
					       .divide(new BigDecimal(2),Term.precision,RoundingMode.CEILING);
			
			if(term.getSine()!=null){
			term.setSine(a);
			}
			else if(term.getCosine()!=null)
			term.setCosine(a);
		    }
		    );
		 return termList;
		}
	              
	

	
	
	public static List<Term> setSineToOneAndCosineToZero(List<Term> termList) {
		termList = termList.stream().filter(term -> term.getCosine()==null)
		                 .collect(Collectors.toList());
		
	return termList;
	}
	
	
    public static List<Term> multiplyAndMerge(List<Term> termList1, List<Term> termList2){
		
    	List<Term> productTerms = new ArrayList<Term>();
    	
    	if(termList1.isEmpty() && !termList2.isEmpty()){
    	productTerms.addAll(termList2);
    	return productTerms;
    	}
    	
    	else if(!termList1.isEmpty() && termList2.isEmpty()){
        productTerms.addAll(termList1);
        return productTerms;
        }
    	
    	
    	for(Term term1:termList1){
    	  		for(Term term2:termList2){
    	  			
    	  		if(term1.getSine()!=null && term2.getCosine()!=null){
    	  			continue;
    	  		}
    	  		
    	  		if(term1.getCosine()!=null && term2.getSine()!=null){
    	  			continue;
    	  		}
    		 	productTerms.add(multiply(term1,term2));
    	  	}
    	 }
    	productTerms = mergeLikeTerms(productTerms);
    		
	 return productTerms;
	}
    
    private static Term multiply(Term term1, Term term2) {
		Term term = new Term();
		//Combine all powers of N to one single constant
		
		if(term1.getSine()!=null && term2.getSine()!=null){
		term.setSine(term1.getSine()
				    .multiply(term2.getSine())
				     );
		
		
		}
		
		else if(term1.getCosine()!=null && term2.getCosine()!=null){
			term.setCosine(term1.getCosine()
					    .multiply(term2.getCosine())
					    
					    );
			}
		
	
		term.setXpower(term1.getXpower()+term2.getXpower());
		//term.setPipower(term1.getPipower()+term2.getPipower());
		///term.setLpower(term1.getLpower()+term2.getLpower());
		
		return term;
	}


	public static List<Term> mergeLikeTerms(List<Term> termList1) {

		Map<Integer, Term> termMaps = new HashMap<Integer, Term>();
		Map<Integer, Term> termMapc = new HashMap<Integer, Term>();
		
		for (Term term : termList1) {
			
			if(term.getSine()!=null){
			Term term1 = termMaps.get(term.getXpower());

			if (term1 == null) {
			termMaps.put(term.getXpower(), term);
			}

			else {
			term1.setSine(term1.getSine().add(term.getSine()));
			}
	   	}
			
			else if(term.getCosine()!=null){
			Term term1 = termMapc.get(term.getXpower());

			if (term1 == null) {
			termMapc.put(term.getXpower(), term);
			}

			else {
			term1.setCosine(term1.getCosine().add(term.getCosine()));
			}
	   	}
		}	

		List<Term> terms = new ArrayList<Term>(termMaps.values());
		List<Term> terms2 = new ArrayList<Term>(termMapc.values());
		terms.addAll(terms2);
		
		return terms;
	}
    
    public void generatePolynomialEquations(List<Term> termList){
    	
    	
    }
        
    public void applyCiteria(Criteria criteria){
    	
    	CriteriaFactory CriteriaFactory = new CriteriaFactory();
    	criteria = CriteriaFactory.generateCriteria();
    	WaveletFactory wv = new WaveletFactory();
    	wv.createAllWaveletsMap();
    	wv.substituteLowerInHigherInMap(new BigDecimal(0));
    	wv.createSquareWaves();
    	
    	
    	List<Term> termsa1 = wv.termListMap.get("a2");
    	System.out.println("Terms:"+termsa1.size());
    	
    	
    	//for(Term term:wv.fetchOnlyRelevent(wv.termListMap.get("a2"))){
    		//System.out.println("Term a2:"+term)	;
    	//}
    	
    	//for(Term term: wv.fetchOnlyRelevent(wv.termListMap.get("a20"))){
    		//System.out.println("Term a20:"+term)	;
    	//}
    	
    	BigDecimal h = evaluate(wv.termListMap.get("a2"),new BigDecimal("1522.10164066"));
    	System.out.println("Value a2 is:"+h);
    	
    	BigDecimal h1 = evaluate(wv.termListMap.get("a20"),new BigDecimal("1522.10164066"));
    	System.out.println("Value a20 is:"+h1);
    	
    	
    	/*for(Expression exp:criteria.getExpList()){
    		
    		List<Term> termList = new ArrayList<Term>();
    		
    		for(String variable:exp.getVarList()){
            termList = multiplyAndMerge(termList, setSineToOneAndCosineToZero(wv.termListMap.get(variable)));
    		}
    		listOfTerms.addAll(termList);
    	 }
    	 
    	  generatePolynomialEquations(mergeLikeTerms(listOfTerms));
    	  */
    }
    
    public static BigDecimal evaluate(List<Term> terms,BigDecimal x){
    	
    	BigDecimal sum = new BigDecimal("0");
    	for(Term term:terms){
    	
    		if(term.getSine()!=null){
    		sum = sum.add(term.getSine().multiply(TaylorSeries.power(x,term.getXpower())));
    		}
    		
    		else if(term.getCosine()!=null){
    		//sum = sum.add(term.getCosine().multiply(TaylorSeries.power(x,term.getXpower())));	
    		}
    		
    	}
    	return sum;
    }
    
    public static void computeDegree(){
    	
    	listOfTerms.stream().forEach(term->
    	{	
    	if(term.getXpower()>max){
    	max=term.getXpower();	
    	}
    		
    	});
    	System.out.println("Max is:"+max);
    	System.out.println("Count is:"+listOfTerms.size());
    
    	
    }
    
    
    
    public static void main(String[] args){
    	
    	Criteria criteria = new Criteria ();
    	ApplyCriteria applyCriteria = new ApplyCriteria();
    	applyCriteria.applyCiteria(criteria);
    	computeDegree();
        }
    
    
    
    
	
	
}
