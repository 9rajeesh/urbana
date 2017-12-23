package org.urbana.java.criteria.generator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
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
	static Double smallest = 10.0;
	static Double smallestAtValue = 10.0;
	
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
			term1.setSine(term1.getSine().add(WaveletFactory.normalize(term.getSine())));
			}
	   	}
			
			else if(term.getCosine()!=null){
			Term term1 = termMapc.get(term.getXpower());

			if (term1 == null) {
			termMapc.put(term.getXpower(), term);
			}

			else {
			term1.setCosine(term1.getCosine().add(WaveletFactory.normalize(term.getCosine())));
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
    	
    	
    	//List<Term> termsa1 = wv.termListMap.get("a5");
    	//System.out.println("Terms:"+termsa1.size());
    	
    	
    	//for(Term term:wv.fetchOnlyRelevent(wv.termListMap.get("a2"))){
    	//System.out.println("Term a2:"+term)	;
    	//}
    	
    	
    	 //Collections.sort(wv.termListMap.get("a5"));
    	
    	//printTerms(wv.termListMap.get("a20"));
    	
    	
    	//BigDecimal h = evaluate(wv.termListMap.get("a2"),new BigDecimal("2003"));
    	//sSystem.out.println("Value a2 is:"+h);
    	BigDecimal value = new BigDecimal("10");
    	
    	for(int i=0;i<100;i++){
    	value = value.add(new BigDecimal("20"));
    	
    	BigDecimal h1 = evaluate(wv.termListMap.get("a5"),value);
    	System.out.println("Value a5 at "+value+" is:"+h1);
    	
    	BigDecimal h2 = evaluate(wv.termListMap.get("a10"),value);
    	System.out.println("Value a10 at "+value+" is:"+h2);
    	
    	BigDecimal h3 = evaluate(wv.termListMap.get("a15"),value);
    	System.out.println("Value a15 at "+value+" is:"+h3);
    	
    	BigDecimal h4 = evaluate(wv.termListMap.get("a20"),value);
    	System.out.println("Value a20 at "+value+" is:"+h4);
    	
    	BigDecimal h5 = evaluate(wv.termListMap.get("a8"),value);
    	System.out.println("Value a8 at "+value+" is:"+h5);
    	
    	printboolean(h1,h2,h3,h4,h5);
    	
    	
    	
    	BigDecimal a0 = new BigDecimal("1").subtract(new BigDecimal("1").subtract(h1).divide(new BigDecimal(2),RoundingMode.CEILING));
    	BigDecimal a1 = new BigDecimal("1").subtract(new BigDecimal("1").subtract(h2).divide(new BigDecimal(2),RoundingMode.CEILING));
    	BigDecimal b0 = new BigDecimal("1").subtract(new BigDecimal("1").subtract(h4).divide(new BigDecimal(2),RoundingMode.CEILING));
    	BigDecimal b1 = new BigDecimal("1").subtract(new BigDecimal("1").subtract(h5).divide(new BigDecimal(2),RoundingMode.CEILING));
    	
    	BigDecimal sum1 = a0.multiply(b0);
    	BigDecimal sum2 = new BigDecimal("2").multiply(a0.multiply(b1).add(a1.multiply(b0)));
     	BigDecimal sum3 = new BigDecimal("4").multiply(a1.multiply(b1));
     	
     	BigDecimal sum = sum1.add(sum2).add(sum3);
     	
     	Double v = Math.abs(sum.doubleValue() - 6);
     	if(v<smallest){
     		smallest=v;
     		smallestAtValue=value.doubleValue();
     	}
    	
    	System.out.println("Value a0 is:"+a0);
    	System.out.println("Value a1 is:"+a1);
    	System.out.println("Value b0 is:"+b0);
    	System.out.println("Value b1 is:"+b1);
    	System.out.println("Sum at:"+value+"is:"+sum);
    	}
    	System.out.println("Smallest is:"+smallest);
    	System.out.println("Smallest value is:"+smallestAtValue);
    	comb.stream().
    	filter( s-> !s.contains("E")).collect(Collectors.toSet()).forEach(s->System.out.println(s));;
    	
    	
    	
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
    
    static List<String> comb = new ArrayList<String> ();
    
    private static void printboolean(BigDecimal... harry) {
    	
    	String s= "";
    	for(BigDecimal h:harry){
    		
    		double a = h.doubleValue();
    		if(a<-0.8 && a>-1.2){
    			s= s+"0";
    		}
    		else if(a>0.8 && a<1.2){
    			//System.out.print("1");
    			s= s+"1";
    		}
    		else{
    			//System.out.print("E");
    			s= s+"E";
    		}
    		
    	}
    	comb.add(s);	
	}





	private void printTerms(List<Term> list) {
    	 	
    	
    	for(Term term:list){
    	BigDecimal h1 = evaluate(term,new BigDecimal("2000"));
    	
    	h1=h1.multiply(h1);
		if(h1.compareTo(new BigDecimal("0.01"))>0){
		System.out.println("Term a20:" + term);
			
		}
	 }
    }





	private BigDecimal evaluate(Term term, BigDecimal x) {
	
		if(term.getSine()!=null){
    	return (term.getSine().multiply(TaylorSeries.power(x,term.getXpower())));
		}
		
		if(term.getCosine()!=null){
    	return (term.getCosine().multiply(TaylorSeries.power(x,term.getXpower())));
		}
		
		return null;
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
    
    
    
    public static void main(String[] args) throws InterruptedException{
    	
    
    	//Thread.sleep(30000);
    	
    	Criteria criteria = new Criteria ();
    	ApplyCriteria applyCriteria = new ApplyCriteria();
    	applyCriteria.applyCiteria(criteria);
    	computeDegree();
    	
        }
    
    
    
    
	
	
}
