package org.urbana.java.taylor.expansion;

import java.util.List;
import java.math.BigDecimal;

import org.junit.Test;
import org.urbana.java.criteria.generator.WaveletFactory;

public class TaylorTest {

		/*
	@Test
	public void test1(){
		
		
		Term term = new Term();
		term.setSine(new BigDecimal(1));
		
		term.setNpower(0);
		term.setPipower(0);
		term.setXpower(0);
		term.setLpower(0);
		
		
		Terms terms = term.differentiate(term);
		
		System.out.println(term);
		
		
	}
	
	
	@Test
	public void test2(){
		
		
		Term term = new Term();
		term.setSine(new BigDecimal(1));
		
		term.setNpower(0);
		term.setPipower(0);
		term.setXpower(0);
		term.setLpower(0);
		
		try{
		TaylorSeries taylorSeries = new TaylorSeries();
		List<Term> termlist =  taylorSeries.differentiateToNthDerievative(term, 20);
		
		for(Term term2 :termlist){
		System.out.println("Term is:"+term2);	
		}
		
		//termlist.forEach(term4 -> System.out.println("Term"+term4));
		}
		catch(Throwable e){
			e.printStackTrace(System.out);
		}
		
	}
	*/
	@Test
	public void test3(){
		
		Term term = new Term();
		term.setSine(new BigDecimal(1));
		
		term.setNpower(0);
		term.setPipower(0);
		term.setXpower(0);
		term.setLpower(0);
	
		term.setN(1);
		term.setL(new BigDecimal(26214.0));
		
		BigDecimal sum = new BigDecimal(0.0);
		try{
			TaylorSeries taylorSeries = new TaylorSeries();
			List<Term> termlist = taylorSeries.expandTerm(term, 42, 0.001);
			for(Term term1: termlist){
				
			BigDecimal b = new BigDecimal(1048576.0).multiply(new BigDecimal(333728.835137));
					
				 
			BigDecimal value = term1.evaluate(b);
			
			System.out.println("Term:"+term1 + " Value:"+value);
			sum = sum.add(value);
			}
			System.out.println("Sum is:"+sum);
			
		}
	
	catch(Throwable e){
		e.printStackTrace(System.out);
	}
	}
		
	
	
	
}
