package org.urbana.java.taylor.expansion;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.urbana.java.criteria.generator.WaveletFactory;

public class Term implements Comparable<Term> {

	
	public static int  precision = 3;
	private BigDecimal sine;
	private BigDecimal cosine;
	private Integer npower ;
	private Integer pipower ;
	private Integer xpower ;
	private Integer Lpower ;
	private String trigArgument; //sin(npix/L)
	
	private Integer n ;
	private BigDecimal L;
	
	private List<BigDecimal> Llist = new ArrayList<BigDecimal>();
	
	
	
	public List<BigDecimal> getLlist() {
		return Llist;
	}
	public void setLlist(List<BigDecimal> llist) {
		Llist = llist;
	}
	public Integer getNpower() {
		return npower;
	}
	public void setNpower(Integer npower) {
		this.npower = npower;
	}
	public Integer getPipower() {
		return pipower;
	}
	public void setPipower(Integer pipower) {
		this.pipower = pipower;
	}
	public Integer getXpower() {
		return xpower;
	}
	public void setXpower(Integer xpower) {
		this.xpower = xpower;
	}
	public Integer getLpower() {
		return Lpower;
	}
	public void setLpower(Integer lpower) {
		Lpower = lpower;
	}
		
	public BigDecimal getSine() {
		return sine;
	}
	public void setSine(BigDecimal sine) {
		this.sine = sine;
	}
	public BigDecimal getCosine() {
		return cosine;
	}
	public void setCosine(BigDecimal cosine) {
		this.cosine = cosine;
	}
	public String getTrigArgument() {
		return trigArgument;
	}
	public void setTrigArgument(String trigArgument) {
		this.trigArgument = trigArgument;
	}
		
	public Integer getN() {
		return n;
	}
	public void setN(Integer n) {
		this.n = n;
	}
	public BigDecimal getL() {
		return L;
	}
	public void setL(BigDecimal l) {
		L = l;
	}
	public Term(BigDecimal sine, BigDecimal cosine, Integer npower, Integer pipower, Integer xpower, Integer lpower,
			String trigArgument) {
		super();
		this.sine = sine;
		this.cosine = cosine;
		this.npower = npower;
		this.pipower = pipower;
		this.xpower = xpower;
		this.Lpower = lpower;
		this.trigArgument = trigArgument;
	}
	public Term() {
		
	}

	public Terms differentiate(Term term) {

		Term term1 = new Term();
		Term term2 = new Term();
		
		if (term.sine != null && term.cosine == null) {
			term1.sine = null;
			term1.npower = term.npower + 1;
			term1.pipower = term.pipower + 1;
			term1.xpower = term.xpower + 1;
			term1.Lpower = term.Lpower - 2;
			term1.cosine = term.sine.multiply(new BigDecimal(-1));
			term1.n= term.n;
			term1.L=term.L;
			
						
			term2.sine=term.sine.multiply(new BigDecimal(term.Lpower));
			term2.cosine=null;
			term2.npower = term.npower ;
			term2.pipower = term.pipower ;
			term2.xpower = term.xpower ;
			term2.Lpower = term.Lpower - 1;
			term2.n= term.n;
			term2.L=term.L;
		}

		else if (term.sine == null && term.cosine != null) {
			term1.cosine = null;
			term1.npower = term.npower + 1;
			term1.pipower = term.pipower + 1;
			term1.xpower = term.xpower + 1;
			term1.Lpower = term.Lpower - 2;
			term1.sine = term.cosine.multiply(new BigDecimal(1));
			term1.n= term.n;
			term1.L=term.L;
			
						
			term2.cosine=term.cosine.multiply(new BigDecimal(term.Lpower));
			term2.sine=null;
			term2.npower = term.npower ;
			term2.pipower = term.pipower ;
			term2.xpower = term.xpower ;
			term2.Lpower = term.Lpower - 1;
			term2.n= term.n;
			term2.L=term.L;
		}
		Terms terms  = new Terms(term1,term2);		
		return terms;
	}
	
	public String toString(){
		
		if(this.cosine==null){
			return this.sine + "*" + "sin()"  + "n^" + this.npower + "pi^"+this.pipower + "x^"+this.xpower + "L^("+this.Lpower+")";
		}
		
		if(this.sine==null){
			return this.cosine + "*" + "cos()"  + "n^" + this.npower + "pi^"+this.pipower + "x^"+this.xpower + "L^("+this.Lpower+")";
		}
		
		return "";
	}
	
	public  BigDecimal evaluateVaryingL(BigDecimal x){
		BigDecimal value = null;
		
		//BigDecimal npix = new BigDecimal(n).multiply(new BigDecimal(3.142)).multiply(x);
		
		BigDecimal nValue = TaylorSeries.power(new BigDecimal(n),this.npower);
		BigDecimal piValue =TaylorSeries.power(new BigDecimal(WaveletFactory.PI),this.pipower);
		BigDecimal xValue = TaylorSeries.power(x,this.xpower);
		//BigDecimal lValue = TaylorSeries.power(L,this.Lpower*-1);
		
		if(this.sine!=null){
		double x1 = x.doubleValue();
		double L1 = L.doubleValue();
		value = sine.multiply(new BigDecimal(Math.sin(n*WaveletFactory.PI*x1/L1)));
		}
		
		else if(this.cosine!=null){
		double x1 = x.doubleValue();
		double L1 = L.doubleValue();
		value = cosine.multiply(new BigDecimal(Math.cos(n*WaveletFactory.PI*x1/L1)));
		}
		
		value = value.multiply(nValue).multiply(piValue).multiply(xValue);	

        return value;
	}
	
	public  BigDecimal evaluate1(BigDecimal x){
		BigDecimal value = null;
		
		//BigDecimal npix = new BigDecimal(n).multiply(new BigDecimal(3.142)).multiply(x);
		BigDecimal xValue = TaylorSeries.power(x,this.xpower);
		BigDecimal piValue =TaylorSeries.power(new BigDecimal(WaveletFactory.PI),this.pipower);
		///BigDecimal lValue = TaylorSeries.power(L,this.Lpower*-1);
		
		BigDecimal value1 = new BigDecimal(1);
	    List<BigDecimal> list = this.Llist;
		
	    for(BigDecimal l:list){
	    value1 = value1.multiply(l);
		}
	    
		
		if(this.sine!=null){
		double x1 = x.doubleValue();
		double L1 = L.doubleValue();
		//value = sine.multiply(new BigDecimal(Math.sin(x1/L1)));
		value = sine.multiply(new BigDecimal("0.9200260381967906833515366037772518665338708781866960114856456144534893202704932285137483336687150552601967647631284903"));
		}
		
		else if(this.cosine!=null){
		double x1 = x.doubleValue();
		double L1 = L.doubleValue();
		//value = cosine.multiply(new BigDecimal(Math.cos(x1/L1)));
		value = cosine.multiply(new BigDecimal("0.3918572304295500051617098585131229420985467718644703053442188639817024444567672782918274807472604772472819512219928315"));
		}
		
		

        return value.multiply(xValue).divide(value1,Term.precision,RoundingMode.CEILING);
	}
	
	public  BigDecimal evaluate2(BigDecimal x){
		BigDecimal value = null;
		
		//BigDecimal npix = new BigDecimal(n).multiply(new BigDecimal(3.142)).multiply(x);
		
		//BigDecimal nValue = TaylorSeries.power(new BigDecimal(n),this.npower);
		//BigDecimal piValue =TaylorSeries.power(new BigDecimal(WaveletFactory.PI),this.pipower);
		BigDecimal xValue = TaylorSeries.power(x,this.xpower);
		//BigDecimal lValue = TaylorSeries.power(L,this.Lpower*-1);
		
		if(this.sine!=null){
		double x1 = x.doubleValue();
		double L1 = L.doubleValue();
		value = sine.multiply(new BigDecimal(Math.sin(x1/L1)));
		}
		
		else if(this.cosine!=null){
		double x1 = x.doubleValue();
		double L1 = L.doubleValue();
		value = cosine.multiply(new BigDecimal(Math.cos(x1/L1)));
		}
		
	   value = value
				//.multiply(nValue)
				//.multiply(piValue)
				.multiply(xValue);
				//.divide(lValue,Term.precision,RoundingMode.CEILING);	

        return value;
	}
	
	public  BigDecimal evaluate(BigDecimal x){
		BigDecimal value = null;
		
		//BigDecimal npix = new BigDecimal(n).multiply(new BigDecimal(3.142)).multiply(x);
		
		BigDecimal nValue = TaylorSeries.power(new BigDecimal(n),this.npower);
		BigDecimal piValue =TaylorSeries.power(new BigDecimal(WaveletFactory.PI),this.pipower);
		BigDecimal xValue = TaylorSeries.power(x,this.xpower);
		BigDecimal lValue = TaylorSeries.power(L,this.Lpower*-1);
		
		if(this.sine!=null){
		double x1 = x.doubleValue();
		double L1 = L.doubleValue();
		value = sine.multiply(new BigDecimal(Math.sin(n*x1/L1)));
		}
		
		else if(this.cosine!=null){
		double x1 = x.doubleValue();
		double L1 = L.doubleValue();
		value = cosine.multiply(new BigDecimal(Math.cos(n*x1/L1)));
		}
		
		value = value
				//.multiply(nValue)
				//.multiply(piValue)
				.multiply(xValue).divide(lValue,Term.precision,RoundingMode.CEILING);	

        return value;
	}
	
	public  BigDecimal evaluate(Integer n,BigDecimal x,BigDecimal L){
		BigDecimal value = null;
		
		//BigDecimal npix = new BigDecimal(n).multiply(new BigDecimal(3.142)).multiply(x);
		
		BigDecimal nValue = TaylorSeries.power(new BigDecimal(n),this.npower);
		BigDecimal piValue =TaylorSeries.power(new BigDecimal(WaveletFactory.PI),this.pipower);
		BigDecimal xValue = TaylorSeries.power(x,this.xpower);
		BigDecimal lValue = TaylorSeries.power(L,this.Lpower*-1);
		
		if(this.sine!=null){
		value = sine;
		}
		else if(this.cosine!=null){
		value = cosine;	
		}
		value = value.multiply(nValue).multiply(piValue).multiply(xValue).divide(lValue,Term.precision,RoundingMode.CEILING);	

        return value;
	}
	
	@Override
	public int compareTo(Term arg0) {
	
		if(arg0==null){
			return 0;
		}
		else if(Math.abs(this.xpower)>Math.abs(arg0.xpower)){
			return 1;
		}
		else if(Math.abs(this.xpower)<=Math.abs(arg0.xpower)){
			return -1;
		}
		return 0;
	}
	
	
	
}
