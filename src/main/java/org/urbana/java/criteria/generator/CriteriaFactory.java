package org.urbana.java.criteria.generator;

public class CriteriaFactory {

	
	
	
	public Criteria generateCriteria(){
			
		Criteria criteria = new Criteria();
		
		Expression e1 = new Expression();
		e1.getVarList().add("a0");
		//e1.getVarList().add("a1");
		//e1.getVarList().add("a2");
		
		Expression e2 = new Expression();
		e2.getVarList().add("a1");
		///e2.getVarList().add("a5");
		//e2.getVarList().add("a6");
		
		
		//Expression e3 = new Expression();
		//e3.getVarList().add("a7");
		//e3.getVarList().add("a8");
		//e3.getVarList().add("a9");
		
		criteria.getExpList().add(e1);
		criteria.getExpList().add(e2);
		//criteria.getExpList().add(e3);
		
		return criteria;
		
	}
	
	
	
	
	
	
	
	
	
}
