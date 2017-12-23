package org.urbana.java.criteria.generator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.urbana.java.taylor.expansion.TaylorSeries;
import org.urbana.java.taylor.expansion.Term;

public class WaveletFactory {

	
	public static double PI = 3.14159265359;
	
	public static int SIZE = 2;
	public static int N = 20;
	public static final BigDecimal L = new BigDecimal("51");
	public static  BigDecimal delta = new BigDecimal("1");
	
	static Integer maxXpower = 0;
	static Map<String, List<Term>> termListMap = new HashMap<String, List<Term>> ();
	static Map<String, List<Term>> lMap = new HashMap<String, List<Term>> ();
	static Map<Integer,BigDecimal> xsinMap = new HashMap<Integer,BigDecimal>();
	static Map<Integer,BigDecimal> xcosMap = new HashMap<Integer,BigDecimal>();
	
	
	private static BigDecimal X = new BigDecimal("12");
	/*
	public void createWavelet(){
		
	//each L	
	for(int i=0; i<SIZE; i++){
				
		Term term = new Term();
		term.setSine(new BigDecimal(1));
		term.setNpower(0);
		term.setPipower(0);
		term.setXpower(0);
		term.setLpower(0);
		term.setL(L.add(new BigDecimal(i*delta)));
				
		TaylorSeries taylorSeries = new TaylorSeries();
		List<Term> termList = taylorSeries.expandTerm(term,100,i*delta);
		
		List<Term> termListCombined = new ArrayList<Term>();
		for(int j=1;j<=N;j=j+2){
		termListCombined.addAll(substituteNAndCreateFourierComb(termList,j));
		}
		
		termListCombined = mergeLikeTerms(termListCombined);
		termListMap.put("a"+i, termListCombined);
		}
		
	}
  */
	
	public static List<Term> substituteLowerInHigherInMap(BigDecimal L) {
		List<Term> termListCombined = new ArrayList<Term>();

		for (int i = 2; i <= N; i++) {

			List<Term> sinNl = lMap.get("sin" + (int) (i - 1));
			List<Term> cosNl = lMap.get("cos" + (int) (i - 1));

			List<Term> sinNh = lMap.get("sin" + (int) (i));
			List<Term> cosNh = lMap.get("cos" + (int) (i));

			List<Term> term1 = substituteLowerInHigher(sinNl, filterOnlySine(sinNh));
			List<Term> term2 = substituteLowerInHigher(cosNl, filterOnlyCosine(sinNh));
			term1.addAll(term2);
			lMap.put("sin" + (int) (i), term1);

			List<Term> term3 = substituteLowerInHigher(sinNl, filterOnlySine(cosNh));
			List<Term> term4 = substituteLowerInHigher(cosNl, filterOnlyCosine(cosNh));
			term3.addAll(term4);
			lMap.put("cos" + (int) (i), term3);

		}

		return termListCombined;
	}
	
	private static List<Term> filterOnlyCosine(List<Term> sinNh) {
		sinNh = sinNh.stream()
				.filter(term -> term.getSine() == null)
				.collect(Collectors.toList());
		return sinNh;
	}

	private static List<Term> filterOnlySine(List<Term> sinNh) {
		sinNh = sinNh.stream()
				.filter(term -> term.getCosine() == null)
				.collect(Collectors.toList());
		
		return sinNh;
	}

	public static List<Term> substituteLowerInHigher(List<Term> termList1, List<Term> termList2) {
			
	    	List<Term> productTerms = new ArrayList<Term>();
	    	
	    	if(termList1.isEmpty() && !termList2.isEmpty()){
	    	productTerms.addAll(termList2);
	    	return productTerms;
	    	}
	    	
	    	else if(!termList1.isEmpty() && termList2.isEmpty()){
	        productTerms.addAll(termList1);
	        return productTerms;
	        }
	    	
	    	
	    	for(Term term2:termList2){	    	
	    	    for(Term term1:termList1){	
	    	  	
	    		 	productTerms.add(multiplyWithSubstitution(term1,term2));
	    	  	}
	    	 }
	    	
	    	productTerms = addAllLikeTerms(productTerms);
	    	//productTerms = TaylorSeries.compressList(newProdTerms);
	    		
		 return productTerms;
		}
	
	 private static Term multiplyWithSubstitution(Term term1, Term term2) {
			Term term = new Term();
			//Combine all powers of N to one single constant
					
 			BigDecimal higher = term2.getSine();
			BigDecimal lower = null;
			
			if(higher==null){
			higher = term2.getCosine();
			}
			
			if(term1.getSine()!=null){
			lower = term1.getSine();
			}
				
			else if(term1.getCosine()!=null){
			lower = term1.getCosine();
			}
						
			
			
			BigDecimal prod = lower
					    .multiply(higher)
					   // .multiply(TaylorSeries.power(new BigDecimal(WaveletFactory.PI),term1.getPipower()))
					   // .multiply(TaylorSeries.power(new BigDecimal(WaveletFactory.PI),term2.getPipower()))
					   /// .multiply(TaylorSeries.power(X.doubleValue(),term1.getXpower()))
					   /// .multiply(TaylorSeries.power(X.doubleValue(),term2.getXpower()))
										    
					   // .multiply(TaylorSeries.power(term1.getN().doubleValue(),term1.getNpower()))
					  //  .multiply(TaylorSeries.power(term2.getN().doubleValue(),term2.getNpower()))
					   //.divide(TaylorSeries.power(term1.getL().doubleValue(),Math.abs(term1.getLpower())),
					    ///	Term.precision,RoundingMode.CEILING)
					   //.divide(TaylorSeries.power(term2.getL().doubleValue(),Math.abs(term2.getLpower())),
					   ///	Term.precision,RoundingMode.CEILING)
					    
					    ;
				    
			/*
			Double v1 = TaylorSeries.power(term1.getL().doubleValue(),Math.abs(term1.getLpower())).doubleValue();
			Double v2 = TaylorSeries.power(term2.getL().doubleValue(),Math.abs(term2.getLpower())).doubleValue();
			BigDecimal prod = new BigDecimal(lower.doubleValue()*higher.doubleValue()/(v1*v2));
			*/
			
			
			if(term1.getSine()!=null){
			term.setSine(prod);
			}
			
			else if(term1.getCosine()!=null){
			term.setCosine(prod);	
			}
								    
			term.setN(1);
			term.setNpower(0);
			term.setXpower(term1.getXpower()+term2.getXpower());
			term.setPipower(term1.getPipower()+term2.getPipower());
			term.setL(L);
			term.setLpower(0);
			term.setLpower(term1.getLpower()+term2.getLpower());
			
			term.getLlist().addAll(term1.getLlist());
			term.getLlist().addAll(term2.getLlist());
						
			return term;
		}
	 
	 
	 public static  List<Term> addAllLikeTerms(List<Term> termlist){
		 
		 List<Term> t = new ArrayList<Term>();
		 
		 Map<Integer,Term> sinMap= new HashMap<Integer,Term>();
		 Map<Integer,Term> cosMap= new HashMap<Integer,Term>();
		 
		 for(Term term:termlist){
		 
			boolean flagExistence = false;
			Integer xPower = term.getXpower();
			
			if(xPower>80){
				//continue;
			}
			
			
			BigDecimal value1 = new BigDecimal(1);
			BigDecimal prod = null;
						
			if(term.getSine()!=null){
			prod = term.getSine();
			  if(sinMap.get(term.getXpower())!=null){
			  flagExistence = true;
			  }
			}
			
			else if(term.getCosine()!=null){
			prod = term.getCosine();
			
			 if(cosMap.get(term.getXpower())!=null){
			 flagExistence = true;
			 }
		    }
						
			for(BigDecimal l:term.getLlist()){
			value1 = value1.multiply(l);
			}
			
			BigDecimal valueInverse = inverse(value1);
			prod=prod.multiply(valueInverse);
			//prod = normalize(prod);
			//prod = prod.divide(value1,Term.precision,RoundingMode.CEILING);
			term.setLlist(new ArrayList<BigDecimal>());
					
			if(term.getSine()!=null){
			
				if(flagExistence){
					Term t1 = sinMap.get(term.getXpower());
					t1.setSine(t1.getSine().add(prod));
				}
				else{
			    term.setSine(prod);
			    sinMap.put(term.getXpower(), term);
				}
			}
						
			else if(term.getCosine()!=null){
				
				if(flagExistence){
				Term t1 = cosMap.get(term.getXpower());
				t1.setCosine(t1.getCosine().add(prod));
				}
				else{
			    term.setCosine(prod);	
			    cosMap.put(term.getXpower(), term);
			    }
			}
					    
		 }
		List<Term> list =  new  ArrayList<Term>(); 
		List<Term> sinList = new ArrayList<Term>(sinMap.values());
		List<Term> cosList = new ArrayList<Term>(cosMap.values()); 
		list.addAll(sinList);
		list.addAll(cosList);
		
		return list;
	 }
	 
	public static BigDecimal normalize(BigDecimal prod) {
         return prod;
		/*
          String a = prod.toEngineeringString();

		if (a.contains(".") && a.contains("E")) {
			//System.out.println("a is:"+a);

			Pattern pattern = Pattern.compile("^(.+?)\\.(.+?)E(.+?)$");
			Matcher matcher = pattern.matcher(a);
			matcher.find();

			String a1 = matcher.group(1);
			String a2 = matcher.group(2);
			String a3 = matcher.group(3);

			String p = a1 + "." + trim(a2) + "E" + a3;
			//System.out.println("p is:"+p);
			BigDecimal pp = new BigDecimal(p);
			return pp;
		}

		return prod;
		*/
	}

	private static String trim(String a2) {

		if (a2.length() > 50) {
		return a2.substring(0, 49);
		}

		return a2;
	}
	
	

	private static BigDecimal inverse(BigDecimal value1) {
		BigDecimal value = null;
		long power = 0;
		String a = value1.toPlainString();
		String b = "";
		
		if(!a.contains(".")){
		b  = a.substring(0,1) + "." + a.substring(1);
		power = a.length()-1;
		}
		else{
		power = a.indexOf(".")-1;
		a =a.replaceAll("\\.", "");
		b = a.substring(0,1) + "." + a.substring(1);
		}
		
		
		
		value = new BigDecimal(b);
		value = new BigDecimal("1").divide(value,Term.precision,RoundingMode.CEILING);
		
		String p = value.toPlainString()+"E"+(power*-1);
		value = new BigDecimal(p);
		
		return value;
	}
	
	public List<Term> fetchOnlyRelevent(List<Term> termList){
		/*
		List<Term> terms = new ArrayList<Term>();
		
		for(Term term:termList ){
			if(term.getSine()!=null && Math.abs(term.getSine().doubleValue())>0.0000000000000000000000000005){
			
			 terms.add(term);
			}
			else if(term.getCosine()!=null && Math.abs(term.getCosine().doubleValue())>0.0000000000000000000000000005){
				
				 terms.add(term);
				}
		}
		*/
		return termList;
	}
	
	public void createSquareWaves(){
		
		//termListMap.put("a0", fetchOnlyRelevent(lMap.get("sin1")));
		//termListMap.put("a1", fetchOnlyRelevent(lMap.get("sin40")));
		
		termListMap.put("a5",  Harmonics.generateHarmonics(1,fetchOnlyRelevent(lMap.get("sin5"))));
		termListMap.put("a8",  Harmonics.generateHarmonics(1,fetchOnlyRelevent(lMap.get("sin8"))));
		termListMap.put("a10", Harmonics.generateHarmonics(1,fetchOnlyRelevent(lMap.get("sin10"))));
		termListMap.put("a15", Harmonics.generateHarmonics(1,fetchOnlyRelevent(lMap.get("sin15"))));
		termListMap.put("a20", Harmonics.generateHarmonics(1,fetchOnlyRelevent(lMap.get("sin20"))));
	}

	public void createAllWaveletsMap() {
		
		for (int i = 1; i <=N; i = i + 1) {

			Term term = new Term();
			term.setSine(new BigDecimal(1));
			term.setNpower(0);
			term.setPipower(0);
			term.setXpower(0);
			term.setLpower(0);
			term.setL(L);
			
			for(int j=0;j<i-1;j++){
			term.setL(term.getL().add(delta));
			}
			//term.getLlist().add(term.getL());
			term.setN(1);
			TaylorSeries taylorSeries = new TaylorSeries();
			taylorSeries.setCaching(false);
			List<Term> termList = taylorSeries.expandTerm(term, 8, delta);
			
			
			for(Term termA:termList){
			   for(int k=0;k<Math.abs(termA.getLpower());k++){
				termA.getLlist().add(term.getL());
			 }
			}
			
			lMap.put("sin" + i, termList);
			Term term1 = new Term();
			term1.setCosine(new BigDecimal(1));
			term1.setNpower(0);
			term1.setPipower(0);
			term1.setXpower(0);
			term1.setLpower(0);
			term1.setL(L);
			
			for(int j=0;j<i-1;j++){
			term1.setL(term1.getL().add(delta));
			}
			//term1.getLlist().add(term1.getL());
			term1.setN(1);
			TaylorSeries taylorSeries1 = new TaylorSeries();
			taylorSeries1.setCaching(false);
			List<Term> termList1 = taylorSeries1.expandTerm(term1, 8, delta);
			
			for(Term termB:termList1){
				   for(int k=0;k<Math.abs(termB.getLpower());k++){
				termB.getLlist().add(term1.getL());
			  }
			}
			
			lMap.put("cos" + i, termList1);

		}
		
		

	}
	
	/*
	public void createAllWavelets1(){
		
		//each L	
		for(int i=0; i<SIZE; i++){
			List<Term> termListCombined = new ArrayList<Term>();
			
			//each n in Fourier
			for(int j=1;j<=N;j=j+2){		
			
			Term term = new Term();
			term.setSine(new BigDecimal(4.0/(j*PI)));
			term.setNpower(0);
			term.setPipower(0);
			term.setXpower(0);
			term.setLpower(0);
			term.setL(L.add(new BigDecimal(i*delta)));
			term.setN(j);
											
			TaylorSeries taylorSeries = new TaylorSeries();
			taylorSeries.setCaching(true);
			List<Term> termList = taylorSeries.expandTerm(term,10,i*delta);
			termListCombined.addAll(termList);
				
			}
			termListMap.put("a"+i, termListCombined);
			}
	   		
		}
*/
	
	
	public static void main(String[] args) {
		System.out.println("Value1 is:");
		WaveletFactory waveletFactory = new WaveletFactory();
		waveletFactory.createAllWaveletsMap();
		substituteLowerInHigherInMap(new BigDecimal(0));
		System.out.println("Map size is:"+lMap.size());
		
		BigDecimal value = evaluateListValue(lMap.get("sin40"),X);
		
		System.out.println("Value is:"+value);
		System.out.println("Max X power:"+maxXpower);
		
		
		List<Term> tlist = filterOnlySine(lMap.get("sin40"));
		for(Term term:tlist ){
			if(Math.abs(term.getSine().doubleValue())>0.0005){
			System.out.println("Term"+term.getXpower()+ "  "+term.getSine());
			}
		}
		
		/*List<Term> termsList = termListMap.get("a1");
		for(double v = 0.0;v<150.0;v=v+0.1){
		BigDecimal value = evaluateListValue(termsList, new BigDecimal(v));
        System.out.println("Value at" +v +"is:"+value);
		}
		*/
	}

	private static BigDecimal evaluateListValue(List<Term> termsList, BigDecimal x) {

		BigDecimal value = new BigDecimal("0");

		for (Term term : termsList) {
	
		Integer xp = term.getXpower();
		
		BigDecimal v1 = term.getSine();
		
		System.out.println("Term is:"+term);
		
		if(xp > maxXpower){
		maxXpower =xp;	
		}
		BigDecimal v = term.evaluate2(x);
		System.out.println("Value is:"+v);
	    value = value.add(v);
		}
		
	
		return value;
}

	private static int size(String plainString) {
		
		if(!plainString.contains(".")){
		return plainString.length();
		}
		else if(plainString.contains(".")){
			String s= plainString.substring(0,plainString.indexOf("."));
			return s.length();
		}
		
		return 0;
	}
	
}
